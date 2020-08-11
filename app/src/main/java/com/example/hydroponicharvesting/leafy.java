package com.example.hydroponicharvesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class leafy extends AppCompatActivity {
    private int bb,temp;
    private String cf,ppm,pname;
    Button info,settings,home;

    private LinearLayout lettuce,spinach,mint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leafy);

        mint=(LinearLayout)findViewById(R.id.Mint);
        mint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cf="20-25";
                bb=6;
                pname="Mint";
                ppm="1400-1680";
                temp=70;
                starthome();
            }
        });

        spinach=(LinearLayout)findViewById(R.id.Spinach);
        spinach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bb=7;
                cf="18-23";
                ppm="1260-1610";
                pname="Spinach";
                temp=70;
                starthome();
            }
        });

        lettuce=(LinearLayout)findViewById(R.id.lettuce);
        lettuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cf="8-12";
                bb=6;
                ppm="560-840";
                temp=80;
                pname="Lettuce";
                starthome();
            }
        });
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
        home=(Button)findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHome();
            }
        });
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
        Intent intent=new Intent(this,Info.class);
        startActivity(intent);
    }
    public void startsettings(){
        Intent intent=new Intent(this,pestcontrol.class);
        startActivity(intent);
    }

    public void startHome(){
        Intent intent=new Intent(this,harvest.class);
        startActivity(intent);
    }
}
