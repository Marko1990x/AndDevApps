package primeri;

public class Primer6Ciklusi {
    public static void main(String[] args) {
        {
            //for petlja
            for ( int i = 0; i < 10; i ++)
                System . out . println ( i ) ;

            for ( int i = 0 , j = 1; i < 10 && j != 11; i ++ ,
                    j ++)
                System.out.println(i+","+j);

            /*Zbog pretvaranja decimalnih vrednosti u binarnu formu
               uslov za sledecu for petlju nikad nece biti zadovoljen
                jer se ne moze dobiti vrednost 10.
             */
            /*
            for ( double x = 0; x != 10; x +=0.1)
                System.out.println("x = " + x);
            /**/
        }
        System.out.println();
        {
            //while
            int i = 0;
            while ( i <= 10)
            {
                System.out.println( "Trenutno je " + i ) ;
                i = i +1;
            }
        }
        System.out.println();
        {
            //do while
            int i = 0;
            do {
                System.out.println( i ) ;
            } while ( ++i < 10) ;
            //Sta bi se desilo ako se ovde stavi inkrement kao sufiks umesto prefiksa?
        }
        System.out.println();
        {
            //break i continue
            for ( int i = 0; i < 10; i ++) {
                if ( i ==7) {
                    break ;
                }
                if ( i == 2)
                    continue ;
                System.out.println( "Broj je : " + i ) ;
            }
        }
    }
}
