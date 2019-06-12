package com.example.crazynet.medicalhub.Adpters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.crazynet.medicalhub.Model.Report;
import com.example.crazynet.medicalhub.R;

import java.util.ArrayList;

/**
 * Created by CrazyNet on 12/06/2019.
 */

public class MedicalReportsAdapter extends RecyclerView.Adapter<MedicalReportsAdapter.ViewHolder> {

    Context context;
    ArrayList<Report> reports;

    public MedicalReportsAdapter() {
    }

    public MedicalReportsAdapter(Context context, ArrayList<Report> reports) {

        this.context = context;
        this.reports = reports;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.medical_report_item,parent,false);

        return new MedicalReportsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.doctorName.setText(reports.get(position).getDoctorName());
        holder.doctorSpec.setText(reports.get(position).getDoctorSpec());
        holder.report.setText(reports.get(position).getReport());
        holder.date.setText(reports.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return reports.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView doctorName,doctorSpec,report,date;
        public ViewHolder(View itemView) {
            super(itemView);
            doctorName = itemView.findViewById(R.id.medical_report_d_name);
            doctorSpec = itemView.findViewById(R.id.medical_report_d_spec);
            report = itemView.findViewById(R.id.medical_report_p_report);
            date = itemView.findViewById(R.id.medical_report_d_date);
        }
    }
}
