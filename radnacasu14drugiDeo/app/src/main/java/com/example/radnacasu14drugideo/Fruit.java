package com.example.radnacasu14drugideo;

public class Fruit {

    public static final Fruit fruits[] = new Fruit[]{
      new Fruit(0,"pomorandza","narandjaste je boje", "apple.png",4.5f),
            new Fruit(1,"limun","zute je boje", "lemon.png", 3.0f),
            new Fruit(2,"jabuka","zelene je boje", "orange.png", 7f)
    };  // imageFileName mora da se podudara

    // ne moze ; prilikom instanciranja objekata u nizu jer remeti niz
    // podaci nad kojima applikaci radi su korisnicki podaci i idu u

    private int id;
    private String name;
    private String description;
    private String imageFileName;
    private float rating;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Fruit(int id, String name, String description, String imageFileName, float rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageFileName = imageFileName;
        this.rating = rating;
    }
}