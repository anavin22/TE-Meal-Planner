package com.techelevator.dao;

import com.techelevator.model.Meal;
import com.techelevator.model.MealPlan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcMealPlanDao implements MealPlanDao{

    JdbcTemplate jdbcTemplate;
    MealDao mealDao;

    public JdbcMealPlanDao(JdbcTemplate jdbcTemplate, MealDao mealDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.mealDao = mealDao;
    }

    @Override
    public MealPlan createMealPlan(MealPlan mealPlan) {
//        String sql = "INSERT INTO meal_plan (created_by, title) VALUES (?, ?) RETURNING meal_plan_id = ?)";
//        int newId = jdbcTemplate.queryForObject(sql, mealPlan.getCreatedBy(), mealPlan.getTitle(), mealPlan.getMealPlanId());
//        return getMealPlanByMealPlanId(newId);
        //waiting to complete below method
    }

    @Override
    public MealPlan createObjectCalledMealPlan(int mealPlanId) {
        MealPlan createdMealPlan = new MealPlan();
        createdMealPlan.setMealPlanId(mealPlanId);
        String sqlMealPlanTable = "SELECT created_by, title FROM meal_plan WHERE meal_plan_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlMealPlanTable, mealPlanId);
        if(result.next()){
            createdMealPlan.setCreatedBy(result.getInt("created_by"));
            createdMealPlan.setTitle(result.getString("title"));
        }
        createdMealPlan.getMealList(mealDao.getAllMealsByMealId(mealPlanId));
    }

    @Override
    public MealPlan updateMealPlan(MealPlan mealPlan) {
        return null;
    }

    @Override
    public MealPlan deleteMealPlan(int MealPlanId) {
        return null;
    }

    @Override
    public MealPlan getMealPlanByMealPlanId(int MealPlanId) {
        return null;
    }

    @Override
    public List<MealPlan> getAllMealPlans() {
        return null;
    }

    @Override
    public List<MealPlan> getAllMealPlansByCreatedBy(int MealPlanId) {
        return null;
    }

    private MealPlan mapRowToMealPlan(SqlRowSet result){
        MealPlan mealPlan = new MealPlan();
        mealPlan.setMealPlanId(result.getInt("meal_plan_id"));
        mealPlan.setCreatedBy(result.getInt("created_by"));
        mealPlan.setTitle(result.getString("title"));
        return mealPlan;
    }
}
