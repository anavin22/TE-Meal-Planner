package com.techelevator.dao;

import com.techelevator.model.MealPlan;

import java.util.List;

public interface MealPlanDao{

    MealPlan createMealPlan(MealPlan mealPlan);

    MealPlan createObjectCalledMealPlan(int mealPlanId);

    //how else would we update a meal plan???
    MealPlan updateMealPlan(MealPlan mealPlan);

    MealPlan deleteMealPlan(int MealPlanId);

    MealPlan getMealPlanByMealPlanId(int MealPlanId);

    List<MealPlan> getMealPlanByCreatedBy(int createdBy);
}
