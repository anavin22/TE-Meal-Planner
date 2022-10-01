package com.techelevator.controller;

import com.techelevator.dao.MealDao;
import com.techelevator.dao.MealPlanDao;
import com.techelevator.model.Meal;
import com.techelevator.model.MealPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping
@PreAuthorize("isAuthenticated()")
public class MealPlanController {

    @Autowired
    private MealDao mealDao;
    private MealPlanDao mealPlanDao;

    public MealPlanController(){};
    public MealPlanController(MealDao mealDao, MealPlanDao mealPlanDao) {
        this.mealDao = mealDao;
        this.mealPlanDao = mealPlanDao;
    }
        //MEAL PLAN METHODS
    @PostMapping("/mealPlan")
    public MealPlan createMealPlan(@Valid @RequestBody MealPlan mealPlan){
       return mealPlanDao.createMealPlan(mealPlan);
    }

    //MEAL METHODS
    @PutMapping("/mealPlan/{mealId}")
    public void updateMealToMealPlan(@Valid @RequestBody Meal meal, @PathVariable int mealId, int mealPlanId){
        mealDao.updateMealToMealPlan(meal, mealPlanId);
    }
}


//add meal to meal plan mealplan/
// creating a whole new meal --> mealplan/meal
//add meal to meal plan --> /mealplan/{mealId}