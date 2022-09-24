package com.example.regis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplachActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);

        ImageView img = findViewById(R.id.imageView2);
        img.setImageResource(R.drawable.splashim);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.common_animation);
        img.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplachActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 2200);

    }
}