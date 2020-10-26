package firebaseapp.com.radnacasu20.model;

import java.util.Date;
import java.util.List;

public class Actors {

    private String Ime;
    private String Prezime;
    private String Biografija;
    private String Fotografija;
    private int Ocena;
    private Date datumRodjenja;
    private Date datumSmrti;
    private String filmoviActora;


    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String prezime) {
        Prezime = prezime;
    }

    public String getBiografija() {
        return Biografija;
    }

    public void setBiografija(String biografija) {
        Biografija = biografija;
    }

    public String getFotografija() {
        return Fotografija;
    }

    public void setFotografija(String fotografija) {
        Fotografija = fotografija;
    }

    public int getOcena() {
        return Ocena;
    }

    public void setOcena(int ocena) {
        Ocena = ocena;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Date getDatumSmrti() {
        return datumSmrti;
    }

    public void setDatumSmrti(Date datumSmrti) {
        this.datumSmrti = datumSmrti;
    }

    public String getFilmoviActora() {
        return filmoviActora;
    }

    public void setFilmoviActora(String filmoviActora) {
        this.filmoviActora = filmoviActora;
    }

    public Actors() {
    }

    public Actors(String ime, String prezime, String biografija, String fotografija, int ocena, Date datumRodjenja, Date datumSmrti, String filmoviActora) {
        Ime = ime;
        Prezime = prezime;
        Biografija = biografija;
        Fotografija = fotografija;
        Ocena = ocena;
        this.datumRodjenja = datumRodjenja;
        this.datumSmrti = datumSmrti;
        this.filmoviActora = filmoviActora;
    }
}
