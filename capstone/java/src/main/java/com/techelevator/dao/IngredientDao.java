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

    List<Ingredient> getAllIngredients();

    void checkIngredientAndCreateIfNonexistent(Ingredient ingredient);

}
