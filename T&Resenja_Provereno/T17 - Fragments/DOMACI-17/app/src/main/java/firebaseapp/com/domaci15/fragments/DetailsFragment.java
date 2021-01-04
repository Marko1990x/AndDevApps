package firebaseapp.com.domaci15.fragments;

import android.app.Fragment;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import firebaseapp.com.domaci15.Model.Jelo;
import firebaseapp.com.domaci15.Provider.JeloProvider;
import firebaseapp.com.domaci15.Provider.KategorijaProvider;
import firebaseapp.com.domaci15.R;


public class DetailsFragment extends Fragment {

    private static int NOTIFICATION_ID = 1;
    private int position = 0;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null){
            position= savedInstanceState.getInt("position",0);

        }

        ImageView imageView = (ImageView) getView().findViewById(R.id.iv_Image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(JeloProvider.getJeloById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is,null);
            imageView.setImageDrawable(drawable);
        }catch (IOException e){
            e.printStackTrace();
        }

        TextView tvName = (TextView) getView().findViewById(R.id.tv_Name);
        tvName.setText(JeloProvider.getJeloById(position).getName());

        TextView tvDescription = (TextView) getView().findViewById(R.id.tv_Description);
        tvDescription.setText(JeloProvider.getJeloById(position).getDescription());

        Spinner category = (Spinner) getView().findViewById(R.id.sp_category);
        List<String> categories = KategorijaProvider.getKategoriaNames();
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item,categories);
        category.setAdapter(adapter);
        category.setSelection((int)JeloProvider.getJeloById(position).getKategoria().getId());

        RatingBar ratingBar = (RatingBar) getView().findViewById(R.id.rb_Rating);
        ratingBar.setRating(JeloProvider.getJeloById(position).getRating());

        Button button = (Button) getView().findViewById(R.id.btn_Buy);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", position);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container,false);
        return view;
    }



    private void setContent(final int position){
        this.position = position;
        Log.v("Details Fragment", "setContent() sets position to "+position);
    }

    private void updateContent(final int position){
        this.position = position;
        Log.v("Details Fragment", "Update content sets position to "+ position);
        View view;
        ImageView imageView = (ImageView) getView().findViewById(R.id.iv_Image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(JeloProvider.getJeloById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is,null);
            imageView.setImageDrawable(drawable);
        }catch(IOException e){
            e.printStackTrace();
        }

        TextView tvName = (TextView) getView().findViewById(R.id.tv_Name);
        tvName.setText(JeloProvider.getJeloById(position).getName());
        TextView tvDescription = (TextView) getView().findViewById(R.id.tv_Description);
        tvDescription.setText(JeloProvider.getJeloById(position).getDescription());

        Spinner spinner = (Spinner) getView().findViewById(R.id.sp_category);
        List<String> categories = KategorijaProvider.getKategoriaNames();
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,categories);
        spinner.setAdapter(adapter);
        spinner.setSelection((int)JeloProvider.getJeloById(position).getKategoria().getId());

        RatingBar ratingBar = (RatingBar) getView().findViewById(R.id.rb_Rating);
        ratingBar.setRating(JeloProvider.getJeloById(position).getRating());

        Button button = (Button) getView().findViewById(R.id.btn_Buy);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });

    }






    private void showNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity());
        Bitmap bitmap = BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.ic_stat_buy_foreground);
        builder.setSmallIcon(R.drawable.ic_stat_buy_foreground);
        builder.setContentTitle("Item Ordered");
        builder.setContentText("The item has been ordered and it will be shipped");
        builder.setLargeIcon(bitmap);
        NotificationManager manager = (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID, builder.build());
    }
}
