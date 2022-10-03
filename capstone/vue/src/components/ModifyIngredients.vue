<template>
  <div id="modifyIngredients">
    <h4>
      {{ ingredient.quantity }} {{ ingredient.unit }} {{ ingredient.name }}
    </h4>
    <button @click.prevent="toggleMakeChanges">{{ buttonText }}</button>

    <span v-show="makeChanges">
      <button @click.prevent="removeIngredient">Remove this Ingredient</button>

      <input
        class="ModifyIngredientQuantity"
        type="number"
        step="0.25"
        v-model="ingredientToModify.quantity"
      />
      <button>Update Quantity</button>

      <input
        class="ModifyIngredientUnit"
        type="text"
        v-model="ingredientToModify.unit"
      /><button>Update Units</button>
    </span>
  </div>
</template>

<script>
import RecipeService from "../services/RecipeService";
export default {
  name: "modifyIngredients",
  props: ["ingredient"],
  data() {
    return {
      ingredientToModify: this.$props.ingredient,
      makeChanges: false,
      buttonText: "Change this Ingredient",
      ingredientForDelete: {
        ingredientId: this.$props.ingredient.ingredientId,
        recipeId: this.$store.state.workingId,
      },
    };
  },
  methods: {
    toggleMakeChanges() {
      if (this.makeChanges) {
        this.makeChanges = false;
        this.buttonText = "Change this Ingredient";
      } else {
        this.makeChanges = true;
        this.buttonText = "Close Changes Menu";
      }
    },
    removeIngredient() {
      RecipeService.removeIngredientFromRecipe(this.$store.state.workingId, this.$props.ingredient.ingredientId)
      .then(
        (response) => {
          if (response.status == 200) {
            alert("Ingredient Removed!");
          } else {
            alert("Please try again later.");
          }
        }
      );
    },
  },
};
</script>

<style>
</style>