package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        DbHandler db;
        if(doesDatabaseExist(this,DbHandler.DATABASE)) {
            db = new DbHandler(this, null);
        }
        else{
            db = new DbHandler(this, null);
            db.addSys(0);
        }

        int premiereFois= db.getSys();



        if(premiereFois!=0){
            Intent intent=new Intent(this,afficheSwalahActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent=new Intent(this,GetStartedActivity.class);
            startActivity(intent);
            finish();
        }

    }

    private static boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }
}