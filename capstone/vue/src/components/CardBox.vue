<template>
  <div id="card-box">
      
      <router-link 
      v-for="recipe in recipes" :key="recipe.recipeId" 
      v-bind:recipe="recipe" 
      :to="{ name: 'recipeDetails', params: { id: recipe.recipeId } }">
      <recipe-card v-bind:recipe="recipe" />
      </router-link>
  </div>
</template>

<script>
import RecipeCard from './RecipeCard.vue'
import RecipeService from '../services/RecipeService'
export default {
  components: { RecipeCard },
    name: "cardBox",
    data() {
        return {
            recipes: []
        }
    },
    created() {
      RecipeService
      .getLatestRecipes()
      .then(response => {
        this.recipes = response.data;
      });
    }
}
</script>

<style>
#card-box {
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
}

</style>