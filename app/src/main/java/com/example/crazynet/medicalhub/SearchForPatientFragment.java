package com.example.crazynet.medicalhub;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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
import com.example.crazynet.medicalhub.Adpters.searchForPatientAdapter;
import com.example.crazynet.medicalhub.Model.Patient;
import com.example.crazynet.medicalhub.Model.Report;
import com.example.crazynet.medicalhub.Model.SearchTest;

import java.util.ArrayList;


public class SearchForPatientFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText search;
    RecyclerView recyclerView;

    public SearchForPatientFragment() {
        // Required empty public constructor
    }


    public static SearchForPatientFragment newInstance(String param1, String param2) {
        SearchForPatientFragment fragment = new SearchForPatientFragment();
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
        View view = inflater.inflate(R.layout.fragment_search_for_patient, container, false);
        search = view.findViewById(R.id.Patient_search);
        recyclerView = view.findViewById(R.id.Patient_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new searchForPatientAdapter(new ArrayList<Patient>(),getContext()));

        ArrayList<Report> reports = new ArrayList<>();
        reports.add(new Report("D medhat","Liver","it's Liver","17/7/2019"));
        reports.add(new Report("D medhat","Liver","it's Liver","17/7/2019"));
        reports.add(new Report("D medhat","Liver","it's Liver","17/7/2019"));
        reports.add(new Report("D medhat","Liver","it's Liver","17/7/2019"));

        final ArrayList<Patient> arrayList = new ArrayList<>();
        arrayList.add(new Patient("https://5asr.ir/wp-content/uploads/2019/04/%D8%B3%D8%B1%D8%B7%D8%A7%D9%86-%D9%BE%D8%B1%D9%88%D8%B3%D8%AA%D8%A7%D8%AA-%D8%AF%D8%B1-%D9%BE%DB%8C%D8%B1%DB%8C.jpg","medhat","male","address","22 years","12312312312312","bio","170","70","B",reports));
        arrayList.add(new Patient("https://5asr.ir/wp-content/uploads/2019/04/%D8%B3%D8%B1%D8%B7%D8%A7%D9%86-%D9%BE%D8%B1%D9%88%D8%B3%D8%AA%D8%A7%D8%AA-%D8%AF%D8%B1-%D9%BE%DB%8C%D8%B1%DB%8C.jpg","yasin","male","new","22 years","45645645645645","bio","170","70","B",reports));
        arrayList.add(new Patient("https://5asr.ir/wp-content/uploads/2019/04/%D8%B3%D8%B1%D8%B7%D8%A7%D9%86-%D9%BE%D8%B1%D9%88%D8%B3%D8%AA%D8%A7%D8%AA-%D8%AF%D8%B1-%D9%BE%DB%8C%D8%B1%DB%8C.jpg","ahmed","male","city","22 years","78978978978978","bio","170","70","B",reports));
        arrayList.add(new Patient("https://5asr.ir/wp-content/uploads/2019/04/%D8%B3%D8%B1%D8%B7%D8%A7%D9%86-%D9%BE%D8%B1%D9%88%D8%B3%D8%AA%D8%A7%D8%AA-%D8%AF%D8%B1-%D9%BE%DB%8C%D8%B1%DB%8C.jpg","mohamed","male","Minya","22 years","01470147014701","bio","170","70","B",reports));
        arrayList.add(new Patient("https://5asr.ir/wp-content/uploads/2019/04/%D8%B3%D8%B1%D8%B7%D8%A7%D9%86-%D9%BE%D8%B1%D9%88%D8%B3%D8%AA%D8%A7%D8%AA-%D8%AF%D8%B1-%D9%BE%DB%8C%D8%B1%DB%8C.jpg","walid","male","samalout","22 years","35935935935935","bio","170","70","B",reports));


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
                    ArrayList<Patient> searchResult = searchForDoctor(arrayList, "(?i).*"+s+".*");
                    recyclerView.setAdapter(new searchForPatientAdapter(searchResult, getContext()));
                }else{
                    recyclerView.setAdapter(new searchForPatientAdapter(new ArrayList<Patient>(), getContext()));
                }
            }
        });




        return view;
    }

    public ArrayList<Patient> searchForDoctor(ArrayList<Patient> arrayList, String text){

        ArrayList<Patient> result = new ArrayList<>();
        for(int i=0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getN_id().matches(text)){
                result.add(arrayList.get(i));
            }
        }
        return result;
    }

}