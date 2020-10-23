package primer9;

import java.util.ArrayList;

public class Automobil {
    private int maksimalnaBrzina;
    private boolean radi;

    //Kraj veze za Asocijaciju
    private ArrayList<Deo> delovi;

    public Automobil(){
        radi=true;
        delovi=new ArrayList<Deo>();//Inicijalizacija kolekcije
    }

    public Automobil(int maksimalnaBrzina, boolean radi) {
        this.maksimalnaBrzina = maksimalnaBrzina;
        this.radi = radi;
        delovi=new ArrayList<Deo>();//Inicijalizacija kolekcije
    }

    public Automobil(Automobil a) {
        this.maksimalnaBrzina = a.maksimalnaBrzina;
        this.radi = a.radi;
        this.delovi = a.delovi;
    }

    public int getMaksimalnaBrzina ()
    {
        return maksimalnaBrzina ;
    }
    public void setMaksimalnaBrzina( int maksimalnaBrzina )
    {
        this.maksimalnaBrzina = maksimalnaBrzina ;
    }

    public boolean isRadi()
    {
        return radi;
    }

    public void setRadi(boolean radi)
    {
        this.radi = radi;
    }

    public ArrayList<Deo> getDelovi() {
        return delovi;
    }

    public void setDelovi(ArrayList<Deo> delovi) {
        this.delovi = delovi;
    }
}
