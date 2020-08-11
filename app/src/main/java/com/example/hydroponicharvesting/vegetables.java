package com.example.hydroponicharvesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class vegetables extends AppCompatActivity {
private LinearLayout bellpepper,tomatoes,cucumber;
    private int bb,temp;
    private String cf,ppm,pname;
    Button info,settings,home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);

        bellpepper=(LinearLayout)findViewById(R.id.Bellpepper);
        bellpepper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cf="30-40";
                bb=6;
                ppm="1400-1750";
                temp=80;
                pname="Bellpepper";
                starthome();
            }
        });

        tomatoes=(LinearLayout)findViewById(R.id.Tomato);
        tomatoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ppm="1400-3500";
                bb=7;
                cf="20-50";
                temp=60;
                pname="Tomatoes";
                starthome();
            }
        });

        cucumber=(LinearLayout)findViewById(R.id.Cucumber);
        cucumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bb=5;
                cf="17-25";
                ppm="1190-1750";
                temp=70;
                pname="Cucumber";
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
