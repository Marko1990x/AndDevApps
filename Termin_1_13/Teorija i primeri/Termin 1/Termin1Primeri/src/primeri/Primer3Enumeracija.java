package primeri;

public class Primer3Enumeracija {

    enum Size { SMALL , MEDIUM , LARGE , EXTRA_LARGE };
    enum Days { MON , TUE , WEN , THU , FRI , SAT , SUN };

    public static void main(String[] args) {
        Size s = Size.MEDIUM ;
        System.out.println("s= "+s);
        Days d = Days.MON ;
        System.out.println("d= "+d);
    }
}
