package Zadatak3;

public class Zadatak3Verzija2 {

    public static void main(String[] args) {

        int matrix[][] = {
                {4,6,9,4,6}, {1,3,5,8,2}, {4,2,7,8,3}, {3,6,4,2,9},{4,2,5,6,7}};

        int diagonala=1; // nemoze biti 0 jer ce sve vrednosti onda biti 0
        int rows = matrix.length, columns = matrix.length;
        for (int i = 0, j =0; i< rows && j < columns; i++, j++) {
            diagonala= diagonala * matrix[i][j]; // moze i sa  i i  proveri
            System.out.println(diagonala);
        }

    }

}
