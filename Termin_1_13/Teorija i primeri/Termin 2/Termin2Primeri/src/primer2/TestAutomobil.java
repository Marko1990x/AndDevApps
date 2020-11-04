package primer2;

public class TestAutomobil {
    public static void main(String[] args) {
        Automobil a=new Automobil();
        a.setMaksimalnaBrzina(45);
        System.out.println("Maksimalna brzina "+a.getMaksimalnaBrzina());
        a.setRadi(true);
        System.out.println("Radi "+a.isRadi());
    }
}
