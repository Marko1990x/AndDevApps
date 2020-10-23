package primer1.klase;

public class OperatorDodele {
    public static void main(String[] args) {
        Automobil a = new Automobil () ;
        a.radi=true;
        Automobil b = new Automobil () ;
        b.radi=false;
        /*
        Operator dodele vrednosti nad objektima
         samo kopira referencu, ne i objekat
         */
        System.out.println("a.radi = " + a.radi);
        System.out.println("b.radi = " + b.radi);

        b=a;

        System.out.println("a.radi = " + a.radi);
        System.out.println("b.radi = " + b.radi);
    }

}
