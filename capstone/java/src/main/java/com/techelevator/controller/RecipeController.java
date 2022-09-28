package com.techelevator.controller;

import com.techelevator.dao.RecipeDao;
import com.techelevator.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
@PreAuthorize("isAuthenticated()")
public class RecipeController {

    @Autowired
    private RecipeDao recipeDao;

    public RecipeController(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    @GetMapping("/recipes/detail/{id}")
    public Recipe getRecipeByRecipeId(@PathVariable int id) {
        return recipeDao.getRecipeByRecipeId(id);
    }

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes() {
        return recipeDao.getAllRecipes();
    }

    @GetMapping("/recipes/{name}")
    public Recipe getRecipeByName(@PathVariable String name) {
        return recipeDao.getRecipeByName(name);
    }
    //getting list of all recipes created by a single user
    @GetMapping("/recipes/{createdBy}")
    public List<Recipe> getRecipeByCreatedBy(@PathVariable int createdBy){
        return recipeDao.getAllRecipesByCreatedBy(createdBy);
    }
    @GetMapping("/recipes/latest")
    public List<Recipe> getLatestRecipes(){
        return recipeDao.getLatestRecipes();
    }


}
