package primer6.aplikacija1.workarea;

import primer6.aplikacija1.model.Figura;

import java.util.ArrayList;

public class Canvas {

    private ArrayList<Figura> figure;

    public Canvas(){
        figure=new ArrayList<Figura>();
    }

    public void dodajFiguru(Figura f){
        figure.add(f);
    }

    public void iscrtajCanvas(){
        for(Figura el:figure)
            el.iscrtajFiguru();
    }

    public double povrsinaCanvasa(){
        double ukupnaPovrsina=0;
        for(Figura el:figure)
            ukupnaPovrsina+=el.izracunajPovrsinu();

        return ukupnaPovrsina;
    }

}
