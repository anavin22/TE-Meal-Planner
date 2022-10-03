package com.techelevator.dao;

import com.techelevator.model.MealPlan;

import java.util.List;

public interface MealPlanDao{

    MealPlan createMealPlan(MealPlan mealPlan, int newId);

    MealPlan createObjectCalledMealPlan(int mealPlanId);

    public void deleteMealPlan(int MealPlanId);

    MealPlan getMealPlanByMealPlanId(int MealPlanId);

    List<MealPlan> getMealPlanByCreatedBy(int createdBy);



}
