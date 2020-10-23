package model;

import java.util.ArrayList;

public class Jelo {

    private String naziv;
    private String opis;
    private Double cena;
    private Meni menix;
    private ArrayList<PorucenoJelo> porucenoJelos;


    // konstruktori
    public Jelo() {
        this.porucenoJelos = new ArrayList<PorucenoJelo>();
    }

    public Jelo(String naziv, String opis, Double cena) {
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
        this.porucenoJelos = new ArrayList<PorucenoJelo>();
    }

    public Jelo(Jelo a) {  // objekat
        this.naziv = a.naziv;
        this.opis = a.opis;
        this.cena = a.cena;

    }
    // getteri i setteri


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

    // toString


    public ArrayList<PorucenoJelo> getPorucenoJelos() {
        return porucenoJelos;
    }

    public void setPorucenoJelos(ArrayList<PorucenoJelo> porucenoJelos) {
        this.porucenoJelos = porucenoJelos;
    }

    @Override
    public String toString() {
        return "Naziv:" + " " + naziv + "Opis:" + " " + opis +" "+ "Cena:" +" " + cena;
    }

    public Meni getMenix() {
        return menix;
    }

    public void setMenix(Meni menix) {
        this.menix = menix;
    }
}
