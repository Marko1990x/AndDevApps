package zadatak5.zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import zadatak5.model.Artikal;
import zadatak5.model.Racun;
import zadatak5.model.Stavka;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Resenje 2.3
 */
public class Zadatak2DodavanjeBrisanjeIzmenaVrednosti {

    /*Definisanje statickih atributa koji za tip imaju
       genericku klasu Dao
      */
    static Dao<Artikal,Integer> artikalDao;
    static Dao<Racun,Integer> racunDao;
    static Dao<Stavka,Integer> stavkaDao;

    public static void main(String[] args){
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

            /*Brisanje vrednosti iz tabela koje mora biti
              u navedenom redosledu zbog
              ogranicenja referencijalnog integriteta:
              klasa Stavka cuva reference na klase
              Artikal i Racun i da bi se mogle obrisati
              vrednosti iz tih tabela moraju se prvo
               obrisati vrednosti za stavke i tek onda
                se mogu obrisati vrednosti za artikle
                i racune
             */
            TableUtils.clearTable(connectionSource,Stavka.class);
            TableUtils.clearTable(connectionSource,Artikal.class);
            TableUtils.clearTable(connectionSource,Racun.class);


            //Resenje 2.3.1
            /*a) Instanciranje objekta Artikal i upis u bazu
                 prosledjivanjem objekta create metodi
            */
            Artikal a1=new Artikal("Mleko","Mleko u flasi 1L", 40.99);
            artikalDao.create(a1);

            /*b) Instanciranje objekta Artikal i upis u bazu
                 prosledjivanjem objekta create metodi
            */
            Artikal a2=new Artikal("Beli hleb","400g", 50);
            artikalDao.create(a2);

            /*c) Instanciranje objekta Artikal i upis u bazu
                 prosledjivanjem objekta create metodi
            */
            Artikal a3=new Artikal("Crni hleb","Crni razeni hleb", 60);
            artikalDao.create(a3);

            /*d) Instanciranje objekta Artikal i upis u bazu
                 prosledjivanjem objekta create metodi
            */
            Artikal a4=new Artikal("Jogurt","Jogurt u tetrapaku 1L", 90.99);
            artikalDao.create(a4);

            /*a) Instanciranje objekta Racun i upis u bazu
                 prosledjivanjem objekta create metodi
            */
            Racun r1=new Racun("Racun1", new Date());
            racunDao.create(r1);

            /*b) Instanciranje objekta Racun i upis u bazu
                 prosledjivanjem objekta create metodi
            */
            Racun r2=new Racun("Racun2", new Date());
            racunDao.create(r2);

            /*a) Instanciranje objekta Stavka i upis u bazu
                 prosledjivanjem objekta create metodi
            */
            Stavka s1=new Stavka(1,r1,a1);
            stavkaDao.create(s1);

            /*b) Instanciranje objekta Stavka i upis u bazu
                 prosledjivanjem objekta create metodi
            */
            Stavka s2=new Stavka(2,r1,a2);
            stavkaDao.create(s2);

            /*c) Instanciranje objekta Stavka i upis u bazu
                 prosledjivanjem objekta create metodi
            */
            Stavka s3=new Stavka(3,r2,a3);
            stavkaDao.create(s3);

            /*Resenje 2.3.2
               Izmena vrednosti za atribut oznaka u
               "RacunPrvi" i cuvanje izmene pozivom metode
                update i prosledjivanjem izmenjenog objekta
               */
            Racun zaIzmenu=racunDao.queryForId(r1.getId());
            zaIzmenu.setOznaka("RacunPrvi");
            racunDao.update(zaIzmenu);

            /*Opcioni prikaz svih racuna da bi videli da
            su vrednosti izmenjene
            */
            List<Racun> racuni=racunDao.queryForAll();
            System.out.println("Prikaz svih racuna da " +
                    "proverimo da je promenjena oznaka " +
                    "racuna u RacunPrvi");
            for(Racun r:racuni)
                System.out.println(r);


            /*
               Resenje 2.3.3
               Instanciranje novog objekta klase Artikal
               upis te vrednosti u bazu pozivom metode
               create i prosledjivanjem objekta
             */
            Artikal a5=new Artikal("Voda","Flasa vode od 1,5L", 70);
            artikalDao.create(a5);

            /*
             Prikaz svih artikala da bi videli da
              je objekat upisan. Metoda queryForAll vraca
              sve vrednosti iz odgovarajuce tabele za koju je
              napravljen Dao objekat.
             */
            List<Artikal> artikli=artikalDao.queryForAll();
            System.out.println("Prikaz svih artikala da " +
                    "vidimo da je ubacen artikal sa nazivom " +
                    "Voda");
            for(Artikal a:artikli)
                System.out.println(a);

            /*
              Koristeci metodu queryForId pronalazimo objekat
              koji za atribut id ima istu vrednost kao i poslednji
              kreirani objekat i brisanje vrednosti pozivom metode
              delete i prosledjivanjem pronadjenog objekta
             */
            Artikal zaBrisanje=artikalDao.queryForId(a5.getId());
            artikalDao.delete(zaBrisanje);

            /*
              Prikaz svih artikala da bi videli da
               je objekat obrisan
             */
            artikli=artikalDao.queryForAll();
            System.out.println("Prikaz svih artikala " +
                    "da vidimo da je obrisan artikal sa " +
                    "nazivom Voda");
            for(Artikal a:artikli)
                System.out.println(a);

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
