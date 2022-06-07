package com.example.fithub;

import java.util.Date;

public class User {
    private long id;
    private String name;
    private Date birthday;
    private int height;
    private int weight;
    private int bodyGoalOption1;
    private int bodyGoalOption2;
    private int bodyType1;
    private int bodyType2;
    private int bodyFat;
    private Boolean[] problemeArea;
    private int targetWieght;
    private int fitnessLevel;
    private Boolean[] healthProblem;
    private float BMI;
    private int dailyCalorie;
    private int dailyWater;
    private int suggesetedCalorie;
    private int carbs;
    private int fat;
    private int protein;
    private String goal;
    private Boolean[] interestedSport;
    private int numberPushUp;
    private int numberPullUp;
    private int workoutTime;

    public User(long id){
        this.id=id;
    }
    public User(){

    }

    public User(long id, String name, Date birthday, int height, int weight, int bodyGoalOption1, int bodyGoalOption2, int bodyType1, int bodyType2, int bodyFat, Boolean[] problemeArea, int targetWieght, int fitnessLevel, Boolean[] healthProblem, float BMI, int dailyCalorie, int dailyWater, int suggesetedCalorie, int carbs, int fat, int protein, String goal, Boolean[] interestedSport, int numberPushUp, int numberPullUp, int workoutTime) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.bodyGoalOption1 = bodyGoalOption1;
        this.bodyGoalOption2 = bodyGoalOption2;
        this.bodyType1 = bodyType1;
        this.bodyType2 = bodyType2;
        this.bodyFat = bodyFat;
        this.problemeArea = problemeArea;
        this.targetWieght = targetWieght;
        this.fitnessLevel = fitnessLevel;
        this.healthProblem = healthProblem;
        this.BMI = BMI;
        this.dailyCalorie = dailyCalorie;
        this.dailyWater = dailyWater;
        this.suggesetedCalorie = suggesetedCalorie;
        this.carbs = carbs;
        this.fat = fat;
        this.protein = protein;
        this.goal = goal;
        this.interestedSport = interestedSport;
        this.numberPushUp = numberPushUp;
        this.numberPullUp = numberPullUp;
        this.workoutTime = workoutTime;
    }
    public static String boolToString(Boolean[] x){
        StringBuilder string= new StringBuilder(new String(""));
        for(int i=0;i<x.length;i++){
            if(!x[i])
                string.append("0");
            else
                string.append("1");
        }
        return string.toString();
    }

    public static Boolean[] stringToBool(String x){
        Boolean[] bool =new Boolean[x.length()];
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)=='0')
                bool[i]=false;
            else
                bool[i]=true;
        }
        return bool;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBodyGoalOption1() {
        return bodyGoalOption1;
    }

    public void setBodyGoalOption1(int bodyGoalOption1) {
        this.bodyGoalOption1 = bodyGoalOption1;
    }

    public int getBodyGoalOption2() {
        return bodyGoalOption2;
    }

    public void setBodyGoalOption2(int bodyGoalOption2) {
        this.bodyGoalOption2 = bodyGoalOption2;
    }

    public int getBodyType1() {
        return bodyType1;
    }

    public void setBodyType1(int bodyType1) {
        this.bodyType1 = bodyType1;
    }

    public int getBodyType2() {
        return bodyType2;
    }

    public void setBodyType2(int bodyType2) {
        this.bodyType2 = bodyType2;
    }

    public int getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(int bodyFat) {
        this.bodyFat = bodyFat;
    }

    public Boolean[] getProblemeArea() {
        return problemeArea;
    }

    public void setProblemeArea(Boolean[] problemeArea) {
        this.problemeArea = problemeArea;
    }

    public int getTargetWieght() {
        return targetWieght;
    }

    public void setTargetWieght(int targetWieght) {
        this.targetWieght = targetWieght;
    }

    public int getFitnessLevel() {
        return fitnessLevel;
    }

    public void setFitnessLevel(int fitnessLevel) {
        this.fitnessLevel = fitnessLevel;
    }

    public Boolean[] getHealthProblem() {
        return healthProblem;
    }

    public void setHealthProblem(Boolean[] healthProblem) {
        this.healthProblem = healthProblem;
    }

    public float getBMI() {
        return BMI;
    }

    public void setBMI(float BMI) {
        this.BMI = BMI;
    }

    public int getDailyCalorie() {
        return dailyCalorie;
    }

    public void setDailyCalorie(int dailyCalorie) {
        this.dailyCalorie = dailyCalorie;
    }

    public int getDailyWater() {
        return dailyWater;
    }

    public void setDailyWater(int dailyWater) {
        this.dailyWater = dailyWater;
    }

    public int getSuggesetedCalorie() {
        return suggesetedCalorie;
    }

    public void setSuggesetedCalorie(int suggesetedCalorie) {
        this.suggesetedCalorie = suggesetedCalorie;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Boolean[] getInterestedSport() {
        return interestedSport;
    }

    public void setInterestedSport(Boolean[] interestedSport) {
        this.interestedSport = interestedSport;
    }

    public int getNumberPushUp() {
        return numberPushUp;
    }

    public void setNumberPushUp(int numberPushUp) {
        this.numberPushUp = numberPushUp;
    }

    public int getNumberPullUp() {
        return numberPullUp;
    }

    public void setNumberPullUp(int numberPullUp) {
        this.numberPullUp = numberPullUp;
    }

    public int getWorkoutTime() {
        return workoutTime;
    }

    public void setWorkoutTime(int workoutTime) {
        this.workoutTime = workoutTime;
    }
}
