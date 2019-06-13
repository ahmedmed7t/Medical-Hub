package com.example.crazynet.medicalhub;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.crazynet.medicalhub.Adpters.MedicalReportsAdapter;
import com.example.crazynet.medicalhub.Model.Report;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PatientForDaoctorActivity extends AppCompatActivity {

    EditText bio;
    RecyclerView recyclerView;
    Button button;
    TextView name , age , gender , id , address;
    CircleImageView circleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_for_daoctor);
        name = findViewById(R.id.patient_FD_name);
        age = findViewById(R.id.patient_age);
        gender = findViewById(R.id.patient_FD_gender);
        id = findViewById(R.id.patient_FD_NID);
        address = findViewById(R.id.patient_adress);
        circleImageView = findViewById(R.id.patient_FD_image);

        circleImageView.setImageDrawable(getDrawable(R.mipmap.patient));



        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        address.setText(intent.getStringExtra("address"));
        id.setText(intent.getStringExtra("n_id"));
        age.setText(intent.getStringExtra("age"));
        gender.setText(intent.getStringExtra("gender"));


        bio = findViewById(R.id.patient_FD_bio);
        recyclerView = findViewById(R.id.patient_FD_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Report> arrayList = new ArrayList<>();
        arrayList.add(new Report("Medhat","Sokar","this is sokar ","17/7/2019"));
        arrayList.add(new Report("Medhat","Sokar","this is sokar ","17/7/2019"));
        arrayList.add(new Report("Medhat","Sokar","this is sokar ","17/7/2019"));
        arrayList.add(new Report("Medhat","Sokar","this is sokar ","17/7/2019"));
        arrayList.add(new Report("Medhat","Sokar","this is sokar ","17/7/2019"));

        recyclerView.setAdapter(new MedicalReportsAdapter(this,arrayList));

       button = findViewById(R.id.btn_add_history);
       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // intent to add history
                Intent intent = new Intent( getApplicationContext() , AddHistoryActivity.class );
                startActivity(intent);

            }
        });

    }
}
