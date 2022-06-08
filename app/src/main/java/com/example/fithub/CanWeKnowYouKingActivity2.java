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

    public void lb_kg_text(View view){

        RadioGroup radioGroup = findViewById(R.id.lb_kg_groupe);
        int radioId = radioGroup.getCheckedRadioButtonId();
        RadioButton selected_unit = findViewById(radioId);

        TextView weight_input_title = findViewById(R.id.weight_input_title);
        TextView target_input_title = findViewById(R.id.target_weight_input_title);

        EditText weight_input = findViewById(R.id.weight_input);
        EditText target_weight_input = findViewById(R.id.target_weight_input);

        if(selected_unit.getText().toString().equals("kg"))
        {
            weight_input_title.setText(getResources().getString(R.string.current_weight_kg));
            target_input_title.setText(getResources().getString(R.string.target_weight_kg));

            weight_input.setHint(getResources().getString(R.string.___kg));
            target_weight_input.setHint(getResources().getString(R.string.___kg));
        }
        else
        {
            weight_input_title.setText(getResources().getString(R.string.current_weight_lb));
            target_input_title.setText(getResources().getString(R.string.target_weight_lb));

            weight_input.setHint(getResources().getString(R.string.___lb));
            target_weight_input.setHint(getResources().getString(R.string.___lb));
        }

    }
}