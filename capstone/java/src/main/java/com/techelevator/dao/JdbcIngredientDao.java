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

    public JdbcIngredientDao(JdbcTemplate jdbcTemplate) {
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
                "WHERE ingredient_recipe.recipe_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, ingredient);
        if (result.next()) {
            newIngredient = mapRowToIngredient(result);
        }
        return newIngredient;

    }

    @Override
    public Ingredient updateIngredient(Ingredient ingredient) {
        return null;
    }

    @Override //retry state in pgadmin
    public List<Ingredient> getAllIngredientsByRecipeId(int recipeId) {
        List<Ingredient> ingredientList = new ArrayList<>();
        String sql = "SELECT ingredient.ingredient_id, ingredient_name, quantity, unit FROM ingredient\n" +
                "JOIN ingredient_recipe ON ingredient.ingredient_id = ingredient_recipe.ingredient_id\n" +
                "WHERE ingredient_recipe.recipe_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, recipeId);
        while (result.next()) {
            ingredientList.add(mapRowToIngredient(result));
        }
        return ingredientList;
    }

    //need to connect tables to get all ingredients per meal plan to generate list of ingredients
    //didnt finish SELECT table - go from ingredients to meal-plan
    @Override
    public List<Ingredient> getAllIngredientsByMealPlanId(int mealPlanId) {
        List<Ingredient> groceryIngredientList = new ArrayList<>();
        String sql = "SELECT ingredient.ingredient_id, ingredient_name, quantity, unit  FROM ingredient " +
                "JOIN ingredient_recipe ON ingredient.ingredient_id = ingredient_recipe.ingredient_id " +
                "JOIN meal ON ingredient_recipe.recipe_id = meal.recipe_id " +
                "WHERE meal.meal_plan_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, mealPlanId);

        while(results.next()){
            groceryIngredientList.add(mapRowToIngredient(results));
        }
        return groceryIngredientList;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredientList = new ArrayList<>();
        String sql = "SELECT ingredient_name, ingredient_id FROM ingredient";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(results.getString("ingredient_name"));
            ingredient.setIngredientId(results.getInt("ingredient_id"));
            ingredientList.add(ingredient);
        }
        return ingredientList;
    }
    @Override
    public void checkIngredientAndCreateIfNonexistent(Ingredient ingredient) {

    }

    private Ingredient mapRowToIngredient(SqlRowSet result) {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(result.getInt("ingredient_id"));
        ingredient.setName(result.getString("ingredient_name"));
        //ingredient.setType(result.getString("ingredient_type"));
        ingredient.setQuantity(result.getDouble("quantity"));
        ingredient.setUnit(result.getString("unit"));
        return ingredient;
    }
}
