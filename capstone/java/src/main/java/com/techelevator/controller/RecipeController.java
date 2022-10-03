package com.techelevator.controller;

import com.techelevator.dao.*;
import com.techelevator.model.Ingredient;
import com.techelevator.model.Instructions;
import com.techelevator.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
@PreAuthorize("isAuthenticated()")
public class RecipeController {

    @Autowired
    private RecipeDao recipeDao;
    private UserDao userDao;
    private RecipeBuilderDao recipeBuilderDao;
    private IngredientDao ingredientDao;

    public RecipeController(RecipeDao recipeDao, UserDao userDao, RecipeBuilderDao recipeBuilderDao, IngredientDao ingredientDao) {
        this.recipeDao = recipeDao;
        this.userDao = userDao;
        this.recipeBuilderDao = recipeBuilderDao;
        this.ingredientDao = ingredientDao;
    }

    @GetMapping("/recipes/detail/{id}")
    public Recipe getRecipeByRecipeId(@PathVariable int id) {
        return recipeDao.getRecipeByRecipeId(id);
    }

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes() {
        return recipeDao.getAllRecipes();
    }

    //getting list of all recipes created by a single user
    @GetMapping("/recipes/{createdBy}")
    public List<Recipe> getRecipeByCreatedBy(@PathVariable int createdBy) {
        return recipeDao.getAllRecipesByCreatedBy(createdBy);
    }

    @GetMapping("/recipes/latest")
    public List<Recipe> getLatestRecipes() {
        return recipeDao.getLatestRecipes();
    }

    @GetMapping("/recipes/favorites")
    public List<Recipe> getAllSavedRecipesByUserId(Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        return recipeDao.getAllSavedRecipesByUserId(userId);
    }

    @PostMapping("/recipes/favorites")
    public void putARecipeIntoSavedRecipes(Principal principal, @RequestBody Recipe recipe) {
        int userId = userDao.findIdByUsername(principal.getName());
        recipeDao.putARecipeIntoSavedRecipes(userId, recipe);
    }

    @PutMapping("/recipes/favorites")
    public void updateRecipetoRecipeDB(Principal principal, @RequestBody Recipe recipe) {
        int userId = userDao.findIdByUsername(principal.getName());
        recipeBuilderDao.updateRecipeToRecipeDB(recipe, userId);
    }

    @DeleteMapping("/recipes/favorites/{recipeId}")
    public int removeRecipeFromSavedRecipes(Principal principal, @PathVariable int recipeId) {
        int userId = userDao.findIdByUsername(principal.getName());
        int success = recipeDao.removeARecipeFromSavedRecipes(userId, recipeId);
        return success;
    }

    @DeleteMapping("/recipes/{id}")
    public void deleteRecipe(@PathVariable int recipeId) {
        recipeDao.deleteRecipeById(recipeId);
    }

    @GetMapping("/favoritelist")
    public List<Integer> getListOfFavoriteRecipeIdsByUserId(Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        return recipeDao.getListOfFavoriteRecipeIdsByUserId(userId);
    }

    @PostMapping("/recipes")
    public int addRecipeToRecipeDB(Principal principal, @Valid @RequestBody Recipe recipe) {
        int userId = userDao.findIdByUsername(principal.getName());
        return recipeBuilderDao.addRecipeToRecipeDB(recipe.getRecipeName(), recipe.getImage(), userId);
    }

    @PostMapping("/ingredient")
    public int addIngredientToDB(@Valid @RequestBody Ingredient ingredient) {
        return recipeBuilderDao.addIngredientToDB(ingredient);
    }

    @PostMapping("/recipes/ingredientList")
    public void addIngredientToRecipe(@Valid @RequestBody Recipe recipe) {
        List<Ingredient> ingredientList = recipe.getIngredientList();
        for (Ingredient eachIngredient : ingredientList) {
            recipeBuilderDao.addIngredientToRecipe(eachIngredient.getIngredientId(), recipe.getRecipeId(),
                    eachIngredient.getQuantity(), eachIngredient.getUnit());
        }
    }

    @PostMapping("/recipes/ingredient")
    public void addIngredientToIngredientRecipeTable(@Valid @RequestBody Ingredient ingredient) {
        recipeBuilderDao.addIngredientToRecipe(ingredient.getIngredientId(), ingredient.getRecipeId(), ingredient.getQuantity(), ingredient.getUnit());
    }

    @DeleteMapping("/recipes/{recipeId}/ingredient/{ingredientId}")
    public void removeIngredientFromRecipe(@PathVariable int recipeId, @PathVariable int ingredientId) {
        recipeBuilderDao.removeIngredientFromRecipe(ingredientId, recipeId);
    }

    @PostMapping("/recipes/instruction")
    public int addInstructionToRecipe(@Valid @RequestBody Instructions instructions) {
        return recipeBuilderDao.addInstructionToRecipe(instructions);
    }

    @DeleteMapping("/instruction/{instructionId}")
    public void removeInstructionFromRecipe(@PathVariable int instructionId) {
        recipeBuilderDao.removeInstructionFromRecipe(instructionId);
    }

    @PutMapping("/recipes/ingredient")
    public void updateIngredientQuantityToRecipe(@RequestBody Ingredient ingredient) {
        recipeBuilderDao.updateIngredientQuantityToRecipe(ingredient, ingredient.getRecipeId());
    }
    @GetMapping("/ingredient")
    public List<Ingredient> getAllIngredients(){
        return ingredientDao.getAllIngredients();
    }

    @PutMapping("/instruction/{instructionId}")
    public void updateInstructionsToRecipe(@RequestBody Instructions instructions, @PathVariable int instructionId){
        recipeBuilderDao.updateInstructionsToRecipe(instructions, instructionId);
    }

    @GetMapping("recipes/{recipeId}/instruction")
    public List<Instructions> getInstructionsByRecipe(@PathVariable int recipeId) {
        return recipeBuilderDao.getAllInstructionsByRecipe(recipeId);

    }

}



