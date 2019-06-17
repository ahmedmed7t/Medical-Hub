package com.example.crazynet.medicalhub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crazynet.medicalhub.Model.Report;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddHistoryActivity extends AppCompatActivity {

    @BindView(R.id.edit_add_history)
    EditText history;

    @BindView(R.id.btn_add_history_p)
    Button add_history;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_history);
        ButterKnife.bind(this);

        name = getIntent().getStringExtra("name");

    }

    @OnClick(R.id.btn_add_history_p)
    public void addReport(){
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String date = sdf.format(currentTime);

        Report report = new Report();
        report.setDoctorName(home2Activity.name);
        report.setDoctorSpec(home2Activity.u_expertise);
        report.setDate(date);
        report.setReport(history.getText().toString());
        history.setText("");

        PatientForDaoctorActivity activity = new PatientForDaoctorActivity();
        activity.addHistory(report,name);

        Toast.makeText(this,"post added",Toast.LENGTH_LONG).show();

    }
}
