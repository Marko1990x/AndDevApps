package sql.zadatak4;

import java.sql.ResultSet;

public class Konstante {
    /*link za konekciju sa bazom
      prodavnicaSQLite.db - naziv fajla u koji ce biti upisane sve vrednosti za
                            bazu
    */
    public static final String DATABASE_URL="jdbc:sqlite:prodavnicaSQLite.db";

    public static void prikazUniverzalan(ResultSet rs) throws Exception{
        /*MetaData pretstavlja podatke o samoj tabeli, naziv tabele,
           naziv kolona, broj kolona u tabeli
         */
        int columnCount=rs.getMetaData().getColumnCount();//Dobijemo broj kolona u tabeli
        while (rs.next())
        {
            for( int i=1; i<=columnCount;i++)
                /*Na osnovu indexa dobijamo naziv kolone sa getColumnName i
                 vrednost kolone za odgovarajuci red u tabeli sa getObject
                 */
                System.out.print(rs.getMetaData().getColumnName(i) + " " + rs.getObject(i)+ " ");
            System.out.println();
        }
    }
}
