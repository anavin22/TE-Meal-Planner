<template>
  <div id="Home" class="main-look">
    <h1>Latest Recipes</h1>

    <div class="recipes-browse">
      <card-box />

          <h1>My Recipes</h1>
      <my-saved-recipes />
      

    </div>
    <button>Add New Recipe</button>
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
  width: 80%;
  margin-right: auto;
  margin-left: auto;
  margin-top: -9em;
  padding-top: 6em;
  color: #249492;
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
  text-align: center;
  min-height: 1vh;
  z-index: -2;
  overflow-y: scroll;
}

::-webkit-scrollbar {
  width: 10px;
}


</style>