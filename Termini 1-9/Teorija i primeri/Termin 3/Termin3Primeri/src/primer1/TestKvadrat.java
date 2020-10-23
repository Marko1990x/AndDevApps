package primer1;


public class TestKvadrat {
    public static void main(String[] args) {
        Kvadrat k1=new Kvadrat(4);
        System.out.println("k1.izracunajPovrsinu() = " + k1.izracunajPovrsinu());
        System.out.println("k1.izracunajObim() = " + k1.izracunajObim());
        System.out.println("Kvadrat = [" + k1 + "]");
    }
}
