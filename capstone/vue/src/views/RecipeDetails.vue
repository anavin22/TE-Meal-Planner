<template>
  <div id="recipe-details">
      <h2>{{detailedRecipe.recipeName}}</h2>
      <img :src="detailedRecipe.image">
      <ingredients v-bind:ingredients="detailedRecipe.ingredientList" />
      <instructions v-bind:instructions="detailedRecipe.instructions" />

  </div>
</template>

<script>
import Ingredients from '../components/Ingredients.vue'
import Instructions from '../components/Instructions.vue'
import RecipeService from '../services/RecipeService'
export default {
  components: { Ingredients, Instructions },
    name: "recipeDetails",
    props: ['recipe'],
    data() {
        return {
            detailedRecipe: {
        "recipeId": 0,
        "createdBy": 0,
        "recipeName": "",
        "image": "",
        "ingredientList": [],
        "instructions": []
    }
        }
    },
    created() {
        RecipeService
        .getRecipeById(parseInt(this.$route.params.id))
        .then(response => {
            this.detailedRecipe = response.data;
        });
    }
}
</script>

<style>

#recipe-details {
    border-color: white;
  border-style: solid;
  border-width: 5px;
  border-radius: 40px;
  background-image: url("../assets/mainback.png");
  background-position: center;
  background-repeat: repeat-y;
  background-size: 75% auto;
  width: 80%;
  margin-right: auto;
  margin-left: auto;
  margin-top: -7em;
  padding-top: 5em;
  color: #249492;
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
  text-align: center;
  min-height: 80vh;
}



</style>