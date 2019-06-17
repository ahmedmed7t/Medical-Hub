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
    public static boolean is_doctor = false;
    public static String name = "Medhat";
    public static String u_address = "Minya";
    public static String u_id = "12345678912345";
    public static String u_age = "25";
    public static String u_phone = "01234567891";
    public static String u_gender = "1";
    public static String u_bio = "";
    public static String u_expertise = "";


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

        if(who.equals("p")||who.equals("P")){
            navigation.inflateMenu(R.menu.navigation);
            is_doctor = false;
        }
        else if(who.equals("d")||who.equals("D")) {
            navigation.inflateMenu(R.menu.patient_navigation);
            is_doctor = true ;
        } else {
            navigation.inflateMenu(R.menu.navigation);
            is_doctor = false;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frgment, new homeFragment());
        fragmentTransaction.commit();

        String userName, address, phone,age , id , is_male , bio , expertise ;

        if(!is_doctor) {
            SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
             userName = sharedPreferences.getString("full_name", "");
             address = sharedPreferences.getString("address", "");
             phone = sharedPreferences.getString("phone", "");
             age = sharedPreferences.getString("age", "");
             id = sharedPreferences.getString("n_id", "");
             is_male = sharedPreferences.getString("is_male", "");
             bio = sharedPreferences.getString("bio", "");
             expertise = sharedPreferences.getString("expertise", "");

        }else{
            SharedPreferences sharedPreferences = getSharedPreferences("doctor", MODE_PRIVATE);
             userName = sharedPreferences.getString("d_full_name", "");
             address = sharedPreferences.getString("d_address", "");
             phone = sharedPreferences.getString("d_phone", "");
             age = sharedPreferences.getString("d_age", "");
             id = sharedPreferences.getString("d_n_id", "");
             is_male = sharedPreferences.getString("d_is_male", "");
             bio = sharedPreferences.getString("d_bio", "");
             expertise = sharedPreferences.getString("d_expertise", "");
        }
        if(!address.equals("")){ u_address = address; }
        if(!phone.equals("")){ u_phone = phone; }
        if(!userName.equals("")){ name = userName; }
        if(!age.equals("")){ u_age = age; }
        if(!id.equals("")){ u_id = id; }
        if(!is_male.equals("")){ u_gender = is_male ;}
        if(!bio.equals("")){u_bio = bio;}
        if(!expertise.equals("")){u_expertise = expertise;}

    }

}
