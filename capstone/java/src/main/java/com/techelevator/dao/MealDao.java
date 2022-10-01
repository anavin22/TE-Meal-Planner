package com.techelevator.dao;

import com.techelevator.model.Meal;

import java.util.List;

public interface MealDao {

    Meal getMealbyMealId(int id);

    List<Meal> getAllMealsByMealPlanId(int mealPlanId);

    Meal getMealByDayOfWeek();

   void updateMealToMealPlan(Meal meal, int mealPlanId);

    Meal removeMealFromMealPlan();



}
