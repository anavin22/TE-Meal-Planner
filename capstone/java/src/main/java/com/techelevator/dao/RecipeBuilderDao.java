package com.techelevator.dao;

public interface RecipeBuilderDao {

    int addRecipeToRecipeDB(String recipeName, String recipeImage, int createdBy);

    int addIngredientToDB(String ingredientName);

    int addUnitToDB(String unitName);

    void addIngredientToRecipe(int ingredientId, int recipeId, double quantity, int unitId);

    void removeIngredientFromRecipe(int ingredientId, int recipeId);

    int addInstructionToRecipe(int recipeId, int sequence, String instruction_text);

    void removeInstructionFromRecipe(int instructionId);

//    void changeSequenceOfInstruction(int newSequence, int instructionId);

}
