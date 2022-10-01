package com.techelevator.dao;

import com.techelevator.model.Meal;

import java.util.List;

public interface MealDao {

    Meal getMealbyMealId(int id);

    List<Meal> getAllMealsByMealId(int mealId);

    Meal getMealByDayOfWeek();

}
