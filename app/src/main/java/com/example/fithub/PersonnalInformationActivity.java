package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class PersonnalInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnal_information);

        DatePicker datePicker=findViewById(R.id.datePicker);
        EditText nomEditText=findViewById(R.id.nomEditText);
        NumberPicker taillePicker=findViewById(R.id.heightPicker);
        Button continuerBouton=findViewById(R.id.continuerButtonPersonnalInformation);

        DbHandler db=new DbHandler(this,null);


        taillePicker.setMinValue(0);
        taillePicker.setMaxValue(250);
        taillePicker.setWrapSelectorWheel(false);

        Intent intent=new Intent(getApplicationContext(),WeightActivity.class);

        continuerBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nomEditText.getText().toString().equals("")){
                    Toast.makeText(PersonnalInformationActivity.this, "Write something", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase database=db.getWritableDatabase();
                    ContentValues contentValues=new ContentValues();
                    contentValues.put(DbHandler.COL_USER_NAME,nomEditText.getText().toString());
                    contentValues.put(DbHandler.COL_USER_HEIGHT,taillePicker.getValue());
                    contentValues.put(DbHandler.COL_USER_BIRTHDAY,Date.dateToString(new Date(datePicker.getDayOfMonth(),(datePicker.getMonth())+1,datePicker.getYear())));
                    database.update(DbHandler.TABLEUSER,contentValues,DbHandler.COL_USER_ID+" = ?",new String[]{"1"});
                    database.close();
                    db.close();
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}