import axios from 'axios';

export default {

    getAllRecipes() {
        return axios.get('/recipes')
    },

    getLatestRecipes() {
        return axios.get('/recipes/latest')
    },

    getRecipeById(id) {
        return axios.get(`/recipes/detail/${id}`)
    },
    
    getSavedRecipes() {
        return axios.get('/recipes/favorites')
    },

    addToSavedRecipes(recipe) {
        return axios.post('/recipes/favorites', recipe)
    },

    getSavedList() {
        return axios.get('/favoritelist')
    },

    removeFromSavedRecipes(id) {
        return axios.delete(`/recipes/favorites/${id}`)
    },

    addRecipeToDB(recipe) {
        return axios.post('/recipes', recipe)
    },

    addIngredientToDB(ingredient) {
        return axios.post('/ingredient', ingredient)
    },

    addUnitToDB(unitName) {
        return axios.post('/unit', unitName)
    },

    addIngredientToRecipe(recipe) {
        return axios.post('/recipes/ingredientList', recipe)
    },

    removeIngredientFromRecipe(recipeId, ingredientId) {
        return axios.delete(`/recipes/${recipeId}/ingredient/${ingredientId}`)
    },

    addInstructionToRecipe(instruction) {
        return axios.post('/recipes/instruction', instruction)
    },

    removeInstructionFromRecipe(instructionId) {
        return axios.delete(`instruction/${instructionId}`)
    },

    getAllIngredients() {
        return axios.get('/ingredient')
    },

    updateIngredients() {
        return axios.put('/recipes')
    },

    getCreatedByRecipes(createdBy) {
        return axios.get(`/recipes/${createdBy}`) 
    },

    getInstructionsByRecipe(id) {
        return axios.get(`/recipes/${id}/instruction`)
    },

    modifyInstructions(instruction, id) {
        return axios.put(`/instruction/${id}`, instruction)
    },

    removeInstruction(id) {
        return axios.delete(`/instruction/${id}`)
    },

    addSingleIngredientToRecipe(ingredient) {
        return axios.post('recipes/ingredient', ingredient)
    },

    updateIngredientUnitQuantity(ingredient) {
        return axios.put('/recipes/ingredient', ingredient)
    }



}