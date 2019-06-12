package com.example.crazynet.medicalhub.Reminder;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.example.crazynet.medicalhub.MainActivity;
import com.example.crazynet.medicalhub.Model.NotificationHelper;
import com.example.crazynet.medicalhub.R;

/**
 * Created by Medhat on 01/02/2018.
 */
public class Alarm_Service extends Service {

    MediaPlayer mediaPlayer;
    String name = "medicine";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this,R.raw.reminder);
        mediaPlayer.start();

        name = intent.getStringExtra("medicine_name_");

        /*NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(Alarm_Service.this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent1,0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Medicine Reminder");
        builder.setContentText(intent.getStringExtra("medicine_name_"));
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.ic_man);

        Notification noti = builder.build();
        notificationManager.notify(0,noti);*/

        stopSelf();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        NotificationHelper helper = new NotificationHelper(Alarm_Service.this);
        NotificationCompat.Builder bb = helper.createNotification("Medicine Reminder",Alarm_Receiver.name);

        Notification m = bb.build();

        startForeground(1, m);

    }

}
