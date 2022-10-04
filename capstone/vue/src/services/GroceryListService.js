import axios from 'axios';

export default {
    
    getAllIngredientsByMealPlanId(mealPlanId){
        return axios.get(`/mealPlan/${mealPlanId}/groceryList`)
    }
}