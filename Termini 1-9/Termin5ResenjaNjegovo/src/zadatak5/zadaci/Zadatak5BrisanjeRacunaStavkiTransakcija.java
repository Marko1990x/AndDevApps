package zadatak5.zadaci;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.support.ConnectionSource;
import zadatak5.model.Artikal;
import zadatak5.model.Racun;
import zadatak5.model.Stavka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/*
  Resenje 2.6
 */
public class Zadatak5BrisanjeRacunaStavkiTransakcija {

    /*Definisanje statickih atributa koji za tip imaju
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
            artikalDao = DaoManager.createDao(connectionSource, Artikal.class);
            racunDao = DaoManager.createDao(connectionSource, Racun.class);
            stavkaDao = DaoManager.createDao(connectionSource, Stavka.class);

            /*
             Prikazujemo sve stavke da bi mogli da vidimo
             da li ce se uspesno obrisati stavke za racun "Racun2"
             */
            List<Stavka> stavke = stavkaDao.queryForAll();
            System.out.println("Prikaz svih stavki pre brisanja stavki " +
                    "racuna Racun2");
            for (Stavka s : stavke)
                System.out.println(s);

            /*
              Pozivom queryForAll metode nad odgovarajucim Dao objektom
              dobijamo sve racune iz tabele racun u bazi i prikazujemo
              sve vrednosti
             */
            List<Racun> racuni=racunDao.queryForAll();
            System.out.println("Prikaz svih racuna pre brisanja racuna Racun2");
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
              Od pronadjenih racuna uzimamo jedan racun, a to je
               racun koji se u kolekciji nalazi sa indeksom 0.
             */
            Racun r2 = racuni.get(0);
            if (r2 != null) {

                /*
                Pomocna list koja ce cuvati sve stavke racuna, a koje cemo kasnije
                da obrisemo
                 */
                ArrayList<Stavka> stavkeZaBrisanje = new ArrayList<Stavka>();

                /*
                Dobijamo sve stavke za pronadjeni racun.
                 */
                ForeignCollection<Stavka> stavkeRacuna=r2.getStavke();
                /*
                Dobijamo iterator kojim prolazimo kroz sve stavke pronadjenog racuna.
                 */
                CloseableIterator<Stavka> iterator = stavkeRacuna.closeableIterator();

                try {

                    System.out.println("Stavke racuna Racun2");
                    while (iterator.hasNext()) {
                        Stavka s=iterator.next();
                        /*Sve stavke pronadjenog racuna ubacujemo u pomocnu listu
                          za brisanje
                         */
                        stavkeZaBrisanje.add(s);
                        System.out.println("Stavka za brisanje: " + s);
                    }
                }  catch(Exception e)
                {
                    System.out.println("Greska prilikom iteracije");
                }finally {
                    iterator.close();
                }

                /*
                  Pozivom staticke metode callInTransaction prosledjujemo
                  Callable objekat kreiran kao anonimna klasa. Sve naredbe
                  koje se napisu unutar redefinisane call metode bice
                  izvrsene unutar jedne transakcije. Ako se desi greska
                  prilikom izvrsavanja neke od naredbi unutar transakcije
                  sve ostale naredbe u toj istoj transakciji bice ponistene.
                 */
                TransactionManager.callInTransaction(connectionSource,
                        new Callable<Void>() {
                            public Void call() throws Exception {
                               /*
                                U redefinisanoj metodi call prosledimo
                                 sve stavke iz liste za brisanje metodi delete
                                  Dao objekta.
                                */
                                stavkaDao.delete(stavkeZaBrisanje);

                                /*Kada su obrisane sve stavke racuna mozemo obrisati
                                 i sam racun prosledjivanjem objekta Racun delete
                                  metodi odgovarajuceg Dao objekta.
                                */
                                racunDao.delete(r2);

                                return null;
                            }
                        });


            }
            /*
              Prikazujemo sve stavke da bi mogli da vidimo
             da li su uspesno obrisane sve stavke za racun "Racun2"
             */
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
