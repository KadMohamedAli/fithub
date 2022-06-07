package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.google.android.material.slider.Slider;

public class WeightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        NumberPicker currentWeight=findViewById(R.id.currentWeight);
        NumberPicker targetWeight=findViewById(R.id.targetWeight);
        Slider slider=findViewById(R.id.sliderLevelActivity);
        Button buttonContinuer=findViewById(R.id.continuerButtonWeight);


        currentWeight.setMinValue(0);
        currentWeight.setMaxValue(300);
        currentWeight.setWrapSelectorWheel(false);
        targetWeight.setMinValue(0);
        targetWeight.setMaxValue(300);
        targetWeight.setWrapSelectorWheel(false);

        DbHandler db=new DbHandler(this,null);

        Intent intent=new Intent(getApplicationContext(),DiseaseActivity.class);
        buttonContinuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase database=db.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put(DbHandler.COL_USER_WEIGHT,currentWeight.getValue());
                contentValues.put(DbHandler.COL_USER_TARGETWEIGHT,targetWeight.getValue());
                contentValues.put(DbHandler.COL_USER_FITNESSLEVEL,slider.getValue());
                database.update(DbHandler.TABLEUSER,contentValues,DbHandler.COL_USER_ID+" = ?",new String[]{"1"});
                database.close();
                db.close();
                startActivity(intent);
                finish();
            }
        });
    }
}