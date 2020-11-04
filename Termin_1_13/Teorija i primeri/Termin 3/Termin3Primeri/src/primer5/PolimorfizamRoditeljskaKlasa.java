package primer5;

import primer3.Figura;
import primer3.Kvadrat;

import java.util.ArrayList;

public class PolimorfizamRoditeljskaKlasa {
    public static void main(String[] args) {
        Figura f = new Kvadrat(8);
        Kvadrat k=null;
        if (f instanceof Kvadrat) {
            k = (Kvadrat) f;
        }
        System.out.println("f.izracunajObim() = " + f.izracunajObim());
        System.out.println("k.izracunajObim() = " + k.izracunajObim());
        ArrayList<Figura> figure=new ArrayList<Figura>();
        figure.add(new Kvadrat(5));
        figure.add(new Kvadrat(3));
        System.out.println("Prolazak kroz listu figura");
        for(Figura figura:figure)
            System.out.println("figura = " + figura);

        ArrayList lista=new ArrayList();
        lista.add(new Kvadrat(4));
        lista.add(5);
        lista.add(4.5F);
        Object objekat=lista.get(0);

        for(Object o:lista){
            if(o instanceof Kvadrat){
                Kvadrat kvadrat=(Kvadrat)o;
                System.out.println("o.izracunajObim() = "+kvadrat.izracunajObim());
            }
        }
    }
}
