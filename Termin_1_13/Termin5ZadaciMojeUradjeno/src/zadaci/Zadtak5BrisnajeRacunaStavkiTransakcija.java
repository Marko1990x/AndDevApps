package zadaci;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.support.ConnectionSource;
import model.Artikal;
import model.Racun;
import model.Stavka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Zadtak5BrisnajeRacunaStavkiTransakcija {
    static Dao<Artikal, Integer> artikalDao;
    static Dao<Racun, Integer> racunDao;
    static Dao<Stavka, Integer> stavkaDao;

    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);

            artikalDao = DaoManager.createDao(connectionSource, Artikal.class);
            racunDao = DaoManager.createDao(connectionSource, Racun.class);
            stavkaDao = DaoManager.createDao(connectionSource, Stavka.class);

            List<Stavka> stavke = stavkaDao.queryForAll();
            System.out.println("Prikaz svih stavki pre brisanja stavki " +
                    "racuna Racun2");
            for (Stavka s : stavke)
                System.out.println(s);

            List<Racun> racuni = racunDao.queryForAll();
            System.out.println("Prikaz svih racuna pre brisanja racuna Racun2");
            for (Racun r : racuni)
                System.out.println(r);

            racuni = racunDao.queryForEq(Racun.POLJE_OZNAKA, "Racun2");

            Racun r2 = racuni.get(0);
            if (r2 != null) {
                ArrayList<Stavka> stavkeZaBrisanje = new ArrayList<Stavka>();
                ForeignCollection<Stavka> stavkeRacuna = r2.getStavke();
                CloseableIterator<Stavka> iterator = stavkeRacuna.closeableIterator();

                try {

                    System.out.println("Stavke racuna Racun2");
                    while (iterator.hasNext()) {
                        Stavka s = iterator.next();
                        stavkeZaBrisanje.add(s);
                        System.out.println("Stavka za brisanje: " + s);
                    }
                } catch (Exception e) {
                    System.out.println("Greska prilikom iteracije");
                } finally {
                    iterator.close();
                }
                TransactionManager.callInTransaction(connectionSource,
                        new Callable<Void>() {
                            public Void call() throws Exception {

                                stavkaDao.delete(stavkeZaBrisanje);

                                racunDao.delete(r2);

                                return null;
                            }
                        });


            }

            stavke = stavkaDao.queryForAll();
            System.out.println("Prikaz svih stavki nakon sto su obrisane stavke " +
                    "racuna Racun2");
            for (Stavka s : stavke)
                System.out.println(s);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
