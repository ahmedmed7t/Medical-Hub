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
    TextView name , age , gender , id , address , height , weight , blood;
    CircleImageView circleImageView;

    static ArrayList<Report> addedReports = new ArrayList<>();
    static ArrayList<String> patientName = new ArrayList<>();
    static int counter = 0 ;
    ArrayList<Report> arrayList;

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
        height = findViewById(R.id.patient_FD_hight);
        weight = findViewById(R.id.patient_FD_weight);
        blood = findViewById(R.id.patient_FD_blood);
        bio = findViewById(R.id.patient_FD_bio);

        circleImageView.setImageDrawable(getDrawable(R.mipmap.patient));



        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        address.setText(intent.getStringExtra("address"));
        id.setText(intent.getStringExtra("n_id"));
        age.setText(intent.getStringExtra("age"));
        gender.setText(intent.getStringExtra("gender"));
        height.setText(intent.getStringExtra("hight"));
        weight.setText(intent.getStringExtra("weight"));
        blood.setText(intent.getStringExtra("blood"));
        bio.setText(intent.getStringExtra("bio"));



        bio = findViewById(R.id.patient_FD_bio);
        recyclerView = findViewById(R.id.patient_FD_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList = new ArrayList<>();
        arrayList.add(new Report("Ahmed Khaled","diabates","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu ","17 June 2019"));
        arrayList.add(new Report("ALi mohamed","High blood preauser","Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a ","23 December 2018"));
        arrayList.add(new Report("yaser mahmoud","Anemia","Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet.","17 Mars2018"));
        arrayList.add(new Report("Medhat mohamed","Lung diseases","Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus,","10 April 2018"));
        arrayList.add(new Report("ahmed mohamed","bone diseases","sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. ","17 Jule 2016"));

        recyclerView.setAdapter(new MedicalReportsAdapter(this,arrayList));

       button = findViewById(R.id.btn_add_history);
       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // intent to add history
                Intent intent = new Intent( getApplicationContext() , AddHistoryActivity.class );
                intent.putExtra("name",name.getText().toString());
                startActivity(intent);

            }
        });

    }

    public void addHistory(Report report , String Patient){
        addedReports.add(report);
        patientName.add(Patient);
    }

    @Override
    protected void onResume() {
        super.onResume();
        for(int i = 0 ; i < addedReports.size(); i ++){
            if(name.getText().toString().equals(patientName.get(i))){
                arrayList.add(addedReports.get(i));
                counter++;
            }
            recyclerView.setAdapter(new MedicalReportsAdapter(this,arrayList));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        int size = counter;
        for(int i = 0 ; i < size ; i++){
           arrayList.remove(arrayList.size()-1);
           counter--;
        }
    }
}
