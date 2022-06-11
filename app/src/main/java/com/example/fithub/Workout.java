package com.example.fithub;

import android.content.Context;

import java.util.ArrayList;

public class Workout {
    private long id;
    private String name;
    private String description;
    private String photo;
    private ArrayList<Wod> listeWod;
    private Context context;

    public Workout(long id, String name, String description, String photo, ArrayList<Wod> listeWod, Context context) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.listeWod = listeWod;
        this.context=context;
    }
    public Workout(String name, String description, String photo, ArrayList<Wod> listeWod, Context context) {
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.listeWod = listeWod;
        this.context=context;
    }

    public Workout() {
    }

    public Wod getWodById(long id){
        DbHandler db=new DbHandler(context,null);
        return db.getWod(id);
    }

    public String listeWodToString(ArrayList<Wod> listeWod){
        String x=new String("");
        for(int i=0;i<listeWod.size();i++){
            x=x+String.valueOf(listeWod.get(i).get_id())+"-";
        }
        return x;
    }
    public ArrayList<Wod> stringToListeWod(String string){
        ArrayList<Wod> liste=new ArrayList<Wod>();
        int i=0;

        while(i<string.length()) {
            String x=new String("");
            while (string.charAt(i) != '-') {
                x = x + string.charAt(i);
                i = +1;
            }
            if(i+1<=string.length())
                i=i+1;
            liste.add(getWodById(Long.getLong(x)));
        }

        return liste;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public ArrayList<Wod> getListeWod() {
        return listeWod;
    }

    public void setListeWod(ArrayList<Wod> listeWod) {
        this.listeWod = listeWod;
    }
}
