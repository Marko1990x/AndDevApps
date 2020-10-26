package firebaseapp.com.radnacasu20.model;

public class Movies {

    private String imeFilma;
    private int ocenaFilma;

    public String getImeFilma() {
        return imeFilma;
    }

    public void setImeFilma(String imeFilma) {
        this.imeFilma = imeFilma;
    }

    public int getOcenaFilma() {
        return ocenaFilma;
    }

    public void setOcenaFilma(int ocenaFilma) {
        this.ocenaFilma = ocenaFilma;
    }

    public Movies(String imeFilma, int ocenaFilma) {
        this.imeFilma = imeFilma;
        this.ocenaFilma = ocenaFilma;
    }

    public Movies() {
    }
}
