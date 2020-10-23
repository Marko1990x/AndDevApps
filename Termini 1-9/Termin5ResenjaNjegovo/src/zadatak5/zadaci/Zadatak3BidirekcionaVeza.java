package zadatak5.zadaci;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import zadatak5.model.Artikal;
import zadatak5.model.Racun;
import zadatak5.model.Stavka;

import java.io.IOException;
import java.util.List;

/**
 * Resenje 2.4
 */
public class Zadatak3BidirekcionaVeza {

    /*
       Definisanje statickih atributa koji za tip imaju
       genericku klasu Dao
     */
    static Dao<Artikal,Integer> artikalDao;
    static Dao<Racun,Integer> racunDao;
    static Dao<Stavka,Integer> stavkaDao;

    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            /*Uspostavimo konekciju sa bazom preko koje mozemo da posaljemo
               naredbe bazi
            */
            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);
            /*Instanciranje odgovarajucih Dao objekata koristeci pomocnu metodu
              createDao klase DaoManager
            */
            artikalDao= DaoManager.createDao(connectionSource, Artikal.class);
            racunDao = DaoManager.createDao(connectionSource, Racun.class);
            stavkaDao = DaoManager.createDao(connectionSource, Stavka.class);

            /*
              Pozivom queryForAll metode nad odgovarajucim Dao objektom
              dobijamo sve racune iz tabele racun u bazi i prikazujemo
              sve vrednosti
             */
            List<Racun> racuni=racunDao.queryForAll();
            System.out.println("Prikaz svih racuna");
            for(Racun r:racuni)
                System.out.println(r);


            /*
              Pozivom queryForEq metode nad odgovarajucim Dao objektom
              dobijamo sve racune iz tabele racun u bazi koji za vrednost
               kolone oznaka imaju vrednost "Racun2". Metoda queryForEq
               vraca kolekciju tipa List<Racun> a tog istog tipa je i
               promenljiva racuni
             */
            racuni=racunDao.queryForEq(Racun.POLJE_OZNAKA,"Racun2");
            /*
              Iz dobijene kolekcije preuzimamo element sa indexom 0,
              pozivom metode get i prosledjivanjem vrednosti 0. Metoda
              get vraca jedan objekat tipa Racun i pozivamo metodu
              getStavke da bismo dobili sve stavke odgovarajuceg racuna
              kao kolekciju stavki
             */
            ForeignCollection<Stavka> stavke=racuni.get(0).getStavke();

            /*
              Da bismo mogli da prodjemo kroz sve stavke racuna, treba nam
              iterator koji ce omoguciti prolazak kroz kolekciju stavki
             */
            CloseableIterator<Stavka> iterator=stavke.closeableIterator() ;

            try {

                /* hasNext proveravamo da li postoji seledeci element
                   u kolekciji stavki
                */
                System.out.println("Prikaz stavki i artikala stavki za racun sa oznakom Racun2");
                while (iterator.hasNext()) {
                    /*next metodom preuzimamo taj element koji postoji
                     i prelazi se na naredni element u kolekciji
                    */
                    Stavka s = iterator.next();
                    //Prikaz stavke
                    System.out.println("Stavka = " + s);
                    //Prikaz artikla za trenutnu stavku
                    System.out.println("Artikal stavke = " + s.getArtikal());
                }
            } catch(Exception e)
            {
                System.out.println("Greska prilikom iteracije");
            }
            finally {
                iterator.close();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connectionSource != null) {
                try {
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
