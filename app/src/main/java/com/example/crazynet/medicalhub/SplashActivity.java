package com.example.crazynet.medicalhub;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SpannableString string = new SpannableString("Where Doctors And Patients Can Connect together");
        string.setSpan(new BackgroundColorSpan(getResources().getColor(R.color.green)), 0, string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ((TextView)findViewById(R.id.text_sp)).setText(string);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        },3000);
    }

}



