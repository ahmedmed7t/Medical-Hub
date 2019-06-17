package com.example.crazynet.medicalhub.Adpters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.crazynet.medicalhub.Model.AnsweredQuestion;
import com.example.crazynet.medicalhub.Model.SearchTest;
import com.example.crazynet.medicalhub.R;
import com.example.crazynet.medicalhub.doctorForPatientActivity;

import java.util.ArrayList;

/**
 * Created by Medhat on 11/06/2019.
 */

public class AnswerdQustionsAdapter extends RecyclerView.Adapter<AnswerdQustionsAdapter.ViewHolder> {

    private ArrayList<AnsweredQuestion> arrayList;
    private Context context;

    public AnswerdQustionsAdapter(ArrayList<AnsweredQuestion> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        TextView question;
        TextView answer;

        public ViewHolder(View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.answerd_question_question);
            answer = itemView.findViewById(R.id.answerd_question_answer);

        }
    }


    @NonNull
    @Override
    public AnswerdQustionsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.answerd_question_item,parent,false);

        return new AnswerdQustionsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AnswerdQustionsAdapter.ViewHolder holder, final int position) {

        holder.answer.setText(arrayList.get(position).getAnswer());
        holder.question.setText(arrayList.get(position).getQuestion());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
