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
     ArrayList<AnsweredQuestion> answeredQuestionns;
     static ArrayList<AnsweredQuestion> addedQuestions = new ArrayList<>();
     static int counter = 0 ;

    public AnswersQuestionFragment() {
        // Required empty public constructor
    }


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

        answeredQuestionns = new ArrayList<>();
        answeredQuestionns.add(new AnsweredQuestion("sem quam semper libero ? ","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec"));
        answeredQuestionns.add(new AnsweredQuestion("consequat vitae, eleifend ac enim ? ","viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue."));
        answeredQuestionns.add(new AnsweredQuestion("Etiam ultricies nisi vel augue ? ","sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante"));
        answeredQuestionns.add(new AnsweredQuestion("Maecenas tempus, tellus eget condimentum rhoncus ? ","vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt"));
        answeredQuestionns.add(new AnsweredQuestion("Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem ?","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec"));
        answeredQuestionns.add(new AnsweredQuestion("Maecenas nec odio et ante tincidunt tempus ?","viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue."));
        answeredQuestionns.add(new AnsweredQuestion("Donec sodales sagittis magna Sed consequat ?","sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante"));
        answeredQuestionns.add(new AnsweredQuestion(" Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus ?","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec"));



        recyclerView.setAdapter(new AnswerdQustionsAdapter(answeredQuestionns,getContext()));


        return view;
    }

    public void addQuestion(AnsweredQuestion answeredQuestion){
        addedQuestions.add(0,answeredQuestion);
    }

    @Override
    public void onResume() {
        super.onResume();
        for(int i=0 ; i<addedQuestions.size();i++){
            answeredQuestionns.add(0,addedQuestions.get(i));
        }
        recyclerView.setAdapter(new AnswerdQustionsAdapter(answeredQuestionns,getContext()));
    }

    @Override
    public void onPause() {
        super.onPause();
        int size = counter;
        for(int i =0 ; i<size;i++){
            answeredQuestionns.remove(0);
            counter--;
        }
    }
}