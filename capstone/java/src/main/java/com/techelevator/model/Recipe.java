package com.techelevator.model;

import java.util.HashMap;
import java.util.Map;

public class Recipe<recipeName> {
    private int recipeId;
    private int createdBy;
    private String recipeName;
    private String image;
    Map<Integer, String> Instructions = new HashMap<>(); //sequence, instruction_text
    String[] Ingredients;
    //add ingredients array
    //add instruction array-- map? sequence = key, text = value

    public Recipe() {
    }

    public Recipe(int recipeId, int createdBy, String recipeName, String image) {
        this.recipeId = recipeId;
        this.createdBy = createdBy;
        this.recipeName = recipeName;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
