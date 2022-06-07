package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        Button heart=findViewById(R.id.heartDiseaseButton);
        Button scoliosis=findViewById(R.id.severeScoliosis);
        Button spinal=findViewById(R.id.spinalDamage);
        Button tumor=findViewById(R.id.tumor);
        Button hypertention=findViewById(R.id.hypertention);
        Button continuer=findViewById(R.id.continuerDisease);

        DbHandler db=new DbHandler(this,null);

        Intent intent=new Intent(getApplicationContext(),GoalActivity.class);

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entier0+=1;
                if((entier0%2)==0){
                    heart.setBackgroundColor(Color.parseColor("#323232"));
                }
                else{
                    heart.setBackgroundColor(Color.parseColor("#3700FD"));
                }
            }
        });
        scoliosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entier1+=1;
                if((entier1%2)==0){
                    scoliosis.setBackgroundColor(Color.parseColor("#323232"));
                }
                else{
                    scoliosis.setBackgroundColor(Color.parseColor("#3700FD"));
                }
            }
        });
        spinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entier2+=1;
                if((entier2%2)==0){
                    spinal.setBackgroundColor(Color.parseColor("#323232"));
                }
                else{
                    spinal.setBackgroundColor(Color.parseColor("#3700FD"));
                }
            }
        });
        tumor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entier3+=1;
                if((entier3%2)==0){
                    tumor.setBackgroundColor(Color.parseColor("#323232"));
                }
                else{
                    tumor.setBackgroundColor(Color.parseColor("#3700FD"));
                }
            }
        });
        hypertention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entier4+=1;
                if((entier4%2)==0){
                    hypertention.setBackgroundColor(Color.parseColor("#323232"));
                }
                else{
                    hypertention.setBackgroundColor(Color.parseColor("#3700FD"));
                }
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