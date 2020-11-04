package primer4.modifikatori.nivo1;

public class TestMP1 {
    public static void main(String[] args) {
        KlasaMP mp=new KlasaMP();

        int v1=mp.atributPublic;
        int v2=mp.atributDefault;
        //int v3=mp.atributPrivate;
        int v4=mp.atributProtected;
        mp.metodaPublic();
        mp.metodaDefault();
        //mp.metodaPrivate();
        mp.metodaProtected();
    }
}
