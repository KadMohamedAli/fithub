package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseYourGoalActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_goal2);

        DbHandler db=new DbHandler(this,null);

        Button athleteBoutton=findViewById(R.id.athlete);
        Button heroButton=findViewById(R.id.hero);
        Button bodybuilderButton=findViewById(R.id.bodybuilder);

        Intent intent=new Intent(getApplicationContext(),BodyTypeActivity1.class);

        athleteBoutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database=db.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(DbHandler.COL_USER_BODYGOALOPTION2,0);
                database.insert(DbHandler.TABLEUSER,null,contentValues);
                database.close();

                startActivity(intent);
            }
        });

        heroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database=db.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(DbHandler.COL_USER_BODYGOALOPTION2,1);
                database.insert(DbHandler.TABLEUSER,null,contentValues);
                database.close();

                startActivity(intent);
            }
        });

        bodybuilderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database=db.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(DbHandler.COL_USER_BODYGOALOPTION2,2);
                database.insert(DbHandler.TABLEUSER,null,contentValues);
                database.close();

                startActivity(intent);
            }
        });


    }
}