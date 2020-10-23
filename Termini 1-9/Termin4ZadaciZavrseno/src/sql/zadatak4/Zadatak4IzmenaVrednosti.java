package sql.zadatak4;

import java.sql.*;

public class Zadatak4IzmenaVrednosti {

    public static void main(String[] args) {

        Connection connection = null; // poziv metode iz jar fajla pretpostvljam za sql
        Statement statement; // metoda iz sql jar ponovo

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(Konstante.DATABASE_URL);
            System.out.println("usposno povezano sa bazom");


            System.out.println("--------------------------2.4.1--------------------------------------");
            statement = connection.createStatement();
            String sql = "UPDATE meni SET " +
                    "id = 1,oznaka='Restoran Prvi', datum = date('now')" +
                    "WHERE id=1;";
            statement.executeUpdate(sql);
            statement.close();


            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery( "SELECT * FROM meni;" );
            Konstante.prikazUniverzalan(rs);
            rs.close();
            statement.close();


            // ok proverio sam sa viewerom
            System.out.println("--------------------------2.4.2--------------------------------------");
            statement = connection.createStatement();
            sql = "UPDATE jelo SET " +
                    "id=2,naziv='Cevapi',opis='Meso 200g',cena=350.00,meni_id=1 " +
                    "WHERE id=2;";
            statement.executeUpdate(sql);
            statement.close();


            statement = connection.createStatement();
            rs = statement.executeQuery( "SELECT * FROM jelo;" );
            Konstante.prikazUniverzalan(rs);
            rs.close();
            statement.close();


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
