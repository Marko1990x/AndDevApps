package primer8;

public class Test {
    static int a ;
    static int b ;
    int c;
    static void f () {
        /*
        Promenljiva koja nije static ne moze se menjati unutar staticke metode
         */
        //c=8;
        b = 6;
    }
    static {
        a = 5;
        f();
    }

    public int metoda()
    {
        b=7;
        c=10;
        return b;
    }
}
