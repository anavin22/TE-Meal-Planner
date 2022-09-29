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

    addToSavedRecipes() {
        return axios.post('/recipes/favorites')
    }

}