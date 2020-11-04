package com.example.radnacasu15;

public class Song {

    private String Author;
    private String Name;

    public Song(String author, String name) {
        Author = author;
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
