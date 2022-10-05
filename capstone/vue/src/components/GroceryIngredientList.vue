<template>
  <div v-if="!isLoading">

    <table id="grocery-table">
      <tr>
        <th></th>

        <th>Ingredient</th>
      
        <th>Quantity/Unit</th>
      </tr>

      <tr class="ingredientRow" v-for="ingredient in filteredIngredients" :key="ingredient.id">
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
      filteredIngredients: [],
      isLoading: true
  };
},
methods: {
  // hideInStock() {
  //   this.filteredIngredients = this.ingredients.filter((ingredient) => {
  //     !this.ingredientsInStock.includes(ingredient);
  //   });
  // }

},
created() {
  GroceryListService
    .getAllIngredientsByUserIdForUserMealPlan()
    .then(response =>{
      this.ingredients = response.data;
      this.filteredIngredients = response.data;
      this.isLoading = false;
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