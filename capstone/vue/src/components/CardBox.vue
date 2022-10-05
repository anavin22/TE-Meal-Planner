<template>
  <div id="card-box">
      <div class="empty-box">
      </div>
      <router-link 
      v-for="recipe in recipes" :key="recipe.recipeId" 
      v-bind:recipe="recipe" 
      :to="{ name: 'recipeDetails', params: { id: recipe.recipeId } }">
      <recipe-card v-bind:recipe="recipe" />
      </router-link>
            <div class="empty-box">
      </div>
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
  margin-top:4.5%;
    display: flex;
    flex-wrap: nowrap;
    /* justify-content: center; */
    /* width: 100%; */
    margin-left: 20px;
}

/* .empty-box {
background: rgb(36,148,146);
background: linear-gradient(90deg, rgba(36,148,146,1) 70%, rgba(30,70,69,1) 100%);
height: 15em;
width: 10em;
border-radius: 20px;
color: white;
overflow: hidden;
position: relative;
margin-right: -10px;
z-index: 200;
box-shadow: -5px 3px 3px darkslategray;
} */


</style>