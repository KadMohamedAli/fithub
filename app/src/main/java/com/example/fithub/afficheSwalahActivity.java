package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class afficheSwalahActivity extends AppCompatActivity {

    DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_swalah);

        TextView text=findViewById(R.id.textAfficheSwalah);
        DbHandler db=new DbHandler(this,null);
        SQLiteDatabase database=db.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM "+DbHandler.TABLEUSER+" WHERE "+DbHandler.COL_USER_ID+" = ? ",new String[]{"1"});
        cursor.moveToNext();

        text.setText("name : "+cursor.getString(1));
        db.close();
    }
}