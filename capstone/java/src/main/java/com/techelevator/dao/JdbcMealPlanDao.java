package com.techelevator.dao;

import com.techelevator.model.Meal;
import com.techelevator.model.MealPlan;
import com.techelevator.model.UserMealPlan;
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
    public MealPlan createMealPlan(MealPlan mealPlan, int userId) {
        String sql = "INSERT INTO meal_plan (created_by, title) VALUES (?, ?) RETURNING meal_plan_id";
        int newId = jdbcTemplate.queryForObject(sql, Integer.class, mealPlan.getTitle());
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
    public void deleteMealPlan(int mealPlanId) {
        String sql = "BEGIN TRANSACTION; DELETE FROM meal WHERE meal_plan_id = ?; DELETE FROM meal_plan WHERE meal_plan_id = ?; COMMIT;";
        jdbcTemplate.update(sql, mealPlanId, mealPlanId);
    }

    @Override
    public MealPlan getMealPlanByMealPlanId(int mealPlanId) {
        MealPlan mealPlan = createObjectCalledMealPlan(mealPlanId);
        return mealPlan;
    }

    @Override
    public List<MealPlan> getMealPlanByCreatedBy(int createdBy) {
        List<MealPlan> mealPlanList = new ArrayList<>();
        String sql = "SELECT meal_plan_id FROM meal_plan WHERE created_by = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, createdBy);
        while (results.next()) {
            mealPlanList.add(createObjectCalledMealPlan(results.getInt("meal_plan_id")));
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
