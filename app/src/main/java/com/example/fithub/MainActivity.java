package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean premiereFois = false;
        //emb3d nrigloha m3a base de donnes
        if(premiereFois){

        }
        else{
            Intent intent=new Intent(this,GetStartedActivity.class);
            startActivity(intent);
            finish();
        }

    }
}