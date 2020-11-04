package zadatak5.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Resenje 2.1.3
 */
@DatabaseTable(tableName = "stavka")
public class Stavka {

    //Staticki atribut
    public static final String POLJE_KOLICINA="kolicina";

    //Atribut id kojem se vrednost generise automatski
    // prilikom upisa u bazu i
    // predstavlja i primarni kljuc
    @DatabaseField(generatedId = true)
    private int id;
    //Atribut kolicina
    @DatabaseField(columnName = POLJE_KOLICINA)
    private int kolicina;
    //Atribut racun koji u bazi predstavlja
    // kolonu koja cuva strane kljuceve
    // navodi se zbog jedinicnog kraja veze
    // izmedju entiteta Stavka i Racun
    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "racun_id")
    private Racun racun;
    //Atribut artikal koji u bazi predstavlja
    // kolonu koja cuva strane kljuceve
    // navodi se zbog jedinicnog kraja veze
    // izmedju entiteta Stavka i Artikal
    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "artikal_id")
    private Artikal artikal;

    //Konstruktor bez parametara
    public Stavka() {
        //Obavezno se mora navesti za potrebe ORMLite
    }

    //Konstruktor sa parametrima kolicina, racun i artikal
    public Stavka(int kolicina, Racun racun, Artikal artikal) {
        this.kolicina = kolicina;
        this.racun = racun;
        this.artikal = artikal;
    }

    //Get i set metode za odgovarajuce atribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }

    //Redefinisana metoda iz Object klase
    @Override
    public String toString() {
        return "Stavka{" +
                "id=" + id +
                ", kolicina=" + kolicina +
                '}';
    }
}
