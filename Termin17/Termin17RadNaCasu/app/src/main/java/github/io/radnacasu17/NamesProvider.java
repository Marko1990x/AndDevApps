package github.io.radnacasu17;

import java.util.ArrayList;
import java.util.List;

public class NamesProvider {

    private static List<String> names; // nije vezano za instancu nego za klasu


    private static void init(){
        if (names == null){
            names = new ArrayList<>();
            names.add("Pera");
            names.add("Mika");
            names.add("Djoka");
        }
    }

    public static List<String> getAllNames(){

        init();
        return names;

    }

    public static String getNameById(int id){

        init();
        if ((id >= 0) && (id <names.size()) ){
            return  names.get(id);
        }else{
            return null;
        }


    }




}
