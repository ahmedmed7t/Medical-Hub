package com.example.crazynet.medicalhub.Adpters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.crazynet.medicalhub.AskDiscussActivity;
import com.example.crazynet.medicalhub.DiscussFragment;
import com.example.crazynet.medicalhub.Model.CommunitiesTest;
import com.example.crazynet.medicalhub.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Medhat on 16/04/2019.
 */

public class CommunitiesAdapter extends RecyclerView.Adapter<CommunitiesAdapter.ViewHolder> {

    ArrayList<CommunitiesTest> arrayList;
    Context context ;

    public CommunitiesAdapter(ArrayList<CommunitiesTest> arrayList,Context mContext) {
        this.arrayList = arrayList;
        this.context = mContext;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imageView;
        TextView name;
        CardView cardView;
        TextView descreption;
        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.community_image);
            name = itemView.findViewById(R.id.community_name);
            cardView = itemView.findViewById(R.id.communities_card);
            descreption = itemView.findViewById(R.id.descreption_item);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.community_item,parent,false);

        return new CommunitiesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final Intent intent = new Intent(holder.itemView.getContext(), AskDiscussActivity.class);

        holder.name.setText(arrayList.get(position).getName());
        holder.descreption.setText(arrayList.get(position).getDescreption());
        Glide.with(holder.itemView.getContext()).load(arrayList.get(position).getImg()).override(550, 500).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("comm_name",arrayList.get(position).getName());
                DiscussFragment discussFragment = new DiscussFragment();
                discussFragment.setCommId(String.valueOf(arrayList.get(position).getId()));
                intent.putExtra("comm_id",arrayList.get(position).getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("comm_name",arrayList.get(position).getName());
                intent.putExtra("comm_id",String.valueOf(arrayList.get(position).getId()));
                DiscussFragment discussFragment = new DiscussFragment();
                discussFragment.setCommId(String.valueOf(arrayList.get(position).getId()));
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("comm_name",arrayList.get(position).getName());
                intent.putExtra("comm_id",String.valueOf(arrayList.get(position).getId()));
                DiscussFragment discussFragment = new DiscussFragment();
                discussFragment.setCommId(String.valueOf(arrayList.get(position).getId()));
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("comm_name",arrayList.get(position).getName());
                intent.putExtra("comm_id",String.valueOf(arrayList.get(position).getId()));
                DiscussFragment discussFragment = new DiscussFragment();
                discussFragment.setCommId(String.valueOf(arrayList.get(position).getId()));
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.descreption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("comm_name",arrayList.get(position).getName());
                intent.putExtra("comm_id",String.valueOf(arrayList.get(position).getId()));
                DiscussFragment discussFragment = new DiscussFragment();
                discussFragment.setCommId(String.valueOf(arrayList.get(position).getId()));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }




}
