<template>
  <div class="main-look">
      <button id="callList" 
      @click="getGroceryListIngredients">
      Load List
      </button>

      <h3 id="ingredients">
        {{ingredients}}
      </h3>  

  </div>

</template>

<script>
import GroceryListService from '../services/GroceryListService'
export default {
name: "GroceryIngredientList",
components: {},
props: ["ingredient"],
data(){
  return{
    
      ingredients: [],
  };
},
methods: {
  getGroceryListIngredients(){
  GroceryListService
    .getAllIngredientsByUserIdForUserMealPlan()
    .then(response =>{
      this.ingredients = response.data;
    })
}
},
}
</script>

<style>

</style>