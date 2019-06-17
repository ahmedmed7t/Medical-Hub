package com.example.crazynet.medicalhub;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class cont_signActivity extends AppCompatActivity {


    String firstName, lastName, N_id, mail, password, doctor_id , expertise;
    boolean is_doctor, is_male;

    @BindView(R.id.signUp_edit_phone)
    TextInputEditText phone;

    @BindView(R.id.signUp_edit_age)
    TextInputEditText age;

    @BindView(R.id.signUp_edit_address)
    TextInputEditText address;

    @BindView(R.id.signUp_edit_bio)
    TextInputEditText bio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_sign);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        firstName = intent.getStringExtra("f_name");
        lastName = intent.getStringExtra("l_name");
        N_id = intent.getStringExtra("n_id");
        mail = intent.getStringExtra("mail");
        password = intent.getStringExtra("password");
        doctor_id = intent.getStringExtra("doctor_id");
        is_doctor = intent.getBooleanExtra("is_doctor",false);
        is_male = intent.getBooleanExtra("is_male",true);
        expertise = intent.getStringExtra("expertise");

    }

    @OnClick(R.id.create_account)
    public void create(){

        if( phone.getText().toString().equals("") || age.getText().toString().equals("")||
                address.getText().toString().equals("")){
            Toast.makeText(this,"please fill all data required",Toast.LENGTH_LONG).show();
        }else {

            SharedPreferences preferences ;
            if(!is_doctor){
                preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("full_name", firstName + " " + lastName);
                editor.putString("n_id", N_id);
                editor.putString("s_mail", mail);
                editor.putString("s_password", password);
                editor.putString("doctor_id", doctor_id);
                editor.putString("bio",bio.getText().toString());
                if (is_doctor) {
                    editor.putString("is_doctor", String.valueOf(1));
                } else {
                    editor.putString("is_doctor", String.valueOf(0));
                }

                if (is_male) {
                    editor.putString("is_male", String.valueOf(1));
                } else {
                    editor.putString("is_nale", String.valueOf(0));
                }
                editor.putString("age", age.getText().toString());
                editor.putString("phone", phone.getText().toString());
                editor.putString("address", address.getText().toString());
                editor.apply();
            }else{
                preferences = getSharedPreferences("doctor", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("d_full_name", firstName + " " + lastName);
                editor.putString("d_n_id", N_id);
                editor.putString("d_s_mail", mail);
                editor.putString("d_s_password", password);
                editor.putString("d_doctor_id", doctor_id);
                editor.putString("d_bio",bio.getText().toString());
                if (is_doctor) {
                    editor.putString("d_is_doctor", String.valueOf(1));
                } else {
                    editor.putString("d_is_doctor", String.valueOf(0));
                }

                if (is_male) {
                    editor.putString("d_is_male", String.valueOf(1));
                } else {
                    editor.putString("d_is_nale", String.valueOf(0));
                }
                editor.putString("d_age", age.getText().toString());
                editor.putString("d_phone", phone.getText().toString());
                editor.putString("d_address", address.getText().toString());
                editor.putString("d_expertise",expertise);
                editor.apply();
            }

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
