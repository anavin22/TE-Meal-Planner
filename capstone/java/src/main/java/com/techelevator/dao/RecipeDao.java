package com.techelevator.dao;

import com.techelevator.model.Recipe;

import java.security.Principal;
import java.util.List;

public interface RecipeDao {

    Recipe getRecipeByRecipeId(int id);

    List<Recipe> getAllRecipes();

    List<Recipe> getAllSavedRecipesByUserId(int id);

    List<Recipe> getAllRecipesByCreatedBy(int createdBy);

    List<Recipe> getLatestRecipes();

    Recipe createObjectCalledRecipe(int recipeId);

    void putARecipeIntoSavedRecipes(int userId, Recipe recipe);

    int removeARecipeFromSavedRecipes(int userId, int recipeId);

    Recipe deleteRecipeById(int recipeId);

    Recipe createRecipe(Recipe recipe);

    List<Integer> getListOfFavoriteRecipeIdsByUserId(int userId);

    String getRecipeName(int recipeId);

}
