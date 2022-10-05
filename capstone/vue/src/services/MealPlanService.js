import axios from 'axios';

export default {
    getMealPlanByCreatedBy(createdBy) {
        return axios.get(`/mealPlan/${createdBy}`)
    },
    getPlanById(id){
        return axios.get(`/mealPlan/detail/${id}`)
    },

    //userMealPlan
    getUserMealPlan() {
        return axios.get(`/userMealPlan`)
    },

    // makeAPlanForUser(userPlan) {
    //     return axios.post(`/userMealPlan`, userPlan)
    // },

    updateUserPlan(mealPlan) {
        return axios.put('userMealPlan/update', mealPlan)
    }

    
}