<template>
  <div class="meal-card">
      <h4 class="mini-card-title">{{recipeName}}</h4>
      <!-- <img :src="mealRecipe.image" /> -->
  </div>
</template>

<script>
import RecipeService from '../../services/RecipeService'
export default {
    props: ['mealId'],
  data() {
    return {
      recipeName: ""
    }
  },
  created() {
    RecipeService
    .getName(this.mealId)
    .then(response=> {
      if(response.status == 200) {
        this.recipeName = response.data;
        // this.mealRecipe.image = response.data.image;
      }
    });
  }
}
</script>