package primeri;

public class Primer4Operatori {
    public static void main(String[] args) {
        {
            //Aritmeticki operatori

            int rezultat=4+8*(5+7)+32/4;
            System.out.println("rezultat= " + rezultat);

            int x = 5;


            System.out.println("x= " + x);
            System.out.println("k= " + x++);
            System.out.println("x= " + x);


            System.out.println("x= " + x);
            System.out.println("j= " + ++x);
            System.out.println("x= " + x);

            rezultat = 7 / 2;
            int ostatak = 7 % 2;

            System.out.println("rezultat= " + rezultat);
            System.out.println("ostatak= " + ostatak);
        }
        System.out.println();
        {
            //Relacioni i logicki operatori

            boolean rezultatVece=3>6;
            boolean rezultatManje=3<6;
            boolean rezultatRazlicito=3!=6;
            boolean rezultatILI=3>6||4<6;
            boolean rezultatNegacija=!(3>6);

            System.out.println("rezultatVece = " + rezultatVece);
            System.out.println("rezultatManje = " + rezultatManje);
            System.out.println("rezultatRazlicito = " + rezultatRazlicito);
            System.out.println("rezultatILI = " + rezultatILI);
            System.out.println("rezultatNegacija = " + rezultatNegacija);
        }
        System.out.println();
        {
            //Bit operatori
            int a=5;
            int b=17;

            int logickoI=a&b;
            int logickoILI=a|b;
            int ekskluzivnoILI=a^b;
            int negacija=~a;

            System.out.println(Integer.toBinaryString(a));
            System.out.println(Integer.toBinaryString(b));

            System.out.print("Logicko I: ");
            System.out.print(Integer.toBinaryString(logickoI));
            System.out.println(" "+logickoI);
            System.out.print("Logicko ILI: ");
            System.out.print(Integer.toBinaryString(logickoILI));
            System.out.println(" "+logickoILI);
            System.out.print("Ekskluzivno ILI: ");
            System.out.print(Integer.toBinaryString(ekskluzivnoILI));
            System.out.println(" "+ekskluzivnoILI);
            System.out.print("Negacija: ");
            System.out.print(Integer.toBinaryString(negacija));
            System.out.println(" "+negacija);

            a=a<<3;
            b=b>>3;
            System.out.print(Integer.toBinaryString(a));
            System.out.println(" "+a);
            System.out.print(Integer.toBinaryString(b));
            System.out.println(" "+b);

            System.out.println("Negativna vrednost");
            int c=-16;
            System.out.print(Integer.toBinaryString(c));
            System.out.println(" "+c);
            int d=c<<4;
            System.out.print(Integer.toBinaryString(d));
            System.out.println(" "+d);
            int e=c>>2;
            System.out.print(Integer.toBinaryString(e));
            System.out.println(" "+e);
            int f=c>>>2;
            System.out.print(Integer.toBinaryString(f));
            System.out.println(" "+f);
        }
    }
}
