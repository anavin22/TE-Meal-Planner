package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.UserMealPlan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class JdbcIngredientDao implements IngredientDao {
    JdbcTemplate jdbcTemplate;
    UserMealPlanDao userMealPlanDao;

    public JdbcIngredientDao(JdbcTemplate jdbcTemplate, UserMealPlanDao userMealPlanDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userMealPlanDao = userMealPlanDao;
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

//change input to getting all ing by user whom created the mealplan
    //JOIN recipe ON recipe.recipe_id = ingredient_recipe.recipe_id
    //JOIN user_meal_plan ON user_meal_plan.createdBy = recipe.createdBy
    //WHERE user_meal_plan_id = ?
    //
    @Override
    public List<Ingredient> getAllIngredientsByUserMealPlanId(int userMealPlanId) {
        List<Ingredient> groceryIngredientList = new ArrayList<>();
        String sql = "SELECT ingredient.ingredient_id, ingredient_name, quantity, unit  FROM ingredient " +
                "JOIN ingredient_recipe ON ingredient.ingredient_id = ingredient_recipe.ingredient_id " +
                "JOIN recipe ON recipe.recipe_id = ingredient_recipe.recipe_id " +
                "JOIN user_meal_plan ON user_meal_plan.created_by = recipe.created_by " +
                "WHERE user_meal_plan.user_meal_plan_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userMealPlanId);

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
    //calls back all ingredients associated with a createdBy h/ever we will only use this method if user_meal_plan == 1;
    @Override
    public List<Ingredient> getAllIngredientsForMealPlanByUserId(int userId) {
        List<Ingredient> groceryIngredientList = new ArrayList<>();
        String sql = "SELECT ingredient.ingredient_id, ingredient_name, quantity, unit, recipe.recipe_id FROM ingredient " +
                "JOIN ingredient_recipe ON ingredient.ingredient_id = ingredient_recipe.ingredient_id " +
                "JOIN recipe ON recipe.recipe_id = ingredient_recipe.recipe_id " +
                "JOIN user_meal_plan ON user_meal_plan.created_by = recipe.created_by " +
                "WHERE user_meal_plan.created_by = ? ORDER BY ingredient_name ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while(results.next()){
            groceryIngredientList.add(mapRowToIngredient(results));
        }
        return groceryIngredientList;
    }

    @Override
    public void checkIngredientAndCreateIfNonexistent(Ingredient ingredient) {

    }

    @Override
    public List<Ingredient> getAllIngredientsForRecipesByUserMealPlan(int userId) {
        UserMealPlan userMealPlan = userMealPlanDao.getUserMealPlanByCreatedBy(userId);
        List<Integer> recipeIds = new ArrayList<>();
        recipeIds.add(userMealPlan.getMondayBreakfast());
        recipeIds.add(userMealPlan.getMondayLunch());
        recipeIds.add(userMealPlan.getMondayDinner());
        recipeIds.add(userMealPlan.getMondayOther());
        recipeIds.add(userMealPlan.getTuesdayBreakfast());
        recipeIds.add(userMealPlan.getTuesdayLunch());
        recipeIds.add(userMealPlan.getTuesdayDinner());
        recipeIds.add(userMealPlan.getTuesdayOther());
        recipeIds.add(userMealPlan.getWednesdayBreakfast());
        recipeIds.add(userMealPlan.getWednesdayLunch());
        recipeIds.add(userMealPlan.getWednesdayDinner());
        recipeIds.add(userMealPlan.getWednesdayOther());
        recipeIds.add(userMealPlan.getThursdayBreakfast());
        recipeIds.add(userMealPlan.getThursdayLunch());
        recipeIds.add(userMealPlan.getThursdayDinner());
        recipeIds.add(userMealPlan.getThursdayOther());
        recipeIds.add(userMealPlan.getFridayBreakfast());
        recipeIds.add(userMealPlan.getFridayLunch());
        recipeIds.add(userMealPlan.getFridayDinner());
        recipeIds.add(userMealPlan.getFridayOther());
        recipeIds.add(userMealPlan.getSaturdayBreakfast());
        recipeIds.add(userMealPlan.getSaturdayLunch());
        recipeIds.add(userMealPlan.getSaturdayDinner());
        recipeIds.add(userMealPlan.getSaturdayOther());
        recipeIds.add(userMealPlan.getSundayBreakfast());
        recipeIds.add(userMealPlan.getSundayLunch());
        recipeIds.add(userMealPlan.getSundayDinner());
        recipeIds.add(userMealPlan.getSundayOther());

        List<Ingredient> ingredientList = new ArrayList<>();
        for(int recipe : recipeIds){
            List<Ingredient> temp = getAllIngredientsByRecipeId(recipe);
            for(Ingredient eachIngredient : temp){
                ingredientList.add(eachIngredient);

            }
        }
        Collections.sort(ingredientList, new Comparator<Ingredient>() {
            @Override
            public int compare(Ingredient o1, Ingredient o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
                return ingredientList;
    }

    private Ingredient mapRowToIngredient(SqlRowSet result) {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientId(result.getInt("ingredient_id"));
        ingredient.setName(result.getString("ingredient_name"));
        ingredient.setQuantity(result.getDouble("quantity"));
        ingredient.setUnit(result.getString("unit"));
        return ingredient;
    }
}
