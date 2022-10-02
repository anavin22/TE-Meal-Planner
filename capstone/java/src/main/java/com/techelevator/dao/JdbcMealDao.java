package com.techelevator.dao;

import com.techelevator.model.Meal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMealDao implements MealDao {

    JdbcTemplate jdbcTemplate;

    public JdbcMealDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Meal getMealByMealId(int mealId) {
       Meal meal = createObjectCalledMeal(mealId);
       return meal;
    }

    @Override
    public Meal createMeal(Meal meal) {
       String sql = "INSERT INTO meal (meal_plan_id, recipe_id, meal_type, day_of_week) " +
               "VALUES (?, ?, ?, ?) RETURNING meal_id";
       int newId = jdbcTemplate.queryForObject(sql, Integer.class, meal.getMealPlanId(),
               meal.getRecipeId(), meal.getMealType(), meal.getDayOfWeek());
        return getMealByMealId(newId);
    }

    @Override
    public Meal createObjectCalledMeal(int mealId) {
        Meal createdMeal = new Meal();
        createdMeal.setMealId(mealId);
        String sqlMealTable = "SELECT meal_plan_id, recipe_id, meal_type, day_of_week FROM meal WHERE meal_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlMealTable, mealId);
        if (result.next()) {
            createdMeal.setMealPlanId(result.getInt("meal_plan_id"));
            createdMeal.setRecipeId(result.getInt("recipe_id"));
            createdMeal.setMealType(result.getString("meal_type"));
            createdMeal.setDayOfWeek(result.getString("day_of_week"));
        }
        return createdMeal;
    }

    @Override
    public List<Meal> getAllMealsByMealPlanId(int mealPlanId) {
        List<Meal> mealList = new ArrayList<>();
        String sql = "SELECT meal_id, meal.meal_plan_id, recipe_id, meal_type, day_of_week FROM meal " +
                "JOIN meal_plan ON meal.meal_plan_id = meal_plan.meal_plan_id WHERE meal_plan.meal_plan_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, mealPlanId);
        while (results.next()) {
            mealList.add(mapRowToMeal(results));
        }
        return mealList;
    }

    @Override
    public Meal getMealByDayOfWeek() {
        return null;
    }

    @Override //assigns meal to meal plan
    public void updateMealToMealPlan(Meal meal, int mealPlanId) {
        String sql = "UPDATE meal SET meal_plan_id = ? WHERE meal_id = ?";
        jdbcTemplate.update(sql, mealPlanId, meal.getMealId());
    }

    @Override
    public void removeMealFromMealPlan(int mealId) {
        String sql = "DELETE FROM meal WHERE meal_id = ?";
    }

    private Meal mapRowToMeal(SqlRowSet result){
        Meal meal = new Meal();
        meal.setMealId(result.getInt("meal_id"));
        meal.setMealPlanId(result.getInt("meal_plan_id"));
        meal.setRecipeId(result.getInt("recipe_id"));
        meal.setMealType(result.getString("meal_type"));
        meal.setDayOfWeek(result.getString("day_of_week"));
        return meal;
    }
}
