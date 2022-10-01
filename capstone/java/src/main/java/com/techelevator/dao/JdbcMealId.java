package com.techelevator.dao;

import com.techelevator.model.Meal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcMealId implements MealDao{

    JdbcTemplate jdbcTemplate;

    public JdbcMealId(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Meal getMealbyMealId(int id) {
        return null;
    }

    @Override
    public List<Meal> getAllMealsByMealPlanId(int mealId) {
        List<Meal> mealList = new ArrayList<>();
        String sql = "SELECT meal.meal_id, meal_plan_id, recipe_id, meal_type, day_of_week FROM meal " +
                "JOIN meal_plan ON meal.meal_id = meal_plan.meal_id WHERE meal_plan.meal_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, mealId);
        while(results.next()){
            mealList.add()
        }
    }

    @Override
    public Meal getMealByDayOfWeek() {
        return null;
    }
    private Meal mapRowToMeal(SqlRowSet result){
        Meal meal = new Meal();
        meal.setMealId(result.getInt("meal_id"));
        meal.setMealPlanId(result.getInt("meal_plan_id"));
        meal.setRecipeId(result.getInt("recipe_id"));
        meal.getMealType(result.getString("meal_type"));
        meal.getDayOfWeek(result.getString("day_of_week"));
        res
    }
}
