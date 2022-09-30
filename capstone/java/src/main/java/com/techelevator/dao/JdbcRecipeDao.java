package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRecipeDao implements RecipeDao {

    JdbcTemplate jdbcTemplate;
    JdbcIngredientDao jdbcIngredientDao;
    UserDao userDao;
    IngredientDao ingredientDao;

    public JdbcRecipeDao(JdbcTemplate jdbcTemplate, JdbcIngredientDao jdbcIngredientDao, UserDao userDao, IngredientDao ingredientDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcIngredientDao = jdbcIngredientDao;
        this.userDao = userDao;
        this.ingredientDao = ingredientDao;
    }

    @Override   //create recipe table
    public Recipe createRecipe(Recipe recipe) {
        String sql = "INSERT INTO recipe (created_by, recipe_name, recipe_img) " +
                "VALUES (?, ?, ?) RETURNING recipe_id";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, recipe.getCreatedBy(), recipe.getRecipeName(), recipe.getImage());
        return getRecipeByRecipeId(newId);
    }
    @Override
    public Recipe getRecipeByRecipeId(int id) {
        Recipe recipe = createObjectCalledRecipe(id);
        return recipe;
    }
    @Override
    public Recipe createRecipeObjectAndCheckForIngredients(int recipeId) {
        Recipe createdRecipe = new Recipe();
        createdRecipe.setRecipeId(recipeId);
        String sqlRecipeTable = "SELECT recipe_name, created_by, recipe_img " +
                "FROM recipe WHERE recipe_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlRecipeTable, recipeId);
        if (result.next()) {
            createdRecipe.setRecipeName(result.getString("recipe_name"));
            createdRecipe.setCreatedBy(result.getInt("created_by"));
            createdRecipe.setImage(result.getString("recipe_img"));
        }
        List<Ingredient> ingredientList = ingredientDao.getAllIngredients();
        createdRecipe.setIngredientList(ingredientDao.getAllIngredients());
        for(Ingredient eachIngredient : ingredientList) {
            if()
        }
    }

    @Override
    public Recipe createObjectCalledRecipe(int recipeId) {
        Recipe createdRecipe = new Recipe();
        createdRecipe.setRecipeId(recipeId);
        String sqlRecipeTable = "SELECT recipe_name, created_by, recipe_img " +
                "FROM recipe WHERE recipe_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlRecipeTable, recipeId);
        if (result.next()) {
            createdRecipe.setRecipeName(result.getString("recipe_name"));
            createdRecipe.setCreatedBy(result.getInt("created_by"));
            createdRecipe.setImage(result.getString("recipe_img"));
        }
        createdRecipe.setIngredientList(jdbcIngredientDao.getAllIngredientsByRecipeId(recipeId));

        String sqlInstructionsTable = "SELECT instruction_text FROM instructions WHERE recipe_id = ? " +
                "ORDER BY sequence ASC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlInstructionsTable, recipeId);
        while (results.next()) {
            createdRecipe.getInstructions().add(results.getString("instruction_text"));
        }
        return createdRecipe;
    }



    @Override
    public List<Integer> getListOfFavoriteRecipeIdsByUserId(int userId) {
        List<Integer> favoritesList = new ArrayList<>();
        String sql = "SELECT recipe_id FROM saved_recipes WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()){
            favoritesList.add(results.getInt("recipe_id"));
        }
        return favoritesList;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipeList = new ArrayList<>();
        String sql = "SELECT recipe_id FROM recipe ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            recipeList.add(createObjectCalledRecipe(results.getInt("recipe_id")));
        }
        return recipeList;
    }
//
//    @Override
//    public Recipe getRecipeByName(String name) {
//        Recipe recipe = null;
//        String sql = "SELECT recipe_id, created_by, recipe_name, recipe_img " +
//                "FROM recipe WHERE recipe_name = ?";
//        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, name);
//        if (result.next()) {
//            recipe = mapRowToRecipe(result);
//        }
//        return recipe;

//    }

    @Override
    public List<Recipe> getAllSavedRecipesByUserId(int id) {
        List<Recipe> recipeList = new ArrayList<>();
        String sql =  "SELECT recipe_id FROM saved_recipes WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()) {
            recipeList.add(createObjectCalledRecipe(results.getInt("recipe_id")));
        }
        return recipeList;
    }

    @Override
    public List<Recipe> getAllRecipesByCreatedBy(int createdBy) {
        List<Recipe> recipes = new ArrayList<>();
        String sql = "SELECT recipe_id FROM recipe WHERE created_by = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, createdBy);
        while (result.next()) {
            recipes.add(createObjectCalledRecipe(result.getInt("recipe_id")));
        }
        return recipes;
    }

    @Override
    public List<Recipe> getLatestRecipes() {
        List<Recipe> latestRecipes = new ArrayList<>();
        String sql = "SELECT recipe_id FROM recipe ORDER BY recipe_id DESC LIMIT 8";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            latestRecipes.add(createObjectCalledRecipe(results.getInt("recipe_id")));
        }
        return latestRecipes;
    }



    @Override
    public void putARecipeIntoSavedRecipes(int userId, Recipe recipe) {
        String sql = "INSERT INTO saved_recipes (recipe_id, user_id)" +
                " VALUES (?, ?)";
       jdbcTemplate.update(sql, recipe.getRecipeId(), userId);

}

    @Override
    public Recipe deleteRecipeById(int id) {
        return null;
    }

    private Recipe mapRowToRecipe(SqlRowSet result) {
        Recipe recipe = new Recipe();
        recipe.setRecipeId(result.getInt("id"));
        recipe.setCreatedBy(result.getInt("created_by"));
        recipe.setRecipeName(result.getString("recipe_name"));
        recipe.setImage(result.getString("recipe_img"));
        return recipe;

    }
}
