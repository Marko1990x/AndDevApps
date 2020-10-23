package primer9;

public class TestAsocijacija {
    public static void main(String[] args) {
        Automobil a1=new Automobil(54,true);
        Automobil a2=new Automobil(23,false);

        Deo d1=new Deo("Volan");
        Deo d2=new Deo("Volan sportski");
        Deo d3=new Deo("Sediste");
        Deo d4=new Deo("Sediste na spustanje");

        a1.getDelovi().add(d2);
        d2.setAutomobil(a1);

        a1.getDelovi().add(d4);
        d4.setAutomobil(a1);

        a2.getDelovi().add(d1);
        d1.setAutomobil(a2);

        a2.getDelovi().add(d3);
        d3.setAutomobil(a2);

        //Prikaz delova za prvi automobil
        for(Deo d:a1.getDelovi())
            System.out.println("Deo: Naziv: "+d.getNaziv());

        System.out.println("d2.getAutomobil().getMaksimalnaBrzina() = " + d2.getAutomobil().getMaksimalnaBrzina());

        //Prikaz delova za drugi automobil
        for(Deo d:a2.getDelovi())
            System.out.println("Deo: Naziv: "+d.getNaziv());

        //Pronaci deo koji ima naziv "sportski"
        System.out.println("Pocinje pretraga");
        for(Deo d:a1.getDelovi())
        {
            System.out.println("Proveravam deo: "+d.getNaziv());
            if (d.getNaziv().contains("sportski"))
                System.out.println("Pronasao deo: " + d.getNaziv());
        }
        System.out.println("Zavrsena pretraga");
    }
}
