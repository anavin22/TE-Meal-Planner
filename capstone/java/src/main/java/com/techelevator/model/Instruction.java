package com.techelevator.model;

public class Instruction {
    private int instructionId;
    private int recipeID;
    private int sequence;
    private int instructionText;

    public Instruction(){};

    public Instruction(int instructionId, int recipeID, int sequence, int instructionText) {
        this.instructionId = instructionId;
        this.recipeID = recipeID;
        this.sequence = sequence;
        this.instructionText = instructionText;
    }

    public int getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(int instructionId) {
        this.instructionId = instructionId;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getInstructionText() {
        return instructionText;
    }

    public void setInstructionText(int instructionText) {
        this.instructionText = instructionText;
    }
}
