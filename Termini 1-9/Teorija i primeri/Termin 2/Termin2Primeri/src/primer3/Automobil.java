package primer3;

public class Automobil {
    int maksimalnaBrzina;
    boolean radi;

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
}
