package primer7;

import primer4.IFigura;
import primer3.Figura;

public class TestAnonimna {
    public static void main(String[] args) {
        final double stranica=8;
        Figura kvadrat=new Figura() {

            @Override
            public double izracunajPovrsinu() {
                return stranica*stranica;
            }

            @Override
            public double izracunajObim() {
                return 4*stranica;
            }
        };
        System.out.println("kvadrat.izracunajObim() = " + kvadrat.izracunajObim());

        final double b=4;
        IFigura pravougaonik=new IFigura() {

            @Override
            public double izracunajPovrsinu() {
                return stranica*b;
            }

            @Override
            public double izracunajObim() {
                return 2*stranica + 2*b;
            }
        };
        System.out.println("pravougaonik.izracunajObim() = " + pravougaonik.izracunajObim());
    }
}
