package github.io.radnacasu22;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MySevice extends Service {

    public static final String MSG_TAG = "msg_tag";
    public static final int NOTIF_ID = 1;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String msg = intent.getStringExtra(MSG_TAG);
        //ovde mogu da startujem thread
        showServiceNotification(msg);
        return Service.START_NOT_STICKY;
    }

    private void showServiceNotification(String msg){
        // intent saljemo odma a pading intent je nesto sto ce biti izvrseno u buducnosti
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        Notification notification = new NotificationCompat.Builder(this,MyApp.channelId)
                .setContentTitle("Our Foreground Service")
                .setContentText(msg)
                .setSmallIcon(R.drawable.ic_baseline_control_camera_24)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(NOTIF_ID ,notification);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
