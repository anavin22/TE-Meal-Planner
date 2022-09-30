<template>
  <div id="recipe-details">
    <h2 id="recipe-name">{{ detailedRecipe.recipeName }}</h2>
    <img id="foodpic" :src="detailedRecipe.image" />
    <ingredients id="ingredients" v-bind:ingredients="detailedRecipe.ingredientList" />
    <instructions id="instructions" v-bind:instructions="detailedRecipe.instructions" />
    <span id="savecheck">
    <input v-model="recipeSaved" v-on:change="toggleSaved" type="checkbox" id="save" name="saved" value="saved"><br>
    <label v-show="!recipeSaved" for="saved">Save This Recipe</label>
    <label v-show="recipeSaved" for="saved">Recipe Saved</label>
    </span>
  </div>
</template>

<script>
import Ingredients from "../components/Ingredients.vue";
import Instructions from "../components/Instructions.vue";
import RecipeService from "../services/RecipeService";
export default {
  components: { Ingredients, Instructions },
  name: "recipeDetails",
  props: ["recipe"],
  data() {
    return {
      recipeSaved: false,
      currentRecipeId: parseInt(this.$route.params.id),
      detailedRecipe: {
        recipeId: 0,
        createdBy: 0,
        recipeName: "",
        image: "",
        ingredientList: [],
        instructions: [],
      },
    };
  },
  methods: {
    toggleSaved() {
      if(this.recipeSaved) {
      RecipeService
      .addToSavedRecipes(this.detailedRecipe)
      .then(response => {
        if(response.status == 200) {
          this.$store.state.commit('ADD_SAVED_RECIPE', this.currentRecipeId);
          this.recipeSaved = true;
        }
      })
    }
    else {
      RecipeService
      .removeFromSavedRecipes(this.detailedRecipe.recipeId)
      .then(response => {
        if(response.status == 200) {
          this.$store.state.commit('REMOVE_SAVED_RECIPE', this.currentRecipeId);
          this.recipeSaved = false;
        }
      }); 
    }
  },
  },
  created() {
    RecipeService.getRecipeById(parseInt(this.$route.params.id)).then(
      (response) => {
        this.detailedRecipe = response.data;
      });
    if(this.$store.state.savedRecipes.includes(this.currentRecipeId)){
      this.recipeSaved = true;
    }
  },
};
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
  min-height: 80vh;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas: 
    ". recipe-name recipe-name save"
    ". foodpic ingredients ingredients"
    "instructions instructions instructions instructions";
}

#foodpic {
    grid-area: foodpic;
  max-width: 100%;
  height: auto;
  border-radius: 30px;
  box-shadow: 20px 16px teal;
}

#recipe-name {
    grid-area: recipe-name;
}

#ingredients {
    grid-area: ingredients;
}

#instructions {
    grid-area: instructions;
}

#savecheck {
    grid-area: save;
    font-size: .5em;
    transform: scale(4);
    align-self: end;
    color: orangered;
    background-color: #FFFFFF60;
    border-radius: 100px;
    max-width: 15%;
}

h2 {
    font-size: 3em;
}
</style>