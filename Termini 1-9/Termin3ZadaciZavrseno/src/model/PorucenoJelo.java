package model;

public class PorucenoJelo {

   private int kolicina;
    // zadatak ima gresku ovde kada objasnjava generisanje konstruktora kaze stavka mesto PorucenoJelo
   private Jelo jelo;

   private Porudzbina porudzbina;



    public PorucenoJelo() {
    }

    public PorucenoJelo(int kolicina) {
        this.kolicina = kolicina;
    }

    public PorucenoJelo(PorucenoJelo a){
        this.kolicina = a.kolicina;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Jelo getJelo() {
        return jelo;
    }

    public void setJelo(Jelo jelo) {
        this.jelo = jelo;
    }

    public Porudzbina getPorudzbina() {
        return porudzbina;
    }

    public void setPorudzbina(Porudzbina porudzbina) {
        this.porudzbina = porudzbina;
    }

    @Override
    public String toString() {
        return "Kolicina:" +" "+ kolicina;
    }
}
