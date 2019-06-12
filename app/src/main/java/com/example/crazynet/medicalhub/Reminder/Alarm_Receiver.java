package com.example.crazynet.medicalhub.Reminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/**
 * Created by Medhat on 30/01/2018.
 */

public class Alarm_Receiver extends BroadcastReceiver {

    public static String name ;
    @Override
    public void onReceive(Context context, Intent intent) {
        //context.startService(intent1);
        name = intent.getStringExtra("medicine_name");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Intent intent1 = new Intent(context, Alarm_Service.class);
            intent1.putExtra("medicine_name_",intent.getStringExtra("medicine_name"));
            context.startForegroundService(intent1);
        } else {
            Intent intent1 = new Intent(context, Alarm_Service.class);
            intent1.putExtra("medicine_name_",intent.getStringExtra("medicine_name"));
            context.startService(new Intent(context, Alarm_Service.class));
        }
    }


}
