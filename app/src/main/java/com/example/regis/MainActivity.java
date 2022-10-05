package com.example.regis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Comment;

public class MainActivity extends AppCompatActivity {
    private EditText mainEmail, mainName, mainPassword;
    private FirebaseAuth mAuth;
    private Button mainButton;
    private regRepository regRepository;
    // fccca1ba-d975-4ba1-829f-ec0739a8c37b api key
    // http://smarthome.madskill.ru/user request URL
    // https://app.swaggerhub.com/apis-docs/k5422/smart/1.0.0-oas3#/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init();
        mainEmail = findViewById(R.id.mainEmail);
        mainPassword = findViewById(R.id.mainPassword);
        mainName = findViewById(R.id.mainName);
        mainButton = findViewById(R.id.loginButton2);


        regRepository = regRepository.getInstance();
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reg r = new reg(
                  mainName.getText().toString(),
                  mainEmail.getText().toString(),
                  mainPassword.getText().toString()
                );



            }
        });

    }




    /*/ @Override
   protected void onStart() {
        super.onStart();
        FirebaseUser cUser = mAuth.getCurrentUser();
        if(cUser != null)
        {
            Toast.makeText(this, "user not null", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "user null", Toast.LENGTH_SHORT).show();
        }
    }


    private void init()
    {
        mainEmail = findViewById(R.id.mainEmail);
        mainPassword = findViewById(R.id.mainPassword);
        mainName = findViewById(R.id.mainName);

        mAuth = FirebaseAuth.getInstance();
    }
    public void onClickSignUp(View view)
    {
        if(!TextUtils.isEmpty(mainEmail.getText().toString()) && !TextUtils.isEmpty(mainPassword.getText().toString())) {
            mAuth.createUserWithEmailAndPassword(mainEmail.getText().toString(),mainPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(getApplicationContext(), "Sign Up successful", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Sign Up failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Please enter Email and Password", Toast.LENGTH_SHORT).show();

        }
    }


    public void onClickSignIn(View view)
    {
       if(!TextUtils.isEmpty(mainEmail.getText().toString()) && !TextUtils.isEmpty(mainPassword.getText().toString())) {

            mAuth.signInWithEmailAndPassword(mainEmail.getText().toString(), mainPassword.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(getApplicationContext(), "Sign in successful", Toast.LENGTH_SHORT).show();
                        Intent intent;
                        intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Sign in failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

/*/





}