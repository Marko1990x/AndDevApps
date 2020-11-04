package primer6.aplikacija2.model;

public class Kvadrat extends Figura {


    private int stranica;
    public Kvadrat(int stranica){
        this.stranica=stranica;
    }

    @Override
    public void iscrtajFiguru() {
        System.out.println("Figura kvadrat sa stranicom a= "+stranica);
    }

    @Override
    public double izracunajObim() {
        return 4*stranica;
    }

    @Override
    public double izracunajPovrsinu() {
        return stranica*stranica;
    }
}
