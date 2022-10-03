<template>
  <div id="modify-recipe">

      <h2 id="modifyRecipeTitle">{{ modifyingRecipe.recipeName }}</h2>
      <span v-show="readyForThis">
    <input id="ModifyTitle" type="text" v-model="modifyingRecipe.recipeName" />
    <input id="ModifyImage" type="text" v-model="modifyingRecipe.image" />
    <button>Update Recipe Name or Picture</button>
      </span>

    <modify-ingredients
      v-for="ingredient in modifyingRecipe.ingredientList"
      :key="ingredient.id"
      v-bind:ingredient="ingredient"
    />
    <button v-show="!addIngredient" @click.prevent="toggleAddIngredient">Add an Ingredient</button>

    <add-an-ingredient v-if="addIngredient" />

    <modify-instructions
      v-for="instruction in modifyingInstructions"
      :key="instruction.id"
      v-bind:instruction="instruction"
    />
    <!-- <button>Add a Step</button> -->

  </div>
</template>

<script>
import RecipeService from "../services/RecipeService";
import AddAnIngredient from './AddAnIngredient.vue';
import ModifyIngredients from "./ModifyIngredients.vue";
import ModifyInstructions from './ModifyInstructions.vue';
export default {
  name: "ModifyRecipe",
  props: ["recipe"],
  components: { ModifyIngredients, ModifyInstructions, AddAnIngredient },
  data() {
    return {
      modifyingRecipe: [],
      modifyingId: this.$store.state.workingId,
      readyForThis: false,
      modifyingInstructions: {},
      addIngredient: false
    };
  },
  methods: {
      toggleAddIngredient(){
          if(!this.addIngredient){
              this.addIngredient = true;
          } else {this.addIngredient = false; }
      }
  },

  created() {
    RecipeService.getRecipeById(this.$store.state.workingId).then(
      (response) => {
        if (response.status == 200) {
          this.modifyingRecipe = response.data;
        } else {
          alert("Something went wrong.");
        }
      }
    );
    RecipeService
    .getInstructionsByRecipe(this.$store.state.workingId)
    .then(response => {
        if (response.status == 200) {
            this.modifyingInstructions = response.data;
        } else {
          alert("Something went wrong.");
        }
    });
  },
};
</script>

<style>
#modify-recipe {
  position: absolute;
  top: -2%;
  left: 15%;
  right: 10%;
  width: 80%;
  background-color: #FFFFFF60;
}

</style>