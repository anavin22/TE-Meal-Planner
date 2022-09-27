package com.techelevator.dao;

import com.techelevator.model.Ingredient;

public interface IngredientDao {

    Ingredient getIngredientById(int id);

    Ingredient getIngredientByName(String name);

    Ingredient getIngredientByType(String type);

    Ingredient createIngredient(Ingredient newIngredient);

}
