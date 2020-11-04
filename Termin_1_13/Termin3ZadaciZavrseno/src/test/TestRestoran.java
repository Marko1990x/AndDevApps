package test;

import model.Jelo;
import model.Meni;
import model.PorucenoJelo;
import model.Porudzbina;
import java.util.ArrayList;
import java.util.Date;

public class TestRestoran {

    public static Jelo instanciranjeJelo(String naziv, String opis, double cena) {

        Jelo jeloX = new Jelo(naziv, opis, cena);

        return jeloX;
    }

    public static Meni instanciranjeDatum(String oznaka, Date Datum) {
        Meni meni = new Meni(oznaka, Datum);
        return meni;

    }

    public static PorucenoJelo instanciranjePorucenogJela(int Kolicina) {
        PorucenoJelo porucenoJelo = new PorucenoJelo(Kolicina);
        return porucenoJelo;
    }

    public static Porudzbina instanciranjePorudzbine(String konobar, Date datum) {
        Porudzbina porudzbina = new Porudzbina(konobar, datum);
        return porudzbina;

    }


    public static void dodajReference (Meni m, Jelo j){

        m.getJelo().add(j); // ubacuje u array listu i pravi referencu
        System.out.println("dodato jelo u restoran:" + m + " " + j);
        j.setMenix(m);  // ovo je druga referenca

    }


    public static void dodajReferenceJeloPorucenoJelo(Jelo j, PorucenoJelo p){

        j.getPorucenoJelos().add(p); // klasa jelo povezana sa porucenim jelom tako sto sam dodao kolicinu u arrayListu
        p.setJelo(j);

        System.out.println("dodato jelo i porruceno jelo" + j + " " + p);
    }

    public static void dodajReferencePorudzbinaPorucenoJelo(Porudzbina porudzbina, PorucenoJelo porucenoJelo){

        porudzbina.getPorucenoJelos().add(porucenoJelo);
        porucenoJelo.setPorudzbina(porudzbina);  // obe veze
        System.out.println("dodata porudzbina i poruceno jelo:" + porudzbina + " " + porucenoJelo);

    }

