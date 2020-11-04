package Zadatak2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadatak2Verzija3 {
    public static Scanner scanner = new Scanner(System.in);

    public static boolean isNumber(String string) {

        try {
            Long.parseLong(string);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static void main(String[] args) {

        String number = null;   // provera da li je unet broj ili ne
        do {
            number = scanner.nextLine();
            if(!isNumber(number) == true){
                System.out.println("niste uneli broj");
            }

        } while (!isNumber(number));
        if(!isNumber(number) == false){
            System.out.println("uneli ste broj");



            int n = Integer.parseInt(number); // ok  // this one is not good
            int a = n * -1;
            int b = n;

            ArrayList<Integer> numbers = new ArrayList<Integer>(n);

            for (int i = 1; i <= a; i++)
            {
                numbers.add(i);

                System.out.println(numbers.get(i - 1));
            }

            System.out.println(number);
        }

    }




}
