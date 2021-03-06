package com.example.crazynet.medicalhub;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;


public class DoctorProfileFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    TextView ans , notAns , bio , phone , address , expertise , name;
    EditText e_bio , e_phone , e_addrss ;

    public DoctorProfileFragment() {
        // Required empty public constructor
    }


    public static DoctorProfileFragment newInstance(String param1, String param2) {
        DoctorProfileFragment fragment = new DoctorProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_doctor_profile, container, false);
        bio = view.findViewById(R.id.edit_bio);
        address = view.findViewById(R.id.edit_doctor_adress);
        phone = view.findViewById(R.id.edit_doctor_phone);

        e_bio = view.findViewById(R.id.doctor_profile_bio);
        e_addrss = view.findViewById(R.id.doctor_adress);
        e_phone = view.findViewById(R.id.doctor_phone);

        expertise = view.findViewById(R.id.doctor_specialist);
        name = view.findViewById(R.id.doctor_name);

        name.setText(home2Activity.name);
        expertise.setText(home2Activity.u_expertise);
        e_bio.setText(home2Activity.u_bio);
        e_phone.setText(home2Activity.u_phone);
        e_addrss.setText(home2Activity.u_address);

        bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getSharedPreferences("doctor", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                if(bio.getText().equals("Edit Bio")){
                    e_bio.setEnabled(true);
                    bio.setText("Save Bio");
                    editor.putString("d_bio",e_bio.getText().toString());
                }else{
                    e_bio.setEnabled(false);
                    bio.setText("Edit Bio");
                }
                editor.apply();
            }
        });

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getSharedPreferences("doctor", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                if(address.getText().equals("Edit Address")){
                    e_addrss.setEnabled(true);
                    address.setText("Save Address");
                    editor.putString("d_address", e_addrss.getText().toString());
                }else{
                    e_addrss.setEnabled(false);
                    address.setText("Edit Address");
                }
                editor.apply();
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getSharedPreferences("doctor", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                if(phone.getText().equals("Edit Phone")){
                    e_phone.setEnabled(true);
                    phone.setText("Save Phone");
                    editor.putString("d_phone", e_phone.getText().toString());
                }else{
                    e_phone.setEnabled(false);
                    phone.setText("Edit Phone");
                }
                editor.apply();
            }
        });

        final FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.profile_framelayout, new AnswersQuestionFragment());
        fragmentTransaction.commit();

        ans = view.findViewById(R.id.d_profile_ans_ques);
        notAns = view.findViewById(R.id.d_profile_not_ans_ques);

        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.profile_framelayout, new AnswersQuestionFragment());
                fragmentTransaction1.commit();
            }
        });

        notAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                fragmentTransaction2.replace(R.id.profile_framelayout, new NotAnsweredQuestionFragment());
                fragmentTransaction2.commit();
            }
        });



        return view;
    }

}