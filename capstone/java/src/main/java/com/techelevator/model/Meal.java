package com.techelevator.model;

public class Meal {
    private int mealId;
    private int mealPlanId;
    private int recipeId;
    private String mealType;
    private String dayOfWeek;

    public Meal (){};

    public Meal(int mealId, int mealPlanId, int recipeId, String mealType, String dayOfWeek) {
        this.mealId = mealId;
        this.mealPlanId = mealPlanId;
        this.recipeId = recipeId;
        this.mealType = mealType;
        this.dayOfWeek = dayOfWeek;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(int mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
