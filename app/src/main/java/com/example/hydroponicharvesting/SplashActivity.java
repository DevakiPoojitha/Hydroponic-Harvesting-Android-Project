package com.example.hydroponicharvesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    public static final String SHARED_PREFS="sharedPrefs";
    public static final String ACCOUNT="account";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
                String chec=sharedPreferences.getString(ACCOUNT,"");
                if(chec.equals("yes")){
                    startActivity(new Intent(SplashActivity.this,harvest.class));
                    finish();
                }
                else
                {
                    startActivity(new Intent(SplashActivity.this,signup.class));
                }

            }
        },2500);
    }
}
