/*package com.example.fithub;

import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
    private int jour;
    private int mois;
    private int an;

    public MyDate(int jour,int mois,int an){
        this.jour=jour;
        this.mois=mois;
        this.an=an;
    }
    public MyDate(){

    }

    public static String dateToString(MyDate x){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        date.setYear(x.getAn());
        date.setMonth(x.getMois());
        date.setDate(x.getJour());
        return dateFormat.format(date);}

    public static MyDate stringToDate(String x){
        MyDate date=new MyDate();
        Date date1=new Date();
        DateFormat dateF=new SimpleDateFormat("yyyy-MM-dd");
        try{
            date1=dateF.parse(x);
        }
        catch(java.text.ParseException exception){
           date.setAn(2000);
           date.setJour(1);
           date.setMois(1);
        }
        date.setAn(date1.getYear());
        date.setMois(date1.getMonth());
        date.setJour(date1.getDay());
        return date;
    }

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getAn() {
        return an;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public void setAn(int an) {
        this.an = an;
    }
}
*/