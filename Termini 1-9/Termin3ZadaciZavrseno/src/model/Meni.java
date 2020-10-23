package model;

import java.util.ArrayList;
import java.util.Date;

public class Meni  extends Jelo{
    private String naziv;
    private Date datum;
    private ArrayList<Jelo> jelo = new ArrayList<Jelo>();

    public Meni() {
        this.jelo = new ArrayList<Jelo>(); // instanciranje u praznom konstruktoru
    }

    public Meni(String naziv, Date datum) {
        this.naziv = naziv;
        this.datum = datum;
        this.jelo = new ArrayList<Jelo>();
    }
    public Meni(Meni a){
        this.naziv = a.naziv;
        this.datum = a.datum;

    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Meni:" + " "+ "naziv:" + " "+ naziv + " " + "datum:" + " "+ datum;
    }

    public ArrayList<Jelo> getJelo() {
        return jelo;
    }

    public void setJelo(ArrayList<Jelo> jelox) {
        this.jelo = jelox;
    }
}
