package com.example.crazynet.medicalhub.Adpters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.crazynet.medicalhub.Model.Patient;
import com.example.crazynet.medicalhub.PatientForDaoctorActivity;
import com.example.crazynet.medicalhub.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by CrazyNet on 13/06/2019.
 */

public class searchForPatientAdapter extends RecyclerView.Adapter<searchForPatientAdapter.ViewHolder> {


    ArrayList<Patient> arrayList;
    Context context;


    public searchForPatientAdapter(ArrayList<Patient> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name , address;
        CircleImageView image;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.search_patient_name);
            address = itemView.findViewById(R.id.search_patient_address);
            image = itemView.findViewById(R.id.search_patient_image);
            cardView = itemView.findViewById(R.id.patient_card);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.patient_search_item,parent,false);

        return new searchForPatientAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(arrayList.get(position).getName());
        holder.address.setText(arrayList.get(position).getAddress());
        Glide.with(holder.itemView.getContext()).load(arrayList.get(position).getImage()).into(holder.image);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PatientForDaoctorActivity.class);
                intent.putExtra("name",arrayList.get(position).getName());
                intent.putExtra("address",arrayList.get(position).getAddress());
                intent.putExtra("n_id",arrayList.get(position).getN_id());
                intent.putExtra("age",arrayList.get(position).getAge());
                intent.putExtra("gender",arrayList.get(position).getGender());
                intent.putExtra("hight",arrayList.get(position).getHight());
                intent.putExtra("weight",arrayList.get(position).getWeight());
                intent.putExtra("blood",arrayList.get(position).getBlood());
                intent.putExtra("bio",arrayList.get(position).getBio());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
