package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class CanWeKnowYouKingActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_we_know_you_king3);

        Button bouttonContinue_3 = findViewById(R.id.continue_3);
        bouttonContinue_3.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),CanWeKnowYouKingActivity4.class);
            startActivity(intent);
            finish();
        });
    }
}