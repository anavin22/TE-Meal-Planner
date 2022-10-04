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
            <meal-mini v-bind:mealId="userMealPlan.mondayBreakfast" :mealTimeColumn="mealTime.mbColumn" :mealTime="mealTime.mbMealTime" />
        </div>
      </span>
      <span class="TueBre">
        <div class="meal-box">
          <h4 class="mealType">Breakfast</h4>
          <meal-mini v-bind:mealId="userMealPlan.tuesdayBreakfast" :mealTime="tuesdayBreakfast" />
        </div>
      </span>
      <span class="WedBre">
        <div class="meal-box">
          <h4 class="mealType">Breakfast</h4>
          <meal-mini v-bind:mealId="userMealPlan.wednesdayBreakfast" :mealTime="wednesdayBreakfast" />
        </div>
      </span>
      <span class="ThurBre">
              <div class="meal-box">
          <h4 class="mealType">Breakfast</h4>
            <meal-mini v-bind:mealId="userMealPlan.thursdayBreakfast" :mealTime="thursdayBreakfast" />
        </div>
      </span>
      <span class="FriBre"><div class="meal-box">
          <h4 class="mealType">Breakfast</h4>
            <meal-mini v-bind:mealId="userMealPlan.fridayBreakfast" :mealTime="fridayBreakfast" />
        </div>
      </span>
      <span class="SatBre"><div class="meal-box">
          <h4 class="mealType">Breakfast</h4>
            <meal-mini v-bind:mealId="userMealPlan.saturdayBreakfast" :mealTime="saturdayBreakfast" />
        </div>
      </span>
      <span class="SunBre"><div class="meal-box">
          <h4 class="mealType">Breakfast</h4>
            <meal-mini v-bind:mealId="userMealPlan.sundayBreakfast" :mealTime="sundayBreakfast" />
        </div>
      </span>
      <span class="MonLun"><div class="meal-box">
          <h4 class="mealType">Lunch</h4>
            <meal-mini v-bind:mealId="userMealPlan.mondayLunch" :mealTime="mondayLunch" />
        </div>
      </span>
      <span class="TueLun"><div class="meal-box">
          <h4 class="mealType">Lunch</h4>
            <meal-mini v-bind:mealId="userMealPlan.tuesdayLunch" :mealTime="tuesdayLunch" />
        </div>
      </span>
      <span class="WedLun"><div class="meal-box">
          <h4 class="mealType">Lunch</h4>
            <meal-mini v-bind:mealId="userMealPlan.wednesdayLunch" :mealTime="wednesdayLunch" />
        </div>
      </span>
      <span class="ThurLun"><div class="meal-box">
          <h4 class="mealType">Lunch</h4>
            <meal-mini v-bind:mealId="userMealPlan.thursdayLunch" :mealTime="thursdayLunch" />
        </div>
      </span>
      <span class="FriLun"><div class="meal-box">
          <h4 class="mealType">Lunch</h4>
            <meal-mini v-bind:mealId="userMealPlan.fridayLunch" :mealTime="fridayLunch" />
        </div>
      </span>
      <span class="SatLun"><div class="meal-box">
          <h4 class="mealType">Lunch</h4>
            <meal-mini v-bind:mealId="userMealPlan.saturdayLunch" :mealTime="saturdayLunch" />
        </div>
      </span>
      <span class="SunLun"><div class="meal-box">
          <h4 class="mealType">Lunch</h4>
            <meal-mini v-bind:mealId="userMealPlan.sundayLunch" :mealTime="sundayLunch" />
        </div>
      </span>
      <span class="MonDin"><div class="meal-box">
          <h4 class="mealType">Dinner</h4>
            <meal-mini v-bind:mealId="userMealPlan.mondayDinner" :mealTime="mondayDinner" />
        </div>
      </span>
      <span class="TueDin"><div class="meal-box">
          <h4 class="mealType">Dinner</h4>
            <meal-mini v-bind:mealId="userMealPlan.tuesdayDinner" :mealTime="tuesdayDinner" />
        </div>
      </span>
      <span class="WedDin"><div class="meal-box">
          <h4 class="mealType">Dinner</h4>
            <meal-mini v-bind:mealId="userMealPlan.wednesdayDinner" :mealTime="wednesdayDinner" />
        </div>
      </span>
      <span class="ThurDin"><div class="meal-box">
          <h4 class="mealType">Dinner</h4>
            <meal-mini v-bind:mealId="userMealPlan.thursdayDinner" :mealTime="thursdayDinner" />
        </div>
      </span>
      <span class="FriDin"><div class="meal-box">
          <h4 class="mealType">Dinner</h4>
            <meal-mini v-bind:mealId="userMealPlan.fridayDinner" :mealTime="fridayDinner" />
        </div>
      </span>
      <span class="SatDin"><div class="meal-box">
          <h4 class="mealType">Dinner</h4>
            <meal-mini v-bind:mealId="userMealPlan.saturdayDinner" :mealTime="saturdayDinner" />
        </div>
      </span>
      <span class="SunDin"><div class="meal-box">
          <h4 class="mealType">Dinner</h4>
            <meal-mini v-bind:mealId="userMealPlan.sundayDinner" :mealTime="sundayDinner" />
        </div>
      </span>
      <span class="MonOth"><div class="meal-box">
          <h4 class="mealType">Other</h4>
            <meal-mini v-bind:mealId="userMealPlan.mondayOther" :mealTime="mondayOther" />
        </div>
      </span>
      <span class="TueOth"><div class="meal-box">
          <h4 class="mealType">Other</h4>
            <meal-mini v-bind:mealId="userMealPlan.tuesdayOther" :mealTime="tuesdayOther" />
        </div>
      </span>
      <span class="WedOth"><div class="meal-box">
          <h4 class="mealType">Other</h4>
            <meal-mini v-bind:mealId="userMealPlan.wednesdayOther" :mealTime="wednesdayOther" />
        </div>
      </span>
      <span class="ThurOth"><div class="meal-box">
          <h4 class="mealType">Other</h4>
            <meal-mini v-bind:mealId="userMealPlan.thursdayOther" :mealTime="thursdayOther" />
        </div>
      </span>
      <span class="FriOth"><div class="meal-box">
          <h4 class="mealType">Other</h4>
            <meal-mini v-bind:mealId="userMealPlan.fridayOther" :mealTime="fridayOther" />
        </div>
      </span>
      <span class="SatOth"><div class="meal-box">
          <h4 class="mealType">Other</h4>
            <meal-mini v-bind:mealId="userMealPlan.saturdayOther" :mealTime="saturdayOther" />
        </div>
      </span>
      <span class="SunOth"><div class="meal-box">
          <h4 class="mealType">Other</h4>
            <meal-mini v-bind:mealId="userMealPlan.sundayOther" :mealTime="sundayOther" />
        </div>
      </span>
    </div>
  </div>
</template>

<script>
import MealMini from "../components/MealMini.vue"
import MealPlanService from "../services/MealPlanService";
// import RecipeService from "../services/RecipeService";
export default {
  components: { MealMini },
  name: "planDetail",
  data() {
    return {
      userMealPlan: {},
      isLoading: true,
      mealTime: {
        mbColumn: "mondayBreakfast",
        mbMealTime: "Monday Breakfast"
      }
      
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
  background-color: #ffffff;
  max-width: 75%;
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
  margin-top: -3em;
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

.weekday {
  font-size: 1.5em;
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