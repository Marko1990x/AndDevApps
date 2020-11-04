package primer8;

public class Automobil {

    private int maksimalnaBrzina;
    private boolean radi;

    public Automobil(){
        radi=true;
    }

    public Automobil(int maksimalnaBrzina, boolean radi) {
        this.maksimalnaBrzina = maksimalnaBrzina;
        this.radi = radi;
    }

    public Automobil(Automobil a) {
        this.maksimalnaBrzina = a.maksimalnaBrzina;
        this.radi = a.radi;
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
}
