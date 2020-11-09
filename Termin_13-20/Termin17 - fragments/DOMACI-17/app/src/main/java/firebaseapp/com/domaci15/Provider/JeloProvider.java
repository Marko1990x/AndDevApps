package firebaseapp.com.domaci15.Provider;

import java.util.ArrayList;
import java.util.List;

import firebaseapp.com.domaci15.Model.Jelo;
import firebaseapp.com.domaci15.Model.Kategoria;

public class JeloProvider {

    // ja ovde pravim metode koje ce se pozivati i slati podatke mora da se poklapa sa modelom


    // ovo mi je metoda koja vraca listu svih mojih jela sa popunjenom kategorijom
    public static List<Jelo> getJelos() {

        Kategoria pohovano = new Kategoria(0, "Pohovano");
        Kategoria przeno = new Kategoria(1, "Przeno");
        Kategoria kuvano = new Kategoria(2, "Kuvano");
        // kategoriju sam morao posebno da pravim da bi mogao da prosledim jelu kada se napravi objekat u modelu.
        List<Jelo> jelo = new ArrayList<>();
        // ne zaboravi da instanciras jelo kao listu jela da bi u opste mogao da punis model sa podacima.
        /*
        *     private int id;
    private String name;
    private String image;
    private String description;
    private float rating;
    private Kategoria kategoria;
*/
        jelo.add(new Jelo(0, "Karadjordjeva", "karadjordjeva.jpg", "Umotana šnicla sa sirom i salamom", 7.7f, pohovano));
        jelo.add(new Jelo(1, "Krmenadle", "krmenadle.jpg", "Przeno meso od svinje u tiganju", 6.6f, przeno));
        jelo.add(new Jelo(2, "Pasulj", "pasulj.jpg", "Ovo je kuvani pasulj sa mesom u serpi", 8.0f, kuvano));
        jelo.add(new Jelo(3, "Pohovana Piletina", "pp.jpg", "Pohovano meso od pileta u tiganju", 7.6f, pohovano));
        jelo.add(new Jelo(4, "Sarma", "sarma.jpg", "Meso umotano u listove sa zacinima", 8.6f, kuvano));

        return jelo;
    }


    // vraca listu imena #todo dodaj zasto mi je ovo trebalo
    // ovo mi je trebalo zbog adaptera u prvoj aktivnosti da mogu da pokazem sva moja jela koja imam.
    public static List<String> getJeloNames() {
        List<String> strings = new ArrayList<>();
        strings.add("Karadjordjeva");
        strings.add("Krmenadle");
        strings.add("Pasulj");
        strings.add("Pohovana Piletina");
        strings.add("Sarma");
        return strings;
    }

    //todo pronadji kako da return vrati listu jela ako ima vise jela koja spadaju u istu kategoriju
    public static Jelo getJeloById(int id) {
        Kategoria pohovano = new Kategoria(0, "Pohovano");
        Kategoria przeno = new Kategoria(1, "Przeno");
        Kategoria kuvano = new Kategoria(2, "Kuvano");
        switch (id) {
            case 0:
                //ArrayList<Jelo> jeloPohovano = new ArrayList<>();
                // jeloPohovano.add(new Jelo(0,"Karadjordjeva","karadjordjeva.jpg","Umotana šnicla sa sirom i salamom", 7.7f,pohovano));
                //  jeloPohovano.add(new Jelo(3,"Pohovana Piletina", "pp.jpg","Pohovano meso od pileta u tiganju", 7.6f, pohovano));
                return new Jelo(0, "Karadjordjeva", "karadjordjeva.jpg", "Umotana šnicla sa sirom i salamom", 7.7f, pohovano);
            case 1:
                return new Jelo(1, "Krmenadle", "krmenadle.jpg", "Przeno meso od svinje u tiganju", 6.6f, przeno);
            case 2:
                return new Jelo(2, "Pasulj", "pasulj.jpg", "Ovo je kuvani pasulj sa mesom u serpi", 8.0f, kuvano);
            case 3:
                return new Jelo(3, "Pohovana Piletina", "pp.jpg", "Pohovano meso od pileta u tiganju", 7.6f, pohovano);
            case 4:
                return new Jelo(4, "Sarma", "sarma.jpg", "Meso umotano u listove sa zacinima", 8.6f, kuvano);
            default:
                return null;
        }
    }


}
