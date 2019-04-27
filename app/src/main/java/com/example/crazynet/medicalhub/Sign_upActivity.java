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

    @BindView(R.id.signUP_Image)
    ImageView userImage ;

    @BindView(R.id.radio_isDoctor)
    RadioButton isDoctor;

    @BindView(R.id.radio_notDoctor)
    RadioButton notDoctor;

    @BindView(R.id.signUp_doctor_ID)
    TextInputLayout container_doctor_id;

    @BindView(R.id.userAge_doctor_ID)
    ImageView icon_doctorID;

    private String realImgPath;
    private MultipartBody.Part file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);



        // to upload image
//        File imgFile = new File(realImgPath);
//        RequestBody imgReqFile = RequestBody.create(MediaType.parse("image/*"), imgFile);
//        file = MultipartBody.Part.createFormData("photo", imgFile.getName(), imgReqFile);

    }


    @OnCheckedChanged(R.id.radio_isDoctor)
    public void getDoctorID(){
        if(isDoctor.isChecked()){
            container_doctor_id.setVisibility(View.VISIBLE);
            icon_doctorID.setVisibility(View.VISIBLE);
        }
    }

    @OnCheckedChanged(R.id.radio_notDoctor)
    public void goneDoctorID(){
        if(notDoctor.isChecked()){
            container_doctor_id.setVisibility(View.GONE);
            icon_doctorID.setVisibility(View.GONE);
        }
    }


    @OnClick(R.id.signUP_Image)
    public void openGallery() {
        requestPermission();
        Intent i = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, 100);
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);
        }
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 100 && resultCode == RESULT_OK && null != data) {
            final Uri imageUri = data.getData();
            InputStream imageStream = null;
            try {
                imageStream = getContentResolver().openInputStream(imageUri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            userImage.setImageBitmap(selectedImage);
            userImage.setScaleType(ImageView.ScaleType.CENTER_CROP);


            Uri imagePath = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(imagePath,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            realImgPath = cursor.getString(columnIndex);
            cursor.close();
        }

    }

}
