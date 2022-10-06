package com.techelevator.dao;

import com.techelevator.model.MealPlan;
import com.techelevator.model.UserMealPlan;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface MealPlanDao{

    MealPlan createMealPlan(MealPlan mealPlan, int newId);

    MealPlan createObjectCalledMealPlan(int mealPlanId);

    public void deleteMealPlan(int MealPlanId);

    MealPlan getMealPlanByMealPlanId(int MealPlanId);

    List<MealPlan> getMealPlanByCreatedBy(@PathVariable int createdBy);

}
