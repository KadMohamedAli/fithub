package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

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
        User user=db.getUser();
        text.setText(user.getId()+" "+user.getName());
    }
}