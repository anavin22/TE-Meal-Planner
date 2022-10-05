package com.techelevator.dao;

import com.techelevator.model.MealPlan;
import com.techelevator.model.UserMealPlan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserMealPlanDao implements UserMealPlanDao {

    JdbcTemplate jdbcTemplate;

    public JdbcUserMealPlanDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserMealPlan getUserMealPlanByCreatedBy(int createdBy){
        String sql = "SELECT user_meal_plan_id, created_by, monday_breakfast, monday_lunch, monday_dinner, monday_other, tuesday_breakfast, tuesday_lunch, " +
                "tuesday_dinner, tuesday_other, wednesday_breakfast, wednesday_lunch, wednesday_dinner, wednesday_other, thursday_breakfast, thursday_lunch, " +
                "thursday_dinner, thursday_other, friday_breakfast, friday_lunch, friday_dinner, friday_other, saturday_breakfast, saturday_lunch, " +
                "saturday_dinner, saturday_other, sunday_breakfast, sunday_lunch, sunday_dinner, sunday_other FROM user_meal_plan WHERE created_by = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, createdBy);
        if(result.next()){
           return mapRowToUserMealPlan(result);
        } else {
            return createUserMealPlan(createdBy);
        }
    }

    @Override
    public UserMealPlan getUserMealPlanByUserMealPlanId(int userMealPlanId) {
       UserMealPlan userMealPlan = createObjectCalledUserMealPlan(userMealPlanId);
       return userMealPlan;
    }

    @Override
    public UserMealPlan createObjectCalledUserMealPlan(int userMealPlanId) {
        UserMealPlan createdUserMealPlan = new UserMealPlan();
        createdUserMealPlan.setUserMealPlanId(userMealPlanId);
        String sqlUserMealPlanTable = "SELECT created_by, monday_breakfast, monday_lunch, monday_dinner, monday_other, tuesday_breakfast, tuesday_lunch, " +
                "tuesday_dinner, tuesday_other, wednesday_breakfast, wednesday_lunch, wednesday_dinner, wednesday_other, thursday_breakfast, thursday_lunch, " +
                "thursday_dinner, thursday_other, friday_breakfast, friday_lunch, friday_dinner, friday_other, saturday_breakfast, saturday_lunch, " +
                "saturday_dinner, saturday_other, sunday_breakfast, sunday_lunch, sunday_dinner, sunday_other FROM user_meal_plan WHERE user_meal_plan_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlUserMealPlanTable, userMealPlanId);
        while (result.next()) {
            createdUserMealPlan = mapRowToUserMealPlan(result);
        }
        return createdUserMealPlan;
        }

        @Override
        public UserMealPlan createUserMealPlan (int userId) {
            String sql = "INSERT INTO user_meal_plan (created_by) VALUES (?) RETURNING user_meal_plan_id;";
            int newId = jdbcTemplate.queryForObject(sql, Integer.class, userId);


//            String sql = "INSERT INTO user_meal_plan (created_by, monday_breakfast, monday_lunch, monday_dinner, monday_other, " +
//                    "tuesday_breakfast, tuesday_lunch, tuesday_dinner, tuesday_other, wednesday_breakfast, wednesday_lunch, " +
//                    "wednesday_dinner, wednesday_other, thursday_breakfast, thursday_lunch, thursday_dinner, thursday_other, " +
//                    "friday_breakfast, friday_lunch, friday_dinner, friday_other, saturday_breakfast, saturday_lunch, saturday_dinner, " +
//                    "saturday_other, sunday_breakfast, sunday_lunch, sunday_dinner, sunday_other) RETURNING user_meal_plan_id" +
//                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            int newId = jdbcTemplate.queryForObject(sql, Integer.class, userId,
//                    userMealPlan.getMondayBreakfast(),
//                    userMealPlan.getMondayLunch(),
//                    userMealPlan.getMondayDinner(),
//                    userMealPlan.getMondayOther(),
//                    userMealPlan.getTuesdayBreakfast(),
//                    userMealPlan.getTuesdayLunch(),
//                    userMealPlan.getTuesdayDinner(),
//                    userMealPlan.getTuesdayOther(),
//                    userMealPlan.getWednesdayBreakfast(),
//                    userMealPlan.getWednesdayLunch(),
//                    userMealPlan.getWednesdayDinner(),
//                    userMealPlan.getWednesdayOther(),
//                    userMealPlan.getThursdayBreakfast(),
//                    userMealPlan.getThursdayLunch(),
//                    userMealPlan.getThursdayDinner(),
//                    userMealPlan.getThursdayOther(),
//                    userMealPlan.getFridayBreakfast(),
//                    userMealPlan.getFridayLunch(),
//                    userMealPlan.getFridayDinner(),
//                    userMealPlan.getFridayOther(),
//                    userMealPlan.getSaturdayBreakfast(),
//                    userMealPlan.getSaturdayLunch(),
//                    userMealPlan.getSaturdayDinner(),
//                    userMealPlan.getSaturdayOther(),
//                    userMealPlan.getSundayBreakfast(),
//                    userMealPlan.getSundayLunch(),
//                    userMealPlan.getSundayDinner(),
//                    userMealPlan.getSundayOther());

//            return getUserMealPlanByUserMealPlanId(newId);
            return getUserMealPlanByCreatedBy(userId);

    }

    @Override
    public UserMealPlan updateUserMealPlan(UserMealPlan userMealPlan) {
        String sql = "UPDATE user_meal_plan " +
                "SET monday_breakfast = ?, monday_lunch = ?, monday_dinner = ?, monday_other = ?, " +
                "tuesday_breakfast = ?, tuesday_lunch = ?, tuesday_dinner = ?, tuesday_other = ?, " +
                "wednesday_breakfast = ?, wednesday_lunch = ?, wednesday_dinner = ?, wednesday_other = ?, " +
                "thursday_breakfast = ?, thursday_lunch = ?, thursday_dinner = ?, thursday_other = ?, " +
                "friday_breakfast = ?, friday_lunch = ?, friday_dinner = ?, friday_other = ?, " +
                "saturday_breakfast = ?, saturday_lunch = ?, saturday_dinner = ?, saturday_other = ?, " +
                "sunday_breakfast = ?, sunday_lunch =  ?, sunday_dinner = ?, sunday_other = ?";
        jdbcTemplate.update(sql, userMealPlan.getMondayBreakfast(),
                userMealPlan.getMondayLunch(),
                userMealPlan.getMondayDinner(),
                userMealPlan.getMondayOther(),
                userMealPlan.getTuesdayBreakfast(),
                userMealPlan.getTuesdayLunch(),
                userMealPlan.getTuesdayDinner(),
                userMealPlan.getTuesdayOther(),
                userMealPlan.getWednesdayBreakfast(),
                userMealPlan.getWednesdayLunch(),
                userMealPlan.getWednesdayDinner(),
                userMealPlan.getWednesdayOther(),
                userMealPlan.getThursdayBreakfast(),
                userMealPlan.getThursdayLunch(),
                userMealPlan.getThursdayDinner(),
                userMealPlan.getThursdayOther(),
                userMealPlan.getFridayBreakfast(),
                userMealPlan.getFridayLunch(),
                userMealPlan.getFridayDinner(),
                userMealPlan.getFridayOther(),
                userMealPlan.getSaturdayBreakfast(),
                userMealPlan.getSaturdayLunch(),
                userMealPlan.getSaturdayDinner(),
                userMealPlan.getSaturdayOther(),
                userMealPlan.getSundayBreakfast(),
                userMealPlan.getSundayLunch(),
                userMealPlan.getSundayDinner(),
                userMealPlan.getSundayOther());
        return userMealPlan;
    }



    private UserMealPlan mapRowToUserMealPlan(SqlRowSet result){
        UserMealPlan userMealPlan = new UserMealPlan();
        userMealPlan.setUserMealPlanId(result.getInt("user_meal_plan_id"));
        userMealPlan.setCreatedBy(result.getInt("created_by"));
        userMealPlan.setMondayBreakfast(result.getInt("monday_breakfast"));
        userMealPlan.setMondayLunch(result.getInt("monday_lunch"));
        userMealPlan.setMondayDinner(result.getInt("monday_dinner"));
        userMealPlan.setMondayOther(result.getInt("monday_other"));
        userMealPlan.setTuesdayBreakfast(result.getInt("tuesday_breakfast"));
        userMealPlan.setTuesdayLunch(result.getInt("tuesday_lunch"));
        userMealPlan.setTuesdayDinner(result.getInt("tuesday_dinner"));
        userMealPlan.setTuesdayOther(result.getInt("tuesday_other"));
        userMealPlan.setWednesdayBreakfast(result.getInt("wednesday_breakfast"));
        userMealPlan.setWednesdayLunch(result.getInt("wednesday_lunch"));
        userMealPlan.setWednesdayDinner(result.getInt("wednesday_dinner"));
        userMealPlan.setWednesdayOther(result.getInt("wednesday_other"));
        userMealPlan.setThursdayBreakfast(result.getInt("thursday_breakfast"));
        userMealPlan.setThursdayLunch(result.getInt("thursday_lunch"));
        userMealPlan.setThursdayDinner(result.getInt("thursday_dinner"));
        userMealPlan.setThursdayOther(result.getInt("thursday_other"));
        userMealPlan.setFridayBreakfast(result.getInt("friday_breakfast"));
        userMealPlan.setFridayLunch(result.getInt("friday_lunch"));
        userMealPlan.setFridayDinner(result.getInt("friday_dinner"));
        userMealPlan.setFridayOther(result.getInt("friday_other"));
        userMealPlan.setSaturdayBreakfast(result.getInt("saturday_breakfast"));
        userMealPlan.setSaturdayLunch(result.getInt("saturday_lunch"));
        userMealPlan.setSaturdayDinner(result.getInt("saturday_dinner"));
        userMealPlan.setSaturdayOther(result.getInt("saturday_other"));
        userMealPlan.setSundayBreakfast(result.getInt("sunday_breakfast"));
        userMealPlan.setSundayLunch(result.getInt("sunday_lunch"));
        userMealPlan.setSundayDinner(result.getInt("sunday_dinner"));
        userMealPlan.setSundayOther(result.getInt("sunday_other"));
        return userMealPlan;
    }
}
