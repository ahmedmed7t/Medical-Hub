package com.example.crazynet.medicalhub;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
        }
    }

    @OnCheckedChanged(R.id.radio_notDoctor)
    public void goneDoctorID(){
        if(notDoctor.isChecked()){
            container_doctor_id.setVisibility(View.GONE);
        }
    }


}
