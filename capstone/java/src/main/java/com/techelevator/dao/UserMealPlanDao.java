package com.techelevator.dao;

import com.techelevator.model.MealPlan;
import com.techelevator.model.UserMealPlan;

import java.util.List;

public interface UserMealPlanDao {

    UserMealPlan getUserMealPlanByCreatedBy(int createdBy);

    UserMealPlan getUserMealPlanByUserMealPlanId(int userPlanId);

    UserMealPlan createObjectCalledUserMealPlan(int userMealPlanId);

    UserMealPlan createUserMealPlan(int userMealPlanId);

    UserMealPlan updateUserMealPlan(UserMealPlan userMealPlan);
}
