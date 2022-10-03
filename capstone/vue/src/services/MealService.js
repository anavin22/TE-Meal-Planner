import axios from "axios";

export default {

    getPlanById(id){
        return axios.get(`/mealPlan/detail/${id}`)
    }




}