package github.io.radnacasu22;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyIntentService extends IntentService {
    private static final String TAG = "MyIntentService";
    public static final String MSG_TAG = "msg_tag";
    public static final int NOTIF_ID = 5;


    public MyIntentService() {
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        showNotifIfNeeded();
    }

    // u on create se mora napraviti notifikacija prvo za sve verzije uredjaja

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String msg = intent.getStringExtra(MSG_TAG);
        for (int i = 0; i < 10; i++) {
            SystemClock.sleep(1000);
            Log.d(TAG, msg + " : " + i);
            Log.e(TAG, msg + " : " + i);
            updateCountDownNotification(i, msg);
        }
    }

    private void showNotifIfNeeded() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification notification = new NotificationCompat.Builder(this, MyApp.channelId)
                    .setContentTitle("Our Intent Service")
                    .setContentText("... Working hard ...")
                    .setSmallIcon(R.drawable.ic_baseline_control_camera_24)
                    .build();
            startForeground(NOTIF_ID, notification);
        }
    }

    private void updateCountDownNotification(int seconds, String strings) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification notification = new NotificationCompat.Builder(this, MyApp.channelId)
                    .setContentTitle("Our Intent Service")
                    .setContentText("... Working hard ...")
                    .setSmallIcon(R.drawable.ic_baseline_control_camera_24)
                    .build();
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.notify(NOTIF_ID, notification);

        }
    }


}
