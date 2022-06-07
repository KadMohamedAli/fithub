package com.example.fithub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DbHandler extends SQLiteOpenHelper {
    private static final int VERSION=1;

    public static final String DATABASE="fithubDatabase.db";

    public static final String TABLEUSER="user";
    public static final String TABLEEXERCICE="exercice";
    public static final String TABLESYS="sys";

    public static final String COL_USER_ID="_id";
    public static final String COL_USER_NAME="name";
    public static final String COL_USER_BIRTHDAY="birthday";
    public static final String COL_USER_HEIGHT="height";
    public static final String COL_USER_WEIGHT="weight";
    public static final String COL_USER_BODYGOALOPTION1="bodyGoalOption1";
    public static final String COL_USER_BODYGOALOPTION2="bodyGoalOption2";
    public static final String COL_USER_BODYTYPE1="bodyType1";
    public static final String COL_USER_BODYTYPE2="bodyType2";
    public static final String COL_USER_BODYFAT="bodyFat";
    public static final String COL_USER_PROBLEMAREA="problemArea";
    public static final String COL_USER_TARGETWEIGHT="targetWeight";
    public static final String COL_USER_FITNESSLEVEL="fitnessLevel";
    public static final String COL_USER_HEALTHPROBLEM="healthProblem";
    public static final String COL_USER_BMI="BMI";
    public static final String COL_USER_DAILYCALORIE="dailyCalorie";
    public static final String COL_USER_DAILYWATER="dailyWater";
    public static final String COL_USER_SUGGESTEDCALORIE="suggestedCalorie";
    public static final String COL_USER_CARBS="carbs";
    public static final String COL_USER_FAT="fat";
    public static final String COL_USER_PROTEIN="protein";
    public static final String COL_USER_GOAL="goal";
    public static final String COL_USER_INTERESTEDSPORT="interestedSport";
    public static final String COL_USER_NUMBERPUSHUP="numberPushUp";
    public static final String COL_USER_NUMBERPULLUP="numberPullUp";
    public static final String COL_USER_WORKOUTTIME="workoutTime";

    public static final String COL_EXERCICE_ID="_id";
    public static final String COL_EXERCICE_NAME="name";
    public static final String COL_EXERCICE_APPRECIATION="appreciation";
    public static final String COL_EXERCICE_PHOTO="photo";
    public static final String COL_EXERCICE_DESCRIPTION="description";
    public static final String COL_EXERCICE_VIDEO="video";

    public static final String COL_SYS_PREMIEREFOIS="premiereFois";

    public DbHandler(Context context, SQLiteDatabase.CursorFactory factory){
        super(context,DATABASE,factory,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String requete1="CREATE TABLE "+TABLEUSER+
                " ( "+COL_USER_ID+" INTEGER PRIMARY KEY, "+
                COL_USER_NAME+" TEXT, "+
                COL_USER_BIRTHDAY+" TEXT, "+
                COL_USER_HEIGHT+" INTEGER, "+
                COL_USER_WEIGHT+" INTEGER, "+
                COL_USER_BODYGOALOPTION1+" INTEGER, "+
                COL_USER_BODYGOALOPTION2+" INTEGER, "+
                COL_USER_BODYTYPE1+" INTEGER, "+
                COL_USER_BODYTYPE2+" INTEGER, "+
                COL_USER_BODYFAT+" INTEGER, "+
                COL_USER_PROBLEMAREA+" TEXT, "+
                COL_USER_TARGETWEIGHT+" INTEGER, "+
                COL_USER_FITNESSLEVEL+" INTEGER, "+
                COL_USER_HEALTHPROBLEM+" TEXT, "+
                COL_USER_BMI+" REAL, "+
                COL_USER_DAILYCALORIE+" INTEGER, "+
                COL_USER_DAILYWATER+" INTEGER, "+
                COL_USER_SUGGESTEDCALORIE+" INTEGER, "+
                COL_USER_CARBS+" INTEGER, "+
                COL_USER_FAT+" INTEGER, "+
                COL_USER_PROTEIN+" INTEGER, "+
                COL_USER_GOAL+" TEXT, "+
                COL_USER_INTERESTEDSPORT+" TEXT, "+
                COL_USER_NUMBERPUSHUP+" INTEGER, "+
                COL_USER_NUMBERPULLUP+" INTEGER, "+
                COL_USER_WORKOUTTIME+" INTEGER "+
                ")";
        String requete2="CREATE TABLE "+TABLEEXERCICE+
                " ( "+ COL_EXERCICE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL_EXERCICE_NAME+" TEXT, "+
                COL_EXERCICE_APPRECIATION+" INTEGER, "+
                COL_EXERCICE_PHOTO+" TEXT, "+
                COL_EXERCICE_DESCRIPTION+" TEXT, "+
                COL_EXERCICE_VIDEO+" TEXT "+
                ")";
        String requete3=" CREATE TABLE "+TABLESYS+
                " ( "+COL_SYS_PREMIEREFOIS+" INTEGER "+
                ")";
        sqLiteDatabase.execSQL(requete1);
        sqLiteDatabase.execSQL(requete2);
        sqLiteDatabase.execSQL(requete3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLEUSER);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLEEXERCICE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLESYS);
        onCreate(sqLiteDatabase);
    }
    public void deleteAllUser(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLEUSER); //delete all rows in a table
        db.close();
    }

    public void addExercice(Exercice exo){
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_EXERCICE_NAME,exo.getName());
        contentValues.put(COL_EXERCICE_APPRECIATION,exo.getAppreciation());
        contentValues.put(COL_EXERCICE_DESCRIPTION,exo.getDescription());
        contentValues.put(COL_EXERCICE_PHOTO,exo.getPhoto());
        contentValues.put(COL_EXERCICE_VIDEO,exo.getVideo());
        SQLiteDatabase db=this.getWritableDatabase();
        exo.setId(db.insert(TABLEEXERCICE,null,contentValues));
        db.close();
    }
    public void addSys(int i){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_SYS_PREMIEREFOIS,i);
        db.insert(TABLESYS,null,contentValues);
        db.close();
    }
    public void addUser(){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_USER_ID,"1");
        db.insert(TABLEUSER,null,contentValues);
        db.close();
    }
    public int getSys(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * from "+TABLESYS,null);
        cursor.moveToNext();
        int i =cursor.getInt(0);
        cursor.close();
        db.close();
        return i;
    }
    public void setSys(int i){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_SYS_PREMIEREFOIS,i);
        db.update(DbHandler.TABLESYS,contentValues,DbHandler.COL_SYS_PREMIEREFOIS+" = ?",new String[]{"0"});
        db.close();
    }
    //ajouter getExo

    public User getUser(){
        SQLiteDatabase db=this.getReadableDatabase();
        User user=new User();

        Cursor cursor=db.rawQuery("SELECT * from "+TABLEUSER+" WHERE "+COL_USER_ID+" =? ",new String[]{"1"});
        cursor.moveToNext();



        user.setId(cursor.getLong(0));
        user.setName(cursor.getString(1));
        try{
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(cursor.getString(2)));}
        catch(java.text.ParseException exp){
            user.setBirthday(new Date(1970,1,1));
        }

        user.setHeight(cursor.getInt(3));
        user.setWeight(cursor.getInt(4));
        user.setBodyGoalOption1(cursor.getInt(5));
        user.setBodyGoalOption2(cursor.getInt(6));
        user.setBodyType1(cursor.getInt(7));
        user.setBodyType2(cursor.getInt(8));
        user.setBodyFat(cursor.getInt(9));
        user.setProblemeArea(User.stringToBool(cursor.getString(10)));
        user.setTargetWieght(cursor.getInt(11));
        user.setFitnessLevel(cursor.getInt(12));
        user.setHealthProblem(User.stringToBool(cursor.getString(13)));
        user.setBMI(cursor.getFloat(14));
        user.setDailyCalorie(cursor.getInt(15));
        user.setDailyWater(cursor.getInt(16));
        user.setSuggesetedCalorie(cursor.getInt(17));
        user.setCarbs(cursor.getInt(18));
        user.setFat(cursor.getInt(19));
        user.setProtein(cursor.getInt(20));
        user.setGoal(cursor.getString(21));
        user.setInterestedSport(User.stringToBool(cursor.getString(22)));
        user.setNumberPushUp(cursor.getInt(23));
        user.setNumberPullUp(cursor.getInt(24));
        user.setWorkoutTime(cursor.getInt(25));

        cursor.close();
        db.close();
        return user;
    }
}
