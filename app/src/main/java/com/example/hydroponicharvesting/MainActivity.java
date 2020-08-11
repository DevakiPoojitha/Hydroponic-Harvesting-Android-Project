package com.example.hydroponicharvesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private int bb,temp;
    private String cf,ppm,pname;
    Button info,settings;

    private LinearLayout lettuce,spinach,strawberry,mint,tomatoes,cucumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info=(Button)findViewById(R.id.info);
        settings=(Button)findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startsettings();
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startinfo();
            }
        });
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout1);

        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();

        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);

        animationDrawable.start();


//        cucumber=(LinearLayout)findViewById(R.id.Cucumber);
//        cucumber.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bb=5;
//                cf="17-25";
//                ppm="1190-1750";
//                temp=70;
//                pname="Cucumber";
//                starthome();
//            }
//        });

//        tomatoes=(LinearLayout)findViewById(R.id.Tomato);
//        tomatoes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ppm="1400-3500";
//                bb=7;
//                cf="20-50";
//                temp=60;
//                pname="Tomatoes";
//                starthome();
//            }
//        });

//        bellpepper=(LinearLayout)findViewById(R.id.Bellpepper);
//        bellpepper.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cf="30-40";
//                bb=6;
//                ppm="1400-1750";
//                temp=80;
//                pname="Bellpepper";
//                starthome();
//            }
//        });
//        mint=(LinearLayout)findViewById(R.id.Mint);
//        mint.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cf="20-25";
//                bb=6;
//                pname="Mint";
//                ppm="1400-1680";
//                temp=70;
//                starthome();
//            }
//        });


        strawberry=(LinearLayout)findViewById(R.id.Strawberry);
        strawberry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bb=6;
                cf="18-22";
                ppm="1260-1540";
                pname="Strawberry";
                temp=60;
                starthome();
            }
        });

//        spinach=(LinearLayout)findViewById(R.id.Spinach);
//        spinach.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bb=7;
//                cf="18-23";
//                ppm="1260-1610";
//                pname="Spinach";
//                temp=70;
//                starthome();
//            }
//        });
//
//        lettuce=(LinearLayout)findViewById(R.id.lettuce);
//        lettuce.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cf="8-12";
//                bb=6;
//                ppm="560-840";
//                temp=80;
//                pname="Lettuce";
//                starthome();
//            }
//        });

    }

    public void starthome(){
        Intent intent=new Intent(this,Home.class);
        Bundle bundle=new Bundle();

        bundle.putString("bb",String.valueOf(bb));
        bundle.putString("cf",cf);
        bundle.putString("ppm",ppm);
        bundle.putString("name",pname);
        bundle.putString("temp",String.valueOf(temp));
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void startinfo(){
        Intent intent=new Intent(this,harvest.class);
        startActivity(intent);
    }
    public void startsettings(){
        Intent intent=new Intent(this,pestcontrol.class);
        startActivity(intent);


    }

}
