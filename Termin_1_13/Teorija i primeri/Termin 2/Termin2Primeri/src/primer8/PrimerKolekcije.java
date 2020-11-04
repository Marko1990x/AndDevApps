package primer8;


import java.util.ArrayList;

public class PrimerKolekcije {
    public static void main(String[] args) {
        {
            ArrayList<Integer> lista = new
                    ArrayList<Integer>();
        }
        {
            ArrayList lista = new ArrayList () ;
            lista.add(5) ;
            lista.add("Tekst");
        }
        {
            ArrayList<Integer> lista = new ArrayList<Integer>() ;
            lista.add(5) ;
            lista.add( new Integer (5) ) ;
            lista.add(1 , 15) ;
            System.out.println ( " Velicina je : " + lista.size() ) ;
            lista.remove(0) ;
            int broj = lista.get(0) ;
            System.out.println ( broj ) ;
            System.out.println ( " Velicina je : " + lista.size() ) ;

            for ( int i = 0; i < lista.size() ; i ++) {
                System.out.println ( " Broj je : " + lista.get( i ) ) ;
            }

            for ( Integer el : lista ) {
                System.out.println( " Broj je : " + el ) ;
            }
        }

        {
            ArrayList<Automobil> lista = new ArrayList<Automobil>() ;
            lista.add(new Automobil());
            lista.add( new Automobil(34,true) ) ;
            lista.add(1 , new Automobil(57,false)) ;
            System.out.println ( " Velicina je : " + lista.size() ) ;
            lista.remove(0) ;
            Automobil a = lista.get(0) ;
            System.out.println("a.getMaksimalnaBrzina() = " + a.getMaksimalnaBrzina());
            System.out.println("a.isRadi() = " + a.isRadi());
            System.out.println ( " Velicina je : " + lista.size() ) ;

            Automobil a1;
            for ( int i = 0; i < lista.size() ; i ++) {
                a1=lista.get(i);
                System.out.println ( " Automobil: Maksimalna brzina: " + a1.getMaksimalnaBrzina() +
                                                   "Radi: " + a1.isRadi()) ;
            }

            for ( Automobil el : lista ) {
                System.out.println( " Automobil: Maksimalna brzina: " + el.getMaksimalnaBrzina() +
                        "Radi: " + el.isRadi()) ;
            }
        }
    }
}
