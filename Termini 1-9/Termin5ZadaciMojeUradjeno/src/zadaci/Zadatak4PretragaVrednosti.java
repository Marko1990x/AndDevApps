package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.support.ConnectionSource;
import model.Artikal;
import model.Racun;
import model.Stavka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Zadatak4PretragaVrednosti {

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

            //ovaj ceo kode blok he za SELECT IZRAZ
            QueryBuilder<Artikal, Integer> artikalIntegerQueryBuilder = artikalDao.queryBuilder();

            artikalIntegerQueryBuilder.where().like(Artikal.POLJE_NAZIV, "%hleb%"); // trazi po plju i delu reci
            PreparedQuery<Artikal> artikalPreparedQuery = artikalIntegerQueryBuilder.prepare();
            List<Artikal> artikli = artikalDao.query(artikalPreparedQuery);
            System.out.println("Artikal koji u nazivu imaju text hleb");
            for(Artikal artikal: artikli){
                System.out.println("a = " + artikal);
            }
            // dovde

            //SELECT ARG
            SelectArg selectArg = new SelectArg(); // inicializacija // i sta se prosledjuje

            PreparedQuery<Artikal> artkalQuerPripremljen = artikalDao.queryBuilder().where().like(Artikal.POLJE_OPIS,
                    selectArg).prepare();


            // ovaj deo se ponavlja
            selectArg.setValue("%1L%");
            artikli = artikalDao.query(artkalQuerPripremljen); // lista se puni sa ovim

            System.out.println("Artikli koji u opisu imaju text 1l");
            for(Artikal artikal: artikli){   // ok
                System.out.println("a: " + artikal);
            }


            // za artikle koji imaju u
            selectArg.setValue("%U%"); // ok
            artikli = artikalDao.query(artkalQuerPripremljen);
            System.out.println("Artikli koji u opisu imaju U");
            for(Artikal artikal: artikli){
                System.out.println("a: " + artikal);
            }


            // Seleck sa Join Izrazom
            QueryBuilder<Racun, Integer>racunIntegerQueryBuilder = racunDao.queryBuilder();
            QueryBuilder<Stavka, Integer> stavkaIntegerQueryBuilder = stavkaDao.queryBuilder();

            stavkaIntegerQueryBuilder.where().eq(Stavka.POLJE_KOLICINA, 2);
            List<Racun> racuns = racunIntegerQueryBuilder.join(stavkaIntegerQueryBuilder).query();
            System.out.println("racuni cija stavka za kolicinu ima vrednost 2");
            for(Racun racun:racuns){
                System.out.println("R: " + racun);
            }







        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }
}
