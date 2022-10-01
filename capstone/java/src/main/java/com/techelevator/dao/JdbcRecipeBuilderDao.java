package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Instructions;
import com.techelevator.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
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
        int newRecipeId = jdbcTemplate.queryForObject(sql, Integer.class, createdBy, recipeName, recipeImage);
        return newRecipeId;
    }
    //need to pass in a userId to verify userId == createdBy for conditional statement
    @Override
    public void updateRecipeToRecipeDB(Recipe recipe, int userId) {
        String sql = "UPDATE recipe " +
                    "SET created_by = ?, recipe_name = ?, recipe_img = ? " +
                    "WHERE recipe_id = ?;";
        jdbcTemplate.update(sql, userId, recipe.getRecipeName(),
                        recipe.getImage(),recipe.getRecipeId());
    }


    @Override
    public int addIngredientToDB(Ingredient ingredient) {
        String sql = "INSERT INTO ingredient (ingredient_name) " +
                "VALUES (?) RETURNING ingredient_id";
        int newIngredientId = jdbcTemplate.queryForObject(sql, Integer.class, ingredient.getName());
        return newIngredientId;
    }

    @Override   //inserting ingredient to ingredient_recipe table
    public void addIngredientToRecipe(int ingredientId, int recipeId, double quantity, String unit) {
        String sql = "INSERT INTO ingredient_recipe (ingredient_id, recipe_id, quantity, unit " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, ingredientId, recipeId, quantity, unit);
    }

    @Override
    public void removeIngredientFromRecipe(int ingredientId, int recipeId) {
        String sql = "DELETE FROM ingredient_recipe WHERE ingredient_id = ? AND recipe_id =?";
        jdbcTemplate.update(sql, ingredientId, recipeId);

    }

    @Override
    public void updateIngredientQuantityToRecipe(Ingredient ingredient, int recipeId) {
        String sql = "UPDATE ingredient_recipe SET quantity = ? WHERE ingredient_id = ? AND recipe_id = ? ";
                jdbcTemplate.update(sql, ingredient.getQuantity(), ingredient.getIngredientId(), recipeId);

    }

    @Override
    public int addInstructionToRecipe(Instructions instructions) {
        String sql = "INSERT INTO instructions (recipe_id, sequence, instruction_text) VALUES (?, ?, ?) RETURNING instruction_id;";
        int newId = jdbcTemplate.queryForObject(sql, Integer.class, instructions.getRecipeId(), instructions.getSequence(), instructions.getInstruction_text());
        return newId;
    }

    @Override
    public void removeInstructionFromRecipe(int instructionId) {
        String sql = "DELETE FROM instructions WHERE instruction_id = ?";
        jdbcTemplate.update(sql, instructionId);

    }
    @Override
    public void updateInstructionsToRecipe(Instructions instructions, int instructionId){
        String sql = "UPDATE instructions SET instruction_text = ? WHERE instruction_id = ?";
        jdbcTemplate.update(sql, instructions.getInstruction_text(), instructions.getInstruction_id());
    }

}
