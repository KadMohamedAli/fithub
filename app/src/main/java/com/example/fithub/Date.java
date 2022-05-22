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
        return new String(String.valueOf(x.getAn())+"-"+String.valueOf(x.getMois())+"-"+String.valueOf(x.getJour())+"-");
    }

    public static Date stringToDate(String x){
        Date date=new Date();
        StringBuilder jour= new StringBuilder(new String(""));
        StringBuilder mois= new StringBuilder(new String(""));
        StringBuilder an= new StringBuilder(new String(""));
        int i=0;
        while(x.charAt(i)!='-'){
            an.append(String.valueOf(x.charAt(i)));
            i=+1;
        }
        i=+1;
        while(x.charAt(i)!='-'){
            mois.append(String.valueOf(x.charAt(i)));
            i=+1;
        }
        i=+1;
        while(x.charAt(i)!='-'){
            jour.append(String.valueOf(x.charAt(i)));
            i=+1;
        }
        date.setAn(Integer.getInteger(an.toString()));
        date.setMois(Integer.getInteger(mois.toString()));
        date.setJour(Integer.getInteger(jour.toString()));
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
