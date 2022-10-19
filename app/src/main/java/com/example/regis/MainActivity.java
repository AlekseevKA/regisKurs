package com.example.regis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText mainEmail, mainName, mainPassword;
    private FirebaseAuth mAuth;
    private Button mainButton, mainButton2;
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
        mainButton2 = findViewById(R.id.button2);


        CallRetrofit();

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(mainEmail.getText().toString()) && !TextUtils.isEmpty(mainPassword.getText().toString())) {
                    CallRetrofit();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Please enter Email and Password", Toast.LENGTH_SHORT).show();

                }
            }
        });
        mainButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
    private void CallRetrofit(){

        String postEmail = mainEmail.getText().toString();
        String postName = mainName.getText().toString();
        String postPassword = mainPassword.getText().toString();




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://petstore.swagger.io/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        regService service = retrofit.create(regService.class);
        RegModel regModel = new RegModel("username", "email", "password");

        Call<RegModel> call = service.PostDataIntoServer(regModel);




        call.enqueue(new Callback<RegModel>() {
            @Override
            public void onResponse(Call<RegModel> call, Response<RegModel> response) {
                //results

                if (response.isSuccessful()){
                    //успешный запрос
                    Toast.makeText(getApplicationContext(), "response successful", Toast.LENGTH_SHORT).show();

                } else{
                    //сервер вернул ошибку
                    Toast.makeText(getApplicationContext(), "response fail", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<RegModel> call, Throwable t) {
                // ошибка во время выполнения запроса

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