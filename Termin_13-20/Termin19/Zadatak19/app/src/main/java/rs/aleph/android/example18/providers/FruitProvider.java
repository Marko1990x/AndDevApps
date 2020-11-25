package rs.aleph.android.example18.providers;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example18.model.Category;
import rs.aleph.android.example18.model.Fruit;

public class FruitProvider {

    public static List<Fruit> getFruits() {

        Category pohovano = new Category(0, "pohovano");
        Category przeno = new Category(1, "przeno");
        Category kuvano = new Category(2, "kuvano");

        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit(0, "karadjordjeva.jpg", "karadjordjeva", "Umotana šnicla sa sirom i salamom", 7.7f, pohovano));
        fruits.add(new Fruit(1, "krmenadle.jpg", "Krmenadle", "Przeno meso od svinje u tiganju", 6.6f, przeno));
        fruits.add(new Fruit(2, "pasulj.jpg", "Pasulj", "Ovo je kuvani pasulj sa mesom u serpi", 8.0f, kuvano));
        fruits.add(new Fruit(3, "pp.jpg", "Pohovana piletina", "Pohovano meso od pileta u tiganju", 7.6f, pohovano));
        fruits.add(new Fruit(4, "sarma.jpg", "Sarma", "Meso umotano u listove sa zacinima", 8.6f, kuvano));
       return fruits;
    }

    public static List<String> getFruitNames() {

        List<String> names = new ArrayList<>();
        names.add("Karadjordjeva");
        names.add("Krmenadle");
        names.add("Pasulj");
        names.add("Pohovana Piletina");
        names.add("Sarma");
        return names;
    }

    public static Fruit getFruitById(int id) {

        Category pohovano = new Category(0, "pohovano");
        Category przeno = new Category(1, "przeno");
        Category kuvano = new Category(2, "kuvano");

        switch (id) {
            case 0:
                //ArrayList<Jelo> jeloPohovano = new ArrayList<>();
                // jeloPohovano.add(new Jelo(0,"Karadjordjeva","karadjordjeva.jpg","Umotana šnicla sa sirom i salamom", 7.7f,pohovano));
                //  jeloPohovano.add(new Jelo(3,"Pohovana Piletina", "pp.jpg","Pohovano meso od pileta u tiganju", 7.6f, pohovano));
                return new Fruit(0, "karadjordjeva.jpg", "Karadjordjeva", "Umotana šnicla sa sirom i salamom", 7.7f, pohovano);
            case 1:
                return new Fruit(1, "krmenadle.jpg", "Krmenadle", "Przeno meso od svinje u tiganju", 6.6f, przeno);
            case 2:
                return new Fruit(2, "pasulj.jpg", "Pasulj", "Ovo je kuvani pasulj sa mesom u serpi", 8.0f, kuvano);
            case 3:
                return new Fruit(3, "pp.jpg", "Pohovana Piletina", "Pohovano meso od pileta u tiganju", 7.6f, pohovano);
            case 4:
                return new Fruit(4, "sarma.jpg", "Sarma", "Meso umotano u listove sa zacinima", 8.6f, kuvano);
            default:
                return null;
        }
    }
}
