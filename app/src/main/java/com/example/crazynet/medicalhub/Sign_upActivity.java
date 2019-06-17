package com.example.crazynet.medicalhub;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class Sign_upActivity extends AppCompatActivity {

    private static final int REQUEST_WRITE_PERMISSION = View.generateViewId();


    @BindView(R.id.radio_isDoctor)
    RadioButton isDoctor;

    @BindView(R.id.radio_notDoctor)
    RadioButton notDoctor;

    @BindView(R.id.signUp_doctor_ID)
    TextInputLayout container_doctor_id;

    @BindView(R.id.signUp_doctor_expertise)
    TextInputLayout container_doctor_expertise;

    @BindView(R.id.signUp_edit_doctor_expertise)
    TextInputEditText doctor_expertise;

    @BindView(R.id.signUp_edit_firstName)
    TextInputEditText firstName;

    @BindView(R.id.signUp_edit_lastName)
    TextInputEditText lastName;

    @BindView(R.id.signUp_edit_ID)
    TextInputEditText N_id;

    @BindView(R.id.signUp_edit_mail)
    TextInputEditText mail;

    @BindView(R.id.signUp_edit_password)
    TextInputEditText password;

    @BindView(R.id.signUp_edit_doctor_ID)
    TextInputEditText doctor_id;

    boolean is_male = true;
    boolean is_doctor = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);



    }


    @OnCheckedChanged(R.id.radio_isDoctor)
    public void getDoctorID(){
        if(isDoctor.isChecked()){
            container_doctor_id.setVisibility(View.VISIBLE);
            container_doctor_expertise.setVisibility(View.VISIBLE);
            is_doctor = true;
        }
    }

    @OnCheckedChanged(R.id.radio_notDoctor)
    public void goneDoctorID(){
        if(notDoctor.isChecked()){
            container_doctor_id.setVisibility(View.GONE);
            container_doctor_expertise.setVisibility(View.GONE);
            is_doctor = false;
        }
    }

    @OnCheckedChanged(R.id.radio_male)
    public void male(){
        if(notDoctor.isChecked()){
            is_male = true;
        }
    }

    @OnCheckedChanged(R.id.radio_female)
    public void female(){
        if(notDoctor.isChecked()){
            is_male = false;
        }
    }


    @OnClick(R.id.create_new_account)
    public void toNext(){

        String id = doctor_id.getText().toString();
        String expertise = doctor_expertise.getText().toString();

        Intent intent = new Intent(this, cont_signActivity.class);
        intent.putExtra("f_name", firstName.getText().toString());
        intent.putExtra("l_name", lastName.getText().toString());
        intent.putExtra("n_id", N_id.getText().toString());
        intent.putExtra("mail", mail.getText().toString());
        intent.putExtra("password", password.getText().toString());
        intent.putExtra("doctor_id", doctor_id.getText().toString());
        intent.putExtra("is_doctor",is_doctor);
        intent.putExtra("is_male", is_male);
        intent.putExtra("expertise",expertise);


        if(firstName.getText().toString().equals("") || lastName.getText().toString().equals("")||
                N_id.getText().toString().equals("") || mail.getText().toString().equals("") ||
                password.getText().toString().equals(""))
        {
            Toast.makeText(this, "please fill all data required", Toast.LENGTH_LONG).show();
        }else{
            if(is_doctor == true && !id.equals("") && !expertise.equals("")){
                startActivity(intent);
            }else if(is_doctor == false && id.equals("") && expertise.equals("")){
                startActivity(intent);
            }else {
                Toast.makeText(this, "enter doctor id", Toast.LENGTH_LONG).show();
            }
        }

    }

}
