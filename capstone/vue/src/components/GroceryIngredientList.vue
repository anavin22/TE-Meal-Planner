<template>
  <div class="main-look">
    <button id="grocery-list-button"
    @click="getAllIngredientsByUserIdForUserMealPlan()"
    >Load Shopping List</button>
      <span id="ingredients-list">{{ingredients}}</span>




  </div>
</template>

<script>
import GroceryListService from '../services/GroceryListService'
export default {
name: "GroceryIngredientList",
components: {},
data(){
  return{
    currentMealPlanId : parseInt(this.$route.params.id),
    GroceryIngredientsList:{
      ingredients: [],
    }
  };
},
created(){

  GroceryListService
    .getAllIngredientsByUserIdForUserMealPlan()
    .then(response =>{
      this.ingredients = response.data;
    })
}
}
</script>

<style>

</style>