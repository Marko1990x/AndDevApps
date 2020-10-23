package Zadatak3;

public class Zadatak3Verzija4 {

    public static void main(String[] args) {

        // pronadji maksimalnu vrednost


        int matrix[][] = {
                {4,6,9,4,6}, {1,3,5,8,2}, {4,2,7,8,3}, {3,6,4,2,9},{4,2,5,6,7}};

        int rows = matrix.length, columns = matrix.length;
        int diagonala=1;
        for (int j = 0; j < columns; j++) {  // treba da j bude beca od i
            for (int i=j ; i>=0 ; i--) {
                diagonala= diagonala * matrix[i][j];
            }

        }

        System.out.println("\nMatrix is : ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("multiplication of upper triangle is: "+diagonala);
    }

}
