package Provajder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Filmovi;
import Model.Glumac;

public class Glumac_Provajder {

    public static List<Glumac> getGlumci(){

        List<Filmovi> filmovis = new ArrayList<>();
        Filmovi filmovi1 = new Filmovi("film 1", "film 1 je noir drama", 7);
        Filmovi filmovi2 = new Filmovi("film 2", "film 2 je komedija", 8);
        Filmovi filmovi3 = new Filmovi("film 3", "film 3 je akcija", 6);
        filmovis.add(filmovi1);
        filmovis.add(filmovi2);
        filmovis.add(filmovi3);

        /*
         private String imeGlumca;
    private String prezimeGlumca;
    private String biographijaGlumca;
    private int ocenaGlumca;
    private Date dateRodjenja;
    private Date dateSmrti;
    private List<Filmovi> listaFilmova;
        * */
        List<Glumac> glumac = new ArrayList<>();
        glumac.add(new Glumac(0,"arnold.jpg","Arnold ","Swarchenegger ","Dobar glumac", 8.1f, "July 30, 1947","not dead yet",filmovis));
        glumac.add(new Glumac(1,"keanuReaves.jpg","Keanu ","Reaves ","Los glumac", 9.0f, "September 2, 1964","not dead yet",filmovis));
        glumac.add(new Glumac(2,"rambo.jpg" ,"Sylvester  ","Stallone ","Dobar glumac", 7.0f, "July 6, 1946","not dead yet",filmovis));
        glumac.add(new Glumac(3,"stalone.jpg" ,"Sylvester 2 ","Stallone 2 ","Los glumac", 6.0f,"July 6, 1946","not dead yet",filmovis));
        glumac.add(new Glumac(4,"willSmith.jpg","Will ","Smith ","Dobar glumac", 6.0f, "September 25, 1968","not dead yet",filmovis));

        return glumac;
    }

    public static List<String> getGlumciNames(){

        List<String> strings = new ArrayList<>();

        strings.add("Arnold Swarchenegger");
        strings.add("Keanu Reaves");
        strings.add("Sylvester Stallone");
        strings.add("Sylvester Stallone 2");
        strings.add("Will Smith");
        return  strings;


    }


    // potrebno je zbog slike glumca
    public static Glumac getGlumacById(int id){

        List<Filmovi> filmovis = new ArrayList<>();
        Filmovi filmovi1 = new Filmovi("film 1", "film 1 je noir drama", 7);
        Filmovi filmovi2 = new Filmovi("film 2", "film 2 je komedija", 8);
        Filmovi filmovi3 = new Filmovi("film 3", "film 3 je akcija", 6);
        filmovis.add(filmovi1);
        filmovis.add(filmovi2);
        filmovis.add(filmovi3);

        switch (id){
            case 0:
                return new Glumac(0,"arnold.jpg","Arnold ","Swarchenegger "," Austrian-born American bodybuilder, film actor, and politician", 8, "July 30, 1947","not dead yet",filmovis);
            case 1:
                return new Glumac(1,"keanuReaves.jpg","Keanu ","Reaves ","Keanu Charles Reeves was born in Beirut, Lebanon, on September 2, 1964", 9, "September 2, 1964","not dead yet",filmovis);
            case 2:
                return new Glumac(2,"rambo.jpg" ,"Sylvester  ","Stallone ","Actor, writer, director and producer Stallone was born on July 6, 1946, in New York City", 7,"July 6, 1946","not dead yet",filmovis);
            case 3:
                return new Glumac(3,"stalone.jpg" ,"Sylvester 2 ","Stallone 2 ","Actor, writer, director and producer Stallone was born on July 6, 1946, in New York City", 6, "July 6, 1946","not dead yet",filmovis);
            case 4:
                return new Glumac(4,"willSmith.jpg","Will ","Smith ","Will Smith was born Willard Carroll Smith Jr. on September 25, 1968", 5,"September 25, 1968","not dead yet",filmovis);
            default:
                return null;
        }
    }




}
