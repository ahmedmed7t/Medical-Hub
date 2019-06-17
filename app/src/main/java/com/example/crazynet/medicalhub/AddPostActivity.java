package com.example.crazynet.medicalhub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crazynet.medicalhub.Model.PostTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddPostActivity extends AppCompatActivity {

    @BindView(R.id.editText_post)
    EditText postContent;

    @BindView(R.id.btn_post)
    Button post;

    String comm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        ButterKnife.bind(this);

        comm = getIntent().getStringExtra("comm");

    }

    @OnClick(R.id.btn_post)
    public void addPost(){

        PostTest item = createPost();
        DiscussFragment fragment = new DiscussFragment();
        fragment.addPost(item);
        postContent.setText("");
        Toast.makeText(this,"post added",Toast.LENGTH_LONG).show();
    }

    public PostTest createPost(){

        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String date = sdf.format(currentTime);

        PostTest postTest = new PostTest();

        postTest.setLikes(0);
        postTest.setComm(comm);
        postTest.setContent(postContent.getText().toString());
        postTest.setDate(date);
        postTest.setDoctor(home2Activity.is_doctor);
        if(home2Activity.is_doctor){
            postTest.setImage("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg");
        }else{
            postTest.setImage("https://1heurf2kk91pad4b23w0jddl-wpengine.netdna-ssl.com/wp-content/uploads/2015/03/8800806_m.jpg");
        }
        postTest.setName(home2Activity.name);

        return postTest;
    }

}
