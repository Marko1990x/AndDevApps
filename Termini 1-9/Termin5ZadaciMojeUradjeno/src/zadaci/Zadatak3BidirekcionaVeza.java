package zadaci;

import com.j256.ormlite.dao.*;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Artikal;
import model.Racun;
import model.Stavka;

import java.io.IOException;
import java.util.List;


public class Zadatak3BidirekcionaVeza {

    static Dao<Artikal, Integer> artikalDao;
    static Dao<Racun, Integer> racunDao;
    static Dao<Stavka, Integer> stavkaDao;

    public static void main(String[] args) {

        ConnectionSource connectionSource = null;

        try {
            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);
            artikalDao= DaoManager.createDao(connectionSource, Artikal.class);
            racunDao = DaoManager.createDao(connectionSource, Racun.class);
            stavkaDao = DaoManager.createDao(connectionSource, Stavka.class);

            // neophodan blok za instanciranje objekta klase dao

            List<Racun> racuns= racunDao.queryForAll(); // ok je
            System.out.println("Prikaz racuna preko dao");
            for(Racun racun: racuns){
                System.out.println(racun);
            }

            // jednom napravljena lista moze da se koristi ponovo
            racuns = racunDao.queryForEq(Racun.POLJE_OZNAKA, "RacunDrugi");
            // ovo prolazi kroz databazu i gde u polju oznaka ima racunDrugi to ce naci
            ForeignCollection<Stavka> stavka = racuns.get(0).getStavke();
            System.out.println(racuns.get(0).getStavke());
            CloseableIterator<Stavka> iterator=stavka.closeableIterator() ;

            try {

                System.out.println("prikaz stavki i artikala stavki za racun sa oznakom RacunDrugi");
                while(iterator.hasNext()){
                    Stavka s = iterator.next();
                    System.out.println("Stavka: = " + s);
                    System.out.println("Artikal Stavke= " + s.getArtikal());
                }


            }catch (Exception e){
                System.out.println("greska prilikom iteracije: " + e);
            }finally {
                iterator.close();
            }




        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }finally {
            if (connectionSource != null){
                try {
                    connectionSource.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }
}
