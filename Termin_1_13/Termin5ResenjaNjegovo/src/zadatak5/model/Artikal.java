package zadatak5.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Resenje 2.1.1
 */
@DatabaseTable(tableName = "artikal")
public class Artikal {

    //Staticki atributi
    public static final String POLJE_NAZIV="naziv";
    public static final String POLJE_OPIS="opis";
    public static final String POLJE_CENA="cena";

    //Atribut id kojem se vrednost generise automatski
    // prilikom upisa u bazu i
    // predstavlja i primarni kljuc
    @DatabaseField(generatedId = true)
    private int id;

    //Atribut naziv
    @DatabaseField(columnName = POLJE_NAZIV, canBeNull = false)
    private String naziv;
    //Atribut opis
    @DatabaseField(columnName = POLJE_OPIS, canBeNull = false)
    private String opis;
    //Atribut cena
    @DatabaseField(columnName = POLJE_CENA, canBeNull = false)
    private double cena;

    //Atribut stavke zbog vise kraja veze
    // izmedju entiteta Artikal i Stavka
    @ForeignCollectionField(foreignFieldName = "artikal")
    private ForeignCollection<Stavka> stavke;

    //Konstruktor bez parametara
    public Artikal() {
        //Obavezno se mora navesti za potrebe ORMLite
    }

    //Konstruktor sa parametrima naziv, opis i cena
    public Artikal(String naziv, String opis, double cena) {
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
    }

    //Get i set metode za odgovarajuce atribute
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

    public ForeignCollection<Stavka> getStavke() {
        return stavke;
    }

    public void setStavke(ForeignCollection<Stavka> stavke) {
        this.stavke = stavke;
    }

    //Redefinisana metoda iz Object klase
    @Override
    public String toString() {
        return "Artikal{" +
                "id=" + id +
                ", naziv=" + naziv +
                ", opis='" + opis + '\'' +
                ", cena='" + cena + '\'' +
                '}';
    }
}
