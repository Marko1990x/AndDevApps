package sql.zadatak4;


import java.sql.*;

public class Zadatak6BrisanjeTabela {

    public static void main(String[] args) {


        Connection connection = null; // poziv metode iz jar fajla pretpostvljam za sql
        Statement statement; // metoda iz sql jar ponovo

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(Konstante.DATABASE_URL);
            System.out.println("usposno povezano sa bazom");



            statement = connection.createStatement();
            String sql = "DROP TABLE IF EXISTS poruceno_jelo";
            statement.executeUpdate(sql);
            statement.close();

            statement = connection.createStatement();
            sql = "DROP TABLE IF EXISTS poruceno_jelo";
            statement.executeUpdate(sql);
            statement.close();

            statement = connection.createStatement();
            sql = "DROP TABLE IF EXISTS porudzbina";
            statement.executeUpdate(sql);
            statement.close();

            statement = connection.createStatement();
            sql = "DROP TABLE IF EXISTS porudzbina";
            statement.executeUpdate(sql);
            statement.close();

            statement = connection.createStatement();
            sql = "DROP TABLE IF EXISTS jelo";
            statement.executeUpdate(sql);
            statement.close();

            statement = connection.createStatement();
            sql = "DROP TABLE IF EXISTS meni";
            statement.executeUpdate(sql);
            statement.close();

            statement = connection.createStatement();
            sql = "DROP TABLE IF EXISTS meni";
            statement.executeUpdate(sql);
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

        System.out.println("Tabele obrisane");

    }

}
