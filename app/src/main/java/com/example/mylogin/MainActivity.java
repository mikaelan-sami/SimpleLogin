package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int currentProgress = 0;
    com.github.lzyzsd.circleprogress.DonutProgress progBar;
    Button Continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progBar = findViewById(R.id.pbar);
        Continue = findViewById(R.id.btnCont);




        // Dynamic Background
        ConstraintLayout constraintLayout = findViewById(R.id.splashLayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(1000);
        animationDrawable.start();

        CountDownTimer cdt = new CountDownTimer(11*1000, 1000) {
            @Override
            public void onTick(long l) {
            currentProgress = currentProgress + 13;
            progBar.setProgress(currentProgress);
            progBar.setMax(100);
            }

            @Override
            public void onFinish() {

            }
        };

        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (currentProgress == 100){
                    progBar.setVisibility(View.VISIBLE);
                    cdt.start();
                }


            }
        });



    }
}