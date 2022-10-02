package com.techelevator.model;

import java.util.List;

public class MealPlan {
    private int mealPlanId;
    private int createdBy;
    private String title;
    List<Meal> mealList;

    public MealPlan (){};

    public MealPlan(int mealPlanId, int createdBy, String title, List<Meal> mealList) {
        this.mealPlanId = mealPlanId;
        this.createdBy = createdBy;
        this.title = title;
        this.mealList = mealList;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

    public int getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(int mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
