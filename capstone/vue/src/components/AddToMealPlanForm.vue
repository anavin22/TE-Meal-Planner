<template>
  <div class="meal-plan-form">
      
        

        <div class="plan-options">
            <ul>
                <li v-for="plan in mealplans" :key="plan.id" >
                    {{ plan.title }}
                </li>
            </ul>
        </div>

        <div class="meal-options">
            <ul>
                <li><input type="checkbox"/> Breakfast</li>
                <li><input type="checkbox"/> Lunch</li>
                <li><input type="checkbox"/> Dinner</li>
                <li><input type="checkbox"/> Other</li>
            </ul>
        </div>
        <div class="week-options">
            <ul>
                <li><input type="checkbox"/> Sunday</li>
                <li><input type="checkbox"/> Monday</li>
                <li><input type="checkbox"/> Tuesday</li>
                <li><input type="checkbox"/> Wednesday</li>
                <li><input type="checkbox"/> Thursday</li>
                <li><input type="checkbox"/> Friday</li>
                <li><input type="checkbox"/> Saturday</li>
            </ul>
        </div>
    

  </div>
    
    </template>

<script>
    import mealplanservice from '../services/MealPlanService'
export default {
    name: "AddToMealPlanForm",
    components: {},
    props: [],
    data() {return {
        mealplans: {},
        selectedPlanID: 0,
        workingMeal: {
            mealPlanId: 0,
            recipeId: 0,
            mealType: "",
            dayOfWeek: ""
        }


    }},
    methods: {
        
    },
    created() {
        mealplanservice.getMealPlanByCreatedBy(this.$store.state.user.id).then(response => {
            if (response.status==200) {
                this.mealplans=response.data;
            }
            else {alert("Something Went Wrong.");}
        }
        )
    }
}
</script>

<style>

</style>