<template>
  <div class="Grocery-List">




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
    .getAllIngredientsByMealPlanId(parseInt(this.$route.params.id))
    .then(response =>{
      this.ingredients = response.data;
    })
}
}
</script>

<style>

</style>