package com.example.fithub;

import android.content.Context;

import java.util.ArrayList;

public class RemplirBaseDonnee {
    private Context context;

    public RemplirBaseDonnee(Context context){
        this.context=context;
    }

    public void remplir(){
        DbHandler db=new DbHandler(context,null);

        ArrayList<Exercice> listeExercice=new ArrayList<Exercice>();

        listeExercice.add(new Exercice("Pompe",5,"rien","Exercice de base","rien"));
        listeExercice.add(new Exercice("Traction",4,"rien","Exercice de base","rien"));

        for(int i=0;i<listeExercice.size();i++)
            db.addExercice(listeExercice.get(i));

        ArrayList<Serie> listeSerie=new ArrayList<Serie>();

        listeSerie.add(new Serie(1,12,4,30,context));
        listeSerie.add(new Serie(2,8,3,30,context));

        for(int i=0;i<listeSerie.size();i++)
            db.addSerie(listeSerie.get(i));

        ArrayList<Wod> listeWod=new ArrayList<Wod>();

        listeWod.add(new Wod("Wod1","description",listeSerie,2,context));

        for(int i=0;i<listeWod.size();i++)
            db.addWod(listeWod.get(i));


        ArrayList<Workout> listeWorkout=new ArrayList<Workout>();

        listeWorkout.add(new Workout("name","description","rien",listeWod,context));


        for(int i=0;i<listeWorkout.size();i++)
            db.addWorkout(listeWorkout.get(i));


    }
}
