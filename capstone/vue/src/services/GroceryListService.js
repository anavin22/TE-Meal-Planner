import axios from 'axios';

export default {
    
    getAllIngredientsByUserIdForUserMealPlan(){
        return axios.get(`/userMealPlan/groceryList`)
    }
}