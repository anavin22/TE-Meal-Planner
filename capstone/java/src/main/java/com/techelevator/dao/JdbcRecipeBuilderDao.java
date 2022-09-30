package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcRecipeBuilderDao implements RecipeBuilderDao {
    JdbcTemplate jdbcTemplate;

    public JdbcRecipeBuilderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addRecipeToRecipeDB(String recipeName, String recipeImage, int createdBy) {
        String sql = "INSERT INTO recipe (created_by, recipe_name, recipe_img) " +
                "VALUES (?, ?, ?) RETURNING recipe_id";
        int newRecipeId = jdbcTemplate.update(sql, Integer.class, createdBy, recipeName, recipeImage);
        return newRecipeId;
    }

    @Override
    public int addIngredientToDB(String ingredientName) {
        String sql = "INSERT INTO ingredient (ingredient_name) " +
                "VALUES (?) RETURNING ingredient_id";
        int newIngredientId = jdbcTemplate.update(sql, Integer.class, ingredientName);
        return newIngredientId;
    }

    @Override
    public int addUnitToDB(String unitName) {
       String sql = "INSERT INTO unit (unit_name) VALUES (?) RETURNING unit_id";
       int newUnitId = jdbcTemplate.update(sql, Integer.class, unitName);
       return newUnitId;
    }

    @Override   //inserting ingredient to ingredient_recipe table
    public void addIngredientToRecipe(int ingredientId, int recipeId, double quantity, int unitId) {
        String sql = "INSERT INTO ingredient_recipe (ingredient_id, recipe_id, quantity, unit_id " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, ingredientId, recipeId, quantity, unitId);
    }

    @Override
    public void removeIngredientFromRecipe(int ingredientId, int recipeId) {
        String sql = "DELETE FROM ingredient_recipe WHERE ingredient_id = ? AND recipe_id =?";
        jdbcTemplate.update(sql, ingredientId, recipeId);

    }

    @Override
    public int addInstructionToRecipe(int recipeId, int sequence, String instruction_text) {
        String sql = "INSERT INTO instructions (recipe_id, sequence, instruction_text) " +
                "VALUES (?, ?, ?) RETURNING instruction_id";
        int newInstructionid = jdbcTemplate.update(sql, Integer.class, recipeId, sequence, instruction_text);
        return newInstructionid;
    }

    @Override
    public void removeInstructionFromRecipe(int instructionId) {
        String sql = "DELETE FROM instructions WHERE instruction_id = ?";
        jdbcTemplate.update(sql, instructionId);

    }
    //add new componenet - recipe name/picture
    //just updating recipe table -- just in DB
    //When user pushes button, recipe should go to DB -- only goes to Recipe
    //recipe id returned -- newId -- return int




    //Think about Ingredients
    //pull getAllIngredients() in front end -- search function

    //getAllUnits
    //If ingredient and/or unit is not present, add.

}
