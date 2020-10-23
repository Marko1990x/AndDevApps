package Model;

import java.util.ArrayList;

public class Artikal extends Stavka {  // zadatak 2 ok

    private ArrayList<Stavka> arrayStavka = new ArrayList<Stavka>(); // po zadatku 2.3.1
    private String naziv = null;
    private String opis = null;
    private Double cena = null;


    public Artikal() {
        arrayStavka = new ArrayList<>();  // inicializacija prazne liste u konstruktor bez pr
    }

    public Artikal(String naziv, String opis, Double cena) {
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
        arrayStavka = new ArrayList<>();

    }

    public Artikal(Artikal a) { // copy konstruktor
        this.naziv = a.naziv;
        this.opis = a.opis;
        this.cena = a.cena;
        this.arrayStavka = a.arrayStavka; // stavka u copy construktoru
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public ArrayList<Stavka> getArrayStavka() {
        return arrayStavka;
    }

    public void setArrayStavka(ArrayList<Stavka> arrayStavka) {
        this.arrayStavka = arrayStavka;
        System.out.println(arrayStavka);
    }

    public void setArrayStavka(int i, int i1, int i2) {
       /* ArrayList<Integer> intx = new ArrayList<>();
        intx.add(i);
        intx.add(i1);
        intx.add(i2);
        var x = getArrayStavka();
        // kako da mu stavim int u stavku tip ......*/


    }

    public void cancer(Stavka stavka) {
        arrayStavka.add(stavka);
    }
}
