package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BodyTypeActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_type1);

        DbHandler db=new DbHandler(this,null);

        Button ectomorphBoutton=findViewById(R.id.ectomorph);
        Button mesomorphBoutton=findViewById(R.id.mesomorph);
        Button endomorphBoutton=findViewById(R.id.endomorph);
        ImageButton infoImageBoutton=findViewById(R.id.infoImageBoutton);

        ectomorphBoutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database=db.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(DbHandler.COL_USER_BODYTYPE1,0);
                database.insert(DbHandler.TABLEUSER,null,contentValues);
                database.close();
            }
        });
        mesomorphBoutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database=db.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(DbHandler.COL_USER_BODYTYPE1,1);
                database.insert(DbHandler.TABLEUSER,null,contentValues);
                database.close();
            }
        });
        endomorphBoutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database=db.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(DbHandler.COL_USER_BODYTYPE1,2);
                database.insert(DbHandler.TABLEUSER,null,contentValues);
                database.close();
            }
        });
        infoImageBoutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}