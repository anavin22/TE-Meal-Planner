package com.techelevator.dao;

import com.techelevator.model.Recipe;

import java.util.List;

public interface RecipeDao {

    Recipe getRecipeByRecipeId(int id);

    List<Recipe> getAllRecipes();

    Recipe getRecipeByName(String name);

    List<Recipe> getAllRecipesByCreatedBy(int createdBy);

    //getrecipebytag .. array of tags

    Recipe createRecipe(Recipe newRecipe);

    Recipe updateRecipe(Recipe recipe);

    Recipe deleteRecipeById(int id);

}
