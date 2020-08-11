package com.example.hydroponicharvesting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity implements View.OnClickListener {
    EditText mEmail,mPassword;
    Button signin,signup;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    DatabaseReference myRef;
    FirebaseDatabase database;
    ProgressBar progressBar;
    public static final String SHARED_PREFS="sharedPrefs";
    public static final String ACCOUNT="account";
    public static final String USER_NAME="username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail=(EditText)findViewById(R.id.loginemail);
        mPassword=(EditText)findViewById(R.id.signinpassword);
        signin=(Button)findViewById(R.id.login);
        signup=(Button)findViewById(R.id.signuppp);
        signin.setOnClickListener(this);
        signup.setOnClickListener(this);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                if(validateFields()){
                    processLogin(mEmail.getText().toString(), mPassword.getText().toString());

                }
                break;
            case R.id.signuppp:
                startActivity(new Intent(this,signup.class));
                 break;
            default:
                break;
        }
    }

    private DatabaseReference fireBaseInitialSetup() {

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Email");
        return myRef;
    }


    private void processLogin(final String email, final String password) {
        progressBar.setVisibility(View.VISIBLE);
        myRef = fireBaseInitialSetup();
        String encodedEmail=email.replace(".",",");
        try {
            myRef.child(encodedEmail).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()){
                        userdetails userdDetails=dataSnapshot.getValue(userdetails.class);
                        String databasepassword=userdDetails.getmPassword();
                        String name=userdDetails.getName();


                        if(password.equals(databasepassword)){
                            Intent intent=new Intent(login.this,harvest.class);
                            Bundle bundle=new Bundle();
                            bundle.putString("name",name);
                            intent.putExtras(bundle);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString(ACCOUNT,"yes");
                            editor.putString(USER_NAME,name);
                            editor.apply();
                            startActivity(intent);
                            finish();
                        }
                        else{
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(login.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(login.this,"User Not Found",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(login.this,"User Not Found",Toast.LENGTH_SHORT).show();
                }
            });

        }
        catch(Exception e){
            progressBar.setVisibility(View.INVISIBLE);
            Toast.makeText(login.this,"Unable to process your request",Toast.LENGTH_SHORT).show();
        }
    }


    private boolean validateFields() {

        if (mEmail.getText().toString().trim().length() == 0) {
            setFocus(mEmail,"Enter Correct Email");
            return false;
        } else if (!mEmail.getText().toString().trim().matches(emailPattern)) {
            setFocus(mEmail,"Enter correct Email");
            return false;
        }
        if (mPassword.getText().toString().trim().length() == 0) {
            setFocus(mPassword, "Enter correct Password");
            return false;
        }

        return true;
    }

    private void setFocus(EditText editText, String string) {
        editText.requestFocus();
        editText.setError("Enter valid text");
    }
}
