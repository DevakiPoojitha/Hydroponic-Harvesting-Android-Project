package com.example.hydroponicharvesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Home extends AppCompatActivity {
    int seekvalue1;
    Button info,settings,home;
        public TextView cfl,ppmt,naaammm,ph,tem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout2);

        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();

        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);

        animationDrawable.start();


        ph=(TextView)findViewById(R.id.phl);
        tem=(TextView)findViewById(R.id.t1);

        cfl=(TextView)findViewById(R.id.cfl);

        ppmt=(TextView)findViewById(R.id.ppml);





        naaammm=(TextView)findViewById(R.id.name);

        Bundle bundle=getIntent().getExtras();

        String b=bundle.getString("bb");
        String cf=bundle.getString("cf");
        String ppm=bundle.getString("ppm");
        String temp=bundle.getString("temp");

        naaammm.setText(bundle.getString("name"));



        cfl.setText(cf);

        ppmt.setText(ppm);


        ph.setText(b);
        tem.setText(temp+"F");
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
        });        home=(Button)findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHome();
            }
        });


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
