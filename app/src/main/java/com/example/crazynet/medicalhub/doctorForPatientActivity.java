package com.example.crazynet.medicalhub;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.crazynet.medicalhub.Adpters.AnswerdQustionsAdapter;
import com.example.crazynet.medicalhub.Model.AnsweredQuestion;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class doctorForPatientActivity extends AppCompatActivity {

    @BindView(R.id.doctor_f_patient_name)
    TextView doctorName;

    @BindView(R.id.doctor_f_patient_rate)
    RatingBar ratingBar;

    @BindView(R.id.doctor_f_patient_recycler)
    RecyclerView recyclerView;

    @BindView(R.id.doctor_f_patient_adress)
    TextView address;

    @BindView(R.id.doctor_f_patient_phone)
    TextView phone;

    @BindView(R.id.doctor_f_patient_specialist)
    TextView spect;

    @BindView(R.id.doctor_f_patient_image)
    CircleImageView circleImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_for_patient);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        doctorName.setText(intent.getStringExtra("doctor_name"));
        address.setText(intent.getStringExtra("doctor_address"));
        phone.setText(intent.getStringExtra("doctor_phone"));
        spect.setText(intent.getStringExtra("doctor_exper"));
        Glide.with(this).load(intent.getStringExtra("doctor_image")).into(circleImageView);
        ratingBar.setRating(intent.getFloatExtra("doctor_rate",(float)0));


        Drawable drawable = ratingBar.getProgressDrawable();
        drawable.setColorFilter(Color.parseColor("#ffd91d"), PorterDuff.Mode.SRC_ATOP);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<AnsweredQuestion> answeredQuestionns = new ArrayList<>();
        answeredQuestionns.add(new AnsweredQuestion("sem quam semper libero ? ","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec"));
        answeredQuestionns.add(new AnsweredQuestion("consequat vitae, eleifend ac enim ? ","viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue."));
        answeredQuestionns.add(new AnsweredQuestion("Etiam ultricies nisi vel augue ? ","sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante"));
        answeredQuestionns.add(new AnsweredQuestion("Maecenas tempus, tellus eget condimentum rhoncus ? ","vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt"));
        answeredQuestionns.add(new AnsweredQuestion("Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem ?","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec"));
        answeredQuestionns.add(new AnsweredQuestion("Maecenas nec odio et ante tincidunt tempus ?","viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue."));
        answeredQuestionns.add(new AnsweredQuestion("Donec sodales sagittis magna Sed consequat ?","sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante"));
        answeredQuestionns.add(new AnsweredQuestion(" Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus ?","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec"));


        recyclerView.setAdapter(new AnswerdQustionsAdapter(answeredQuestionns,this));


    }


    @OnClick(R.id.fab_d_f_p)
    public void getQuestion(){

        final String[] m_Text = new String[1];

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ask a question");

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(10, 10, 10, 10);

        final EditText input = new EditText(this);
        input.setLayoutParams(lp);
        input.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES|InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        builder.setView(input);

        builder.setPositiveButton("SEND", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text[0] = input.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
