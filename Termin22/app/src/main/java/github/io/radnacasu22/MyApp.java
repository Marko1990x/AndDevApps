package github.io.radnacasu22;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

// mora da extenduje obavezno
public class MyApp extends Application {

    public static final String channelId = "my_channel_id";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();

    }

    private void createNotificationChannel(){

        // pita koja je verzija androida da li je veca od androida oreo
        //
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, "My Notif Channel", NotificationManager.IMPORTANCE_DEFAULT);


            channel.setDescription("Description");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

    }


}
