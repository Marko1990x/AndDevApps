package firebaseapp.com.domaci15.Model;

public class Jelo {

    private int id;
    private String name;
    private String image;
    private String description;
    private float rating;
    private Kategoria kategoria;

    public Jelo() {
    }

    public Jelo(int id, String name, String image, String description, float rating, Kategoria kategoria) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.rating = rating;
        this.kategoria = kategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    @Override
    public String toString() {
        return "Jelo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", kategoria=" + kategoria +
                '}';
    }
}
