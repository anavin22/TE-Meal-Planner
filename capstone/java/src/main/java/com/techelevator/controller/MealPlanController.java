package com.techelevator.controller;

import com.techelevator.dao.MealDao;
import com.techelevator.dao.MealPlanDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Meal;
import com.techelevator.model.MealPlan;
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

    public MealPlanController(MealDao mealDao, MealPlanDao mealPlanDao, UserDao userDao) {
        this.mealDao = mealDao;
        this.mealPlanDao = mealPlanDao;
        this.userDao = userDao;

    }
        //MEAL PLAN METHODS
    @PostMapping("/mealPlan")
    public MealPlan createMealPlan(Principal principal, @Valid @RequestBody MealPlan mealPlan){
        int userId = userDao.findIdByUsername(principal.getName());
       return mealPlanDao.createMealPlan(mealPlan, userId);
    }
    @GetMapping("/mealPlan/{createdBy}")
    public List<MealPlan> getMealPlanByCreatedBy(@PathVariable int createdBy){
       return mealPlanDao.getMealPlanByCreatedBy(createdBy);

    }
    @DeleteMapping("/mealPlan/{mealPlanId}")
    public void deleteMealPlan(@PathVariable int mealPlanId){
        mealPlanDao.deleteMealPlan(mealPlanId);
    }
    //MEAL METHODS
    @PutMapping("/mealPlan/{mealId}")
    public void updateMealToMealPlan(@Valid @RequestBody Meal meal, @PathVariable int mealId, int mealPlanId){
        mealDao.updateMealToMealPlan(meal, mealPlanId);
    }

}
