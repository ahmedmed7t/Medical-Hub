package com.example.crazynet.medicalhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000'>Medical Hub</font>"));

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
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
}
