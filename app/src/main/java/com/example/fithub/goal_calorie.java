package com.example.fithub;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.slider.Slider;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link goal_calorie#newInstance} factory method to
 * create an instance of this fragment.
 */
public class goal_calorie extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public goal_calorie() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment goal_calorie.
     */
    // TODO: Rename and change types and number of parameters
    public static goal_calorie newInstance(String param1, String param2) {
        goal_calorie fragment = new goal_calorie();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

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



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View convertView=inflater.inflate(R.layout.fragment_goal_calorie, container, false);

        TextView goalTextView=convertView.findViewById(R.id.goalTextView);
        TextView BMITextView=convertView.findViewById(R.id.textViewBMI);
        TextView weightCom=convertView.findViewById(R.id.weightCommentaire);
        Slider sliderBMI=convertView.findViewById(R.id.sliderBMI);
        TextView dailyCalorie=convertView.findViewById(R.id.dailyCalorie);
        TextView dailyWater=convertView.findViewById(R.id.dailyWater);
        TextView calorieTable=convertView.findViewById(R.id.calorieTable);
        TextView carbsTable=convertView.findViewById(R.id.carbsTable);
        TextView fatTable=convertView.findViewById(R.id.fatTable);
        TextView proteinTable=convertView.findViewById(R.id.proteinTable);


        DbHandler db=new DbHandler(getContext(),null);
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





        return convertView;
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