package primer6.aplikacija2.model;

import primer6.aplikacija2.interfejsi.IFigura;
import primer6.biblioteka.model.JednakostraniciniTrougao;

/**
 * Adapter klasa koja metode iz klase JednakostranicniTrougao
 * poziva za odgovarajuce metode iz interfejsa IFigura.
 * NAPOMENA:Mogli bi i da nasledimo klasu JednakostranicniTrougao,
 * ali bi tada bile vidljive i metode iz klase iz Jednakostranicnog trougla
 * i klase iz interfejsa IFigura, sto moze da zbuni onoga ko bude koristio ovu
 * klasu, pa se zato koristi poseban atribut koji cuva referencu na objekat tipa
 * JednakostranicniTrougao, a u redefinisanim metodama iz interfejsa IFigura
 * se pozivaju metode klase JednakostraniciTrougao.
 */
public class AdapterJednakostranicniTrougao  implements IFigura {

    private JednakostraniciniTrougao referenca;
    public AdapterJednakostranicniTrougao(int stranica){
        referenca=new JednakostraniciniTrougao(stranica);
    }

    @Override
    public void iscrtajFiguru() {
        referenca.prikazi();
    }

    @Override
    public double izracunajPovrsinu() {
        return referenca.povrsina();
    }

    @Override
    public double izracunajObim() {
        return referenca.obim();
    }
}
