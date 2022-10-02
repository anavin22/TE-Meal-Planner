package com.techelevator.dao;

import com.techelevator.model.MealPlan;

import java.util.List;

public interface MealPlanDao{

    MealPlan createMealPlan(MealPlan mealPlan, int newId);

    MealPlan createObjectCalledMealPlan(int mealPlanId);

    //how else would we update a meal plan???
    MealPlan updateMealPlan(MealPlan mealPlan);

    public void deleteMealPlan(int MealPlanId);

    MealPlan getMealPlanByMealPlanId(int MealPlanId);

    List<MealPlan> getMealPlanByCreatedBy(int createdBy);

}
