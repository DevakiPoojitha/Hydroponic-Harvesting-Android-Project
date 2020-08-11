package com.example.hydroponicharvesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class fruits extends AppCompatActivity {
    private int bb,temp;
    private String cf,ppm,pname;
    private LinearLayout strawberry;
    Button info,settings,home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

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
        info=(Button)findViewById(R.id.Fruitinfo);
        settings=(Button)findViewById(R.id.Fruitsettings);
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

        home=(Button)findViewById(R.id.Fruithome);
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
