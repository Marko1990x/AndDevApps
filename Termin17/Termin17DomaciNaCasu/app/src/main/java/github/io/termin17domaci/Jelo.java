package github.io.termin17domaci;

import java.util.List;

public class Jelo {


    private String naziv;
    private float ocena;
    private int id;
    private String opis;
    private List<String> sastojci;
    private int kalorije;
    private double cena;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public List<String> getSastojci() {
        return sastojci;
    }

    public void setSastojci(List<String> sastojci) {
        this.sastojci = sastojci;
    }

    public int getKalorije() {
        return kalorije;
    }

    public void setKalorije(int kalorije) {
        this.kalorije = kalorije;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Jelo(int id, String naziv, float ocena, String opis, List<String> sastojci, int kalorije, double cena) {
        this.id = id;
        this.naziv = naziv;
        this.ocena = ocena;
        this.opis = opis;
        this.sastojci = sastojci;
        this.kalorije = kalorije;
        this.cena = cena;
    }

    public Jelo(String naziv, float ocena, int id, String opis, List<String> sastojci, int kalorije, double cena) {
        this.naziv = naziv;
        this.ocena = ocena;
        this.id = id;
        this.opis = opis;
        this.sastojci = sastojci;
        this.kalorije = kalorije;
        this.cena = cena;
    }
}
