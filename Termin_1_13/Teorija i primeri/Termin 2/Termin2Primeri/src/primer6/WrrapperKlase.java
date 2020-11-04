package primer6;

public class WrrapperKlase {
    public static void main(String[] args) {
        {
            System.out.println("Wrrapper za Integer");
            System.out.println(Integer.parseInt("10"));
            System.out.println(Integer.toBinaryString(3));
            System.out.println(Integer.toString(7));
            int min = Integer.MIN_VALUE;
            int max = Integer.MAX_VALUE;

            System.out.println("min = " + min);
            System.out.println("max = " + max);
        }
        System.out.println();
        {
            System.out.println("Wrrapper za Long");
            System.out.println(Long.parseLong("10"));
            System.out.println(Long.toBinaryString(45L));
            System.out.println(Long.toString(34L));
            long min = Long.MIN_VALUE;
            long max = Long.MAX_VALUE;

            System.out.println("min = " + min);
            System.out.println("max = " + max);
        }
        System.out.println();
        {
            System.out.println("Wrrapper za Float");
            System.out.println(Float.parseFloat("10.34"));
            System.out.println(Float.toString(45.8F));
            Float min = Float.MIN_VALUE;
            Float max = Float.MAX_VALUE;

            System.out.println("min = " + min);
            System.out.println("max = " + max);
        }
        System.out.println();
        {
            System.out.println("Wrrapper za Double");
            System.out.println(Double.parseDouble("10.478"));
            System.out.println(Double.toString(3.45));
            double min = Double.MIN_VALUE;
            double max = Double.MAX_VALUE;

            System.out.println("min = " + min);
            System.out.println("max = " + max);
        }
    }
}
