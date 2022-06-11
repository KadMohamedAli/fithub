package com.example.fithub;

public class Exercice {
    private long id;
    private String name;
    private int appreciation;
    private String photo;
    private String description;
    private String video;

    public Exercice(long id, String name){
        this.id=id;
        this.name=name;
    }
    public Exercice(){

    }

    public Exercice(String name, int appreciation, String photo, String description,String video) {
        this.name = name;
        this.appreciation = appreciation;
        this.photo = photo;
        this.description = description;
        this.video=video;
    }

    public Exercice(int id, String name, int appreciation, String photo, String description,String video) {
        this.id = id;
        this.name = name;
        this.appreciation = appreciation;
        this.photo = photo;
        this.description = description;
        this.video=video;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
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

    public int getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(int appreciation) {
        this.appreciation = appreciation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
