package primer5;

import primer4.IFigura;
import primer4.Kvadrat;

import java.util.ArrayList;

public class PolimorfizamInterfejs {
    public static void main(String[] args) {
        IFigura f=new Kvadrat(7);
        System.out.println("f.izracunajObim() = " + f.izracunajObim());
        ArrayList<IFigura> figure=new ArrayList<IFigura>();
        figure.add(new Kvadrat(5));
        figure.add(new Kvadrat(3));
        System.out.println("Prolazak kroz listu figura");
        for(IFigura figura:figure)
            System.out.println("figura = " + figura);
    }
}
