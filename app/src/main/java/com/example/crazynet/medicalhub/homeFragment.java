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

import com.example.crazynet.medicalhub.Adpters.CommunitiesAdapter;
import com.example.crazynet.medicalhub.Model.CommunitiesTest;

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

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homeFragment.
     */
    // TODO: Rename and change types and number of parameters
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
        arrayList.add(new CommunitiesTest("https://www.aspiretrainingteam.co.uk/wp-content/uploads/2017/12/Diabetes-1000x600.jpg","SOKAR"));
        arrayList.add(new CommunitiesTest("https://cdn1.medicalnewstoday.com/content/images/articles/172/172408/liver-3d.jpg","PRESSURE"));
        arrayList.add(new CommunitiesTest("https://www.lstatic.org/UserFiles/images/Arab-and-World/Diverts/Large/Kidney-transplants.jpg","KELYA"));
        arrayList.add(new CommunitiesTest("https://png.pngtree.com/element_origin_min_pic/17/08/18/057a209808206ee97fb90a4f6286be60.jpg","LUNG"));
        arrayList.add(new CommunitiesTest("https://cdn1.medicalnewstoday.com/content/images/articles/172/172408/liver-3d.jpg","LIVER"));
        arrayList.add(new CommunitiesTest("http://www.interactive-biology.com/wp-content/uploads/2012/06/MaleSkeletonsitting1.jpg","BONES"));
        arrayList.add(new CommunitiesTest("https://cdn1.medicalnewstoday.com/content/images/articles/321/321379/scabies-on-the-hand-cause-by-mange-in-humans.jpg","SKIN"));
        arrayList.add(new CommunitiesTest("https://media.mnn.com/assets/images/2017/12/blue-eyes-ss.jpg.653x0_q80_crop-smart.jpg","EYES"));
        arrayList.add(new CommunitiesTest("https://www.aspiretrainingteam.co.uk/wp-content/uploads/2017/12/Diabetes-1000x600.jpg","SOKAR"));


        CommunitiesAdapter adapter = new CommunitiesAdapter(arrayList,this.getContext());
        communities_recycler.setAdapter(adapter);

        return view;
    }


}
