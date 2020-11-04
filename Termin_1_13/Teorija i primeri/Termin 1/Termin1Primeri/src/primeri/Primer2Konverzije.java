package primeri;

public class Primer2Konverzije {
    public static void main(String[] args) {
        {
            //Implicitna konverzija tipova

            long a;
            int i = 5;
            a = i;

            float f=i;


            System.out.println("a= " + a);
            System.out.println("i= " + i);
            System.out.println("f= " + f);
        }
        System.out.println();
        {
            //Eksplicitna konverzija tipova

            long a = 5L;
            int b = (int) a;

            System.out.println("a= " + a);
            System.out.println("b= " + b);


            float f=4.23F;
            long o= (long) f;

            System.out.println("f= " + f);
            System.out.println("o= " + o);
        }
    }
}
