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
import com.example.crazynet.medicalhub.Model.SearchTest;
import com.example.crazynet.medicalhub.R;
import com.example.crazynet.medicalhub.doctorForPatientActivity;

import java.util.ArrayList;

/**
 * Created by CrazyNet on 29/04/2019.
 */

public class AskAdapter extends RecyclerView.Adapter<AskAdapter.ViewHolder> {

    private ArrayList<SearchTest> arrayList;
    private Context context;

    public AskAdapter(ArrayList<SearchTest> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView place;
        RatingBar rate;
        TextView expertise;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.search_image);
            name = itemView.findViewById(R.id.search_name);
            place = itemView.findViewById(R.id.search_place);
            rate = itemView.findViewById(R.id.search_rate);
            expertise = itemView.findViewById(R.id.search_expertise);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.ask_search_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        Glide.with(holder.itemView.getContext()).load(arrayList.get(position).getImage()).into(holder.image);
        holder.name.setText(arrayList.get(position).getName());
        holder.place.setText(arrayList.get(position).getPlace());
        holder.rate.setRating(arrayList.get(position).getRate());
        holder.expertise.setText(arrayList.get(position).getExpertise());

        Drawable drawable = holder.rate.getProgressDrawable();
        drawable.setColorFilter(Color.parseColor("#ffd91d"), PorterDuff.Mode.SRC_ATOP);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),doctorForPatientActivity.class);
                intent.putExtra("doctor_name",arrayList.get(position).getName());
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
