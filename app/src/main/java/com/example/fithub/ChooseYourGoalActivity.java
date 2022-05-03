package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseYourGoalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_goal);

        Button loseWeightBoutton=findViewById(R.id.athlete);
        Button getShreddedBoutton=findViewById(R.id.hero);
        Button gainMuscleMassBoutton=findViewById(R.id.bodybuilder);

        Intent intent=new Intent(getApplicationContext(),ChooseYourGoalActivity2.class);

        loseWeightBoutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(intent);
            }
        });

        getShreddedBoutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(intent);
            }
        });

        gainMuscleMassBoutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(intent);
            }
        });

    }
}