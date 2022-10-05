<template>
  <div id="recipe-details" class="main-look">
    <h2 id="recipe-name">{{ detailedRecipe.recipeName }}</h2>
    <img id="foodpic" :src="detailedRecipe.image" />
    <ingredients id="ingredients" v-bind:ingredients="detailedRecipe.ingredientList" />
    <instructions id="instructions" v-bind:instructions="detailedRecipe.instructions" />




    
    <span id="savecheck">
    <input v-model="recipeSaved" v-on:change="toggleSaved" type="checkbox" id="save" name="saved" value="saved"><br>
    <label v-if="!recipeSaved" for="saved">Save This Recipe</label>
    <label v-if="recipeSaved" for="saved">Recipe Saved</label>
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
          this.$store.commit('ADD_SAVED_RECIPE', this.currentRecipeId);
          this.recipeSaved = true;
        }
      })
    }
    else {
      alert("Unsaved recipes cannot be added to meal plans!");
      RecipeService
      .removeFromSavedRecipes(this.detailedRecipe.recipeId)
      .then(response => {
        if(response.status == 200) {
          this.$store.commit('REMOVE_SAVED_RECIPE', this.currentRecipeId);
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
  display: grid;
  grid-template-columns: 1fr 2fr 2fr 1fr;
  grid-template-areas: 
    ". recipe-name recipe-name save"
    ". foodpic foodpic ."
    ". ingredients ingredients ."
    "instructions instructions instructions instructions";
  gap: 30px;
}

#foodpic {
  grid-area: foodpic;
  max-width: 80%;
  height: auto;
  border-radius: 30px;
  margin-left: 15%;
  box-shadow: -5px 3px 3px darkslategray;
}

#recipe-name {
    grid-area: recipe-name;
    font-size: 4em;
    margin-top: 10%;
}

#ingredients {
    grid-area: ingredients;
    margin-top: 20px;
  padding-left: 15%;
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

</style>