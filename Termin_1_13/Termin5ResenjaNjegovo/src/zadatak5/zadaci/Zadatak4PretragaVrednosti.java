package zadatak5.zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.support.ConnectionSource;
import zadatak5.model.Artikal;
import zadatak5.model.Racun;
import zadatak5.model.Stavka;

import java.io.IOException;
import java.util.List;

/**
 * Resenje 2.5
 */
public class Zadatak4PretragaVrednosti {

    /*Definisanje statickih atributa koji za tip imaju
       genericku klasu Dao
      */
    static Dao<Artikal, Integer> artikalDao;
    static Dao<Racun, Integer> racunDao;
    static Dao<Stavka, Integer> stavkaDao;

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
              Resenje 2.5.1
              Select izraz se kreira pozivom queryBuilder metode nad kojom se zatim
              poziva where metoda i nad dobijenim WHERE objektom moze se napraviti
              uslov WHERE klauzule pozivom metode like i odredjivanjem da se za
               vrednosti kolone naziv traze samo one vrednosti koje sadrze tekst hleb.
               Sablon za pronalazenje teksta hleb je "%hleb%".
             */
            QueryBuilder<Artikal, Integer> artikalHlebQuery = artikalDao.queryBuilder();
            artikalHlebQuery.where().like(Artikal.POLJE_NAZIV, "%hleb%");
            PreparedQuery<Artikal> artikalHlebPripremljen = artikalHlebQuery.prepare();
            /*Pripremljen SELECT izraz izvrsavamo pozivom query metode
               koja vraca sve pronadjene artikle, a koji odgovaraju uslovu.
             */
            List<Artikal> artikli = artikalDao.query(artikalHlebPripremljen);
            //Pronadjene artikle prikazujemo u konzoli
            System.out.println("Artikli koji u nazivu imaju " +
                    "tekst hleb");
            for (Artikal a : artikli)
                System.out.println("a = " + a);


            /*
              Resenje 2.5.2
              Prilikom kreiranja like uslova umesto sablona koristi se SelectArg objekat
              preko kojeg se kasnije prosledjuje odgovarajuci sablon za poredjenje
              sa vrednostima kolone opis
             */
            SelectArg selectZaOpis = new SelectArg();
            PreparedQuery<Artikal> artikalQueryPripremljen = artikalDao.queryBuilder().where().like(Artikal.POLJE_OPIS, selectZaOpis).prepare();
            /*
            Kroz SelectArg se prosledjuje sablon za like uslov "%1L%"
             */
            selectZaOpis.setValue("%1L%");
            artikli = artikalDao.query(artikalQueryPripremljen);
            System.out.println("Artikli koji u opisu imaju " +
                    "tekst 1L");
            for (Artikal a : artikli)
                System.out.println("a = " + a);

            /*
            Kroz SelectArg se prosledjuje sablon za like uslov "%u%"
             */
            selectZaOpis.setValue("%u%");
            artikli = artikalDao.query(artikalQueryPripremljen);
            System.out.println("Artikli koji u opisu imaju " +
                    "karakter u");
            for (Artikal a : artikli)
                System.out.println("a = " + a);


            /*
              Resenje 2.5.3
              Da bi se koristeci ORMLite napravio join tabela racun i stavke
              potrebno je napraviti posebne  QueryBuilder objekte samo za
              Racun i samo za Stavka klase.
             */
            QueryBuilder<Racun, Integer> racunQuery = racunDao.queryBuilder();

            QueryBuilder<Stavka, Integer> stavkaQuery = stavkaDao.queryBuilder();
            /*
               Za stavke hocemo da pronadjemo samo one kod kojih je vrednost
               kolone kolicina jednaka 2.
             */
            stavkaQuery.where().eq(Stavka.POLJE_KOLICINA, 2);
            /*
            Da bi dobili racune kod kojih stavke imaju vrednost kolone kolicina 2,
            spajamo ove dve tabele pozivom join metode.
             */
            List<Racun> racuni = racunQuery.join(stavkaQuery).query();
            System.out.println("Racuni cija stavka za kolicinu ima vrednost 2");
            for (Racun r : racuni)
                System.out.println("r = " + r);

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
