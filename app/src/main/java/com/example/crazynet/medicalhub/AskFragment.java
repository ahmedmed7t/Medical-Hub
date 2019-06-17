package com.example.crazynet.medicalhub;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.crazynet.medicalhub.Adpters.AskAdapter;
import com.example.crazynet.medicalhub.Model.SearchTest;

import java.util.ArrayList;

/**
 * Created by MEdhat on 27/04/2019.
 */

public class AskFragment extends Fragment {

    RecyclerView recyclerView;
    EditText search;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ask_fragment,container,false);

        search = view.findViewById(R.id.Ask_search);
        recyclerView = view.findViewById(R.id.ask_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        final ArrayList<SearchTest> arrayList = new ArrayList<>();

        arrayList.add(new SearchTest("01012121212","https://image.shutterstock.com/image-photo/friendly-male-doctor-gym-smiling-260nw-108451796.jpg","Osama Ali",(float)5,"Minya","diabetes"));
        arrayList.add(new SearchTest("01045454545","https://ak3.picdn.net/shutterstock/videos/9149753/thumb/1.jpg","Khaled Essam",(float)5,"Giza","blood pressure"));
        arrayList.add(new SearchTest("01032323233","https://www.rd.com/wp-content/uploads/2017/09/02_doctor_Insider-Tips-to-Choosing-the-Best-Primary-Care-Doctor_519507367_Stokkete.jpg","Ehap Hossam",(float)4.5,"Alex","depression"));
        arrayList.add(new SearchTest("01099999999","http://pharmawebhosting.com/wp/drugs/ar/wp-content/uploads/2015/06/How-to-Find-a-Marijuana-Doctor.jpg","Aasser Ali",(float)4,"Sohag","allergy"));
        arrayList.add(new SearchTest("01077777777","https://i2-prod.mirror.co.uk/interactives/article12645227.ece/ALTERNATES/s615/doctor.jpg","Alaa Khalaf",(float)3.5,"Minya","Heart diseases"));
        arrayList.add(new SearchTest("01074747474","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHcxPEMuIzqj8tRZDVmlRpQ0LseFrUpUtSOtsdhCjC3FmAzWiC","Omar Mohamed",(float)3,"assuit","diabetes"));
        arrayList.add(new SearchTest("01002020202","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiIDZ_fUwNNazSBegB3tl3oEUxEWpiylxNvHFkTt0Z8E5wqqeH","Abd Allah Mahmoud",(float)2.5,"Qena","depression"));
        arrayList.add(new SearchTest("01059595959","https://5.imimg.com/data5/CN/HW/MY-43391949/doctor-uniform-250x250.jpg","Ahmed Mahmoud",(float)2,"luxor","Heart diseases"));
        arrayList.add(new SearchTest("01073737373","https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Mohamed Essam",(float)1,"sohag","blood pressure"));

        recyclerView.setAdapter(new AskAdapter(arrayList,this.getContext()));

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().equals("") && !s.toString().equals(" ")) {
                    ArrayList<SearchTest> searchResult = searchForDoctor(arrayList, "(?i).*"+s+".*");
                    recyclerView.setAdapter(new AskAdapter(searchResult, getContext()));
                }else{
                    recyclerView.setAdapter(new AskAdapter(arrayList, getContext()));
                }
            }
        });

        return view;
    }

    public ArrayList<SearchTest> searchForDoctor(ArrayList<SearchTest> arrayList,String text){

        ArrayList<SearchTest> result = new ArrayList<>();
        for(int i=0 ; i< arrayList.size();i++){
            if(arrayList.get(i).getName().matches(text)){
                result.add(arrayList.get(i));
            }
        }
       return result;
    }
}
