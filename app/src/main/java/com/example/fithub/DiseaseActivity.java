package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class DiseaseActivity extends AppCompatActivity {

    private int entier0=0;
    private int entier1=0;
    private int entier2=0;
    private int entier3=0;
    private int entier4=0;
    private Boolean[] diseaseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

        CheckBox heart=findViewById(R.id.heartDiseaseButton);
        CheckBox scoliosis=findViewById(R.id.severeScoliosis);
        CheckBox spinal=findViewById(R.id.spinalDamage);
        CheckBox tumor=findViewById(R.id.tumor);
        CheckBox hypertention=findViewById(R.id.hypertention);
        Button continuer=findViewById(R.id.continuerDisease);

        DbHandler db=new DbHandler(this,null);

        Intent intent=new Intent(getApplicationContext(),GoalActivity.class);

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entier0+=1;
                /**
                if((entier0%2)==0){
                    heart.setBackgroundColor(Color.parseColor("#323232"));
                }
                else{
                    heart.setBackgroundColor(Color.parseColor("#3700FD"));
                }
                **/
            }
        });
        scoliosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entier1+=1;

            }
        });
        spinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entier2+=1;

            }
        });
        tumor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entier3+=1;

            }
        });
        hypertention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entier4+=1;

            }
        });
        continuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diseaseList=new Boolean[5];
                diseaseList[0]=(entier0 % 2) != 0;
                diseaseList[1]=(entier1 % 2) != 0;
                diseaseList[2]=(entier2 % 2) != 0;
                diseaseList[3]=(entier3 % 2) != 0;
                diseaseList[4]=(entier4 % 2) != 0;

                SQLiteDatabase database=db.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(DbHandler.COL_USER_HEALTHPROBLEM,User.boolToString(diseaseList));
                database.update(DbHandler.TABLEUSER,contentValues,DbHandler.COL_USER_ID+" = ?",new String[]{"1"});
                database.close();
                db.close();
                startActivity(intent);
                finish();
            }
        });
    }

}