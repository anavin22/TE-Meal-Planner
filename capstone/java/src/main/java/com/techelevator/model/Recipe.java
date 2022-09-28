package com.techelevator.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe<recipeName> {
    private int recipeId;
    private int createdBy;
    private String recipeName;
    private String image;
    Map<Integer, String> Instructions = new HashMap<>(); //sequence, instruction_text
    List<Ingredient> ingredientList;
    //add ingredients array
    //add instruction array-- map? sequence = key, text = value

    public Recipe() {
    }

    public Recipe(int recipeId, int createdBy, String recipeName, String image, Map<Integer, String> Instructions, List<Ingredient> ingredientList) {
        this.recipeId = recipeId;
        this.createdBy = createdBy;
        this.recipeName = recipeName;
        this.image = image;
        this.Instructions = Instructions;
        this.ingredientList = ingredientList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Map<Integer, String> getInstructions() {
        return Instructions;
    }

    public void setInstructions(Map<Integer, String> instructions) {
        Instructions = instructions;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
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
