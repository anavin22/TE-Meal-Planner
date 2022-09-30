package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;

public interface RecipeBuilderDao {

    int addRecipeToRecipeDB(String recipeName, String recipeImage, int createdBy);

    void updateRecipeToRecipeDB(Recipe recipe, int userId);

    int addIngredientToDB(String ingredientName);

    void addIngredientToRecipe(int ingredientId, int recipeId, double quantity, String unit);

    void removeIngredientFromRecipe(int ingredientId, int recipeId);

    void updateIngredientQuantityToRecipe(Ingredient ingredient, int recipeId);

    int addInstructionToRecipe(int recipeId, int sequence, String instructionText);

    void removeInstructionFromRecipe(int instructionId);

    void updateInstructionsToRecipe(int recipeId, int sequence, String instructionText);


}
