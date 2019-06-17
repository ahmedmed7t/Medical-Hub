package com.example.crazynet.medicalhub.Adpters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.crazynet.medicalhub.Model.Comment;
import com.example.crazynet.medicalhub.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Medhat on 17/06/2019.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{

    ArrayList<Comment> arrayList;
    Context context;

    public CommentAdapter(ArrayList<Comment> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView auther , content , date;
        CircleImageView circleImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            auther = itemView.findViewById(R.id.comment_auther);
            content = itemView.findViewById(R.id.comment_content);
            circleImageView = itemView.findViewById(R.id.comment_image);
            date = itemView.findViewById(R.id.comment_date);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment_item,parent,false);

        return new CommentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.auther.setText(arrayList.get(position).getAuther());
        holder.content.setText(arrayList.get(position).getContent());
        holder.date.setText(arrayList.get(position).getDate());
        Glide.with(context).load(arrayList.get(position).getImage()).into(holder.circleImageView);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
