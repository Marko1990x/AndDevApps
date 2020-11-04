package Zadatak2;


import java.util.Scanner;

public class Zadatak2Verzija2 {
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



            int n = Integer.parseInt(number), sum = 0;  // ok
            // neparni brojevi imaju ostatak pri deljenu sa 0

            for(int i = 1; i <= n; ++i)
            {
                if(i%2!=0){
                    sum = sum + i;
                }
            }

            System.out.println("Sum = " + sum);


        }

    }




}
