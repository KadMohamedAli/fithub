package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BodyTypeActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_type2);

        DbHandler db=new DbHandler(this,null);

        Button option0=findViewById(R.id.body_type2_option0);
        Button option1=findViewById(R.id.body_type2_option1);
        Button option2=findViewById(R.id.body_type2_option2);


        Intent intent=new Intent(getApplicationContext(),BodyFatActivity.class);
        option0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database=db.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(DbHandler.COL_USER_BODYTYPE2,0);
                database.insert(DbHandler.TABLEUSER,null,contentValues);
                database.close();
                startActivity(intent);
            }
        });
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database=db.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(DbHandler.COL_USER_BODYTYPE2,1);
                database.insert(DbHandler.TABLEUSER,null,contentValues);
                database.close();
                startActivity(intent);
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database=db.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(DbHandler.COL_USER_BODYTYPE2,2);
                database.insert(DbHandler.TABLEUSER,null,contentValues);
                database.close();
                startActivity(intent);
            }
        });
    }
}