package com.example.crazynet.medicalhub.Adpters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.crazynet.medicalhub.AddHistoryActivity;
import com.example.crazynet.medicalhub.Model.Developers;
import com.example.crazynet.medicalhub.PatientForDaoctorActivity;
import com.example.crazynet.medicalhub.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Medhat on 12/06/2019.
 */

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.ViewHolder> {

    Context context;
    ArrayList<Developers> developers;

    public DeveloperAdapter() {
    }

    public DeveloperAdapter(Context context, ArrayList<Developers> developers) {

        this.context = context;
        this.developers = developers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.developer_item,parent,false);

        return new DeveloperAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.d_name.setText(developers.get(position).getName());
        holder.d_job.setText(developers.get(position).getJob());
        Glide.with(context).load(developers.get(position).getImage()).into(holder.d_image);
        holder.d_image.setImageDrawable(developers.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return developers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView d_name , d_job ;
        CircleImageView d_image;
        public ViewHolder(View itemView) {
            super(itemView);
            d_name = itemView.findViewById(R.id.developer_name);
            d_job = itemView.findViewById(R.id.developer_job);
            d_image = itemView.findViewById(R.id.developer_image);

        }
    }
}
