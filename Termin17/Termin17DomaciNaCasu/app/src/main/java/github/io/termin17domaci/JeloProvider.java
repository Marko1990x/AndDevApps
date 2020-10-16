package github.io.termin17domaci;

import java.util.ArrayList;
import java.util.List;

public class JeloProvider {


    private static List<Jelo> jelos;

    private void init() {
        if (jelos == null) {
            jelos = new ArrayList<Jelo>();
            List<String> sastojci = new ArrayList<>();
            sastojci.add("sastojak1");
            sastojci.add("sastojak2");
            Jelo jelo = new Jelo("Gulas", 3.7f, 123, "madjarsko pikantno jelo", new ArrayList<String>(sastojci), 1000, 20.00);
        }

    }


}
