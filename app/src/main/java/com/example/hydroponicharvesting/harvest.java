package com.example.hydroponicharvesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class harvest extends AppCompatActivity {
    TextView name;
    ImageButton info,setting,veggi,leafy,fruits;
    public static final String SHARED_PREFS="sharedPrefs";
    public static final String USER_NAME="username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvest);
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.linear_harvest);
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();

        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);

        animationDrawable.start();


        name=(TextView)findViewById(R.id.heyname);
        Bundle bundle=getIntent().getExtras();

        if(bundle!=null)
        {
            String b=bundle.getString("name");
            name.setText("Hey "+b+"!");
        }

        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        String user=sharedPreferences.getString(USER_NAME,"");
        name.setText("Hey "+user+"!");
        info=(ImageButton) findViewById(R.id.homeinfo);
        setting=(ImageButton) findViewById(R.id.homesetting);


        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfo();
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetting();
            }
        });
        veggi=(ImageButton)findViewById(R.id.veggie);
        veggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVeggi();
            }
        });

        leafy=(ImageButton)findViewById(R.id.leaf);
        leafy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLeafy();
            }
        });

        fruits=(ImageButton)findViewById(R.id.fruit);
        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfruit();
            }
        });

    }

    public void openInfo(){
        Intent intent=new Intent(this,Info.class);
        startActivity(intent);
    }
    public void openSetting(){
        Intent intent=new Intent(this,pestcontrol.class);
        startActivity(intent);
    }
    public void openVeggi(){
        Intent intent=new Intent(this,vegetables.class);
        startActivity(intent);
    }
    public void openLeafy(){
        Intent intent=new Intent(this, com.example.hydroponicharvesting.leafy.class);
        startActivity(intent);

    }
    public void openfruit() {
        Intent intent = new Intent(this, com.example.hydroponicharvesting.fruits.class);
        startActivity(intent);
    }
}
