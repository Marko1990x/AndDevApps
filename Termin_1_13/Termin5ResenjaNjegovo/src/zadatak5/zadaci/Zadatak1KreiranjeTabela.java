package zadatak5.zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import zadatak5.model.Artikal;
import zadatak5.model.Racun;
import zadatak5.model.Stavka;

import java.io.IOException;

/**
 * Resenje 2.2
 */
public class Zadatak1KreiranjeTabela {

    public static void main(String[] args){
        ConnectionSource connectionSource = null;
        try {
            /*Uspostavimo konekciju sa bazom preko koje mozemo da posaljemo
               naredbe bazi
            */
            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);


            /*Brisanje tabela koje mora biti
              u navedenom redosledu zbog
              ogranicenja referencijalnog integriteta:
              klasa Stavka cuva reference na klase
              Racun  i Artikal i da bi se mogle obrisati
              mora se prvo obrisati tabela Stavka i tek
              onda se mogu obrisati tabele za
               Artikal i Racun
             */
            TableUtils.dropTable(connectionSource,Stavka.class,true);
            TableUtils.dropTable(connectionSource,Artikal.class,true);
            TableUtils.dropTable(connectionSource,Racun.class,true);


            /*
              Kreiranje tabela koje mora biti u navedenom
              redosledu zbog ogranicenja referencijalnog
              integriteta:
              klasa Stavka cuva reference na klase Racun i
              Artikal i prilikom kreiranja tabela moraju
              postojati tabele Racun i Artikal da bi
              prilikom kreiranja tabele Stavka mogla da
              se odredi veza prema tabelama Racun i Artikal
             */
            TableUtils.createTable(connectionSource,Artikal.class);
            TableUtils.createTable(connectionSource,Racun.class);
            TableUtils.createTable(connectionSource,Stavka.class);
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
