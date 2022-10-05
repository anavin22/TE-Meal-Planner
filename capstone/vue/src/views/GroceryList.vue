<template>
    <div id="Grocery-List" class="main-look">

        <div id="theRest">
        <h2 id="ingredientListTitle"> Grocery Shopping Ingredient List </h2>
        
        <grocery-ingredient-list/>

</div>
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
#theRest {
    margin-top: 5%;
}

</style>