package primer6.aplikacija1;


import primer6.aplikacija1.model.Figura;
import primer6.aplikacija1.model.Kvadrat;
import primer6.aplikacija1.workarea.Canvas;

public class App1 {
    public static void main(String[] args) {
        Canvas canvas=new Canvas();
        canvas.dodajFiguru(new Kvadrat(4));
        canvas.dodajFiguru(new Kvadrat(8));

        System.out.println("Iscrtavanje Canvasa");
        canvas.iscrtajCanvas();
        System.out.println("Iscrtavanje Canvasa je zavrseno");

        double povrsina=canvas.povrsinaCanvasa();

        System.out.println("povrsina = " + povrsina);

    }
}
