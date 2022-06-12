package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.slider.Slider;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GoalActivity extends AppCompatActivity {

    private int cpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        cpt=0;
        Button continuer=findViewById(R.id.continuerGoalActivity);
        DbHandler db=new DbHandler(this,null);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.placeholder, new goal_calorie());
        ft.commit();


        Intent intent=new Intent(this,MainActivity2.class);
        continuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.setSys(1);
                if(cpt==0) {
                    RemplirBaseDonnee a = new RemplirBaseDonnee(getApplicationContext());
                    a.remplir();
                }
                cpt=+1;

                startActivity(intent);
                finish();
            }
        });

    }


}