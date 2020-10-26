package Model;

import java.util.Date;
import java.util.List;

public class Glumac {

    private int id;
    private String imageGLumca;
    private String imeGlumca;
    private String prezimeGlumca;
    private String biographijaGlumca;
    private float ocenaGlumca;
    private String dateRodjenja;
    private String dateSmrti;
    private List<Filmovi> listaFilmova;

    public Glumac() {
    }

    public Glumac(int id, String imageGLumca, String imeGlumca, String prezimeGlumca, String biographijaGlumca, float ocenaGlumca, String dateRodjenja, String dateSmrti, List<Filmovi> listaFilmova) {
        this.id = id;
        this.imageGLumca = imageGLumca;
        this.imeGlumca = imeGlumca;
        this.prezimeGlumca = prezimeGlumca;
        this.biographijaGlumca = biographijaGlumca;
        this.ocenaGlumca = ocenaGlumca;
        this.dateRodjenja = dateRodjenja;
        this.dateSmrti = dateSmrti;
        this.listaFilmova = listaFilmova;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageGLumca() {
        return imageGLumca;
    }

    public void setImageGLumca(String imageGLumca) {
        this.imageGLumca = imageGLumca;
    }

    public String getImeGlumca() {
        return imeGlumca;
    }

    public void setImeGlumca(String imeGlumca) {
        this.imeGlumca = imeGlumca;
    }

    public String getPrezimeGlumca() {
        return prezimeGlumca;
    }

    public void setPrezimeGlumca(String prezimeGlumca) {
        this.prezimeGlumca = prezimeGlumca;
    }

    public String getBiographijaGlumca() {
        return biographijaGlumca;
    }

    public void setBiographijaGlumca(String biographijaGlumca) {
        this.biographijaGlumca = biographijaGlumca;
    }

    public float getOcenaGlumca() {
        return ocenaGlumca;
    }

    public void setOcenaGlumca(float ocenaGlumca) {
        this.ocenaGlumca = ocenaGlumca;
    }

    public String getDateRodjenja() {
        return dateRodjenja;
    }

    public void setDateRodjenja(String dateRodjenja) {
        this.dateRodjenja = dateRodjenja;
    }

    public String getDateSmrti() {
        return dateSmrti;
    }

    public void setDateSmrti(String dateSmrti) {
        this.dateSmrti = dateSmrti;
    }

    public List<Filmovi> getListaFilmova() {
        return listaFilmova;
    }

    public void setListaFilmova(List<Filmovi> listaFilmova) {
        this.listaFilmova = listaFilmova;
    }

    @Override
    public String toString() {
        return "Glumac{" +
                "id=" + id +
                ", imageGLumca='" + imageGLumca + '\'' +
                ", imeGlumca='" + imeGlumca + '\'' +
                ", prezimeGlumca='" + prezimeGlumca + '\'' +
                ", biographijaGlumca='" + biographijaGlumca + '\'' +
                ", ocenaGlumca=" + ocenaGlumca +
                ", dateRodjenja='" + dateRodjenja + '\'' +
                ", dateSmrti='" + dateSmrti + '\'' +
                ", listaFilmova=" + listaFilmova +
                '}';
    }
}
