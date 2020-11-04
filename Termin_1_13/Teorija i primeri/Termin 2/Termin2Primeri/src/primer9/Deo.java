package primer9;



public class Deo {
    private String naziv;

    //Kraj veze za Asocijaciju
    private Automobil automobil;

    public Deo() {
    }

    public Deo(String naziv) {
        this.naziv = naziv;
    }

    public Deo(Deo d){
        this.naziv=d.naziv;
        this.automobil=d.automobil;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Automobil getAutomobil() {
        return automobil;
    }

    public void setAutomobil(Automobil automobil) {
        this.automobil = automobil;
    }
}
