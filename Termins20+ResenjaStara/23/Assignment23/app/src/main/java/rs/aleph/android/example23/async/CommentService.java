package rs.aleph.android.example23.async;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by milossimic on 11/1/16.
 */
public class CommentService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String title = intent.getExtras().getString("title");
        String comment = intent.getExtras().getString("comment");

        new CommentTask(getApplicationContext()).execute(title, comment);

        stopSelf();

        return START_NOT_STICKY;
    }
}
