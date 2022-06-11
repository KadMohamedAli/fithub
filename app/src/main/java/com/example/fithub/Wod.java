package com.example.fithub;

import android.content.Context;

import java.util.ArrayList;

public class Wod {
    private long _id;
    private String name;
    private String description;
    private ArrayList<Serie> listeSerie;
    private int jour;
    private Context context;

    public Wod(long _id, String name, String description, ArrayList<Serie> listeSerie,int jour, Context context) {
        this._id = _id;
        this.name = name;
        this.description = description;
        this.listeSerie = listeSerie;
        this.jour=jour;
        this.context=context;
    }
    public Wod(String name, String description, ArrayList<Serie> listeSerie,int jour, Context context) {
        this.name = name;
        this.description = description;
        this.listeSerie = listeSerie;
        this.jour=jour;
        this.context=context;
    }

    public Wod() {
    }

    public Serie getSerieById(long id){
        DbHandler db=new DbHandler(context,null);
        return db.getSerie(id);
    }

    public String serieToString(ArrayList<Serie> listeSerie){
        String x=new String();
        for(int i=0;i<listeSerie.size();i++)
            x=x+String.valueOf(listeSerie.get(i).get_id())+"-";
        return x;
    }
    public ArrayList<Serie> stringToSerie(String string){
        ArrayList<Serie> serie=new ArrayList<Serie>();
        int i=0;

        while(i<string.length()) {
            String x=new String("");
            while (string.charAt(i) != '-') {
                x = x + string.charAt(i);
                i = +1;
            }
            if(i+1<=string.length())
                i=i+1;
            serie.add(getSerieById(Long.getLong(x)));
        }

        return serie;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Serie> getListeSerie() {
        return listeSerie;
    }

    public void setListeSerie(ArrayList<Serie> listeSerie) {
        this.listeSerie = listeSerie;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }
}
