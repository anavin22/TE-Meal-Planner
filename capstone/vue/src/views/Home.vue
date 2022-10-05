<template>
  <div id="Home" class="main-look">
    <h1 class="frontTitle">Latest Recipes</h1>

    <div class="recipes-browse">
      <div class="container">
      <card-box />
</div>
          <h1 class="frontTitle">My Recipes</h1>
          <div class="container">
      <my-saved-recipes />
      </div>

    </div>
    <button @click="$router.push('recipe-editor')">Add New Recipe</button>
  </div>
</template>



<script>
import CardBox from '../components/CardBox.vue';
import MySavedRecipes from '../components/MySavedRecipes.vue';
import RecipeService from '../services/RecipeService'
export default {
  components: { CardBox, MySavedRecipes },
  name: "home",
  data() {
    return {
      recipe: {
        recipe_id: 1,
        created_by: 1,
        recipe_name: 'test-recipe',
        recipe_img: '',
        ingredients: [
          { ingredient_id: 1,
            name: 'ingredient1',
            quantity: 1,
            unit: 'whole',
        }
        ],
        instructions: ['instructions1', 'instructions2']
      }
    }
  },
  created(){
    RecipeService
    .getSavedList()
    .then(response => {
      if(response.status == 200) {
        this.$store.commit('GET_SAVED_LIST', response.data);
      }
    });
  }
  


};
</script>

<style>

.main-look {
  border-color: white;
  border-style: solid;
  border-width: 5px;
  border-radius: 40px;
  background-image: url("../assets/mainback.png");
  background-position: center;
  background-repeat: repeat-y;
  background-size: 75% auto;
  max-width: 80vw;
  margin-right: auto;
  margin-left: auto;
  margin-top: -9em;
  padding-top: 6em;
  color: #249492;
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
  text-align: center;
  min-height: 100vh;
  z-index: -2;
  overflow-y: scroll;
}

.frontTitle {
  font-size: 6em;
  margin-bottom: -4.5%;
}


.container {
  height: 20em;
  overflow-x: scroll;
  overflow-y: visible;
  margin-left: 1em;
  margin-right: 1em;
}

</style>