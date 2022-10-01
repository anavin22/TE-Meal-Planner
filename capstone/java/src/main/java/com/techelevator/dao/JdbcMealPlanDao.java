package com.techelevator.dao;

import com.techelevator.model.Meal;
import com.techelevator.model.MealPlan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMealPlanDao implements MealPlanDao{

    JdbcTemplate jdbcTemplate;
    MealDao mealDao;

    public JdbcMealPlanDao(JdbcTemplate jdbcTemplate, MealDao mealDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.mealDao = mealDao;
    }

    @Override
    public MealPlan createMealPlan(MealPlan mealPlan) {
        String sql = "INSERT INTO meal_plan (created_by, title) VALUES (?, ?) RETURNING meal_plan_id = ?)";
        int newId = jdbcTemplate.queryForObject(sql, Integer.class, mealPlan.getCreatedBy(), mealPlan.getTitle(), mealPlan.getMealPlanId());
        return getMealPlanByMealPlanId(newId);
    }

    @Override
    public MealPlan createObjectCalledMealPlan(int mealPlanId) {
        MealPlan createdMealPlan = new MealPlan();
        createdMealPlan.setMealPlanId(mealPlanId);
        String sqlMealPlanTable = "SELECT created_by, title FROM meal_plan WHERE meal_plan_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlMealPlanTable, mealPlanId);
        if (result.next()) {
            createdMealPlan.setCreatedBy(result.getInt("created_by"));
            createdMealPlan.setTitle(result.getString("title"));
            createdMealPlan.setMealList(mealDao.getAllMealsByMealPlanId(mealPlanId));
        }
        return createdMealPlan;
    }
    @Override
    public MealPlan updateMealPlan(MealPlan mealPlan) {
       return null; //not yet
    }

    @Override
    public MealPlan deleteMealPlan(int MealPlanId) {
        return null; //not yet
    }

    @Override
    public MealPlan getMealPlanByMealPlanId(int mealPlanId) {
        MealPlan mealPlan = createObjectCalledMealPlan(mealPlanId);
        return mealPlan;
    }

    @Override
    public List<MealPlan> getMealPlanByCreatedBy(int createdBy) {
        List<MealPlan> mealPlanList = new ArrayList<>();
        String sql = "SELECT meal_plan_id FROM meal_plan WHERE createdBy = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, createdBy);
        while(results.next()){
            mealPlanList.add(createObjectCalledMealPlan(results.getInt("created_by")));
        }
        return mealPlanList;
    }

    private MealPlan mapRowToMealPlan(SqlRowSet result){
        MealPlan mealPlan = new MealPlan();
        mealPlan.setMealPlanId(result.getInt("meal_plan_id"));
        mealPlan.setCreatedBy(result.getInt("created_by"));
        mealPlan.setTitle(result.getString("title"));
        return mealPlan;
    }
}
