package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.slider.RangeSlider;
import com.google.android.material.slider.Slider;

public class BodyFatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_fat);

        DbHandler db=new DbHandler(this,null);

        Slider slider=findViewById(R.id.slider);
        Button continuer=findViewById(R.id.continueButton);

        Intent intent=new Intent(getApplicationContext(),ProblemAreaActivity.class);
        continuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database=db.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(DbHandler.COL_USER_BODYFAT,String.valueOf(slider.getValue()));
                database.update(DbHandler.TABLEUSER,contentValues,DbHandler.COL_USER_ID+" = ?",new String[]{"1"});
                database.close();
                db.close();
                startActivity(intent);
                finish();
            }
        });
    }
}