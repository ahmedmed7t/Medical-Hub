package com.example.crazynet.medicalhub;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.crazynet.medicalhub.Adpters.CommunitiesAdapter;
import com.example.crazynet.medicalhub.Model.CommunitiesTest;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class home2Activity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction.replace(R.id.main_frgment, new homeFragment());
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_reminder:
                    fragmentTransaction.replace(R.id.main_frgment, new ReminderFragment());
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_profile:
                    fragmentTransaction.replace(R.id.main_frgment, new PatientProfileFragment());
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_about:
                    fragmentTransaction.replace(R.id.main_frgment, new AboutUsFragment());
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_doctors:
                    fragmentTransaction.replace(R.id.main_frgment, new AskFragment());
                    fragmentTransaction.commit();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ButterKnife.bind(this);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frgment, new homeFragment());
        fragmentTransaction.commit();



    }

}
