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

    addIngredientToRecipe(recipeId, recipe) {
        return axios.post(`/recipes/${recipeId}/ingredient`, recipe)
    },

    removeIngredientFromRecipe(ingredientId, recipeId) {
        return axios.delete(`/ingredient/${ingredientId}`, ingredientId, recipeId)
    },

    addInstructionToRecipe(instruction) {
        return axios.post('/recipes/instruction', instruction)
    },

    removeInstructionFromRecipe(instructionId) {
        return axios.delete(`instruction/${instructionId}`)
    },

    getAllIngredients() {
        return axios.get('/ingredient')
    }



}