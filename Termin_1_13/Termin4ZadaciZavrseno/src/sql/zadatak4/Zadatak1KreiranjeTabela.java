package sql.zadatak4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Zadatak1KreiranjeTabela {

    public static void main(String[] args) {

        Connection connection = null; // poziv metode iz jar fajla pretpostvljam za sql
        Statement statement; // metoda iz sql jar ponovo

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(Konstante.DATABASE_URL);
            System.out.println("usposno povezano sa bazom");

            statement = connection.createStatement();
            String sql = "CREATE TABLE meni " +
                    "(id      INT PRIMARY KEY     NOT NULL," +
                    " oznaka   TEXT    NOT NULL, " +
                    " datum    NUMERIC     NOT NULL)";
            statement.executeUpdate(sql); // salje definicuju tabele da se napravi
            statement.close();

            statement = connection.createStatement();
            String sql2 = "CREATE TABLE jelo " +
                    "(id      INT PRIMARY KEY     NOT NULL," +
                    " naziv   TEXT    NOT NULL, " +
                    " opis   TEXT    NOT NULL, " +
                    " cena   DECIMAL    NOT NULL, " +
                    " meni_id   INT    NOT NULL, " +
                    " FOREIGN KEY(meni_id) REFERENCES meni(id))";
            statement.executeUpdate(sql2); // salje definicuju tabele da se napravi
            statement.close();


            statement = connection.createStatement();
            String sql3 = "CREATE TABLE porudzbina " +
                    "(id      INT PRIMARY KEY     NOT NULL," +
                    " konobar   TEXT    NOT NULL, " +
                    " datum    NUMERIC     NOT NULL)";
            statement.executeUpdate(sql3); // salje definicuju tabele da se napravi
            statement.close();

            statement = connection.createStatement();
            String sql4 = "CREATE TABLE poruceno_jelo " +
                    "(id      INT PRIMARY KEY     NOT NULL," +
                    " kolicina   INT    NOT NULL, " +
                    " jelo_id   INT    NOT NULL, " +
                    " porudzbina_id   INT    NOT NULL, " +
                    " FOREIGN KEY(jelo_id) REFERENCES jelo(id), " +
                    " FOREIGN KEY(porudzbina_id) REFERENCES porudzbina(id))";
            statement.executeUpdate(sql4); // salje definicuju tabele da se napravi
            statement.close();


            //Definisati i ograniˇcenje referencijalnog integriteta: je foreign key koji pravi vezu
            // izmedju meni i jelo klase ili tabele preko id -a
        }catch (Exception e){

            System.err.println( e.getClass().getName() + ": " + e.getMessage() );

        }finally {

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        System.out.println("Tabela uspesno kreirana");

    }

}


/*

try {

        }catch (Exception e){

        }finally {

        }

* */