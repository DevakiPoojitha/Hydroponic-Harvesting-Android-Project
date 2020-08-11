package com.example.hydroponicharvesting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.Inet4Address;

public class signup extends AppCompatActivity {
    public EditText mFullName,mEmail,mPassword,confirmp;
    Button mRegisterBtn,loginbtn,sign;
    //FirebaseAuth fAuth;
    ProgressBar progressBar;
    DatabaseReference myRef;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFullName=(EditText)findViewById(R.id.fullname);
        mEmail=(EditText)findViewById(R.id.email);
        mPassword=(EditText)findViewById(R.id.password);
        mRegisterBtn=(Button) findViewById(R.id.signupp);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        loginbtn=(Button)findViewById(R.id.signinn);
        confirmp=(EditText)findViewById(R.id.confirmpassword);
        sign=(Button)findViewById(R.id.signinn);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensiginin();
            }
        });
//        fAuth=FirebaseAuth.getInstance();

//        if(fAuth.getCurrentUser() !=null){
//            startActivity(new Intent(getApplicationContext(),harvest.class));
//            finish();
//        }
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = fireBaseInitialSetup();
                final String name=mFullName.getText().toString();
                String email=mEmail.getText().toString().trim();
                String password=mPassword.getText().toString();
                String cpassword=confirmp.getText().toString();
                final String encodedemail=email.replace(".",",");
                if(TextUtils.isEmpty(email)){
                    mEmail.setError("E-Mail is Required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required");
                    return;
                }



                if(cpassword.equals(password)) {


                    progressBar.setVisibility(View.VISIBLE);
                    final userdetails userdetails = new userdetails();
                    userdetails.setName(name);
                    userdetails.setmPassword(password);
                    try {
                        myRef.child(encodedemail).addListenerForSingleValueEvent(new ValueEventListener() {


                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists()) {
                                    Toast.makeText(signup.this, "User Exists", Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.INVISIBLE);
                                    return;
                                } else {
                                    myRef.child(encodedemail).setValue(userdetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(signup.this, "User Created Please Login", Toast.LENGTH_SHORT).show();
                                            success();
                                        }
                                    });
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    } catch (Exception e) {

                    }
                }
                else{
                    Toast.makeText(signup.this, "Password Mismatched", Toast.LENGTH_SHORT).show();
                }



//                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            Toast.makeText(signup.this,"User Created",Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(getApplicationContext(),harvest.class));
//                        }
//
//                        else{
//                            Toast.makeText(signup.this,"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//                });
            }
        });


    }

    private DatabaseReference fireBaseInitialSetup() {

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Email");
        return myRef;
    }

    public void success()
    {
        Intent intent=new Intent(this,login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();

    }

    public void opensiginin(){
        Intent intent=new Intent(this,login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
