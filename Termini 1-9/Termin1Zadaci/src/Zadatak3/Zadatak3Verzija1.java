package Zadatak3;

import java.util.*;


public class Zadatak3Verzija1 {

    public static void sorter(int matrix[][]){   // dodaje redove u matricu
        for (int[] row: matrix
             )

        {
            System.out.println(Arrays.toString(row)); // moze i druga print metoda print za kolone
        }
    }

    public static void main(String[] args) {

        int matrix[][] = {
                {4,6,9,4,6}, {1,3,5,8,2}, {4,2,7,8,3}, {3,6,4,2,9},{4,2,5,6,7}};

        sorter(matrix);
    }


}
