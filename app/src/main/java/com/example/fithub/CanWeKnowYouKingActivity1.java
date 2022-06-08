package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CanWeKnowYouKingActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_we_know_you_king1);

        Button bouttonContinue_1 = findViewById(R.id.continue_1);
        bouttonContinue_1.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),CanWeKnowYouKingActivity2.class);
            startActivity(intent);
            finish();
        });
    }

    public void feet_cm_text(View view){

        RadioGroup radioGroup = findViewById(R.id.ft_cm_groupe);
        int radioId = radioGroup.getCheckedRadioButtonId();
        RadioButton selected_unit = findViewById(radioId);

        TextView height_input_title = findViewById(R.id.height_input_title);
        EditText height_input = findViewById(R.id.height_input);

        if(selected_unit.getText().toString().equals("cm"))
        {
            height_input_title.setText(getResources().getString(R.string.height_cm));
            height_input.setHint(getResources().getString(R.string.___cm));
        }
        else
        {
            height_input_title.setText(getResources().getString(R.string.height_ft));
            height_input.setHint(getResources().getString(R.string.___ft));
        }

    }

}