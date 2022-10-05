<template>
  <div id="created-by-me">
      <created-recipe-cards v-for="recipe in recipes" :key="recipe.id" v-bind:recipe="recipe"  />


  </div>
</template>

<script>
import RecipeService from '../services/RecipeService'
import CreatedRecipeCards from './CreatedRecipeCards.vue'
export default {
  components: { CreatedRecipeCards },
  data(){
      return {
          recipes: [],


      }
  },

  created() {
      RecipeService
      .getCreatedByRecipes(this.$store.state.user.id)
      .then(response => {
          if(response.status == 200) {
              this.recipes = response.data;
          } else {
              alert("Something went wrong.")
          }
      });
  }

}
</script>

<style>

#created-by-me {
    display: flex;
    flex-direction: column;
    margin-top: 5%;
    position: relative;

}


</style>