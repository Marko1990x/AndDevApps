package sql.zadatak4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Zadatak2UbacivanjeVrednosti {

    public static void main(String[] args) {

        Connection connection = null; // poziv metode iz jar fajla pretpostvljam za sql
        Statement statement; // metoda iz sql jar ponovo

        try {

            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(Konstante.DATABASE_URL);
            System.out.println("usposno povezano sa bazom");

            statement = connection.createStatement();   // mora posebno za svaku vrednost ?
            String sql = "INSERT INTO meni (id,oznaka,datum) " +
                    "VALUES (1, 'Restoran1', date('now'));";
            statement.executeUpdate(sql);
            statement.close();


            statement = connection.createStatement();   // moze se ista promenjiva koristiti
            sql = "INSERT INTO meni (id,oznaka,datum) " +
                    "VALUES (2, 'Restoran2', date('now'));";
            statement.executeUpdate(sql);
            statement.close();


            // ok za ubacene vrednosti proverio sam sa db viewer

            statement = connection.createStatement();   // moze se ista promenjiva koristiti
            String jelo = "INSERT INTO jelo (id,naziv,opis,cena,meni_id) " +
                    "VALUES (1, 'Spagete', 'Testo sa mesom' , 400.00 , 1 );";
            statement.executeUpdate(jelo);
            statement.close();

            statement = connection.createStatement();   // moze se ista promenjiva koristiti
            jelo = "INSERT INTO jelo (id,naziv,opis,cena,meni_id) " +
                    "VALUES (2, 'Cevapi', 'MEso' , 350.00 , 1 );";
            statement.executeUpdate(jelo);
            statement.close();

            statement = connection.createStatement();   // moze se ista promenjiva koristiti
            jelo = "INSERT INTO jelo (id,naziv,opis,cena,meni_id) " +
                    "VALUES (3, 'Koalc', 'Kolac sa orasima' , 200 , 1 );";
            statement.executeUpdate(jelo);
            statement.close();

            statement = connection.createStatement();   // moze se ista promenjiva koristiti
            jelo = "INSERT INTO jelo (id,naziv,opis,cena,meni_id) " +
                    "VALUES (4, 'Pljeskavica', 'Lepinja sa mesom' , 200.00 , 2 );";
            statement.executeUpdate(jelo);
            statement.close();

            statement = connection.createStatement();   // moze se ista promenjiva koristiti
            jelo = "INSERT INTO jelo (id,naziv,opis,cena,meni_id) " +
                    "VALUES (5, 'Belo Meso', 'Belo meso 300g' , 370.00 , 2 );";
            statement.executeUpdate(jelo);
            statement.close();

            statement = connection.createStatement();   // moze se ista promenjiva koristiti
            jelo = "INSERT INTO jelo (id,naziv,opis,cena,meni_id) " +
                    "VALUES (6, 'Slatka palacinka', 'Palacinka sa orasima' , 350 , 1 );";
            statement.executeUpdate(jelo);
            statement.close();

            // zadatal 2.2.2 ok proverio sam sa vieverom



            statement = connection.createStatement();   // moze se ista promenjiva koristiti
            String porudzbina = "INSERT INTO porudzbina (id,konobar,datum) " +
                    "VALUES (1, 'Jovan Jovanovic', date('now'));";
            statement.executeUpdate(porudzbina);
            statement.close();

            statement = connection.createStatement();   // moze se ista promenjiva koristiti
            porudzbina = "INSERT INTO porudzbina (id,konobar,datum) " +
                    "VALUES (2, 'Petar Petrovic', date('now'));";
            statement.executeUpdate(porudzbina);
            statement.close();


            // zadatak 2.2.3 ok proverio sam sa viewrom

            statement = connection.createStatement();   // moze se ista promenjiva koristiti
            String porucenojelo = "INSERT INTO poruceno_jelo (id,kolicina,jelo_id,porudzbina_id) " +
                    "VALUES (1, 1, 1 ,1 );";
            statement.executeUpdate(porucenojelo);
            statement.close();

            statement = connection.createStatement();   // moze se ista promenjiva koristiti
            porucenojelo = "INSERT INTO poruceno_jelo (id,kolicina,jelo_id,porudzbina_id) " +
                    "VALUES (2, 2, 2 ,1 );";
            statement.executeUpdate(porucenojelo);
            statement.close();

            statement = connection.createStatement();   // moze se ista promenjiva koristiti
            porucenojelo = "INSERT INTO poruceno_jelo (id,kolicina,jelo_id,porudzbina_id) " +
                    "VALUES (3, 3, 3 ,1 );";
            statement.executeUpdate(porucenojelo);
            statement.close();

            statement = connection.createStatement();   // moze se ista promenjiva koristiti
            porucenojelo = "INSERT INTO poruceno_jelo (id,kolicina,jelo_id,porudzbina_id) " +
                    "VALUES (4, 4, 4 ,2 );";
            statement.executeUpdate(porucenojelo);
            statement.close();

            statement = connection.createStatement();   // moze se ista promenjiva koristiti
            porucenojelo = "INSERT INTO poruceno_jelo (id,kolicina,jelo_id,porudzbina_id) " +
                    "VALUES (5, 5, 5 ,2 );";
            statement.executeUpdate(porucenojelo);
            statement.close();


            // ok je proverio sam sa viewerom


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}


/*   generalno isti deo za ove tabele

  Connection connection = null; // poziv metode iz jar fajla pretpostvljam za sql
        Statement statement; // metoda iz sql jar ponovo

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(Konstante.DATABASE_URL);
            System.out.println("usposno povezano sa bazom");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
*
* */