package com.techelevator.dao;

import com.techelevator.model.Ingredient;

import java.util.List;

public interface IngredientDao {

    Ingredient getIngredientById(int id);

    Ingredient getIngredientByName(String name);

    Ingredient getIngredientByType(String type);

    Ingredient createIngredient(Ingredient ingredient);

    Ingredient updateIngredient(Ingredient ingredient);

    List<Ingredient> getAllIngredientsByRecipeId(int recipeId);

    List<Ingredient> getAllIngredientsByUserMealPlanId(int userMealPlanId);

    List<Ingredient> getAllIngredients();

    List <Ingredient>getAllIngredientsForMealPlanByUserId(int userId);

    void checkIngredientAndCreateIfNonexistent(Ingredient ingredient);

    List<Ingredient> getAllIngredientsForRecipesByUserMealPlan(int userId);

}
