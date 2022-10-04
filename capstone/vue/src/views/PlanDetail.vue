<template>
  <div id="plan-look">
    <h1 class="plan0title">My Meal Plan</h1>
    <div id="week-display" v-if="!isLoading">
      <span class="Monday"><h3 class="weekday">Monday</h3></span>
      <span class="Tuesday"><h3 class="weekday">Tuesday</h3></span>
      <span class="Wednesday"><h3 class="weekday">Wednesday</h3></span>
      <span class="Thursday"><h3 class="weekday">Thursday</h3></span>
      <span class="Friday"><h3 class="weekday">Friday</h3></span>
      <span class="Saturday"><h3 class="weekday">Saturday</h3></span>
      <span class="Sunday"><h3 class="weekday">Sunday</h3></span>
      <span class="MonBre">
        <div class="meal-box">
          <h4 class="mealType">Breakfast</h4>
            <monday-breakfast v-bind:mealId="userMealPlan.mondayBreakfast" />
        </div>
      </span>
      <span class="TueBre">
        <div class="meal-box">
          <h4 class="mealType">Breakfast</h4>
          <tuesday-breakfast v-bind:mealId="userMealPlan.tuesdayBreakfast" />
        </div>
      </span>
      <span class="WedBre">
        <div class="meal-box">
          <h4 class="mealType">Breakfast</h4>
          <wednesday-breakfast v-bind:mealId="userMealPlan.wednesdayBreakfast" />
        </div>

      </span>
      <span class="ThurBre">Breakfast</span>
      <span class="FriBre">Breakfast</span>
      <span class="SatBre">Breakfast</span>
      <span class="SunBre">Breakfast</span>
      <span class="MonLun">Lunch</span>
      <span class="TueLun">Lunch</span>
      <span class="WedLun">Lunch</span>
      <span class="ThurLun">Lunch</span>
      <span class="FriLun">Lunch</span>
      <span class="SatLun">Lunch</span>
      <span class="SunLun">Lunch</span>
      <span class="MonDin">Dinner</span>
      <span class="TueDin">Dinner</span>
      <span class="WedDin">Dinner</span>
      <span class="ThurDin">Dinner</span>
      <span class="FriDin">Dinner</span>
      <span class="SatDin">Dinner</span>
      <span class="SunDin">Dinner</span>
      <span class="MonOth">Other</span>
      <span class="TueOth">Other</span>
      <span class="WedOth">Other</span>
      <span class="ThurOth">Other</span>
      <span class="FriOth">Other</span>
      <span class="SatOth">Other</span>
      <span class="SunOth">Other</span>
    </div>
  </div>
</template>

<script>
import MondayBreakfast from '../components/MealPlanMeals/MondayBreakfast.vue';
import TuesdayBreakfast from '../components/MealPlanMeals/TuesdayBreakfast.vue';
import WednesdayBreakfast from '../components/MealPlanMeals/WednesdayBreakfast.vue';
import MealPlanService from "../services/MealPlanService";
// import RecipeService from "../services/RecipeService";
export default {
  components: { MondayBreakfast, TuesdayBreakfast, WednesdayBreakfast },
  name: "planDetail",
  data() {
    return {
      userMealPlan: {},
      savedRecipes: [],
      isLoading: true
    };
  },

  // methods: {

  //   addToRecipeList(mealName, id) {
  //     RecipeService.getRecipeById(id).then((response) => {
  //       this.savedRecipes.push({[mealName]: response.data.recipeName});
  //     });
  //   },
  // },

  created() {
    //Pull Plan
    MealPlanService.getUserMealPlan(this.$store.state.user.id).then(
      (response) => {
        if (response.status == 200) {
          this.userMealPlan = response.data;
          this.isLoading = false;
        } else {
          alert("Something went wrong");
        }
      }
    );
  },

  // mounted() {
  //         let mondayBreakfastId = this.userMealPlan.mondayBreakfast;
  //         this.addToRecipeList("mondayBreakfast", mondayBreakfastId);
  //         let mondayLunchId = this.userMealPlan.mondayLunch;
  //         this.addToRecipeList("mondayLunch", mondayLunchId);
  // }
};
</script>

<style>
#plan-look {
  border-color: white;
  border-style: solid;
  border-width: 5px;
  border-radius: 40px;
  background-color: #ffffff60;
  max-width: 95%;
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

.meal-box {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.mealType {
  color: black;
  font-size: 1.25em;
  z-index: 20;
}

/* .meal-card {
 height: 6em;
 width: 5em;
 position: relative;
border-radius: 20px;

background-color: #FCAE1E50;
margin-top: -40px;
display: flex;
align-items: flex-start;
justify-content: center;
} */

#week-display {
  background-color: #ffffff;
  right: 0;
  margin-top: 5%;
  margin-left: 0.5em;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr;
  grid-template-rows: 1fr 3fr 3fr 3fr 3fr;
  grid-template-areas:
    "Monday Tuesday Wednesday Thursday Friday Saturday Sunday"
    "MonBre TueBre WedBre ThurBre FriBre SatBre SunBre"
    "MonLun TueLun WedLun ThurLun FriLun SatLun SunLun"
    "MonDin TueDin WedDin ThurDin FriDin SatDin SunDin"
    "MonOth TueOth WedOth ThurOth FriOth SatOth SunOth";
}

.Monday {
  grid-area: Monday;
}
.MonBre {
  grid-area: MonBre;
}
.MonLun {
  grid-area: MonLun;
}
.MonDin {
  grid-area: MonDin;
}
.MonOth {
  grid-area: MonOth;
}
.Tuesday {
  grid-area: Tuesday;
}
.TueBre {
  grid-area: TueBre;
}
.TueLun {
  grid-area: TueLun;
}
.TueDin {
  grid-area: TueDin;
}
.TueOth {
  grid-area: TueOth;
}
.Wednesday {
  grid-area: Wednesday;
}
.WedBre {
  grid-area: WedBre;
}
.WedLun {
  grid-area: WedLun;
}
.WedDin {
  grid-area: WedDin;
}
.WedOth {
  grid-area: WedOth;
}
.Thursday {
  grid-area: Thursday;
}
.ThurBre {
  grid-area: ThurBre;
}
.ThurLun {
  grid-area: ThurLun;
}
.ThurDin {
  grid-area: ThurDin;
}
.ThurOth {
  grid-area: ThurOth;
}
.Friday {
  grid-area: Friday;
}
.FriBre {
  grid-area: FriBre;
}
.FriLun {
  grid-area: FriLun;
}
.FriDin {
  grid-area: FriDin;
}
.FriOth {
  grid-area: FriOth;
}
.Saturday {
  grid-area: Saturday;
}
.SatBre {
  grid-area: SatBre;
}
.SatLun {
  grid-area: SatLun;
}
.SatDin {
  grid-area: SatDin;
}
.SatOth {
  grid-area: SatOth;
}
.Sunday {
  grid-area: Sunday;
}
.SunBre {
  grid-area: SunBre;
}
.SunLun {
  grid-area: SunLun;
}
.SunDin {
  grid-area: SunDin;
}
.SunOth {
  grid-area: SunOth;
}
</style>