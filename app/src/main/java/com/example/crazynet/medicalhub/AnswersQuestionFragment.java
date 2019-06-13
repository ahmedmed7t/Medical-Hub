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

import com.example.crazynet.medicalhub.Adpters.AnswerdQustionsAdapter;
import com.example.crazynet.medicalhub.Model.AnsweredQuestion;

import java.util.ArrayList;


public class AnswersQuestionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;

    public AnswersQuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnswersQuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnswersQuestionFragment newInstance(String param1, String param2) {
        AnswersQuestionFragment fragment = new AnswersQuestionFragment();
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
        View view = inflater.inflate(R.layout.fragment_answers_question, container, false);

        recyclerView = view.findViewById(R.id.answerd_question_doctor_profile);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<AnsweredQuestion> answeredQuestionns = new ArrayList<>();
        answeredQuestionns.add(new AnsweredQuestion("question ","answer"));
        answeredQuestionns.add(new AnsweredQuestion("question ","answer"));
        answeredQuestionns.add(new AnsweredQuestion("question ","answer"));
        answeredQuestionns.add(new AnsweredQuestion("question ","answer"));
        answeredQuestionns.add(new AnsweredQuestion("question ","answer"));
        answeredQuestionns.add(new AnsweredQuestion("question ","answer"));
        answeredQuestionns.add(new AnsweredQuestion("question ","answer"));
        answeredQuestionns.add(new AnsweredQuestion("question ","answer"));
        answeredQuestionns.add(new AnsweredQuestion("question ","answer"));
        answeredQuestionns.add(new AnsweredQuestion("question ","answer"));


        recyclerView.setAdapter(new AnswerdQustionsAdapter(answeredQuestionns,getContext()));


        return view;
    }

}