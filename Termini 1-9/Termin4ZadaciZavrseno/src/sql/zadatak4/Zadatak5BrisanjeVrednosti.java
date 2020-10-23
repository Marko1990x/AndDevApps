package sql.zadatak4;

import java.sql.*;

public class Zadatak5BrisanjeVrednosti {

    public static void main(String[] args) {

        Connection connection = null; // poziv metode iz jar fajla pretpostvljam za sql
        Statement statement; // metoda iz sql jar ponovo

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(Konstante.DATABASE_URL);
            System.out.println("usposno povezano sa bazom");

            statement = connection.createStatement();
            String sql = "DELETE FROM poruceno_jelo where ID=2 AND ID=4;";  // ovo je greska
            statement.executeUpdate(sql);
            statement.close();


            ResultSet rs = statement.executeQuery( "SELECT * FROM poruceno_jelo" );
            Konstante.prikazUniverzalan(rs);
            rs.close();


            statement = connection.createStatement();
            sql = "DELETE FROM porudzbina where ID=2;";
            statement.executeUpdate(sql);
            statement.close();


            rs = statement.executeQuery( "SELECT * FROM porudzbina" );
            Konstante.prikazUniverzalan(rs);
            rs.close();
            // ok je vidim da brise kako treba 2.5.2


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

