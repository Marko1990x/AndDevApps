package Model;

import java.util.List;

public class Kategoria {

    private int id;
    private String name;
    private List<Jelo> jelos;

    public Kategoria() { // dodaj listu u prazan konstruktor
        this.jelos = jelos;
    }

    public Kategoria(List<Jelo> jelos) {
        this.jelos = jelos;
    }

    public Kategoria(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Kategoria(int id, String name, List<Jelo> jelos) {
        this.id = id;
        this.name = name;
        this.jelos = jelos;
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

    public List<Jelo> getJelos() {
        return jelos;
    }

    public void setJelos(List<Jelo> jelos) {
        this.jelos = jelos;
    }

    @Override
    public String toString() {
        return "Kategoria{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jelos=" + jelos +
                '}';
    }
}
