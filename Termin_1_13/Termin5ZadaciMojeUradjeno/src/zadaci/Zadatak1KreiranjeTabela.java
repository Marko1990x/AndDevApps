package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Artikal;
import model.Racun;
import model.Stavka;

import java.sql.Connection;

public class Zadatak1KreiranjeTabela {
    public static void main(String[] args) {

        ConnectionSource connectionSource = null;
        try {

            // greska pri nazivu
            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);

            // prosledjivanje tabela koje su u stvari klase generatoru

            // ok prvo se brisu zbog database pa se generisu
            // salje se connection prvo , onda Classa.class onda true ili false za ignore errors


            // redosled je bitan pri brisanju i kreiranju prema vise veza tabela creiraj i ubijaj tabele sa vise veza prvo pa onda druge

            TableUtils.dropTable(connectionSource, Stavka.class, true);
            TableUtils.dropTable(connectionSource, Artikal.class, true);
            TableUtils.dropTable(connectionSource, Racun.class, true);

            // onda kreiranje tabela

            TableUtils.createTable(connectionSource, Artikal.class);
            TableUtils.createTable(connectionSource, Racun.class);
            TableUtils.createTable(connectionSource, Stavka.class); // ovo je kreianje tabela



        }catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }finally {

        }


    }
}
