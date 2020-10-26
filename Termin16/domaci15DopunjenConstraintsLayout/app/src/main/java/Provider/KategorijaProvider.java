package Provider;

import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

import Model.Kategoria;

public class KategorijaProvider {


    public static List<Kategoria> getCategories() {
        List<Kategoria> kategorias = new ArrayList<>();

        kategorias.add(new Kategoria(0, "Pohovano"));
        kategorias.add(new Kategoria(1, "Przeno"));
        kategorias.add(new Kategoria(2, "Kuvano"));

        return kategorias;
    }

    public static List<String> getKategoriaNames() {

        List<String> imena = new ArrayList<>();
        imena.add("Karadjordjeva");
        imena.add("Krmenadle");
        imena.add("Pasulj");
        imena.add("Pohovana Piletina");
        imena.add("Sarma");
        return imena;

    }

    public static Kategoria getKategoryById(int id) {

        switch (id) {

            case 0:
                return new Kategoria(0, "Pohovano");
            case 1:
                return new Kategoria(1, "Przeno");
            case 2:
                return new Kategoria(2, "Kuvano");
            default:
                return null;


        }

    }


}
