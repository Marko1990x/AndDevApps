package primer8;

public class TestStatic {
    public static void main(String[] args) {
        System.out.println("Test.a = " + Test.a);
        System.out.println("Test.b = " + Test.b);
        Test.f();
        System.out.println("Test.b = " + Test.b);

        //Test.metoda();
        //Test.c;
        Test t=new Test();
        t.metoda();

        System.out.println("Test.b = " + Test.b);
        System.out.println("t.c = " + t.c);

        System.out.println("Math.abs(-8.7) = " + Math.abs(-8.7));
        System.out.println("Math.sin(60)) = " + Math.sin(60));
        System.out.println("Math.PI = " + Math.PI);
        System.out.println("Math.E = " + Math.E);
    }
}
