package com.example.fithub;

public class Date {
    private int jour;
    private int mois;
    private int an;

    public Date(int jour,int mois,int an){
        this.jour=jour;
        this.mois=mois;
        this.an=an;
    }
    public Date(){

    }

    public static String dateToString(Date x){
        String string=new String("");
        string.concat(String.valueOf(x.getAn())+"-"+String.valueOf(x.getMois())+"-"+String.valueOf(x.getJour())+"-");
        return string;
    }

    public static Date stringToDate(String x){
        Date date=new Date();
        String jour=new String("");
        String mois=new String("");
        String an=new String("");
        int i=0;
        while(x.charAt(i)!='-'){
            an.concat(String.valueOf(x.charAt(i)));
            i=+1;
        }
        i=+1;
        while(x.charAt(i)!='-'){
            mois.concat(String.valueOf(x.charAt(i)));
            i=+1;
        }
        i=+1;
        while(x.charAt(i)!='-'){
            jour.concat(String.valueOf(x.charAt(i)));
            i=+1;
        }
        date.setAn(Integer.getInteger(an));
        date.setMois(Integer.getInteger(mois));
        date.setJour(Integer.getInteger(jour));
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
