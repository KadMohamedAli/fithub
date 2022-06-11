package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.slider.Slider;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GoalActivity extends AppCompatActivity {

    private int height;
    private int weight;
    private int fitnessLevel;
    private Boolean[] problems;
    private Boolean[] diseases;
    private Date birthday;
    private int bodyFat;
    private int bodyType1;
    private int bodyType2;
    private int targetBody2;
    private int goal1;
    private float BMI;
    private int AMR;
    private int cpt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        TextView goalTextView=findViewById(R.id.goalTextView);
        TextView BMITextView=findViewById(R.id.textViewBMI);
        TextView weightCom=findViewById(R.id.weightCommentaire);
        Slider sliderBMI=findViewById(R.id.sliderBMI);
        TextView dailyCalorie=findViewById(R.id.dailyCalorie);
        TextView dailyWater=findViewById(R.id.dailyWater);
        TextView calorieTable=findViewById(R.id.calorieTable);
        TextView carbsTable=findViewById(R.id.carbsTable);
        TextView fatTable=findViewById(R.id.fatTable);
        TextView proteinTable=findViewById(R.id.proteinTable);
        Button continuer=findViewById(R.id.continuerGoalActivity);

        cpt=0;

        DbHandler db=new DbHandler(this,null);
        SQLiteDatabase database=db.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM "+DbHandler.TABLEUSER+" WHERE "+DbHandler.COL_USER_ID+" = ? ",new String[]{"1"});
        cursor.moveToNext();

        height=cursor.getInt(3);
        weight=cursor.getInt(4);
        fitnessLevel=cursor.getInt(12);
        problems=User.stringToBool(cursor.getString(10));
        diseases=User.stringToBool(cursor.getString(13));
        bodyFat=cursor.getInt(9);
        bodyType1=cursor.getInt(7);
        bodyType2=cursor.getInt(8);
        goal1=cursor.getInt(5);
        targetBody2=cursor.getInt(6);
        try{
            birthday=new SimpleDateFormat("yyyy-MM-dd").parse(cursor.getString(2));}
        catch(java.text.ParseException exp){
            birthday=new Date(2000,1,1);
        }
        Log.i("GoalActivity", String.valueOf(birthday));
        birthday=new Date(2000,1,1);//kyn probleme m3a les dates ki yetrigla probleme naho cette ligne

        AMR=calculateAMR(calculateBMR(height,weight,birthday),fitnessLevel);

        BMI=(float)calculateBMI(height,weight);
        double water=calculateWater(weight,fitnessLevel);

        ContentValues contentValues=new ContentValues();
        contentValues.put(DbHandler.COL_USER_DAILYCALORIE,AMR);
        contentValues.put(DbHandler.COL_USER_BMI,BMI);
        contentValues.put(DbHandler.COL_USER_DAILYWATER,water);



        DecimalFormat df = new DecimalFormat("#.00");
        dailyCalorie.setText(String.valueOf(AMR)+" KCAL");
        dailyWater.setText(df.format(water)+" L");
        BMITextView.setText(String.valueOf((int)BMI));
        sliderBMI.setValue(BMI);
        sliderBMI.setFocusable(false);
        sliderBMI.setEnabled(false);

        double customCalorie=AMR;
        double customCarbs=0;
        double customFat=0;
        double customProtein=0;
        String goalText="";

        switch(goal1){
            case 0:goalText="Your goal is to lose weight ";
                customCalorie=AMR*0.8;
                customCarbs=(customCalorie*0.4)/4;
                customFat=(customCalorie*0.25)/9;
                customProtein=(customCalorie*0.25)/4;
                break;
            case 1:goalText="Your goal is to get shredded ";
                customCalorie=AMR*0.95;
                customCarbs=(customCalorie*0.45)/4;
                customFat=(customCalorie*0.2)/9;
                customProtein=(customCalorie*0.35)/4;
                break;
            case 2:goalText="Your goal is to gain muscles";
                customCalorie=AMR*1.2;
                customCarbs=(customCalorie*0.5)/4;
                customFat=(customCalorie*0.2)/9;
                customProtein=(customCalorie*0.3)/4;
                break;
        }

        goalTextView.setText(goalText);
        contentValues.put(DbHandler.COL_USER_GOAL,goalText);
        contentValues.put(DbHandler.COL_USER_FAT,customFat);
        contentValues.put(DbHandler.COL_USER_CARBS,customCarbs);
        contentValues.put(DbHandler.COL_USER_PROTEIN,customProtein);
        contentValues.put(DbHandler.COL_USER_SUGGESTEDCALORIE,customCalorie);
        database.update(DbHandler.TABLEUSER,contentValues,DbHandler.COL_USER_ID+" = ?",new String[]{"1"});
        database.close();
        db.close();


        calorieTable.setText(String.valueOf((int)customCalorie)+" calories");
        carbsTable.setText(String.valueOf((int)customCarbs)+" g");
        fatTable.setText(String.valueOf((int)customFat)+" g");
        proteinTable.setText(String.valueOf((int)customProtein)+" g");


        if(BMI>40) {
            weightCom.setText("Severely Overweight");
        }
        else {
            if (BMI > 35)
                weightCom.setText("Severely Obese");
            else {
                if (BMI > 30)
                    weightCom.setText("Moderately Obese");
                else {
                    if (BMI > 25)
                        weightCom.setText("Overweight");
                    else {
                        if (BMI > 18.5)
                            weightCom.setText("Normal");
                        else {
                            if (BMI > 16)
                                weightCom.setText("Underweight");
                            else
                                weightCom.setText("Severely Underweight");
                            }
                        }
                    }
                }
            }



        continuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.setSys(1);
                if(cpt==0) {
                    RemplirBaseDonnee a = new RemplirBaseDonnee(getApplicationContext());
                    a.remplir();
                }
                cpt=+1;
            }
        });

    }

    public static int calculateBMR(int heightCM, int weightKG, Date birthday){
        int ageY=getAge(birthday.getYear(), birthday.getMonth(), birthday.getDay());
        double bmr=66.47+(13.75*weightKG)+(5.003*heightCM)-6.755*ageY;
        return (int)bmr;
    }
    public static int calculateAMR(int BMR,int fitnessLevel){
        double amr=0;
        if(fitnessLevel<=2){
            amr=BMR*1.2;
        }
        else{
            if(fitnessLevel<4){
                amr=BMR*1.375;
            }
            else{
                if(fitnessLevel<6){
                    amr=BMR*1.55;
                }
                else{
                    if(fitnessLevel<8){
                        amr=BMR*1.725;
                    }
                    else{
                        if(fitnessLevel<=10){
                            amr=BMR*1.9;
                        }
                    }
                }
            }
        }

        return (int)amr;
    }

    public static double calculateBMI(int heightM,int weightKG){
        return (double)weightKG/(Math.pow((double)heightM/100,2));
    }

    private static int getAge(int year, int month, int day){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        return age;
    }
    public static double calculateWater(int weightKG,int activityLevel){
        double x=(double)weightKG/30;
        if(activityLevel>=8)
            x=x+0.35;
        if((activityLevel>=2)&&(activityLevel<5))
            x=x+0.2;
        if((activityLevel>=5)&&(activityLevel<8))
            x=x+0.3;
        if(activityLevel<2)
            x=x+0.1;
        return x;
    }
}