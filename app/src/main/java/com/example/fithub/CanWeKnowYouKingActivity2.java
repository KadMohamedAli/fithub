package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class CanWeKnowYouKingActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_we_know_you_king2);

        Button bouttonContinue_2 = findViewById(R.id.continue_2);
        bouttonContinue_2.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),CanWeKnowYouKingActivity3.class);
            startActivity(intent);
            finish();
        });
    }
}