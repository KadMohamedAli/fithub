package com.example.fithub;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GetStartedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);


        Button boutonGetStarted=findViewById(R.id.boutonGetStarted);
        boutonGetStarted.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),ChooseYourGoalActivity.class);
            startActivity(intent);
            finish();
        });

        Button bouttonCanWeKnowYou = findViewById(R.id.bouttonCanWeKnowYou);
        bouttonCanWeKnowYou.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),CanWeKnowYouKingActivity1.class);
            startActivity(intent);
            finish();
        });

    }
}