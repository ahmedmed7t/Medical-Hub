package com.example.crazynet.medicalhub.Adpters;

import android.content.Context;
import android.content.Intent;
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
import com.example.crazynet.medicalhub.CommentsActivity;
import com.example.crazynet.medicalhub.Model.PostTest;
import com.example.crazynet.medicalhub.R;

import java.util.ArrayList;

/**
 * Created by Medhat on 29/04/2019.
 */

public class PostAdapter  extends RecyclerView.Adapter<PostAdapter.ViewHolder>  {

    private ArrayList<PostTest> arrayList;
    private Context context;
    private String CommId;

    public void setCommId(String commId) {
        CommId = commId;
    }

    public PostAdapter(ArrayList<PostTest> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView isDoctor,likeNum;
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
            likeNum = itemView.findViewById(R.id.like_num);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discuss_post_item,parent,false);

        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

            holder.isDoctor.setVisibility(View.INVISIBLE);
            Glide.with(holder.itemView.getContext()).load(arrayList.get(position).getImage()).into(holder.image);
            holder.content.setText(arrayList.get(position).getContent());
            holder.date.setText(arrayList.get(position).getDate());
            holder.likeNum.setText(String.valueOf(arrayList.get(position).getLikes()));
            if (arrayList.get(position).getDoctor() == false) {
                holder.name.setText(arrayList.get(position).getName());
            } else {
                holder.name.setText("Dr.  " + arrayList.get(position).getName());
            }
            holder.like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.like.getTextColors().getDefaultColor() == (holder.itemView.getResources().getColor(R.color.black))) {
                        holder.like.setTextColor(holder.itemView.getResources().getColor(R.color.red_light));
                        arrayList.get(position).setLikes(arrayList.get(position).getLikes() + 1);
                        notifyDataSetChanged();
                    } else {
                        holder.like.setTextColor(holder.itemView.getResources().getColor(R.color.black));
                        arrayList.get(position).setLikes(arrayList.get(position).getLikes() - 1);
                        notifyDataSetChanged();
                    }
                }
            });

            holder.comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // holder.commentLinear.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(context, CommentsActivity.class);
                    intent.putExtra("commID",CommId);
                    intent.putExtra("postId",String.valueOf(arrayList.get(position).getId()));
                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
