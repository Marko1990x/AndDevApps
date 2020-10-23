package Zadatak3;

public class Zadatak3Verzija3 {

    public static void main(String[] args) {

        int matrix[][] = {
                {4,6,9,4,6}, {1,3,5,8,2}, {4,2,7,8,3}, {3,6,4,2,9},{4,2,5,6,7}};

        int diagonala=1; // nemoze biti 0 jer ce sve vrednosti onda biti 0
        int rows = matrix.length, columns = matrix.length;
        for (int i = 1; i < rows; i++) {
            for (int j=i-1 ; j>=0 ; j--) {
                diagonala= diagonala * matrix[i][j];
                System.out.println(diagonala);
            }

        }

    }

}
