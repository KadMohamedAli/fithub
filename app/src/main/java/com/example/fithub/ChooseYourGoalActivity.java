package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseYourGoalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_goal);

        DbHandler db=new DbHandler(this,null);
        Button loseWeightBoutton=findViewById(R.id.athlete);
        Button getShreddedBoutton=findViewById(R.id.hero);
        Button gainMuscleMassBoutton=findViewById(R.id.bodybuilder);

        Intent intent=new Intent(getApplicationContext(),ChooseYourGoalActivity2.class);
        int id=1;
        loseWeightBoutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database=db.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(DbHandler.COL_USER_ID,id);
                contentValues.put(DbHandler.COL_USER_BODYGOALOPTION1,0);
                database.insert(DbHandler.TABLEUSER,null,contentValues);
                database.close();
                db.close();
                startActivity(intent);
                finish();
            }
        });

        getShreddedBoutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database=db.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(DbHandler.COL_USER_ID,id);
                contentValues.put(DbHandler.COL_USER_BODYGOALOPTION1,1);
                database.insert(DbHandler.TABLEUSER,null,contentValues);
                database.close();
                db.close();

                startActivity(intent);
                finish();
            }
        });

        gainMuscleMassBoutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database=db.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(DbHandler.COL_USER_ID,id);
                contentValues.put(DbHandler.COL_USER_BODYGOALOPTION1,2);
                database.insert(DbHandler.TABLEUSER,null,contentValues);
                database.close();

                db.close();
                startActivity(intent);
                finish();
            }
        });

    }
}