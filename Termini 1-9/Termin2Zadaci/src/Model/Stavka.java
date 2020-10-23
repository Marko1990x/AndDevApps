package Model;

public class Stavka {

    private int kolicina;
    Artikal artikal; // po zadatku 2.3.2 dadati i getteri i setteri

    public Stavka() {
    }

    public Stavka(int kolicina) {
        this.kolicina = kolicina;
    }

    public Stavka(Stavka a) { // copy konstruktor
        this.kolicina = a.kolicina;
        this.artikal = a.artikal;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }
}
