package Model;

import java.util.ArrayList;
import java.util.Date;

public class Racun {

  private    String oznaka = null;
  private    Date date = null;
  private ArrayList<Stavka> stavka = new ArrayList<>();

    public Racun() {
    }

    public void setStavka(Stavka stavka){
        this.stavka.add(stavka);
    }

    public Racun(String oznaka, Date date) {
        this.oznaka = oznaka;
        this.date = date;
    }

    public Racun(Racun a) { // copy konstruktor
        this.oznaka = a.oznaka;
        this.date = a.date;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Stavka> getStavka() {
        return stavka;
    }

    public void setStavka(ArrayList<Stavka> stavka) {
        this.stavka = stavka;
    }

    public ArrayList<Stavka> getStavke() {
        return stavka;
    }
}
