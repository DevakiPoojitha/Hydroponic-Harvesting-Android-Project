package com.example.hydroponicharvesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Info extends AppCompatActivity {
    private Button one,home,setting;
    private Button plantmedia,fertigation,planttypes,nutri,serba,hydraulictools,hu,wick,raft,drip,ebb,nft,dft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setting=(Button)findViewById(R.id.settings);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensetting();
            }
        });
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);

        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();

        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);

        animationDrawable.start();

        home=(Button)findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhome();

            }
        });


        one=(Button)findViewById(R.id.AboutHydroponics);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                about();
            }
        });

        dft=(Button)findViewById(R.id.hydraulicdftsystem);
        dft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dftt();
            }
        });

        nft=(Button)findViewById(R.id.hydroponicsystemsnft);
        nft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nftt();
            }
        });

        ebb=(Button)findViewById(R.id.ebbandflowhydroponicsystems);
        ebb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eb();
            }
        });


        drip=(Button)findViewById(R.id.hydroponicdripsystem);
        drip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dripp();
            }
        });

        raft=(Button)findViewById(R.id.hydroponicfloatingraftsystem);
        raft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rafft();
            }
        });

        wick=(Button)findViewById(R.id.hydroponicwicksystem);
        wick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wickk();
            }
        });

        hu=(Button)findViewById(R.id.hydroponicswithusedmineralbottles);
        hu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                huu();
            }
        });

        hydraulictools=(Button)findViewById(R.id.hydraulicsupportingtools);
        hydraulictools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tools();
            }
        });


        serba=(Button)findViewById(R.id.serbaserbinetpot);
        serba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serbaa();
            }
        });

        nutri=(Button)findViewById(R.id.hydroponicnutrition);
        nutri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nutrii();
            }
        });

        planttypes=(Button)findViewById(R.id.typeofhydroponicplants);
        planttypes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantttypes();
            }
        });

        fertigation=(Button)findViewById(R.id.hydroponicfertigation);
        fertigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fertigationm();
            }
        });

        plantmedia=(Button)findViewById(R.id.hydroponicplantmedia);
        plantmedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantm();
            }
        });
    }
    public void about(){
        Intent intent=new Intent(this,abouthydroponics.class);
        startActivity(intent);
    }
    public void plantm(){
        Intent intent=new Intent(this,plantmedia.class);
        startActivity(intent);
    }

    public void fertigationm(){
        Intent intent=new Intent(this,fertigationmaterials.class);
        startActivity(intent);
 }
    public void plantttypes(){
        Intent intent=new Intent(this,hydroponicplanttypes.class);
        startActivity(intent);
    }
    public void nutrii(){
        Intent intent=new Intent(this,hydroponicnutrition.class);
        startActivity(intent);
    }
    public void serbaa(){
        Intent intent=new Intent(this,serbaserbinetpot.class);
        startActivity(intent);
    }
    public void tools(){
        Intent intent=new Intent(this,hydraulictools.class);
        startActivity(intent);
    }

    public void huu(){
        Intent intent=new Intent(this,hydroponicswithusedmineralbottles.class);
        startActivity(intent);
    }
    public void wickk(){
        Intent intent=new Intent(this,wicksystem.class);
        startActivity(intent);
    }
    public void rafft(){
        Intent intent=new Intent(this,raftsystem.class);
        startActivity(intent);
    }
    public void dripp(){
        Intent intent=new Intent(this,dripsystem.class);
        startActivity(intent);
    }
    public void eb(){
        Intent intent=new Intent(this,ebbsystems.class);
        startActivity(intent);
    }
    public void nftt(){
        Intent intent=new Intent(this,hydroponicnft.class);
        startActivity(intent);
    }
    public void dftt(){
        Intent intent=new Intent(this,hydroponicdft.class);
        startActivity(intent);
    }
    public void openhome(){
        Intent intent=new Intent(this,harvest.class);
        startActivity(intent);

    }
    public void opensetting(){

        Intent intent=new Intent(this,pestcontrol.class);
        startActivity(intent);
    }
}
