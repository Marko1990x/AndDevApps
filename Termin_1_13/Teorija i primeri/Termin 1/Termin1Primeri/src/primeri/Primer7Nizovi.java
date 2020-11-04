package primeri;

public class Primer7Nizovi {
    public static void main(String[] args) {
        {
            System.out.println("Niz");
            int niz [] = {1 , 2 , 3 , 4};
            for ( int i = 0; i < niz.length ; i ++)
                System.out.println(niz[i]) ;
        }

        {
            System.out.println();
            System.out.println("Visedimenzionalni niz");
            int [][] a = { {1 , 2 , 3} , {4 , 5 , 6} };
            for ( int i = 0; i < a.length ; i ++) {
                for ( int j = 0; j < a[i].length ; j ++) {
                    System.out.println(a[i][j]) ;
                }
                System.out.println() ;
            }
        }
    }
}
