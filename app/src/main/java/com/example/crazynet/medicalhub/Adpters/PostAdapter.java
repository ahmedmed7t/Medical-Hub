package com.example.crazynet.medicalhub.Adpters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.crazynet.medicalhub.Model.PostTest;
import com.example.crazynet.medicalhub.R;

import java.util.ArrayList;

/**
 * Created by CrazyNet on 29/04/2019.
 */

public class PostAdapter  extends RecyclerView.Adapter<PostAdapter.ViewHolder>  {

    private ArrayList<PostTest> arrayList;
    private Context context;

    public PostAdapter(ArrayList<PostTest> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView isDoctor;
        TextView content;
        TextView date;
        Button like;
        Button comment;
        LinearLayout commentLinear;
        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.post_image);
            name = itemView.findViewById(R.id.post_name);
            isDoctor = itemView.findViewById(R.id.post_isDoctor);
            content = itemView.findViewById(R.id.post_content);
            date = itemView.findViewById(R.id.post_date);
            like = itemView.findViewById(R.id.post_like);
            comment = itemView.findViewById(R.id.post_comment);
            commentLinear = itemView.findViewById(R.id.post_linear2);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discuss_post_item,parent,false);

        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        Glide.with(holder.itemView.getContext()).load(arrayList.get(position).getImage()).into(holder.image);
        holder.name.setText(arrayList.get(position).getName());
        holder.content.setText(arrayList.get(position).getContent());
        holder.date.setText(arrayList.get(position).getDate());
        if(arrayList.get(position).getDoctor() == false){
            holder.isDoctor.setVisibility(View.INVISIBLE);
        }
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(holder.like.getTextColors().getDefaultColor() == (holder.itemView.getResources().getColor(R.color.black))){
                   holder.like.setTextColor(holder.itemView.getResources().getColor(R.color.red_light));
               }else{
                   holder.like.setTextColor(holder.itemView.getResources().getColor(R.color.black));
               }
            }
        });

        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.commentLinear.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
