package primer6.biblioteka.model;

public class JednakostraniciniTrougao {

    private int stranica;
    public JednakostraniciniTrougao(int stranica){
        this.stranica=stranica;
    }

    public void prikazi(){
        System.out.println("Jednakostranici trougao stranica je a= "+stranica);
    }

    public double povrsina(){
        return stranica*stranica*Math.sqrt(3)/2;
    }

    public double obim(){
        return 3*stranica;
    }
}
