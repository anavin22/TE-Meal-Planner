<template>
    <div id="saved">
        <recipe-card/>
    </div>
</template>

<script>
import RecipeCard from './RecipeCard.vue'
import RecipeService from '../services/RecipeService'
export default {
  components: { RecipeCard },
  data() {
      return {
          recipes: []
      }
  },
  created() {
      RecipeService.getSavedRecipes().then(
          (response) => {
              this.recipes= response.data;
          }
      )
  }
    
}
</script>

<style>

</style>