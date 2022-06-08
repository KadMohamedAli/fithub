package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

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

    public void uncheck_none_of_the_above(View view){

        CheckBox none_of_the_above = (CheckBox) findViewById(R.id.none_of_the_above);
        CheckBox condition_1 = (CheckBox) findViewById(R.id.condition_1);
        CheckBox condition_2 = (CheckBox) findViewById(R.id.condition_2);
        CheckBox condition_3 = (CheckBox) findViewById(R.id.condition_3);
        CheckBox condition_4 = (CheckBox) findViewById(R.id.condition_4);
        CheckBox condition_5 = (CheckBox) findViewById(R.id.condition_5);

        if(condition_1.isChecked() || condition_2.isChecked() || condition_3.isChecked()
        || condition_4.isChecked() || condition_5.isChecked())
        {
            none_of_the_above.setChecked(false);
        }

    }

    public void uncheck_all_conditions(View view)
    {
        CheckBox none_of_the_above = (CheckBox) findViewById(R.id.none_of_the_above);
        CheckBox condition_1 = (CheckBox) findViewById(R.id.condition_1);
        CheckBox condition_2 = (CheckBox) findViewById(R.id.condition_2);
        CheckBox condition_3 = (CheckBox) findViewById(R.id.condition_3);
        CheckBox condition_4 = (CheckBox) findViewById(R.id.condition_4);
        CheckBox condition_5 = (CheckBox) findViewById(R.id.condition_5);

        if(none_of_the_above.isChecked())
        {
            condition_1.setChecked(false);
            condition_2.setChecked(false);
            condition_3.setChecked(false);
            condition_4.setChecked(false);
            condition_5.setChecked(false);
        }
    }
}