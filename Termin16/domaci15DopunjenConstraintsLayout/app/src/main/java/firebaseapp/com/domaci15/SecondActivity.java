package firebaseapp.com.domaci15;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import Model.Jelo;
import Model.Kategoria;
import Provider.JeloProvider;
import Provider.KategorijaProvider;

public class SecondActivity extends AppCompatActivity {
    private int position = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // ovo mi govori ako vec postoji saved instance state da pozicija dobija vrednost sacuvanu
        // koji ce mi ovo ocin
        if (savedInstanceState != null) {
            this.position = savedInstanceState.getInt("kljuc");
        }
        // ovo uzima prosledjenu vrednost
        // ovo je isto key da poveze prosledjene vrednosti
        // Load instance state from bundle
        position = getIntent().getIntExtra("kljuc", 0);

       // Toast.makeText(this, "Ovo je vrednost"+position, Toast.LENGTH_SHORT).show();


        // treba da ucitavam sliku sada
        ImageView imageView = findViewById(R.id.iv_Image);
        InputStream inputStream = null;
        try {
            // metode da bi se pozvale moraju biti public ili verovatno imale svoje get metode.
            inputStream = getAssets().open(JeloProvider.getJeloById(position).getImage());
           // ovo vezuje moju sliku po poziciji sa input stream
            Drawable drawable = Drawable.createFromStream(inputStream,null);
            // ovo mi povezuje is sa drawable objektom
            imageView.setImageDrawable(drawable);
            // ovo puni image view sa drawable
        }catch (Exception e){

            Toast.makeText(this, "Error: "+e, Toast.LENGTH_SHORT).show();

        }
        TextView naziv = findViewById(R.id.tv_Name);
        naziv.setText(JeloProvider.getJeloById(position).getName());
        TextView opis = findViewById(R.id.tv_Description);
        opis.setText(JeloProvider.getJeloById(position).getDescription());

        Spinner kategorySpinner = findViewById(R.id.sp_Kategory);
        List<String> listaZaSpinner = KategorijaProvider.getKategoriaNames();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaZaSpinner);
        kategorySpinner.setAdapter(arrayAdapter);
        //todo pogledaj kako da automatski postavlja dobar element na osnovu indexa
        kategorySpinner.setSelection(JeloProvider.getJeloById(position).getKategoria().getId());
        //todo resenje

        RatingBar ratingBar = findViewById(R.id.rb_Rating);
        ratingBar.setRating(JeloProvider.getJeloById(position).getRating());

        Button button = findViewById(R.id.btn_Buy);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "Kupili ste" + JeloProvider.getJeloById(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
