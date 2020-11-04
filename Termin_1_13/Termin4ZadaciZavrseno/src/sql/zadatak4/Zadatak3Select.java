package sql.zadatak4;

import java.sql.*;

public class Zadatak3Select {

    public static void main(String[] args) {


        Connection connection = null; // poziv metode iz jar fajla pretpostvljam za sql
        Statement statement; // metoda iz sql jar ponovo

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(Konstante.DATABASE_URL);
            System.out.println("usposno povezano sa bazom");
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM jelo");
            while (rs.next()) {
                int id = rs.getInt("id");
                String naziv = rs.getString("naziv");
                String opis = rs.getString("opis");
                double cena = rs.getDouble("cena");
                int meni_id = rs.getInt("meni_Id");
                System.out.println("ID = " + id + " " + "Naziv: " + naziv + " " + "Opis: " + opis + " Cena: " + cena + " meni id: " + meni_id);
            }
            rs.close();
            statement.close();

            // vraca sve vrednosti i ispisuje ih ok  2.3.a

            System.out.println("---------------2.3.b---------------------------------------------------");

            System.out.println("\n prikaz svih kolona tabele jelo kod kojih u nazivu postoji karakter m");
            statement = connection.createStatement();
            rs = statement.executeQuery( "SELECT * FROM jelo WHERE naziv LIKE '%m%' ORDER BY naziv ASC" );
            Konstante.prikazUniverzalan(rs);
            rs.close();
            statement.close();


            System.out.println("---------------2.3.c---------------------------------------------------");

            System.out.println("sve kolone tabele poruceno_jelo kod koje su vrednosti kolone kolicina\n" +
                    "vece od 3");
            statement = connection.createStatement();
            rs = statement.executeQuery( "SELECT * FROM poruceno_jelo WHERE kolicina>3 ORDER BY kolicina" );
            Konstante.prikazUniverzalan(rs);
            rs.close();
            statement.close();

            System.out.println("---------------2.3.d---------------------------------------------------");

            System.out.println("prikazuje sve kolone tabele poruceno_jelo kod koje su vrednosti kolone kolicina u\n" +
                    "intervalu od 1 do 4");
            statement = connection.createStatement();
            rs = statement.executeQuery( "SELECT * FROM poruceno_jelo WHERE kolicina BETWEEN 1 AND 4" );
            Konstante.prikazUniverzalan(rs);
            rs.close();
            statement.close();


            System.out.println("---------------2.3.e---------------------------------------------------");

            System.out.println("koji spaja tabele jelo i meni navode´ci uslov spajanja tabela u WHERE klauzuli i prikazuje\n" +
                    "sve vrednosti kolona");
            statement = connection.createStatement();
            rs = statement.executeQuery( "SELECT * FROM meni t1,jelo t2 " +
                    "WHERE t1.id=t2.meni_id" );  // malo zeznuto  jelo ima u tabeli meni id
            Konstante.prikazUniverzalan(rs);
            rs.close();
            statement.close();


            System.out.println("---------------2.3.f---------------------------------------------------");

            System.out.println("koji spaja tabele jelo i meni koriste´ci INNER JOIN u FROM klauzuli i prikazuje sve vrednosti kolona");
            statement = connection.createStatement();
            rs = statement.executeQuery( "SELECT * " +
                    "FROM meni a INNER JOIN jelo s "+
                    "ON a.id=s.meni_id ");
            Konstante.prikazUniverzalan(rs);
            rs.close();
            statement.close();

            System.out.println("---------------2.3.g---------------------------------------------------");
/*
            System.out.println(" koji spaja tabele jelo, poruceno_jelo i porudzbina koriste´ci INNER JOIN u FROM klauzuli\n" +
                    "i prikazuje sve vrednosti kolona");
            statement = connection.createStatement();
            rs = statement.executeQuery( "SELECT * " +
                    "FROM meni a INNER JOIN jelo s "+
                    "ON a.id=s.meni_id ");
            Konstante.prikazUniverzalan(rs);
            rs.close();
            statement.close();
*///   uradi na casu



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


/* kod koji se cesto ponavlja

package sql.zadatak4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Zadatak3Select {

    public static void main(String[] args) {


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

}


*  */
