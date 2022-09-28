import axios from 'axios';

export default {

    getAllRecipes() {
        return axios.get('/recipes')
    }

}