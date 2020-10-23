package model;

import java.util.ArrayList;
import java.util.Date;

public class Porudzbina {

    private String konobar;
    private Date Datum;
    private ArrayList<PorucenoJelo> porucenoJelos;

    public Porudzbina() {
        this.porucenoJelos = new ArrayList<PorucenoJelo>();
    }

    public Porudzbina(String konobar, Date datum) {
        this.konobar = konobar;
        Datum = datum;
        this.porucenoJelos = new ArrayList<PorucenoJelo>();
    }

    public Porudzbina(Porudzbina a) {
        this.konobar = a.konobar;
        this.Datum = a.Datum;
    }

    public String getKonobar() {
        return konobar;
    }

    public void setKonobar(String konobar) {
        this.konobar = konobar;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date datum) {
        Datum = datum;
    }


    public ArrayList<PorucenoJelo> getPorucenoJelos() {
        return porucenoJelos;
    }

    public void setPorucenoJelos(ArrayList<PorucenoJelo> porucenoJelos) {
        this.porucenoJelos = porucenoJelos;
    }

    @Override
    public String toString() {
        return "Konobar:" + " "+ konobar + " " +  "Datum:" + " " + Datum;
    }
}
