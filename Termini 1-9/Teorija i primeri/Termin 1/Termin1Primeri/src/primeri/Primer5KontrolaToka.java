package primeri;

public class Primer5KontrolaToka {
    public static void main(String[] args) {
        {
            //if else
            int testval=3,target=4;
            int result = 0;
            if ( testval > target )
                result = -1;
            else if ( testval < target )
                result = +1;
            else
                result = 0; // kada su vrednosti iste
            //Zadatak 1. Napisati gornji if else izraz koristeci uslovni operator.
        }
        System.out.println();
        {
            //Uslovni operator
            int a,i=4;
            a = i < 10 ? i * 100 : i * 10;

            System.out.println("a = " + a);

            if ( i < 10)
                a = i * 100;
            else
                a = i * 10;

            System.out.println("a = " + a);
        }
        {
            //switch
            char c='a';
            switch ( c ) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println( "samoglasnik" ) ;
                    break ;
                default :
                    System.out.println( "suglasnik" ) ;
            }
            //Zadatak 2. Napisati gornju switch naredbu koristeci if else izraz


            int ocena = -1;

            if ( ocena == 5)
                System.out.println( "odlican" ) ;
            else if ( ocena == 4)
                System.out.println( "vrlo dobar" ) ;
            else if ( ocena == 3)
                System.out.println( "dobar" ) ;
            else if ( ocena == 2)
                System.out.println( "dovoljan" ) ;
            else if ( ocena == 1)
                System.out.println( "nedovoljan" ) ;
            else
                System.out.println( "nepostojeca ocena" ) ;

            switch ( ocena ) {
                case 5: System.out.println( "odlican" ) ;
                    break ;
                case 4: System.out.println ( " vrlo dobar " ) ;
                    break ;
                case 3: System.out.println ( "dobar" ) ;
                    break ;
                case 2: System.out.println ( "dovoljan" ) ;
                    break ;
                case 1: System.out.println ( "nedovoljan" ) ;
                    break ;
                default : System.out.println( "nepostojeca ocena" ) ;
            }
        }
    }
}
