package com.techelevator.dao;

import com.techelevator.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcRecipeDao implements RecipeDao {
    @Override
    public Recipe getRecipeByRecipeId(int id) {
        return null;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return null;
    }

    @Override
    public Recipe getRecipeByName(String name) {
        return null;
    }

    @Override
    public List<Recipe> getAllRecipesByCreatedBy(int createdBy) {
        return null;
    }

    @Override
    public Recipe createRecipe(Recipe newRecipe) {
        return null;
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        return null;
    }

    @Override
    public Recipe deleteRecipeById(int id) {
        return null;
    }
}
