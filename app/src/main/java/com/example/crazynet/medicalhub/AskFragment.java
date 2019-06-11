package com.example.crazynet.medicalhub;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.crazynet.medicalhub.Adpters.AskAdapter;
import com.example.crazynet.medicalhub.Model.SearchTest;

import java.util.ArrayList;

/**
 * Created by MEdhat on 27/04/2019.
 */

public class AskFragment extends Fragment {

    RecyclerView recyclerView;
    EditText search;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ask_fragment,container,false);

        search = view.findViewById(R.id.Ask_search);
        recyclerView = view.findViewById(R.id.ask_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        final ArrayList<SearchTest> arrayList = new ArrayList<>();

        arrayList.add(new SearchTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Medhat",(float)5,"Minya","Sokar"));
        arrayList.add(new SearchTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Ahmed",(float)5,"Giza","Sokar"));
        arrayList.add(new SearchTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","yasin",(float)4.5,"Alex","Sokar"));
        arrayList.add(new SearchTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","walid",(float)4,"Sohag","Sokar"));
        arrayList.add(new SearchTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","shaaban",(float)3.5,"Minya","Sokar"));
        arrayList.add(new SearchTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Mohamed",(float)3,"Minya","Sokar"));
        arrayList.add(new SearchTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","momen",(float)2.5,"Minya","Sokar"));
        arrayList.add(new SearchTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","amr",(float)2,"Minya","Sokar"));
        arrayList.add(new SearchTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Medhat",(float)1,"Minya","Sokar"));

        recyclerView.setAdapter(new AskAdapter(arrayList,this.getContext()));

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().equals("") && !s.toString().equals(" ")) {
                    ArrayList<SearchTest> searchResult = searchForDoctor(arrayList, "(?i).*"+s+".*");
                    recyclerView.setAdapter(new AskAdapter(searchResult, getContext()));
                }else{
                    recyclerView.setAdapter(new AskAdapter(arrayList, getContext()));
                }
            }
        });

        return view;
    }

    public ArrayList<SearchTest> searchForDoctor(ArrayList<SearchTest> arrayList,String text){

        ArrayList<SearchTest> result = new ArrayList<>();
        for(int i=0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getName().matches(text)){
                result.add(arrayList.get(i));
            }
        }
       return result;
    }
}
