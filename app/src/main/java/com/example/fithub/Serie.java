package com.example.fithub;

import android.content.Context;

public class Serie {
    private long _id;
    private long exercice_id;
    private Exercice exercice;
    private int nRep;
    private int nSerie;
    private int tRepos;

    public Serie(long _id, long exercice_id, int nRep, int nSerie, int tRepos, Context context) {
        this._id = _id;
        this.exercice_id = exercice_id;
        this.nRep = nRep;
        this.nSerie = nSerie;
        this.tRepos = tRepos;
        this.exercice=new Exercice();
        setExerciceByid(exercice_id,context);
    }
    public Serie(long exercice_id, int nRep, int nSerie, int tRepos, Context context) {
        this.exercice_id = exercice_id;
        this.nRep = nRep;
        this.nSerie = nSerie;
        this.tRepos = tRepos;
        this.exercice=new Exercice();
        setExerciceByid(exercice_id,context);
    }

    public Serie() {
    }

    public void setExerciceByid(long exercice_id,Context context){
        Exercice exo=new Exercice();
        DbHandler db=new DbHandler(context,null);
        exo=db.getExercice(exercice_id);
        this.exercice=exo;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public long getExercice_id() {
        return exercice_id;
    }

    public void setExercice_id(long exercice_id) {
        this.exercice_id = exercice_id;
    }

    public Exercice getExercice() {
        return exercice;
    }

    public void setExercice(Exercice exercice) {
        this.exercice = exercice;
    }

    public int getnRep() {
        return nRep;
    }

    public void setnRep(int nRep) {
        this.nRep = nRep;
    }

    public int getnSerie() {
        return nSerie;
    }

    public void setnSerie(int nSerie) {
        this.nSerie = nSerie;
    }

    public int gettRepos() {
        return tRepos;
    }

    public void settRepos(int tRepos) {
        this.tRepos = tRepos;
    }
}
