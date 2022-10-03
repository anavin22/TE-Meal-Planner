package com.techelevator.controller;

import com.techelevator.dao.*;
import com.techelevator.model.Ingredient;
import com.techelevator.model.Meal;
import com.techelevator.model.MealPlan;
import com.techelevator.model.UserMealPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
@PreAuthorize("isAuthenticated()")
public class MealPlanController {

    @Autowired
    private MealDao mealDao;
    private MealPlanDao mealPlanDao;
    private UserDao userDao;
    private IngredientDao ingredientDao;
    private UserMealPlanDao userMealPlanDao;

    public MealPlanController(MealDao mealDao, MealPlanDao mealPlanDao, UserDao userDao,
                              IngredientDao ingredientDao, UserMealPlanDao userMealPlanDao) {
        this.mealDao = mealDao;
        this.mealPlanDao = mealPlanDao;
        this.userDao = userDao;
        this.ingredientDao = ingredientDao;
        this.userMealPlanDao = userMealPlanDao;

    }

    //MEAL PLAN METHODS
    @PostMapping("/mealPlan")
    public MealPlan createMealPlan(Principal principal, @Valid @RequestBody MealPlan mealPlan) {
        int userId = userDao.findIdByUsername(principal.getName());
        return mealPlanDao.createMealPlan(mealPlan, userId);
    }

    @GetMapping("/mealPlan/{createdBy}")
    public List<MealPlan> getMealPlanByCreatedBy(@PathVariable int createdBy) {
        return mealPlanDao.getMealPlanByCreatedBy(createdBy);
    }

    @GetMapping("/mealPlan/detail/{mealPlanId}")
    public MealPlan getPlanById(@PathVariable int mealPlanId) {
        return mealPlanDao.getMealPlanByMealPlanId(mealPlanId);
    }


    @DeleteMapping("/mealPlan/{mealPlanId}")
    public void deleteMealPlan(@PathVariable int mealPlanId) {
        mealPlanDao.deleteMealPlan(mealPlanId);
    }

    @GetMapping("/mealPlan/{mealPlanId}/groceryList")
    public List<Ingredient> getAllIngredientsByMealPlanId(@PathVariable int mealPlanId) {
        return ingredientDao.getAllIngredientsByMealPlanId(mealPlanId);
    }

    //MEAL METHODS
    @PostMapping("/meal")
    public Meal createMeal(@RequestBody Meal meal) {
        return mealDao.createMeal(meal);
    }

    @PutMapping("/mealPlan/{mealId}")
    public void updateMealToMealPlan(@Valid @RequestBody Meal meal, @PathVariable int mealId, int mealPlanId) {
        mealDao.updateMealToMealPlan(meal, mealPlanId);
    }

    @DeleteMapping("/mealPlan/meal/{mealId}")
    public void removeMealFromMealPlan(@PathVariable int mealId) {
        mealDao.removeMealFromMealPlan(mealId);
    }

    //getMealByMealId
    //getAllMeals(?? not created yet)


    //USER MEAL PLAN METHODS
    @PostMapping("/userMealPlan")
    public UserMealPlan createUserMealPlan(Principal principal, @Valid @RequestBody UserMealPlan userMealPlan) {
        int userId = userDao.findIdByUsername(principal.getName());
        return userMealPlanDao.createUserMealPlan(userMealPlan, userId);
    }

    @GetMapping("/userMealPlan/{createdBy}")
    public List<UserMealPlan> getUserMealPlanByCreatedBy(@PathVariable int createdBy) {
        return userMealPlanDao.getUserMealPlanByCreatedBy(createdBy);
    }
}
