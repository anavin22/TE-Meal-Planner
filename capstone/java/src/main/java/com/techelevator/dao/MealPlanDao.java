package com.techelevator.dao;

import com.techelevator.model.MealPlan;

import java.util.List;

public interface MealPlanDao{

//    //updates DB with mealplan info
//    MealPlan createMealPlan(MealPlan mealPlan);


    MealPlan createMealPlan(MealPlan mealPlan);

    MealPlan createObjectCalledMealPlan(int mealPlanId);

    MealPlan updateMealPlan(MealPlan mealPlan);

    MealPlan deleteMealPlan(int MealPlanId);

    MealPlan getMealPlanByMealPlanId(int MealPlanId);

    List<MealPlan> getAllMealPlans();

    List<MealPlan> getAllMealPlansByCreatedBy(int MealPlanId);
}
