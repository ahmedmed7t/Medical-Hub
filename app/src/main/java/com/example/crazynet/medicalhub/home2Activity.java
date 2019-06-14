package com.example.crazynet.medicalhub;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.crazynet.medicalhub.Adpters.CommunitiesAdapter;
import com.example.crazynet.medicalhub.Model.CommunitiesTest;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class home2Activity extends AppCompatActivity {

    String who;


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
                case R.id.navigation_search_patient:
                    fragmentTransaction.replace(R.id.main_frgment, new SearchForPatientFragment());
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_profile_patient:
                    fragmentTransaction.replace(R.id.main_frgment, new DoctorProfileFragment());
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


        Intent intent = getIntent();
        who = intent.getStringExtra("who");

        if(who.equals("p")||who.equals("P"))
            navigation.inflateMenu(R.menu.navigation);
        else if(who.equals("d")||who.equals("D"))
            navigation.inflateMenu(R.menu.patient_navigation);
        else
            navigation.inflateMenu(R.menu.navigation);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frgment, new homeFragment());
        fragmentTransaction.commit();

    }

}
