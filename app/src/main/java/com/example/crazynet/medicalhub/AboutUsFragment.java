package com.example.crazynet.medicalhub;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.crazynet.medicalhub.Adpters.DeveloperAdapter;
import com.example.crazynet.medicalhub.Model.Developers;

import java.util.ArrayList;


public class AboutUsFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    RecyclerView recyclerView;

    public AboutUsFragment() {
        // Required empty public constructor
    }


    public static AboutUsFragment newInstance(String param1, String param2) {
        AboutUsFragment fragment = new AboutUsFragment();
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
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);

        recyclerView = view.findViewById(R.id.about_us_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        ArrayList<Developers> arrayList = new ArrayList<>();
        arrayList.add(new Developers(getResources().getDrawable(R.mipmap.ana),"Ahmed Medhat","Android Developer"));
        arrayList.add(new Developers(getResources().getDrawable(R.mipmap.yasen),"Mostafa Ahmed","Back End Developer"));
        arrayList.add(new Developers(getResources().getDrawable(R.mipmap.walid),"Walid Qotb","Android Developer"));
        arrayList.add(new Developers(getResources().getDrawable(R.mipmap.fatma),"Fatma Adel","Front End Developer"));
        arrayList.add(new Developers(getResources().getDrawable(R.mipmap.rehab),"Rehab Mohamed","UI & UX Designer"));
        arrayList.add(new Developers(getResources().getDrawable(R.mipmap.shaaban),"Mahmoud Shaaban","Front End Developer"));

        recyclerView.setAdapter(new DeveloperAdapter(getContext(),arrayList));

        return view;
    }


}
