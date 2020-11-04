package Test;

import Model.Artikal;
import Model.Racun;
import Model.Stavka;

import java.util.Date;

public class TestProdavnica {


    public static Artikal instanciranjeArtikal(String Naziv, String Opis, double Cena) {

        Artikal artikalX = new Artikal(Naziv, Opis, Cena);

        // što mi nenudi automatsko pokazivanje svih konstruktora kao u eclipsu ?

        System.out.println("Naziv = " + Naziv + ", Opis = " + Opis + ", Cena = " + Cena);

        return artikalX;


    }


    public static Racun inicializacijaRacuna(String oznaka, Date datum) {

        Racun racun = new Racun(oznaka, datum);

        System.out.println("oznaka = " + oznaka + ", datum = " + datum);

        return racun;
    }

    public static int incializacijaStavka(int kolicina) {
        Stavka stavka = new Stavka(kolicina);
        System.out.println("kolicina = " + kolicina);
        return kolicina;

    }

    public static void references(Artikal artikal, Stavka stavka) {

        artikal.getNaziv();
        System.out.println(artikal);


    }

    public static void main(String[] args) {



/*
        // instanciranje artikala //poziv metode ispis parametara.
      Artikal artikal1  =  instanciranjeArtikal("Mleko", "Mleko u flasi 1L", 40.99 );
      Artikal artikal2  = instanciranjeArtikal("Beli Hleb", "400g", 50 );
      Artikal  artikal3 = instanciranjeArtikal("Crni Hleb", "Crni Razeni hleb", 60 );
        Artikal artikal4  = instanciranjeArtikal("Jogurt", "Jogurt u tetrapaku 1l", 90.99 );

        //System.out.println(artikal1);

        Stavka stavka = new Stavka(1);
        Stavka stavka1 = new Stavka(2);
        Stavka stavka2 = new Stavka(3);


        System.out.println("-------------------------------------------------------");
        // instanciranje racuna //
       Racun racun = inicializacijaRacuna("Racun1", new Date());
       Racun racun1 = inicializacijaRacuna("Racun2", new Date());

        // instanciranje klase stavka
*/

        //cancer // reference vezane za stavku i za artikal


        // previse sam ga bip zakomplikovao gde nije trebalo

        Artikal artikal1 = new Artikal("Mleko", "Mleko u flasi 1L", 40.99);
        Artikal artikal2 = new Artikal("Beli hleb", "400g", 50.00);
        Artikal artikal3 = new Artikal("Crni hleb", "Crni rezani hleb", 60.00);
        Artikal artikal4 = new Artikal("Jogurt", "Jogurt u tetrapaku 1L", 90.99);

        Racun racun1 = new Racun("Racun1", new Date());
        Racun racun2 = new Racun("Racun2", new Date());

        Stavka stavka1 = new Stavka(1);
        Stavka stavka2 = new Stavka(2);
        Stavka stavka3 = new Stavka(3);


        stavka1.setArtikal(artikal1);
        stavka2.setArtikal(artikal2);
        stavka3.setArtikal(artikal3);

        artikal1.cancer(stavka1);
        artikal2.cancer(stavka2);
        artikal3.cancer(stavka3);

        racun1.setStavka(stavka1);
        racun1.setStavka(stavka2);
        racun2.setStavka(stavka3);

        System.out.println("-------------------------------------------------------");
        for (Stavka stavka :
                racun1.getStavke()) {
            System.out.println("naziv:" + " " + stavka.getArtikal().getNaziv() + "kolicina: " + " " + stavka.getKolicina());
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("\n Ako je kolicina 2");
        for (Stavka stavka :
                racun1.getStavke()) {
            if (stavka.getKolicina() == 2)
                System.out.println("Naziv:" + " " + stavka.getArtikal().getNaziv() + "Kolicina :" + " " + stavka.getKolicina());
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("\n Ako je naziv Mleko");
        for (Stavka stavka :
                racun1.getStavke()) {
            if (stavka.getArtikal().getNaziv().equals("Mleko"))
                System.out.println("Naziv:" + " " + stavka.getArtikal().getNaziv() + "Kolicina :" + " " + stavka.getKolicina());
        }

       /* var a = incializacijaStavka(1);
        var b = incializacijaStavka(2);
        var c = incializacijaStavka(3);*/

        // System.out.println(c);// test da vidim da li mi metoda vraca vrednost

        /*ArrayList<Stavka> arl = new ArrayList<Stavka>();

        Artikal artikal = new Artikal();
        artikal.setArrayStavka(a,b,c);
        System.out.println(artikal.getArrayStavka());*/


    }


}
