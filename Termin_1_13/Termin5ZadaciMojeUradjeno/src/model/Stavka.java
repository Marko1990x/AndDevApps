package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "stavka")
public class Stavka {

    public static final String POLJE_KOLICINA = "kolicina";
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_KOLICINA)
    private int kolicina;
    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "racun_id")
    private Racun racun;
    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "artikal_id")
    private Artikal artikal;


    public Stavka() {
    }

    public Stavka(int kolicina, Racun racun, Artikal artikal) {
        this.kolicina = kolicina;
        this.racun = racun;
        this.artikal = artikal;
    }

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

    @Override
    public String toString() {
        return "Stavka{" +
                "id=" + id +
                ", kolicina=" + kolicina +
                '}';
    }
}
