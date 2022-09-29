<template>
    <div id="favorites">
 <router-link 
      v-for="recipe in recipes" :key="recipe.recipeId" 
      v-bind:recipe="recipe" 
      :to="{ name: 'recipeDetails', params: { id: recipe.recipeId } }">
      <saved-card v-bind:recipe="recipe" />
      </router-link>
    </div>
</template>

<script>
import RecipeService from '../services/RecipeService'
import SavedCard from './SavedCard.vue'
export default {
    name: "myFavorites",
  components: { SavedCard },
  data() {
      return {
          recipes: []
      }
  },
  created() {
      RecipeService.getSavedRecipes().then(response => {
              this.recipes= response.data;
          }
      );
  }
    
}
</script>

<style>
#favorites {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>