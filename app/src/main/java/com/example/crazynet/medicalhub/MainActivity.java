package com.example.crazynet.medicalhub;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.username)
    TextInputEditText userName;

    @BindView(R.id.password)
    TextInputEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);}else if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED) {

            addReminderInCalendar();
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        System.exit(0);
    }


    @OnClick(R.id.button_createAccount)
    void toSignUp(){
        Intent intent = new Intent(this,Sign_upActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button_login)
    void login(){
        Intent intent = new Intent(this,home2Activity.class);

        if(userName.getText().toString().equals("p") || userName.getText().toString().equals("P")||
        userName.getText().toString().equals("D")|| userName.getText().toString().equals("d")) {
            intent.putExtra("who",userName.getText().toString());
            startActivity(intent);
        }else if (userName.getText().toString().equals("") && password.getText().toString().equals("")){
            Toast.makeText(this,"enter username and password",Toast.LENGTH_LONG).show();
        }
        else{
            SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
            String m_mail =sharedPreferences.getString("s_mail","");
            String m_password = sharedPreferences.getString("s_password","");
            if(password.getText().toString().equals(m_password) && userName.getText().toString().equals(m_mail)){
                intent.putExtra("who","p");
                startActivity(intent);
            }else{
                SharedPreferences sharedPreferences1 = getSharedPreferences("doctor",MODE_PRIVATE);
                String m_mail1 =sharedPreferences1.getString("d_s_mail","");
                String m_password1 = sharedPreferences1.getString("d_s_password","");
                if(password.getText().toString().equals(m_password1) && userName.getText().toString().equals(m_mail1)){
                    intent.putExtra("who","d");
                    startActivity(intent);
                }else{
                    Toast.makeText(this,"enter valid username or password",Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private String getCalendarUriBase(boolean eventUri) {
        Uri calendarURI = null;
        try {
            if (android.os.Build.VERSION.SDK_INT <= 7) {
                calendarURI = (eventUri) ? Uri.parse("content://calendar/") : Uri.parse("content://calendar/calendars");
            } else {
                calendarURI = (eventUri) ? Uri.parse("content://com.android.calendar/") : Uri
                        .parse("content://com.android.calendar/calendars");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calendarURI.toString();
    }

    private void addReminderInCalendar() {
        Calendar cal = Calendar.getInstance();
        Uri EVENTS_URI = Uri.parse(getCalendarUriBase(true) + "events");
        ContentResolver cr = getContentResolver();
        TimeZone timeZone = TimeZone.getDefault();

        /** Inserting an event in calendar. */
        ContentValues values = new ContentValues();
        values.put(CalendarContract.Events.CALENDAR_ID, 1);
        values.put(CalendarContract.Events.TITLE, "Sanjeev Reminder 01");
        values.put(CalendarContract.Events.DESCRIPTION, "A test Reminder.");
        values.put(CalendarContract.Events.ALL_DAY, 0);
        // event starts at 11 minutes from now
        values.put(CalendarContract.Events.DTSTART, cal.getTimeInMillis() + 1 * 60 * 1000);
        // ends 60 minutes from now
        values.put(CalendarContract.Events.DTEND, cal.getTimeInMillis() + 60 * 60 * 1000);
        values.put(CalendarContract.Events.EVENT_TIMEZONE, timeZone.getID());
        values.put(CalendarContract.Events.HAS_ALARM, 1);
        Uri event = cr.insert(EVENTS_URI, values);

        // Display event id
        Toast.makeText(getApplicationContext(), "Event added :: ID :: " + event.getLastPathSegment(), Toast.LENGTH_SHORT).show();

        /** Adding reminder for event added. */
        Uri REMINDERS_URI = Uri.parse(getCalendarUriBase(true) + "reminders");
        values = new ContentValues();
        values.put(CalendarContract.Reminders.EVENT_ID, Long.parseLong(event.getLastPathSegment()));
        values.put(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALERT);
        values.put(CalendarContract.Reminders.MINUTES, 10);
        cr.insert(REMINDERS_URI, values);
    }
}
