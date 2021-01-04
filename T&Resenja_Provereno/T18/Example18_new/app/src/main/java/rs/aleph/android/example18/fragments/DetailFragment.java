package rs.aleph.android.example18.fragments;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
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

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import rs.aleph.android.example18.R;
import rs.aleph.android.example18.providers.CategoryProvider;
import rs.aleph.android.example18.providers.FruitProvider;

// Each fragment extends Fragment class
public class DetailFragment extends Fragment {

    // TODO
    private static final int NOTIFICATION_ID = 1;
    public static final String NOTIF_CHANNEL_ID = "rs.aleph.android.example18.default_channel";

    // Position of the item to be displayed in the detail fragment
    private int position = 0;

    // onActivityCreated method is a life-cycle method that is called when the fragment's activity has been created and this fragment's view hierarchy instantiated.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        // Shows a toast message (a pop-up message)
        //Toast.makeText(getActivity(), "DetailFragment.onActivityCreated()", Toast.LENGTH_SHORT).show();

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position", 0);
        }

        // Finds "ivImage" ImageView and sets "imageDrawable" property
        ImageView ivImage = getView().findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(FruitProvider.getFruitById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Finds "tvName" TextView and sets "text" property
        TextView tvName = getView().findViewById(R.id.tv_name);
        tvName.setText(FruitProvider.getFruitById(position).getName());

        // Finds "tvDescription" TextView and sets "text" property
        TextView tvDescription = getView().findViewById(R.id.tv_description);
        tvDescription.setText(FruitProvider.getFruitById(position).getDescription());

        // Finds "spCategory" Spiner and sets "selection" property
        Spinner category = getView().findViewById(R.id.sp_category);
        List<String> categories = CategoryProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection(FruitProvider.getFruitById(position).getCategory().getId());

        // Finds "rbRating" RatingBar and sets "rating" property
        RatingBar rbRating = getView().findViewById(R.id.rb_rating);
        rbRating.setRating(FruitProvider.getFruitById(position).getRating());

        // Finds "btnBuy" Button and sets "onClickListener" listener
        Button btnBuy = getView().findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });

    }

    // onSaveInstanceState method is a life-cycle method that is called to ask the fragment to save its current dynamic state, so it can later be reconstructed in a new instance of its process is restarted.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        // Shows a toast message (a pop-up message)
        //Toast.makeText(getActivity(), "DetailFragment.onSaveInstanceState()", Toast.LENGTH_SHORT).show();

        savedInstanceState.putInt("position", position);
    }

    // onCreateView method is a life-cycle method that is called  to have the fragment instantiate its user interface view.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Shows a toast message (a pop-up message)
        //Toast.makeText(getActivity(), "DetailFragment.onCreateView()", Toast.LENGTH_SHORT).show();

        // Finds view in the view hierarchy and returns it.
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        createNotificationChannel();
        return view;
    }

    // Called to set fragment's content.
    public void setContent(final int position) {

        this.position = position;

        Log.v("DetailFragment", "setContent() sets position to " + position);
    }

    // Called to update fragment's content.
    public void updateContent(final int position) {

        this.position = position;

        Log.v("DetailFragment", "updateContent() sets position to " + position);

        // Finds "ivImage" ImageView and sets "imageDrawable" property
        ImageView ivImage = getView().findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(FruitProvider.getFruitById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Finds "tvName" TextView and sets "text" property
        TextView tvName = getView().findViewById(R.id.tv_name);
        tvName.setText(FruitProvider.getFruitById(position).getName());

        // Finds "tvDescription" TextView and sets "text" property
        TextView tvDescription = getView().findViewById(R.id.tv_description);
        tvDescription.setText(FruitProvider.getFruitById(position).getDescription());

        // Finds "spCategory" Spiner and sets "selection" property
        Spinner category = getView().findViewById(R.id.sp_category);
        List<String> categories = CategoryProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection((int)FruitProvider.getFruitById(position).getCategory().getId());

        // Finds "rbRating" RatingBar and sets "rating" property
        RatingBar rbRating = getView().findViewById(R.id.rb_rating);
        rbRating.setRating(FruitProvider.getFruitById(position).getRating());

        // Finds "btnBuy" Button and sets "onClickListener" listener
        Button btnBuy = getView().findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });
    }

    private void showNotification() {
        // Creates notification with the notification builder
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(), NOTIF_CHANNEL_ID);
        Bitmap bitmap = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.ic_stat_buy);
        builder.setSmallIcon(R.drawable.ic_stat_buy);
        builder.setContentTitle(getActivity().getString(R.string.notification_title));
        builder.setContentText(getActivity().getString(R.string.notification_text));
        builder.setLargeIcon(bitmap);

        // Shows notification with the notification manager (notification ID is used to update the notification later on)
        NotificationManager manager = (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID, builder.build());
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(NOTIF_CHANNEL_ID, "Example18 Notification Channel", importance);
            channel.setDescription("Notification channel for Example18 application");
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getActivity().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
