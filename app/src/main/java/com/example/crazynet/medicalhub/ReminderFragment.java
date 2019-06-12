package com.example.crazynet.medicalhub;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.crazynet.medicalhub.Adpters.ReminderAdapter;
import com.example.crazynet.medicalhub.Model.Reminder;
import com.example.crazynet.medicalhub.Reminder.Alarm_Receiver;

import java.util.ArrayList;
import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;
import static android.content.Context.NOTIFICATION_SERVICE;


public class ReminderFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    static RecyclerView recyclerView;
    public static ArrayList<Reminder> reminders = new ArrayList<>();
    FloatingActionButton floatingActionButton;


    public ReminderFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ReminderFragment newInstance(String param1, String param2) {
        ReminderFragment fragment = new ReminderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reminder, container, false);

        floatingActionButton = view.findViewById(R.id.fab_add_reminder);

        recyclerView = view.findViewById(R.id.reminder_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setHasFixedSize(true);


        reminders.add(new Reminder("name of med","5:30"));
        reminders.add(new Reminder("name of med","2:30"));
        reminders.add(new Reminder("name of med","5:50"));
        reminders.add(new Reminder("name of med","7:10"));

        recyclerView.setAdapter(new ReminderAdapter(this.getContext(),reminders));

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),AddReminderActivity.class);
                getContext().startActivity(intent);
            }
        });

        return view;
    }


    public static void add_date(String name,String date,Context context){
        reminders.add(new Reminder(name,date));
        recyclerView.setAdapter(new ReminderAdapter(context,reminders));
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        reminders.clear();
    }
}
