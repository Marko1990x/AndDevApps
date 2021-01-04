package com.example.termin14zadatak;

public class Vocke {

    public static final Vocke vocke[] = new Vocke[]{  // konstruktor je potreban da bi odma mogao ovde da ih instanciram
        new Vocke(1,"banana", "duguljasta zuta vocka", "banana.jpg", 4.5f),
            new Vocke(2,"Malina",  "crvenkasta vocka", "malina.jpg", 8f),
            new Vocke(3,"pomorandza", "slatka vocka", "pomorandza.jpg", 6.3f),
            new Vocke(4, "Dinja", "slatka vocka", "dinja.jpg", 8f)
    };


    private int id;
    private String name;
    private String opis;
    private String imagefilename; // key that must match
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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getImagefilename() {
        return imagefilename;
    }

    public void setImagefilename(String imagefilename) {
        this.imagefilename = imagefilename;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Vocke(int id, String name, String opis, String imagefilename, float rating) {
        this.id = id;
        this.name = name;
        this.opis = opis;
        this.imagefilename = imagefilename;
        this.rating = rating;
    }
}
