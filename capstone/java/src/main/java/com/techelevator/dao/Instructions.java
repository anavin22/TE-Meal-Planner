package com.techelevator.dao;

public class Instructions {
    private int instruction_id;
    private String instruction_text;
    private int recipeId;

    public Instructions(int instruction_id, String instruction_text, int recipeId) {
        this.instruction_id = instruction_id;
        this.instruction_text = instruction_text;
        this.recipeId = recipeId;
    }

    public int getInstruction_id() {
        return instruction_id;
    }

    public void setInstruction_id(int instruction_id) {
        this.instruction_id = instruction_id;
    }

    public String getInstruction_text() {
        return instruction_text;
    }

    public void setInstruction_text(String instruction_text) {
        this.instruction_text = instruction_text;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
}
