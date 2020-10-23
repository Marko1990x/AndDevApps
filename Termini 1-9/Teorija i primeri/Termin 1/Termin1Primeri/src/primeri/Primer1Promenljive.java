package primeri;

public class Primer1Promenljive {
    public static void main(String[] args) {
        {
            /*
            postoji od deklaracije do kraja bloka koda u kojem je definisana
             */
            int promenljiva=5;
            System.out.println(promenljiva);
        }
        //System.out.println(promenljiva);

        int $novaPromenljiva_1$;
        //int 1promenljiva; // Ne moze poceti brojem
        //int for; // Ne moze se koristiti rezervisana rec
        //int class; // Ne moze se koristiti rezervisana rec
        $novaPromenljiva_1$=10;
        int promenljiva=2;
        int promenljivA=3;//razlicito se tretiraju velika i mala slova
        System.out.println(promenljiva);
        System.out.println(promenljivA);

        System.out.println("Ispis u jednom redu");
        System.out.print(promenljiva);
        System.out.print("_");
        System.out.print(promenljivA);
    }
}
