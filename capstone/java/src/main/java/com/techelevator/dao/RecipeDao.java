package com.techelevator.dao;

import com.techelevator.model.Recipe;

import java.util.List;

public interface RecipeDao {

    Recipe getRecipeByRecipeId(int id);

    List<Recipe> getAllRecipes();

    Recipe getRecipeByName(String name);

    List<Recipe> getAllSavedRecipesByUserId(int id);

    List<Recipe> getAllRecipesByCreatedBy(int createdBy);

    //getrecipebytag .. array of tags

    Recipe createObjectCalledRecipe(Recipe newRecipe, int recipeId, String name);

    Recipe updateRecipe(Recipe recipe);

    Recipe deleteRecipeById(int id);

}
