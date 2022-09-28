package com.techelevator.dao;

import com.techelevator.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRecipeDao implements RecipeDao {

    JdbcTemplate jdbcTemplate;
    JdbcIngredientDao jdbcIngredientDao;

    public JdbcRecipeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Recipe getRecipeByRecipeId(int id) {
        Recipe recipe = null;
        String sql = "SELECT id, created_by, recipe_name, recipe_img " +
                "FROM recipe WHERE id= ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if(result.next()){
            recipe = mapRowToRecipe(result);
        }
        return recipe;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipeList = new ArrayList<>();
        String sql = "SELECT id, created_by, recipe_name, recipe_img " +
                "FROM recipe";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            recipeList.add(mapRowToRecipe(results));
        }
        return recipeList;
    }

    @Override
    public Recipe getRecipeByName(String name) {
        Recipe recipe = null;
        String sql = "SELECT id, created_by, recipe_name, recipe_img " +
                "FROM recipe WHERE recipe_name = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, name);
         if(result.next()){
             recipe = mapRowToRecipe(result);
         }
         return recipe;

    }

    @Override
    public List<Recipe> getAllSavedRecipesByUserId(int id){
        List<Recipe> recipeList = new ArrayList<>();
        String sql = "SELECT id, created_by, recipe_name, recipe_img " +
                "FROM recipe " +
                "JOIN saved_recipe ON recipe.recipe_id = saved_recipe.recipe_id " +
                "JOIN ";
        return recipeList;
    }

    @Override
    public List<Recipe> getAllRecipesByCreatedBy(int createdBy) {
        return null;
    }

    @Override
    public Recipe createObjectCalledRecipe(Recipe newRecipe, int recipeId, String name) {
        newRecipe.setIngredientList(jdbcIngredientDao.getAllIngredientsByRecipeId(recipeId));
        newRecipe.setRecipeName(name);
        return newRecipe;
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        return null;
    }

    @Override
    public Recipe deleteRecipeById(int id) {
        return null;
    }
    private Recipe mapRowToRecipe(SqlRowSet result){
        Recipe recipe = new Recipe();
        recipe.setRecipeId(result.getInt("id"));
        recipe.setCreatedBy(result.getInt("created_by"));
        recipe.setRecipeName(result.getString("recipe_name"));
        recipe.setImage(result.getString("recipe_img"));
        return recipe;

    }
}