    public static void main(String[] args) {

        // instanciranje klase test Jelo

        var j = instanciranjeJelo("Spagete", "Testo sa mesom", 400.00);
        var j1 = instanciranjeJelo("Cevapi", "Meso", 350.00);
        var j2 = instanciranjeJelo("Kolac", "Kolac sa orasima", 200.00);
        var j3 = instanciranjeJelo("pleskavica", "lepinja sa mesom", 200.00);
        var j4 = instanciranjeJelo("Belo meso", "Belo meso 300g", 370.00);
        var j5 = instanciranjeJelo("Slatka Palacinka", "Palacinka sa orsima", 350.00);

        // koristi overide to string iz klase jelo
        //System.out.println(a);
        //System.out.println(a1);

        // instanciranje klase meni
        var m = instanciranjeDatum("Restoran 1", new Date());
        var m1 = instanciranjeDatum("Restoran 2", new Date());
       /* var x = m1.getNaziv();
        System.out.println(x);*/

        //System.out.println(m);
        //System.out.println(m1);

        var porucenoJelo = instanciranjePorucenogJela(1);
        var porucenoJelo1 = instanciranjePorucenogJela(2);
        var porucenoJelo2 = instanciranjePorucenogJela(3);
        var porucenoJelo3 = instanciranjePorucenogJela(4);
        var porucenoJelo4 = instanciranjePorucenogJela(5);


        // instanciranje klase porudzbine

        var porudzbina = instanciranjePorudzbine("Jovan Jovanovic", new Date());
        var porudzbina1 = instanciranjePorudzbine("Petar Petrovic", new Date());


        // asociacije


        // m je objekat klase meni koji ima restoran 1 treba povezati sa j promenjivom koja ima spagete u sebi

        /*
        Potrebno je postaviti odgovaraju´ce reference izme ¯ du objekata tipa Meni i Jelo. Veze postoje
izmedu sledecih objekata:

Za objekat klase Meni sa nazivom "Restoran1" postaviti da je povezan sa objektom
klase Jelo koji za vrednost atributa naziv ima vrednost "Spagete"

        *  */



          // naziv menija restorana 1 punim sa objektom jela koji ima spagete u nazivu.;



        dodajReference(m,j);    // dodavanje referenca na obe strane preko metode
        dodajReference(m,j1);
        dodajReference(m,j2);
        dodajReference(m1,j3);
        dodajReference(m1,j4);
        dodajReference(m,j5);


        dodajReferenceJeloPorucenoJelo(j, porucenoJelo);   // veze izmedju tipa jelo i poruceno jelo
        dodajReferenceJeloPorucenoJelo(j1, porucenoJelo1);
        dodajReferenceJeloPorucenoJelo(j2, porucenoJelo2);
        dodajReferenceJeloPorucenoJelo(j3, porucenoJelo3);
        dodajReferenceJeloPorucenoJelo(j4, porucenoJelo4);


        dodajReferencePorudzbinaPorucenoJelo(porudzbina, porucenoJelo);  // veze izmedju porudzbina i poruceno jelo
        dodajReferencePorudzbinaPorucenoJelo(porudzbina, porucenoJelo1);
        dodajReferencePorudzbinaPorucenoJelo(porudzbina, porucenoJelo2);
        dodajReferencePorudzbinaPorucenoJelo(porudzbina1, porucenoJelo3);
        dodajReferencePorudzbinaPorucenoJelo(porudzbina1, porucenoJelo4);


        System.out.println("Prikaz jela menija:  "+ " restoran " + m.getNaziv());
        for (Jelo jx:
                m.getJelo()) {
            System.out.println("Jelo je: "+ " " +jx);
        }

        System.out.println("\n prikaz jela porudzbine" + porudzbina.getKonobar()); // prvi konbar
        for (PorucenoJelo asd:
             porudzbina.getPorucenoJelos()) {
            System.out.println("Kolicina: " + asd.getKolicina() + " Jelo " + asd.getJelo());
        }

        System.out.println("\n prikaz jela drugog konovara: "+ porudzbina1.getKonobar() + "  " + "gde u nazivu ima meso");
        for (PorucenoJelo asd2:
             porudzbina1.getPorucenoJelos()) {
            if (asd2.getJelo().getNaziv().contains("meso"));
            System.out.println("kolicina: " + asd2.getKolicina() + " Jelo " + asd2.getJelo());
        }

        // sada je skroz ok


        /*

        var pJelo0 = new ArrayList<PorucenoJelo>();
        pJelo0.add(porucenoJelo); // prvi objekat

        var pJelo1 = new ArrayList<PorucenoJelo>();
        pJelo1.add(porucenoJelo1);  // drugi

        var pJelo2 = new ArrayList<PorucenoJelo>();
        pJelo2.add(porucenoJelo2); // etd

        var pJelo3 = new ArrayList<PorucenoJelo>();
        pJelo3.add(porucenoJelo3);

        var pJelo4 = new ArrayList<PorucenoJelo>();
        pJelo4.add(porucenoJelo4);


        // associacija izmedju klase jelo i poruceno jelo ok

        j.setPorucenoJelos(pJelo0); // spagete sa vrednoscu 1
        j.setPorucenoJelos(pJelo1); //cevapi sa 2
        j.setPorucenoJelos(pJelo2);  // kolac sa 3
        j.setPorucenoJelos(pJelo3); // pljeskavica sa 4
        j.setPorucenoJelos(pJelo4);  // belo meso sa 5


        System.out.println("--------------------------------------------------------------------");
        //POVEZIVANJE OBJEKATA KLASA PORUDZBINA I PORUCENOJELO


        // ok porudzbina i 1 sa kolicinom (porucenim jelima ) jovan prva 3 pera ostalo

        var z0 = new ArrayList<PorucenoJelo>();
        z0.add(porucenoJelo);
        var z1 = new ArrayList<PorucenoJelo>();
        z1.add(porucenoJelo1);
        var z2 = new ArrayList<PorucenoJelo>();
        z2.add(porucenoJelo2);
        var z3 = new ArrayList<PorucenoJelo>();
        z3.add(porucenoJelo3);
        var z4 = new ArrayList<PorucenoJelo>();
        z4.add(porucenoJelo4);
        porudzbina.setPorucenoJelos(z0);
        porudzbina.setPorucenoJelos(z1);
        porudzbina.setPorucenoJelos(z2);
        porudzbina1.setPorucenoJelos(z3);
        porudzbina1.setPorucenoJelos(z4);






/*
  // asociacija restorana sa objekom klase jelo
        ArrayList Restoran1 = new ArrayList<Jelo>();
        Restoran1.add(j); // spagete
        Restoran1.add(j1); // cevapi
        Restoran1.add(j2); // kolac

        ArrayList Restoran2 = new ArrayList<Jelo>();
        Restoran2.add(j3);  // pljeskavica
        Restoran2.add(j4);  // belo meso
        Restoran2.add(j5);  // slatka palacinka

        System.out.println(Restoran1);
        System.out.println(Restoran2);
        //System.out.println(j);

       // settovanje array liste u klasi meni za restoran 1 i 2
        m.setJelo(Restoran1);
        m1.setJelo(Restoran2);

        // provera ok restoran 1
        System.out.println(m);
        System.out.println(m.getJelo());

        // provera ok restoran 2
        System.out.println(m1);
        System.out.println(m1.getJelo());


        System.out.println("---------------------------------------------------------------");

        // j set array of poruceno jelo

*/

    }


}
