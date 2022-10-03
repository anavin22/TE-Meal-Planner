import axios from 'axios';

export default {
    getMealPlanByCreatedBy(createdBy) {
        return axios.get(`/mealPlan/${createdBy}`)
    },

    
}