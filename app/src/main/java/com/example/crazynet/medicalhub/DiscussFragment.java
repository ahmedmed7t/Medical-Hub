package com.example.crazynet.medicalhub;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.crazynet.medicalhub.Adpters.PostAdapter;
import com.example.crazynet.medicalhub.Model.CommunitiesTest;
import com.example.crazynet.medicalhub.Model.PostTest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Medhat on 27/04/2019.
 */

public class DiscussFragment extends Fragment {

    RecyclerView recyclerView;
    String commName;
    public TextView communityName;
    FloatingActionButton floatingActionButton;
    int counter = 0 ;

    public static ArrayList<PostTest> addedPost = new ArrayList<>();
     ArrayList<PostTest> arrayList = new ArrayList<>();
    ArrayList<PostTest> pausearrayList = new ArrayList<>();


    public void setCommName(String commName) {
        this.commName = commName;
    }

    public DiscussFragment() {
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discuss_fragment,container,false);

        communityName = view.findViewById(R.id.txt_name_discuss);
        communityName.setText(commName);

        floatingActionButton = view.findViewById(R.id.fab_add_post);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),AddPostActivity.class);
                intent.putExtra("comm",communityName.getText().toString());
                getContext().startActivity(intent);
            }
        });

        recyclerView = view.findViewById(R.id.discuss_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setHasFixedSize(true);


        arrayList.add(new PostTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Medhat","17 July 2019","semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus.",true,25));
        arrayList.add(new PostTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Medhat","23 September 2018","Sugary drinks are among the most fattening items you can put into your body,This is because your brain doesn’t measure calories from liquid sugar the same way it does for solid food (1),Therefore, when you drink soda, you end up eating more total calories (2, 3), Sugary drinks are strongly associated with obesity, type 2 diabetes, heart disease, and many other health problems (4, 5, 6, 7). Keep in mind that certain fruit juices may be almost as bad as soda in this regard, as they sometimes contain just as much sugar. Their small amounts of antioxidants do not negate the sugar’s harmful effects (8).",false,17));
        arrayList.add(new PostTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Medhat","02 February 2019","a duty of care is a legal obligation which is imposed on an individual requiring adherence to a standard of reasonable care while performing any acts that could foreseeably harm others. It is the first element that must be established to proceed with an action in negligence. The claimant must be able to show a duty of care imposed by law which the defendant has breached. In turn, breaching a duty may subject an individual to liability. The duty of care may be imposed by operation of law between individuals who have no current direct relationship (familial or contractual or otherwise) but eventually become related in some manner, as defined by common law (meaning case law).",false,4));
        arrayList.add(new PostTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Medhat","04 Jule 2019","Compared to people who always ate breakfast, those who say they never did had a 87% higher odds of dying from heart-related causes, according to a study that tracked the health of 6,550 Americans for about 20 years.",true,12));
        arrayList.add(new PostTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Medhat","07 October 2017","At common law, duties were formerly limited to those with whom one was in privity one way or another, as exemplified by cases like Winterbottom v. Wright (1842). In the early 20th century, judges began to recognize that the cold realities of the Second Industrial Revolution (in which end users were frequently several parties removed from the original manufacturer) implied that enforcing the privity requirement against hapless consumers had harsh results in many product liability cases.",false,20));
        arrayList.add(new PostTest("https://hcplive.s3.amazonaws.com/v1_media/_image/happydoctor.jpg","Medhat","30 Jenuary 2017","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut",true,4));

        recyclerView.setAdapter(new PostAdapter(arrayList,this.getContext()));
        return view;
    }


    public ArrayList<PostTest> getFromStatic(){
        ArrayList<PostTest> arrayList = new ArrayList<>();
        for(int i = 0 ; i<addedPost.size(); i ++){
            if(communityName.getText().equals(addedPost.get(i).getComm())){
                arrayList.add(addedPost.get(i));
            }
        }

        return arrayList;
    }

    public void addPost(PostTest item){
        addedPost.add(item);
    }

    @Override
    public void onPause() {
        super.onPause();
        int size = counter;
        for(int i = 0;i<size;i++){
            arrayList.remove(0);
            counter--;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(addedPost.size()>=1){
            ArrayList<PostTest> newArray = getFromStatic();
            if(newArray.size()>=1){
                for(int i=0 ; i < newArray.size();i++){
                    arrayList.add(0,newArray.get(i));
                    counter++;
                }
                recyclerView.setAdapter(new PostAdapter(arrayList, this.getActivity()));

            }
        }
    }

    public void addToPref(PostTest item){

        SharedPreferences preferences = getActivity().getSharedPreferences("posts", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(item);
        editor.putString(json,"m_posts");
        editor.apply();

    }

    public PostTest loadFromPref(){

        PostTest item ;

        SharedPreferences preferences = getActivity().getSharedPreferences("posts",Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString("m_posts",null);
        Type type = new TypeToken<CommunitiesTest>(){}.getType();
        item = gson.fromJson(json,type);

        return item;
    }
}