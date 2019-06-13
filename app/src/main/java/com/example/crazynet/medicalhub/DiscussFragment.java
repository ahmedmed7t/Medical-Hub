package com.example.crazynet.medicalhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.crazynet.medicalhub.Adpters.PostAdapter;
import com.example.crazynet.medicalhub.Model.PostTest;

import java.util.ArrayList;

/**
 * Created by Medhat on 27/04/2019.
 */

public class DiscussFragment extends Fragment {

    RecyclerView recyclerView;
    String commName;
    TextView communityName;
    FloatingActionButton floatingActionButton;


    public void setCommName(String commName) {
        this.commName = commName;
    }

    public DiscussFragment() {
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discuss_fragment,container,false);

        communityName = view.findViewById(R.id.txt_name_discuss);
        communityName.setText(commName);

        floatingActionButton = view.findViewById(R.id.fab_add_post);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),AddPostActivity.class);
                getContext().startActivity(intent);
            }
        });

        recyclerView = view.findViewById(R.id.discuss_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setHasFixedSize(true);

        ArrayList<PostTest> arrayList = new ArrayList<>();
        arrayList.add(new PostTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Medhat","17 July 2017","Compared to people who always ate breakfast, those who say they never did had a 87% higher odds of dying from heart-related causes, according to a study that tracked the health of 6,550 Americans for about 20 years.\n" +
                "\n" +
                "The odds for stroke, in particular, were especially elevated if people said they always skipped breakfast. These individuals had more than three times the odds of fatal stroke, compared to people who said they always ate in the a.m.",true));

        arrayList.add(new PostTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Medhat","17 July 2017","Compared to people who always ate breakfast, those who say they never did had a 87% higher odds of dying from heart-related causes, according to a study that tracked the health of 6,550 Americans for about 20 years.",false));
        arrayList.add(new PostTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Medhat","17 July 2017","Compared to people who always ate breakfast, those who say they never did had a 87% higher odds of dying from heart-related causes, according to a study that tracked the health of 6,550 Americans for about 20 years.",false));
        arrayList.add(new PostTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Medhat","17 July 2017","Compared to people who always ate breakfast, those who say they never did had a 87% higher odds of dying from heart-related causes, according to a study that tracked the health of 6,550 Americans for about 20 years.",true));
        arrayList.add(new PostTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Medhat","17 July 2017","Compared to people who always ate breakfast, those who say they never did had a 87% higher odds of dying from heart-related causes, according to a study that tracked the health of 6,550 Americans for about 20 years.",false));
        arrayList.add(new PostTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Medhat","17 July 2017","Compared to people who always ate breakfast, those who say they never did had a 87% higher odds of dying from heart-related causes, according to a study that tracked the health of 6,550 Americans for about 20 years.",true));

        recyclerView.setAdapter(new PostAdapter(arrayList,this.getContext()));
        return view;
    }
}
