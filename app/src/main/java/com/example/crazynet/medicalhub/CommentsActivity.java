package com.example.crazynet.medicalhub;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.crazynet.medicalhub.Adpters.CommentAdapter;
import com.example.crazynet.medicalhub.Adpters.MedicalReportsAdapter;
import com.example.crazynet.medicalhub.Model.Comment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommentsActivity extends AppCompatActivity {

    static RecyclerView recyclerView;

    @BindView(R.id.btn_add_comment)
    ImageView add_comment;

    static EditText comment_content;

    static ArrayList<Comment> arrayList = new ArrayList<>();
    static ArrayList<Comment> addedarrayList = new ArrayList<>();
    static int counter;

    static String community_id;
    static String post_id;
    public static CommentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        ButterKnife.bind(this);

        recyclerView = findViewById(R.id.comment_recycler);
        comment_content = findViewById(R.id.edit_comment);

        Intent intent = getIntent();
        community_id = intent.getStringExtra("commID");
        post_id = intent.getStringExtra("postId");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        arrayList.clear();
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","1","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","1","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","1","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","1","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","1","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","1","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","1","2"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","1","2"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","1","2"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","1","3"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","1","3"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","1","3"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","1","4"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","1","4"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","1","4"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","2","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","2","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","2","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","2","2"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","2","2"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","2","2"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","2","3"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","2","3"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","2","3"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","3","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","3","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","3","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","3","2"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","3","2"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","3","2"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","3","3"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","3","3"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","3","3"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","4","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","4","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","4","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","4","2"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","4","2"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","4","2"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","4","3"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","4","3"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","4","3"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","5","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","5","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","5","1"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","5","2"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","5","2"));
        arrayList.add(new Comment("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab","auther","https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","17 june 2019","5","2"));

        adapter = null;
        ArrayList<Comment> myArray = filterComments(arrayList);

        adapter = new CommentAdapter(myArray,this);

        recyclerView.setAdapter(adapter);

        add_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_comment(getApplicationContext());
                comment_content.setText("");
                Toast.makeText(getApplicationContext(),"comment Added ", Toast.LENGTH_LONG).show();
            }
        });

    }

    public static ArrayList<Comment> filterComments(ArrayList<Comment> arrayListComment){
        ArrayList<Comment> newArray = new ArrayList<>();

        for(int i=0;i<arrayListComment.size();i++){
            if(arrayListComment.get(i).getCommunity_id().equals(community_id) &&
                    arrayListComment.get(i).getPost_id().equals(post_id)){
                newArray.add(arrayListComment.get(i));
            }
        }

        return newArray;
    }

    public static void add_comment(Context context){

        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String date = sdf.format(currentTime);

        Comment comment = new Comment();
        comment.setContent(comment_content.getText().toString());
        comment.setAuther(home2Activity.name);
        comment.setCommunity_id(community_id);
        comment.setPost_id(post_id);
        comment.setDate(date);
        if(home2Activity.is_doctor){
            comment.setImage("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg");
        }else{
            comment.setImage("https://1heurf2kk91pad4b23w0jddl-wpengine.netdna-ssl.com/wp-content/uploads/2015/03/8800806_m.jpg");
        }
        addedarrayList.add(comment);

        arrayList.add(comment);

        adapter = null ;
        ArrayList<Comment> myArray = filterComments(arrayList);
        adapter = new CommentAdapter(myArray,context);
        recyclerView.setAdapter(adapter);
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

    @Override
    protected void onResume() {
        super.onResume();
        for(int i = 0 ; i < addedarrayList.size(); i ++) {
            arrayList.add(addedarrayList.get(i));
            counter++;
        }
         adapter = null;
          ArrayList<Comment> myArray = filterComments(arrayList);
          adapter = new CommentAdapter(myArray,this);
         recyclerView.setAdapter(adapter);

    }
}
