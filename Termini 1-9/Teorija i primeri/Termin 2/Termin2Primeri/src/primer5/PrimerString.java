package primer5;

public class PrimerString {
    public static void main(String[] args) {
        String s="Niz karaktera";
        String s1=new String("Karakteri");
        System.out.println(s);
        s=s+" dodatni karakteri";

        System.out.println(s);

        System.out.println(s.charAt(3));
        System.out.println("s.length() = " + s.length());
        System.out.println("s.indexOf('a') = " + s.indexOf('a'));
        System.out.println("s.indexOf(\"tera\") = " + s.indexOf("tera"));

        System.out.println("s.substring(4) = " + s.substring(4));
        System.out.println("s.substring(3,7) = " + s.substring(3, 7));
        
        String d="Karakteri";
        String h="Karakteri";
        System.out.println("h==d = " + (h==d));
        System.out.println("h.equals(d) = " + h.equals(d));

        String v=new String("Karakteri");
        String n=new String("Karakteri");
        System.out.println("v==n = " + (v==n));
        System.out.println("v.equals(n) = " + v.equals(n));


        String j="TEKST";
        String k="teKst";
        System.out.println("k.equals(j) = " + k.equals(j));
        System.out.println("k.equalsIgnoreCase(j) = " + k.equalsIgnoreCase(j));
        System.out.println("k.contains(\"st\") = " + k.contains("st"));


        System.out.println("k.startsWith(\"eK\") = " + k.startsWith("eK"));
        System.out.println("k.startsWith(\"teK\") = " + k.startsWith("teK"));
        System.out.println("j.toLowerCase() = " + j.toLowerCase());

        //for petlja
        for(int i=0;i<j.length();i++)
            System.out.println(j.charAt(i));

        //for each
        for(char karakter:j.toCharArray())
            System.out.println(karakter);
    }
}
