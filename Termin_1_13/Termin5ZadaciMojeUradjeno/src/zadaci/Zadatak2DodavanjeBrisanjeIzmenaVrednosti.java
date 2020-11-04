package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Artikal;
import model.Racun;
import model.Stavka;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class Zadatak2DodavanjeBrisanjeIzmenaVrednosti {

    // genericka klasa dao , prvi parametar klasa , drugi parametar tip primarnog kljuca
    static Dao<Artikal, Integer>  artikalDao;
    static Dao<Racun, Integer> racunDao;
    static Dao<Stavka, Integer> stavkaDao;
    // ostalo u main metodi

    public static void main(String[] args) {

        // static izvan main metode
        ConnectionSource connectionSource = null;

        try {
            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);

            artikalDao = DaoManager.createDao(connectionSource, Artikal.class);
            racunDao = DaoManager.createDao(connectionSource, Racun.class);
            stavkaDao = DaoManager.createDao(connectionSource, Stavka.class);

            TableUtils.clearTable(connectionSource,Stavka.class);
            TableUtils.clearTable(connectionSource,Artikal.class);
            TableUtils.clearTable(connectionSource,Racun.class);

            // 2.3.1
            // kreiranje podataka preko dao managera
            Artikal a1 = new Artikal("Mleko", "Mleko u flasi 1l", 40.99);
            // objekat je napravljen u promenjvoj ali se treba ubaciti u dao sada da se napravi
            // promenjivima gore se dodaju ove promenjive
            artikalDao.create(a1);
            Artikal a2 = new Artikal("Beli hleb", "400g", 50);
            artikalDao.create(a2);
            Artikal a3 = new Artikal("Crni Hleb", "Crni Razeni Hleb", 60);
            artikalDao.create(a3);
            Artikal a4 = new Artikal("Jogurt", "Jogurt u tetrapaku 1L", 90.99);
            artikalDao.create(a4);

            // sa ovim bi lista artikala trebala da bude populjena
            // ok je provereno

            Racun r1 = new Racun("Racun1", new Date()); // po konstuktoru ocekuje oznaku i datum
            Racun r2 = new Racun("Racun2", new Date());

            // objekti kreirani sada ih treba ubaciti

            racunDao.create(r1);
            racunDao.create(r2); // kreirani

            // instanciranje objekata stavke

            Stavka s1 = new Stavka(1,r1,a1);
            Stavka s2 = new Stavka(2,r1,a2);
            Stavka s3 = new Stavka(3,r2,a3);

            stavkaDao.create(s1);
            stavkaDao.create(s2);
            stavkaDao.create(s3);

            // izmena preko Dao Poziva

            // prvo napravi objekat
            Racun racunZaMenjenja = racunDao.queryForId(r1.getId()); // trazi bojekat po idu
            racunZaMenjenja.setOznaka("RacunPrvi"); // menja vrednost
            racunDao.update(racunZaMenjenja); // upisuje u database

            Racun racunZaMenjanje2 = racunDao.queryForId(r2.getId());
            racunZaMenjanje2.setOznaka("RacunDrugi");
            racunDao.update(racunZaMenjanje2);

            // trivialna greska liste moraju biti ispod promena
            List<Racun> racuni = racunDao.queryForAll(); // svi racuni se ubace u listu
            System.out.println("provera da li je izmena prosla");

            // for klasa promenjiva / lista u kojoj su podaci
            for(Racun r: racuni){
                System.out.println(r);
            }

            // zadatak brisanje vrednosti 2.3.3
            Artikal artikalNew = new Artikal("Voda", "Flasa vode od 1.5L", 70);

            artikalDao.create(artikalNew); // upis u databazu

            List<Artikal> artikals = artikalDao.queryForAll();
            for(Artikal artikal: artikals){  // uspesno dodat artikal u databasu i izlistan
                System.out.println(artikal);
            }

            // mora se prvo objekat napraviti ponovo ...
            Artikal artikalZaBrisanje = artikalDao.queryForId(artikalNew.getId());
            artikalDao.delete(artikalZaBrisanje); // mora se uvuci u promenjivu da bi se mogao referencirati ovde

            // vec je definisano kao lista gore
            artikals = artikalDao.queryForAll();
            System.out.println("provera da li je iz brisano iz liste");

            for (Artikal r: artikals){  // ok je
                System.out.println(r);
            }


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }
}

