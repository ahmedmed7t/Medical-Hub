package com.example.crazynet.medicalhub;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.crazynet.medicalhub.Reminder.Alarm_Receiver;

import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddReminderActivity extends AppCompatActivity {

    TimePicker timePicker;
    AlarmManager alarmManager;
    Intent intent;
    Button add;
    public int count = -1 ;
    EditText M_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);
        ButterKnife.bind(this);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        timePicker = findViewById(R.id.timePicker);

        M_name = findViewById(R.id.name_medical);

        add = findViewById(R.id.btn_add_reminder);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++ ;
                addReminder(M_name.getText().toString(),count);
            }
        });

        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(0);

    }

    public void addReminder(String name,int count){

        String newHour ;

        Calendar calendar1;
        PendingIntent pendingIntent1;

        calendar1 = Calendar.getInstance();

        int getHour = timePicker.getCurrentHour();
        int getMinute = timePicker.getCurrentMinute();

        if(getHour<10){
             newHour = "0"+getHour;
        }else{
            newHour = String.valueOf(getHour);
        }
        String date = newHour+":"+getMinute;
        ReminderFragment.add_date(name,date,this);

        calendar1.set(Calendar.HOUR_OF_DAY, getHour);
        calendar1.set(Calendar.MINUTE, getMinute);
        calendar1.set(Calendar.SECOND,0);

        Toast.makeText(this,String.valueOf("Alarm Added"),Toast.LENGTH_SHORT).show();

        intent = new Intent(this, Alarm_Receiver.class);
        intent.putExtra("medicine_name",name);

        pendingIntent1 = PendingIntent.getBroadcast(this , count, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar1.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent1);
    }
}
