<template>
  <div id="modifyIngredients">
    <h3 id="ingredientTitle">
      {{ ingredient.quantity }} {{ ingredient.unit }} {{ ingredient.name }}
    </h3>
    <button id="changeMenuBtn" @click.prevent="toggleMakeChanges">
      {{ buttonText }}
    </button>

    <span v-show="makeChanges">
      <button id="removeIngredientBtn" @click.prevent="removeIngredient">
        Remove Ingredient
      </button>

      <form id="quantityUnitForm">
        <label for="units">Units: </label>
        <input
          class="ModifyIngredientQuantity"
          type="number"
          name="units"
          step="0.25"
          v-model="ingredientToModify.quantity"
        /><br />
        <label for="quantity">Quantity: </label>
        <input
          class="ModifyIngredientUnit"
          type="text"
          name="quantity"
          v-model="ingredientToModify.unit"
        />
        <br />
        <button id="quantityUnitsBtn" @click.prevent="updateIngredient">
          Update Units and Quantity
        </button>
      </form>
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
      buttonText: "Change This",
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
        this.buttonText = "Change This";
      } else {
        this.makeChanges = true;
        this.buttonText = "Close";
      }
    },
    removeIngredient() {
      RecipeService.removeIngredientFromRecipe(
        this.$store.state.workingId,
        this.$props.ingredient.ingredientId
      ).then((response) => {
        if (response.status == 200) {
          alert("Ingredient Removed!");
        } else {
          alert("Please try again later.");
        }
      });
    },
    updateIngredient() {
      this.ingredientToModify.recipeId = this.$store.state.workingId;
      RecipeService.updateIngredientUnitQuantity(this.ingredientToModify).then(
        (response) => {
          if (response.status == 200) {
            alert("Ingredient Updated!");
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
#modifyIngredients {
  border-color: slategray;
  border-style: solid;
  border-radius: 20px;
  border-width: 1px;
  width: 80%;
  position: relative;
  float: right;
  margin-right: 5%;
  background-color: #ffffff70;
}

#changeMenuBtn {
  position: absolute;
  top: 10px;
  left: 5px;
}

#ingredientTitle {
  grid-area: title;
  font-size: 1.5em;
}

#removeIngredientBtn {
  grid-area: removeBtn;
  position: absolute;
  left: 5px;
  bottom: 0;
}

#quantityUnitForm {
  position: relative;
  margin-left: 30%;
}

input,
button {
  margin-bottom: 10px;
}
</style>