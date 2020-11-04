package zadatak5.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Resenje 2.1.2
 */
@DatabaseTable(tableName = "racun")
public class Racun {

    //Staticki atributi
    public static final String POLJE_OZNAKA="oznaka";
    public static final String POLJE_DATUM="datum";

    //Atribut id kojem se vrednost generise automatski
    // prilikom upisa u bazu i
    // predstavlja i primarni kljuc
    @DatabaseField(generatedId = true)
    private int id;
    //Atribut oznaka
    @DatabaseField(columnName = POLJE_OZNAKA, canBeNull = false)
    private String oznaka;

    //Atribut datum
    @DatabaseField(columnName = POLJE_DATUM, canBeNull = false)
    private Date datum;

    //Atribut stavke zbog vise kraja veze
    // izmedju entiteta Racun i Stavka
    @ForeignCollectionField(foreignFieldName = "racun")
    private ForeignCollection<Stavka> stavke;

    //Konstruktor bez parametara
    public Racun() {
        //Obavezno se mora navesti za potrebe ORMLite
    }

    //Konstruktor sa parametrima oznaka i datum
    public Racun(String oznaka, Date datum) {
        this.oznaka = oznaka;
        this.datum = datum;
    }

    //Get i set metode za odgovarajuce atribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
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
        return "Racun{" +
                "id=" + id +
                ", oznaka='" + oznaka + '\'' +
                ", datum=" + datum +
                '}';
    }
}
