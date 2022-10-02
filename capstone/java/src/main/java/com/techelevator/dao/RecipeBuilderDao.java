package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Instructions;
import com.techelevator.model.Recipe;

import java.util.List;

public interface RecipeBuilderDao {

    int addRecipeToRecipeDB(String recipeName, String recipeImage, int createdBy);

    void updateRecipeToRecipeDB(Recipe recipe, int userId);

    int addIngredientToDB(Ingredient ingredient);

    void addIngredientToRecipe(int ingredientId, int recipeId, double quantity, String unit);

    void removeIngredientFromRecipe(int ingredientId, int recipeId);

    void updateIngredientQuantityToRecipe(Ingredient ingredient, int recipeId);

    int addInstructionToRecipe(Instructions instructions);

    void removeInstructionFromRecipe(int instructionId);

    void updateInstructionsToRecipe(Instructions instructions, int instructionId);

    List<Instructions> getAllInstructionsByRecipe(int recipeId);



}
