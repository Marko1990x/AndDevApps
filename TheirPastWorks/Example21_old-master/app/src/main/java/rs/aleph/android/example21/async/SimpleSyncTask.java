package rs.aleph.android.example21.async;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example21.R;
import rs.aleph.android.example21.fragments.ListFragment;
import rs.aleph.android.example21.model.Category;
import rs.aleph.android.example21.model.Product;
import rs.aleph.android.example21.provider.CategoryProvider;
import rs.aleph.android.example21.provider.ProductProvider;

/**
 * Created by milossimic on 10/22/16.
 * AsyncTask klasa prima tri parametra prilikom specijalizacije
 * Korisnici sami definisu tip u zavisnosti od posla koji zele da obave.
 *
 * Prvi argument predstavlja ulazne parametre, ono so zelimo
 * da posaljemo zadatku. Recimo ime fajla koji zelimo da skinemo
 *
 * Drugi argument je indikator kako ce se meriti progres. Koliko je posla
 * zavrseno i koliko je opsla ostalo.
 *
 * Treci parametar je povratna vrednost, tj sta ce metoda doInBackground
 * vratiti kao poratnu vrednost metodi onPostExecute
 */
public class SimpleSyncTask extends AsyncTask<String, Void, List>{

    private Activity activity;
    private ListFragment.OnProductSelectedListener listener;
    private ListFragment fragment;

    public SimpleSyncTask(Activity activity, ListFragment fragment) {
        this.activity = activity;
        listener = (ListFragment.OnProductSelectedListener) activity;
        this.fragment = fragment;
    }

    /**
     * Metoda se poziva pre samog starta pozadinskog zadatka
     * Sve pripreme odraditi u ovoj metodi, ako ih ima.
     */
    @Override
    protected void onPreExecute() {
    }

    /**
     * Posao koji se odvija u pozadini, ne blokira glavnu nit aplikacije.
     * Sav posao koji dugo traje izvrsavati unutar ove metode.
     * Primer prima jedan parametar tipa String koji odredjuje sta ce se
     * prikazati u listi. Kao rezultat se vraca lista za adapter.
     */
    @Override
    protected List doInBackground(String... params) {
        try {
            //simulacija posla koji se obavlja u pozadini i traje duze vreme
            Thread.sleep(6000);

            switch (params[0]) {
                case "category":
                    List<Category> categories = CategoryProvider.getCategories();
                    List<String> categoryNames = new ArrayList<>();
                    for (Category cat : categories) {
                        categoryNames.add(cat.getName());
                    }
                    return categoryNames;
                case "products":
                    List<Product> products = ProductProvider.getProducts();
                    List<String> productNames = new ArrayList<>();
                    for (Product prod : products) {
                        productNames.add(prod.getName());
                    }
                    return productNames;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     *
     * Kada se posao koji se odvija u pozadini zavrsi, poziva se ova metoda
     * Ako je potrebno osloboditi resurse ili obrisati elemente koji vise ne trebaju.
     * List products se dobija iz doInBackground kada se ona zavrsi.
     * Kreira se adapter za products i prikaze se u ListView.
     */
    @Override
    protected void onPostExecute(List products) {
        Toast.makeText(activity, "Sync done", Toast.LENGTH_SHORT).show();

        // Create an ArrayAdaptar from the array of Strings
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.list_item, products);
        ListView listView = (ListView) fragment.getView().findViewById(R.id.products);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Send the URL to the host activity
                listener.onProductSelected((int)id);
            }
        });

    }
}
