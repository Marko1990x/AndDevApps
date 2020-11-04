package firebaseapp.com.domaci20;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.io.InputStream;

import Provajder.Glumac_Provajder;

public class SecondActivity extends AppCompatActivity {

    private int position = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glumci_detalji);

        if (savedInstanceState != null){
            this.position = savedInstanceState.getInt("kljuc");
        }

        position = getIntent().getIntExtra("kljuc",0);
        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();

        ImageView imageView = findViewById(R.id.iv_Image);
        InputStream inputStream = null;
        try {

            inputStream = getAssets().open(Glumac_Provajder.getGlumacById(position).getImageGLumca());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);


        }catch (Exception e){
            Toast.makeText(this, "Exception: "+e, Toast.LENGTH_SHORT).show();
        }

        TextView imeGlumca = findViewById(R.id.tv_Ime);
        imeGlumca.setText(Glumac_Provajder.getGlumacById(position).getImeGlumca());
        TextView prezimeGlumca = findViewById(R.id.tv_Prezime);
        prezimeGlumca.setText(Glumac_Provajder.getGlumacById(position).getPrezimeGlumca());
        TextView biographijaGlumca = findViewById(R.id.tv_biographija);
        biographijaGlumca.setText(Glumac_Provajder.getGlumacById(position).getBiographijaGlumca());
        RatingBar ratingBar = findViewById(R.id.rb_ocena);
        ratingBar.setMax(10);
        ratingBar.setIsIndicator(true);
        ratingBar.setRating(Glumac_Provajder.getGlumacById(position).getOcenaGlumca());
        //todo pogledaj kasnije sto mi ovo ne pokazuje ocenu kako treba na rating baru

        TextView glumacDanRodjenja = findViewById(R.id.et_danRodjenja);
       // glumacDanRodjenja.setText(toString(Glumac_Provajder.getGlumacById(position).getDateRodjenja()));
// treba formater ...

        glumacDanRodjenja.setText(Glumac_Provajder.getGlumacById(position).getDateRodjenja());
        TextView danSmrti = findViewById(R.id.et_danSmrti);
        danSmrti.setText(Glumac_Provajder.getGlumacById(position).getDateSmrti());

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,Glumac_Provajder.getGlumacById(position).getListaFilmova());
        spinner.setAdapter(arrayAdapter);


    }
}
