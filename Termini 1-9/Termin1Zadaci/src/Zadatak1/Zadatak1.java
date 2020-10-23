package Zadatak1;

import java.util.Scanner;

enum semafor{  // enumeracija
    Crveno, ZutoCrveno, Zeleno, ZutoZeleno
}

public class Zadatak1 {

    public static Scanner scanner = new Scanner(System.in);

    // metoda za prvi deo zadatka

    public static void zadatak1varianta1(){

        // zadatak 2 deo 1
        String unos;

        do {
            System.out.println("unesite nesto");
            unos = scanner.nextLine();
            semafor sf1 = semafor.Crveno;  // deklaracija i ubaceno u promenjivu
            semafor sf2 = semafor.ZutoCrveno;
            semafor sf3 = semafor.Zeleno;
            semafor sf4 = semafor.ZutoZeleno;
            //       System.out.println(sf1);
            //      System.out.println(sf2);

            // varianta 1 switch;
            String a = unos;
            System.out.println(unos);
            switch (a) {
                case "Crveno":
                    System.out.println("Trenutna Vrednost je "+ "  " + sf1);
                    System.out.println("Prelazi se na" + " " + sf2);
                    break;
                case "ZutoCrveno":
                    System.out.println("uneta je vrednost"+ " " + sf2);
                    System.out.println("Prelazi se na" + " " + sf3);
                    break;
                case "Zeleno":
                    System.out.println("uneta je vrednost" + " " + sf3);
                    System.out.println("prelazi se na" + " " + sf4);
                    break;
                case "ZutoZeleno":
                    System.out.println("uneta je vrednost"+ " " + sf4);
                    System.out.println("Prelazi se na" + " " + sf1);
                    break;
                default :
                    System.out.println( "pogresna opcija unesite ponovo" ) ;
                    System.out.println("unesite x za prekid programa");
            }

            System.out.println("unesite x za prekid programa");
        }while(!unos.equals("x"));



    }


    public static void zadatak1varianta2(){
        String unos;
        System.out.println("unesite nesto");
        unos = scanner.nextLine();
        semafor sf1 = semafor.Crveno;  // deklaracija i ubaceno u promenjivu
        semafor sf2 = semafor.ZutoCrveno;
        semafor sf3 = semafor.Zeleno;
        semafor sf4 = semafor.ZutoZeleno;
        var a = unos;


        do{

            if (a.matches("Crveno")){

                System.out.println("Trenutna Vrednost je "+ "  " + sf1);
                System.out.println("Prelazi se na" + " " + sf2);
                break;

            }else if (a.matches("ZutoCrveno")){

                System.out.println("uneta je vrednost"+ " " + sf2);
                System.out.println("Prelazi se na" + " " + sf3);
                break;

            }else if (a.matches("Zeleno")){

                System.out.println("uneta je vrednost" + " " + sf3);
                System.out.println("prelazi se na" + " " + sf4);
                break;

            }else if (a.matches("ZutoZeleno")){

                System.out.println("uneta je vrednost"+ " " + sf4);
                System.out.println("Prelazi se na" + " " + sf1);
                break;

            } else{
                System.out.println("Uneli ste pogresnu vrednost" + " " +unos);
            }

        }while(!unos.equals("x"));

    }




    public static void main(String[] args) {


    //zadatak1varianta1(); // poziv metode za deo 1

   // zadatak1varianta2(); // poziv metoda za deo 2 zadatka 1





    }
}
