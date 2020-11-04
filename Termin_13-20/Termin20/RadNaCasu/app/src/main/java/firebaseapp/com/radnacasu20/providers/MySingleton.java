package firebaseapp.com.radnacasu20.providers;

public class MySingleton {

    private static MySingleton INSTANCE = new MySingleton();
    private MySingleton(){};
    private static MySingleton getINSTANCE(){
        return  INSTANCE;
    }
}
