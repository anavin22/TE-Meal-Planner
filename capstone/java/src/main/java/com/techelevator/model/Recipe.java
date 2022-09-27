package com.techelevator.model;

public class Recipe<recipeName> {
    private int recipeId;
    private int createdBy;
    private String recipeName;

    public Recipe() {
    }

    public Recipe(int recipeId, int createdBy, String recipeName) {
        this.recipeId = recipeId;
        this.createdBy = createdBy;
        this.recipeName = recipeName;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}
