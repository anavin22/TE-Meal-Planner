<template>
  <div v-if="!isLoading">

    <table id="grocery-table">
      <tr>
        <th></th>

        <th>Ingredient</th>
      
        <th>Quantity/Unit</th>
      </tr>

      <tr class="ingredientRow" v-for="ingredient in ingredients" :key="ingredient.id">
        <td><input type="checkbox" /></td>
        <td>{{ ingredient.name }}</td>
        <td>{{ ingredient.quantity }} {{ ingredient.unit }}</td>
      </tr>
    </table>
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
      ingredientsInStock: [],
      isLoading: true
  };
},
created() {
  GroceryListService
    .getAllIngredientsByUserIdForUserMealPlan()
    .then(response =>{
      if(response.status == 200) {
      this.ingredients = response.data;
      this.isLoading = false;
      } else {
        alert("Something went wrong.")
      }
    });
  
}


}
</script>

<style>
#grocery-table {
  font-size: 1.5em;
  margin: auto;
  background-color: #FFFFFF80;
  color: black;
border-collapse: collapse;
}

.ingredientRow {
    border-bottom: #249492;
  border-bottom-style: solid;
  border-bottom-width: 1px;
}


</style>