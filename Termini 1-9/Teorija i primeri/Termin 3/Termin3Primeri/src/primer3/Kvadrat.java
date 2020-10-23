package primer3;


public class Kvadrat extends Figura {
    protected double stranica;

    public Kvadrat(){
        super();
    }

    public Kvadrat(double stranica)
    {
        super("Kvadrat");
        this.stranica = stranica;
    }

    @Override
    public double izracunajPovrsinu() {
        return stranica*stranica;
    }

    @Override
    public double izracunajObim() {
        return 4*stranica;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Kvadrat{stranica=" + stranica +'}';
    }
}
