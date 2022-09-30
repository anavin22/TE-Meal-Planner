package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;

public interface RecipeBuilderDao {

    int addRecipeToRecipeDB(String recipeName, String recipeImage, int createdBy);

    void updateRecipetoRecipeDB(Recipe recipe, int userId);

    int addIngredientToDB(String ingredientName);

    int addUnitToDB(String unitName);

    void updateUnitToDB(Ingredient ingredient, int recipeId);

    void addIngredientToRecipe(int ingredientId, int recipeId, double quantity, int unitId);

    void removeIngredientFromRecipe(int ingredientId, int recipeId);

    void updateIngredientQuantityToRecipe(Ingredient ingredient, int recipeId);

    int addInstructionToRecipe(int recipeId, int sequence, String instructionText);

    void removeInstructionFromRecipe(int instructionId);

    void updateInstructionsToRecipe(int recipeId, int sequence, String instructionText);

//    void changeSequenceOfInstruction(int newSequence, int instructionId);

}
