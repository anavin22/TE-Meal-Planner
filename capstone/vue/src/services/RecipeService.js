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
    }

}