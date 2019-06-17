package com.example.crazynet.medicalhub;

import android.content.Context;
import android.content.SharedPreferences;
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

import com.bumptech.glide.Glide;
import com.example.crazynet.medicalhub.Adpters.MedicalReportsAdapter;
import com.example.crazynet.medicalhub.Model.Report;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PatientProfileFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    TextView edit , name , age , gender , address , P_id , editMedInfo ;
    CircleImageView image;
    EditText bio , hight , weight , blood;
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
        name = view.findViewById(R.id.patient_name);
        age = view.findViewById(R.id.patient_age);
        address = view.findViewById(R.id.patient_adress);
        P_id = view.findViewById(R.id.patient_NID);
        gender = view.findViewById(R.id.patient_gender);
        image = view.findViewById(R.id.patient_image);
        bio = view.findViewById(R.id.patient_bio);
        hight = view.findViewById(R.id.txt_hight_profile);
        weight = view.findViewById(R.id.txt_weight_prfile);
        blood = view.findViewById(R.id.txt_blood_prfile);
        editMedInfo = view.findViewById(R.id.edit_med_info);

        fillData();

        edit = view.findViewById(R.id.edit_bio);


        recyclerView = view.findViewById(R.id.patient_profile_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Report> arrayList = new ArrayList<>();
        arrayList.add(new Report("Ahmed Khaled","diabates","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu ","17/7/2019"));
        arrayList.add(new Report("ALi mohamed","High blood preauser","Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a ","23/12/2018"));
        arrayList.add(new Report("yaser mahmoud","Anemia","Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet.","17/8/2018"));
        arrayList.add(new Report("Medhat mohamed","Lung diseases","Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus,","10/5/2018"));
        arrayList.add(new Report("ahmed mohamed","bone diseases","sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. ","17/7/2016"));

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
                    SharedPreferences preferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("bio",bio.getText().toString());
                    editor.apply();
                }
            }
        });


        editMedInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editMedInfo.getText().equals("Edit info")){
                    editMedInfo.setText("Save Info");
                    hight.setEnabled(true);
                    weight.setEnabled(true);
                    blood.setEnabled(true);
                }else{
                    editMedInfo.setText("Edit Info");
                    hight.setEnabled(false);
                    weight.setEnabled(false);
                    blood.setEnabled(false);
                }
            }
        });

        return view;
    }

    public void fillData(){

        name.setText(home2Activity.name);
        address.setText(home2Activity.u_address);
        P_id.setText(home2Activity.u_id);
        age.setText(home2Activity.u_age + " years ");
        if(home2Activity.u_gender.equals("1")){
            gender.setText("male");
        }else{gender.setText("female");}

        Glide.with(this.getContext()).load("https://1heurf2kk91pad4b23w0jddl-wpengine.netdna-ssl.com/wp-content/uploads/2015/03/8800806_m.jpg")
                .into(image);
        bio.setText(home2Activity.u_bio);
    }

}
