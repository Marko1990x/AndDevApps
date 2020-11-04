package primer6.aplikacija2;

import primer6.aplikacija2.model.AdapterJednakostranicniTrougao;
import primer6.aplikacija2.model.Kvadrat;
import primer6.aplikacija2.workarea.Canvas;


public class App2 {
    public static void main(String[] args) {
        Canvas canvas=new Canvas();
        canvas.dodajFiguru(new Kvadrat(4));
        canvas.dodajFiguru(new Kvadrat(8));

        System.out.println("Iscrtavanje Canvasa");
        canvas.iscrtajCanvas();
        System.out.println("Iscrtavanje Canvasa je zavrseno");

        double povrsina=canvas.povrsinaCanvasa();

        System.out.println("povrsina = " + povrsina);

        canvas.dodajFiguru(new AdapterJednakostranicniTrougao(5));

        System.out.println("Prikaz Canvas-a nakon dodavanja jednakostrnicnog trougla");

        System.out.println("Iscrtavanje Canvasa");
        canvas.iscrtajCanvas();
        System.out.println("Iscrtavanje Canvasa je zavrseno");

        System.out.println("Povrsina nakon dodavanja jednakostranicnog trougla");

        povrsina=canvas.povrsinaCanvasa();

        System.out.println("povrsina = " + povrsina);
    }
}
