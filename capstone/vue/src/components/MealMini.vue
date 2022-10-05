<template>
  <div @click="editPop = !editPop" class="meal-card">
    <h4 class="mini-card-title">{{ recipeName }}</h4>

    <div id="editPopup" v-if="editPop">
      <button class="linkToDetails" @click="linkToDetails(mealId)">
        Go To Recipe
      </button>
      <!-- <button class="ChangeMeal" @click="popExtend = !popExtend">Pick a Different Recipe</button> -->
      <button @click="!editPop">Close</button>
      <div id="mini-box">
        <mini-cards
          v-for="recipe in recipes"
          :key="recipe.recipeId"
          v-bind:recipe="recipe"

          @click.native="updateUserPlan(recipe.recipeId, recipe.recipeName)"
        />
      </div>
      <h4>Click a Recipe to add to {{ mealTime }}</h4>
    </div>
  </div>
</template>

<script>
import RecipeService from "../services/RecipeService";
import MiniCards from "./MiniCards.vue";
import MealPlanService from "../services/MealPlanService";
export default {
  components: { MiniCards },
  props: ["mealId", "mealTimeColumn", "mealTime"],
  data() {
    return {
      recipes: [],
      recipeName: "",
      editPop: false,
      popExtend: false,
    };
  },
  methods: {
    linkToDetails(mealId) {
      this.$router.push({ name: "recipeDetails", params: { id: mealId } });
    },

    updateUserPlan(newRecipe, recipeName) {
      let userPlan = {};
      MealPlanService.getUserMealPlan(this.$store.state.user.id).then(
        (response) => {
          if (response.status == 200) {
            userPlan = response.data;
            userPlan[this.mealTimeColumn] = newRecipe;
            MealPlanService.updateUserPlan(userPlan).then((response) => {
              if (response.status == 200) {
                this.recipeName = recipeName;
                alert("Updated!");
              } else {
                alert("Something went wrong");
              }
            });
          } else {
            alert("Something went wrong");
          }
        }
      );
    },
  },
  created() {
    RecipeService.getName(this.mealId).then((response) => {
      if (response.status == 200) {
        this.recipeName = response.data;
      }
    });
    RecipeService.getSavedRecipes().then((response) => {
      this.recipes = response.data;
    });
  },
};
</script>

<style>
.meal-card {
  height: 8em;
  width: 60%;
  position: relative;
  border-radius: 20px;
  font-size: 1.25em;
  background-color: #fcae1e50;
  margin-top: -40px;
  display: flex;
  align-items: flex-start;
  justify-content: center;
}

#editPopup {
  position: fixed;
  right: 5%;
  top: 5%;
  margin: auto;
  padding: 5px;
  width: 40%;
  box-shadow: -5px 3px 3px darkslategray;
  border-radius: 15px;
  background-color: #fda172;
  z-index: 99999;
}
#mini-box {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
</style>