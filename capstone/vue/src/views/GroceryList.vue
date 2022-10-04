<template>
    <div id="Grocery-List" class="Groceries">

        <h2 id="ingredientListTitle"> Grocery Shopping Ingredient List </h2>
        
        <grocery-ingredient-list/>


    </div>



    
</template>

<script>
import GroceryIngredientList from "../components/GroceryIngredientList.vue";
//import GroceryListService from "../services/GroceryListService.js"
export default {
components: {
    GroceryIngredientList
},
name: "GroceryList",
props: [],
data(){
    return{

    }
}
}
</script>

<style>

</style>