package github.io.termin17domaci;

import java.util.List;

public class JeloProvider {


    private static List<String> jela;

    private static void init() {
        if (jela == null) {
            jela.add("Pizza");
            jela.add("Hamburger");
            jela.add("Riba");

        }

    }

    public static List<String> getAllJela() {
        init();
        return jela;
    }

    public static String getJelaById(int id) {

        init();
        if ((id >= 0) && (id < jela.size())) {
            return jela.get(id);
        } else {
            return null;
        }

    }


}
