package com.example.crazynet.medicalhub;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.crazynet.medicalhub.Adpters.MedicalReportsAdapter;
import com.example.crazynet.medicalhub.Model.Report;

import java.util.ArrayList;

public class PatientProfileFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    TextView edit ;
    EditText bio;
    RecyclerView recyclerView;


    public PatientProfileFragment() {
        // Required empty public constructor
    }


    public static PatientProfileFragment newInstance(String param1, String param2) {
        PatientProfileFragment fragment = new PatientProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_patient_profile, container, false);

        edit = view.findViewById(R.id.edit_bio);
        bio = view.findViewById(R.id.patient_bio);
        recyclerView = view.findViewById(R.id.patient_profile_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Report> arrayList = new ArrayList<>();
        arrayList.add(new Report("Medhat","Sokar","this is sokar ","17/7/2019"));
        arrayList.add(new Report("Medhat","Sokar","this is sokar ","17/7/2019"));
        arrayList.add(new Report("Medhat","Sokar","this is sokar ","17/7/2019"));
        arrayList.add(new Report("Medhat","Sokar","this is sokar ","17/7/2019"));
        arrayList.add(new Report("Medhat","Sokar","this is sokar ","17/7/2019"));

        recyclerView.setAdapter(new MedicalReportsAdapter(getContext(),arrayList));


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!bio.isEnabled()){
                    edit.setText("Save");
                    bio.setEnabled(true);
                }else{
                    edit.setText("Edit Bio");
                    bio.setEnabled(false);
                }
            }
        });

        return view;
    }


}
