package rs.aleph.android.example18.providers;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example18.model.Category;

public class CategoryProvider {

    public static List<Category> getCategories() {

        List<Category> categories = new ArrayList<>();
        categories.add(new Category(0, "pohovano"));
        categories.add(new Category(1, "Przeno"));
        categories.add(new Category(2, "Kuvano"));
        return categories;
    }

    public static List<String> getCategoryNames() {
        List<String> names = new ArrayList<>();
        names.add("Karadjordjeva");
        names.add("Krmenadle");
        names.add("Pasulj");
        names.add("Pohovana Piletina");
        names.add("Sarma");

        return names;
    }

    public static Category getCategoryById(int id) {
        switch (id) {
            case 0:
                return new Category(0, "Pohovano");
            case 1:
                return new Category(1, "Przeno");
            case 2:
                return new Category(2, "Kuvano");
            default:
                return null;
        }
    }
}
