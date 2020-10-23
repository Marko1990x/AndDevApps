package model;


import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Artikal") // anotacija klase po zadatku
public class Artikal {

    public static final String POLJE_NAZIV = "naziv";
    public static final String POLJE_OPIS = "opis";
    public static final String POLJE_CENA = "cena";

    @DatabaseField(generatedId = true)
    private int id;


    @DatabaseField(columnName = POLJE_NAZIV, canBeNull = false) // veza sa statickim podacima
    private String naziv;

    @DatabaseField(columnName = POLJE_OPIS, canBeNull = false)// pravi naziv u databazi i kaze da nemoze biti prazan
    private String opis;

    @DatabaseField(columnName = POLJE_CENA, canBeNull = false)
    private double cena;

    @ForeignCollectionField(foreignFieldName = "artikal") // kljuc koji je veza kada ide prema vise
    private ForeignCollection<Stavka> stavke;

    public Artikal() {
    }

    public Artikal(String naziv, String opis, double cena) {
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public ForeignCollection<Stavka> getStavke() {
        return stavke;
    }

    public void setStavke(ForeignCollection<Stavka> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String toString() {
        return "Artikal{" +
                "naziv='" + naziv + '\'' +
                ", opis='" + opis + '\'' +
                ", cena=" + cena +
                '}';
    }
}
