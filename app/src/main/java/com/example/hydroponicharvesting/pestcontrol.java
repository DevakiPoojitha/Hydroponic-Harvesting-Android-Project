package com.example.hydroponicharvesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pestcontrol extends AppCompatActivity {
    public Button logout;
    public static final String SHARED_PREFS="sharedPrefs";
    public static final String ACCOUNT="account";
    Button info,settings,home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pestcontrol);

        logout=(Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(ACCOUNT,"");
                editor.commit();
                openLogin();
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

    public void openLogin(){
        Intent intent=new Intent(this,login.class);
        SharedPreferences settings=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        settings.edit().clear().commit();
        startActivity(intent);
        finishAffinity();
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
