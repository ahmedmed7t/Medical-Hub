package com.example.crazynet.medicalhub;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.crazynet.medicalhub.Adpters.CommunitiesAdapter;
import com.example.crazynet.medicalhub.Model.CommunitiesTest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;



public class homeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView communities_recycler;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public homeFragment() {
        // Required empty public constructor
    }


    public static homeFragment newInstance(String param1, String param2) {
        homeFragment fragment = new homeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        communities_recycler = view.findViewById(R.id.comm_recycler);

        communities_recycler.setHasFixedSize(true);

        communities_recycler.setLayoutManager(new LinearLayoutManager(this.getContext()));


        ArrayList<CommunitiesTest> arrayList = new ArrayList<>();
        arrayList.add(new CommunitiesTest("https://cdn1.medicalnewstoday.com/content/images/articles/322/322104/man-having-heart-attack.jpg","Heart diseases","Heart disease may affect any function of the heart and any parts of the heart. The most common heart disease is coronary syndrome (Coronary syndrome) in its various forms and manifestations"));
        arrayList.add(new CommunitiesTest("https://cdn1.medicalnewstoday.com/content/images/articles/159/159283/measuring-blood-pressure.jpg","High blood pressure ","Some people suffer from high blood pressure for years without feeling any offer. High, uncontrolled blood pressure increases the risk of serious health problems, such as heart attack and stroke."));
        arrayList.add(new CommunitiesTest("https://www.aspiretrainingteam.co.uk/wp-content/uploads/2017/12/Diabetes-1000x600.jpg","Diabetes","The term diabetes included a number of disorders in the process of destruction and building - metabolism - (Metabolism) carbohydrates"));
        arrayList.add(new CommunitiesTest("https://modo3.com/thumbs/fit630x300/84107/1479046248/%D8%A8%D8%AD%D8%AB_%D8%AD%D9%88%D9%84_%D9%81%D9%82%D8%B1_%D8%A7%D9%84%D8%AF%D9%85.jpg","Anemia","Anemia is a medical condition characterized by a lack of sufficient red blood cells in the body to move enough oxygen to the tissues."));
        arrayList.add(new CommunitiesTest("https://www.rsnhope.org/wp-content/uploads/2017/04/Understanding-kidney-disease-RSN.jpg","Kidney disease","is a medical condition in which the kidneys are functioning at less than 15% of normal. It is divided into acute kidney failure (cases that develop rapidly) and chronic kidney failure (those that are long term)"));
        arrayList.add(new CommunitiesTest("https://visualstudiomagazine.com/~/media/ECG/visualstudiomagazine/Images/introimages2014/0514vsm_VogelJava.jpg","backbone disease","Spinal disease refers to a condition impairing the backbone. These include various diseases of the back or spine (\"dorso-\"), such as kyphosis. Dorsalgia refers to back pain"));
        arrayList.add(new CommunitiesTest("https://www.researchgate.net/publication/265518023/figure/fig1/AS:611522573238272@1522809751173/Schematic-of-a-human-lung-with-its-five-lobes-RUL-right-upper-lobe-RML-right-middle.png","Lung disease","Some lung diseases can lead to respiratory failure such as asthma, COPD, infections like influenza, lung cancer, and many other breathing problems."));


        CommunitiesAdapter adapter = new CommunitiesAdapter(arrayList,this.getContext());
        communities_recycler.setAdapter(adapter);

        return view;
    }


    public void addToPref(ArrayList<CommunitiesTest> arrayList){

        SharedPreferences preferences = getActivity().getSharedPreferences("communities",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        editor.putString(json,"m_communities");
        editor.apply();

    }

    public ArrayList<CommunitiesTest> loadFromPref(){

        ArrayList<CommunitiesTest> arrayList ;

        SharedPreferences preferences = getActivity().getSharedPreferences("communities",Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString("m_communities",null);
        Type type = new TypeToken<ArrayList<CommunitiesTest>>(){}.getType();
        arrayList = gson.fromJson(json,type);

        return arrayList;
    }


}
