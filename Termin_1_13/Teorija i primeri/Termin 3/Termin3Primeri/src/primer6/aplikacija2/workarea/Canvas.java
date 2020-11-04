package primer6.aplikacija2.workarea;

import primer6.aplikacija1.model.Figura;
import primer6.aplikacija2.interfejsi.IFigura;
import primer6.aplikacija2.interfejsi.IPovrsinaObimFigure;
import primer6.aplikacija2.interfejsi.IPrikazFigure;

import java.util.ArrayList;

public class Canvas {

    private ArrayList<IFigura> figure;

    public Canvas(){
        figure=new ArrayList<IFigura>();
    }

    public void dodajFiguru(IFigura f){
        figure.add(f);
    }

    public void iscrtajCanvas(){
        for(IPrikazFigure el:figure)
            el.iscrtajFiguru();
    }

    public double povrsinaCanvasa(){
        double ukupnaPovrsina=0;
        for(IPovrsinaObimFigure el:figure)
            ukupnaPovrsina+=el.izracunajPovrsinu();

        return ukupnaPovrsina;
    }

}
