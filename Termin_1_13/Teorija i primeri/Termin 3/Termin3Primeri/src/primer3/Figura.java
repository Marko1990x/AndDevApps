package primer3;

public class Figura {

    public Figura(){
        System.out.println("Figura konstruktor bez parametara");
    }

    public Figura(String vrednost){
        System.out.println("Konstruktor sa parametrom vrednost = "+vrednost);
    }

    public double izracunajPovrsinu(){
        return 0;
    }

    public double izracunajObim(){
        return 0;
    }

    /*
    @Override
    public String toString() {
        return "toString metoda iz klase Figura";
    }
    */
}
