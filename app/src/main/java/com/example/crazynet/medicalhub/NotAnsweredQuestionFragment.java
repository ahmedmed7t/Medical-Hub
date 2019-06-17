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

import com.example.crazynet.medicalhub.Adpters.questionAdapter;

import java.util.ArrayList;


public class NotAnsweredQuestionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    public static ArrayList<Integer> positions = new ArrayList<>();

    public NotAnsweredQuestionFragment() {
        // Required empty public constructor
    }


    public static NotAnsweredQuestionFragment newInstance(String param1, String param2) {
        NotAnsweredQuestionFragment fragment = new NotAnsweredQuestionFragment();
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
        View view = inflater.inflate(R.layout.fragment_not_answered_question, container, false);

        recyclerView = view.findViewById(R.id.not_answerd_question_doctor_profile);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<String> questions = new ArrayList<>();
        questions.add("Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus ?");
        questions.add("Donec sodales sagittis magna Sed consequat ?");
        questions.add("Maecenas nec odio et ante tincidunt tempus ?");
        questions.add("Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem ?");
        questions.add("Maecenas tempus, tellus eget condimentum rhoncus ? ");
        questions.add("Etiam ultricies nisi vel augue ? ");

        ArrayList<String> newArray = removeFromAnswerd(questions);

        recyclerView.setAdapter(new questionAdapter(newArray,getContext()));

        return view;
    }

    public ArrayList<String> removeFromAnswerd(ArrayList<String> arrayList){

        for(int i = 0 ; i < positions.size() ; i++){
            int s = positions.get(i);
            arrayList.remove(s);
        }

        return arrayList;
    }

}