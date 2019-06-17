package com.example.crazynet.medicalhub.Adpters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.crazynet.medicalhub.Model.Reminder;
import com.example.crazynet.medicalhub.R;

import java.util.ArrayList;

/**
 * Created by Medhat on 12/06/2019.
 */

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Reminder> reminders;

    public ReminderAdapter(Context context, ArrayList<Reminder> reminders) {
        this.context = context;
        this.reminders = reminders;
        notifyDataSetChanged();
    }

    public ReminderAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.reminder_item,parent,false);

        return new ReminderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(reminders.get(position).getName());
        holder.date.setText(reminders.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return reminders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView date;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.medicine_name);
            date = itemView.findViewById(R.id.medicine_time);
        }
    }
}
