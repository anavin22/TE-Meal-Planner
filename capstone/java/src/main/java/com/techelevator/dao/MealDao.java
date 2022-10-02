package com.techelevator.dao;

import com.techelevator.model.Meal;

import java.util.List;

public interface MealDao {

    Meal getMealByMealId(int mealId);

    Meal createMeal(Meal meal);

    Meal createObjectCalledMeal(int mealId);

    List<Meal> getAllMealsByMealPlanId(int mealPlanId);

    Meal getMealByDayOfWeek();

   void updateMealToMealPlan(Meal meal, int mealPlanId);

    void removeMealFromMealPlan(int mealId);

    //getAllMeals -- do we neeed this??

}
