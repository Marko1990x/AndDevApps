package Model;

public class Filmovi {

    private String nazivFilma;
    private String opisFilma;
    private int ocenaFilma;

    public Filmovi() {
    }

    public Filmovi(String nazivFilma, String opisFilma, int ocenaFilma) {
        this.nazivFilma = nazivFilma;
        this.opisFilma = opisFilma;
        this.ocenaFilma = ocenaFilma;
    }

    public String getNazivFilma() {
        return nazivFilma;
    }

    public void setNazivFilma(String nazivFilma) {
        this.nazivFilma = nazivFilma;
    }

    public String getOpisFilma() {
        return opisFilma;
    }

    public void setOpisFilma(String opisFilma) {
        this.opisFilma = opisFilma;
    }

    public int getOcenaFilma() {
        return ocenaFilma;
    }

    public void setOcenaFilma(int ocenaFilma) {
        this.ocenaFilma = ocenaFilma;
    }

    @Override
    public String toString() {
        return "Filmovi{" +
                "nazivFilma='" + nazivFilma + '\'' +
                ", opisFilma='" + opisFilma + '\'' +
                ", ocenaFilma=" + ocenaFilma +
                '}';
    }
}
