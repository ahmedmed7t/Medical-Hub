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
        arrayList.add(new Patient("https://1heurf2kk91pad4b23w0jddl-wpengine.netdna-ssl.com/wp-content/uploads/2015/03/8800806_m.jpg","Khaled Amr","male","Minya","60 years","12312312312312","Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore","172 CM","78 KG","B+",reports));
        arrayList.add(new Patient("http://greenarea.me/wp-content/uploads/2016/10/aa-32.jpg","Ashraf Belal","male","Alexandria","60 years","45645645645645","magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam","180 CM","90 KG","A+",reports));
        arrayList.add(new Patient("https://www.thaqfya.com/wp-content/uploads/2019/01/%D8%B1%D8%A4%D9%8A%D8%A9-%D8%B4%D8%AE%D8%B5-%D9%85%D8%B1%D9%8A%D8%B6-%D9%81%D9%8A-%D8%A7%D9%84%D9%85%D8%B3%D8%AA%D8%B4%D9%81%D9%89-%D9%81.jpg","Mostafa Selem","male","Giza","71 years","78978978978978","nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur","175 CM","100 KG","AB",reports));
        arrayList.add(new Patient("https://www.rd.com/wp-content/uploads/2016/01/44-50-secrets-hospitals-wont-tell-you-forget-doctors-orders.jpg","yaser Alaa","male","Cairo","25 years","01470147014701","At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos","165","65","O-",reports));
        arrayList.add(new Patient("https://previews.123rf.com/images/rido/rido1704/rido170400092/77309620-senior-doctor-explaining-xray-to-patient-lying-on-hospital-bed-surgeon-showing-radiology-report-to-o.jpg","Khaled Essam","male","sohag","22 years","35935935935935","rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod","185 CM","80 KG","O+",reports));
        arrayList.add(new Patient("https://d2v9y0dukr6mq2.cloudfront.net/video/thumbnail/1809Tdj/videoblocks-in-the-hospital-sick-male-patient-sleeps-on-the-bed-hes-wearing-nasal-cannula-nurse-enters-and-checks-his-drop-counter-increases-dose-of-pain-killer-shot-on-red-epic-w-8k-helium-cinema-camera_rebqs-ufg_thumbnail-full01.png","Ayman Mahmoud","male","Elfayoum","31 years","74174174174174","Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore","172 CM","78 KG","B+",reports));
        arrayList.add(new Patient("https://ak1.picdn.net/shutterstock/videos/23246761/thumb/1.jpg","Abd Elrahem Moahmed","male","assuit","29 years","85285285285285","magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam","180 CM","90 KG","A+",reports));
        arrayList.add(new Patient("https://thumbs.dreamstime.com/z/difficulty-breathing-adult-male-patient-hospital-oxygen-mask-52656449.jpg","Amr ALi","male","qena","32 years","96396396396396","nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur","175 CM","100 KG","AB",reports));
        arrayList.add(new Patient("https://st4.depositphotos.com/7249566/20426/v/600/depositphotos_204268772-stock-video-sick-man-coughing-while-lying.jpg","Ammar Yaser","male","luxor","55 years","95195195195195","At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos","165 CM","65 KG","O-",reports));
        arrayList.add(new Patient("https://carwad.net/sites/default/files/picture-of-sick-man-146880-7430768.jpg","Ehap Hossam","male","Aswan","45 years","75375375375375","rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod","185 KG","80 KG","O+",reports));


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