package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcIngredientDao implements IngredientDao {
     JdbcTemplate jdbcTemplate;
     public JdbcIngredientDao(JdbcTemplate jdbcTemplate){
         this.jdbcTemplate = jdbcTemplate;
     }

    @Override
    public Ingredient getIngredientById(int id) {
        return null;
    }

    @Override
    public Ingredient getIngredientByName(String name) {
        return null;
    }

    @Override
    public Ingredient getIngredientByType(String type) {
        return null;

    }

    @Override
    public Ingredient createIngredient(Ingredient ingredient) {
         Ingredient newIngredient = new Ingredient();
         String sql = "SELECT ingredient_id, name, type, quantity, unit " +
                 "FROM ingredient JOIN ingredient_recipe ON ingredient.ingredient_id = ingredient_recipe.ingredient_id " +
                 "JOIN unit ON ingredient_recipe.unit_id = unit.unit_id " +
                 "WHERE ingredient_recipe.recipe_id = ?";
         SqlRowSet result = jdbcTemplate.queryForRowSet(sql, ingredient);
         if(result.next()){
             newIngredient = mapRowToIngredient(result);
         }
         return newIngredient;

    }

    @Override
    public Ingredient updateIngredient(Ingredient ingredient) {
        return null;
    }

    @Override
    public List<Ingredient> getAllIngredientsByRecipeId(int recipeId) {
         List<Ingredient> ingredientList = new ArrayList<>();
         String sql = "SELECT ingredient_id, name, type, quantity, unit " +
                "FROM ingredient JOIN ingredient_recipe ON ingredient.ingredient_id = ingredient_recipe.ingredient_id " +
                "JOIN unit ON ingredient_recipe.unit_id = unit.unit_id " +
                "WHERE ingredient_recipe.recipe_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, recipeId);
        while(result.next()){
            ingredientList.add(mapRowToIngredient(result));
        }
        return  ingredientList;
    }

    private Ingredient mapRowToIngredient(SqlRowSet result){
         Ingredient ingredient = new Ingredient();
         ingredient.setIngredientId(result.getInt("ingredient_id"));
         ingredient.setName(result.getString("ingredient_name"));
         ingredient.setType(result.getString("ingredient_type"));
         ingredient.setQuantity(result.getDouble("quantity"));
         ingredient.setUnit(result.getDouble("unit"));
        return ingredient;
     }
}
