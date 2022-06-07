package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProblemAreaActivity extends AppCompatActivity {

    private int entier0=0;
    private int entier1=0;
    private int entier2=0;
    private int entier3=0;
    private Boolean[] problemeArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_area);

        DbHandler db=new DbHandler(this,null);

        Button weakChest=findViewById(R.id.weakChestButton);
        Button slimLegs=findViewById(R.id.slimLegsButton);
        Button slimArms=findViewById(R.id.slimArmsButton);
        Button beerBelly=findViewById(R.id.beerBellyButton);
        Button continuer=findViewById(R.id.continuerButtonProblemArea);

        Intent intent=new Intent(getApplicationContext(),PersonnalInformationActivity.class);
        weakChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entier0+=1;
                if((entier0%2)==0){
                    weakChest.setBackgroundColor(Color.parseColor("#323232"));
                  }
                else{
                    weakChest.setBackgroundColor(Color.parseColor("#3700FD"));
                }
            }
        });
        slimLegs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entier1+=1;
                if((entier1%2)==0){
                    slimLegs.setBackgroundColor(Color.parseColor("#323232"));
                }
                else{
                    slimLegs.setBackgroundColor(Color.parseColor("#3700FD"));
                }
            }
        });
        slimArms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entier2+=1;
                if((entier2%2)==0){
                    slimArms.setBackgroundColor(Color.parseColor("#323232"));
                }
                else{
                    slimArms.setBackgroundColor(Color.parseColor("#3700FD"));
                }
            }
        });
        beerBelly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entier3+=1;
                if((entier3%2)==0){
                    beerBelly.setBackgroundColor(Color.parseColor("#323232"));
                }
                else{
                    beerBelly.setBackgroundColor(Color.parseColor("#3700FD"));
                }
            }
        });
        continuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problemeArea=new Boolean[4];
                problemeArea[0]= (entier0 % 2) != 0;
                problemeArea[1]= (entier1 % 2) != 0;
                problemeArea[2]= (entier2 % 2) != 0;
                problemeArea[3]= (entier3 % 2) != 0;

                SQLiteDatabase database=db.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(DbHandler.COL_USER_PROBLEMAREA,User.boolToString(problemeArea));
                database.update(DbHandler.TABLEUSER,contentValues,DbHandler.COL_USER_ID+" = ?",new String[]{"1"});
                database.close();
                db.close();
                startActivity(intent);
                finish();
            }
        });
    }
}