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
          <meal-mini v-bind:mealId="userMealPlan.tuesdayBreakfast" :mealTimeColumn="mealTime.tubColumn" :mealTime="mealTime.tubMealTime" />
        </div>
      </span>
      <span class="WedBre">
        <div class="meal-box">
          <h4 class="mealType">Breakfast</h4>
          <meal-mini v-bind:mealId="userMealPlan.wednesdayBreakfast" :mealTimeColumn="mealTime.wbColumn" :mealTime="mealTime.wbMealTime" />
        </div>
      </span>
      <span class="ThurBre">
              <div class="meal-box">
          <h4 class="mealType">Breakfast</h4>
            <meal-mini v-bind:mealId="userMealPlan.thursdayBreakfast" :mealTimeColumn="mealTime.thbColumn" :mealTime="mealTime.thbMealTime" />
        </div>
      </span>
      <span class="FriBre"><div class="meal-box">
          <h4 class="mealType">Breakfast</h4>
            <meal-mini v-bind:mealId="userMealPlan.fridayBreakfast" :mealTimeColumn="mealTime.fbColumn" :mealTime="mealTime.fbMealTime" />
        </div>
      </span>
      <span class="SatBre"><div class="meal-box">
          <h4 class="mealType">Breakfast</h4>
            <meal-mini v-bind:mealId="userMealPlan.saturdayBreakfast" :mealTimeColumn="mealTime.sabColumn" :mealTime="mealTime.sabMealTime" />
        </div>
      </span>
      <span class="SunBre"><div class="meal-box">
          <h4 class="mealType">Breakfast</h4>
            <meal-mini v-bind:mealId="userMealPlan.sundayBreakfast" :mealTimeColumn="mealTime.subColumn" :mealTime="mealTime.subMealTime" />
        </div>
      </span>
      <span class="MonLun"><div class="meal-box">
          <h4 class="mealType">Lunch</h4>
            <meal-mini v-bind:mealId="userMealPlan.mondayLunch" :mealTimeColumn="mealTime.mlColumn" :mealTime="mealTime.mlMealTime" />
        </div>
      </span>
      <span class="TueLun"><div class="meal-box">
          <h4 class="mealType">Lunch</h4>
            <meal-mini v-bind:mealId="userMealPlan.tuesdayLunch" :mealTimeColumn="mealTime.tulColumn" :mealTime="mealTime.tulMealTime" />
        </div>
      </span>
      <span class="WedLun"><div class="meal-box">
          <h4 class="mealType">Lunch</h4>
            <meal-mini v-bind:mealId="userMealPlan.wednesdayLunch" :mealTimeColumn="mealTime.wlColumn" :mealTime="mealTime.wlMealTime" />
        </div>
      </span>
      <span class="ThurLun"><div class="meal-box">
          <h4 class="mealType">Lunch</h4>
            <meal-mini v-bind:mealId="userMealPlan.thursdayLunch" :mealTimeColumn="mealTime.thlColumn" :mealTime="mealTime.thlMealTime" />
        </div>
      </span>
      <span class="FriLun"><div class="meal-box">
          <h4 class="mealType">Lunch</h4>
            <meal-mini v-bind:mealId="userMealPlan.fridayLunch" :mealTimeColumn="mealTime.flColumn" :mealTime="mealTime.flMealTime" />
        </div>
      </span>
      <span class="SatLun"><div class="meal-box">
          <h4 class="mealType">Lunch</h4>
            <meal-mini v-bind:mealId="userMealPlan.saturdayLunch" :mealTimeColumn="mealTime.salColumn" :mealTime="mealTime.salMealTime" />
        </div>
      </span>
      <span class="SunLun"><div class="meal-box">
          <h4 class="mealType">Lunch</h4>
            <meal-mini v-bind:mealId="userMealPlan.sundayLunch" :mealTimeColumn="mealTime.sulColumn" :mealTime="mealTime.sulMealTime" />
        </div>
      </span>
      <span class="MonDin"><div class="meal-box">
          <h4 class="mealType">Dinner</h4>
            <meal-mini v-bind:mealId="userMealPlan.mondayDinner" :mealTimeColumn="mealTime.mdColumn" :mealTime="mealTime.mdMealTime" />
        </div>
      </span>
      <span class="TueDin"><div class="meal-box">
          <h4 class="mealType">Dinner</h4>
            <meal-mini v-bind:mealId="userMealPlan.tuesdayDinner" :mealTimeColumn="mealTime.tudColumn" :mealTime="mealTime.tudMealTime" />
        </div>
      </span>
      <span class="WedDin"><div class="meal-box">
          <h4 class="mealType">Dinner</h4>
            <meal-mini v-bind:mealId="userMealPlan.wednesdayDinner" :mealTimeColumn="mealTime.wdColumn" :mealTime="mealTime.wdMealTime" />
        </div>
      </span>
      <span class="ThurDin"><div class="meal-box">
          <h4 class="mealType">Dinner</h4>
            <meal-mini v-bind:mealId="userMealPlan.thursdayDinner" :mealTimeColumn="mealTime.thdColumn" :mealTime="mealTime.thdMealTime" />
        </div>
      </span>
      <span class="FriDin"><div class="meal-box">
          <h4 class="mealType">Dinner</h4>
            <meal-mini v-bind:mealId="userMealPlan.fridayDinner" :mealTimeColumn="mealTime.fdColumn" :mealTime="mealTime.fdMealTime" />
        </div>
      </span>
      <span class="SatDin"><div class="meal-box">
          <h4 class="mealType">Dinner</h4>
            <meal-mini v-bind:mealId="userMealPlan.saturdayDinner" :mealTimeColumn="mealTime.sadColumn" :mealTime="mealTime.sadMealTime" />
        </div>
      </span>
      <span class="SunDin"><div class="meal-box">
          <h4 class="mealType">Dinner</h4>
            <meal-mini v-bind:mealId="userMealPlan.sundayDinner" :mealTimeColumn="mealTime.sudColumn" :mealTime="mealTime.sudMealTime" />
        </div>
      </span>
      <span class="MonOth"><div class="meal-box">
          <h4 class="mealType">Other</h4>
            <meal-mini v-bind:mealId="userMealPlan.mondayOther" :mealTimeColumn="mealTime.moColumn" :mealTime="mealTime.moMealTime" />
        </div>
      </span>
      <span class="TueOth"><div class="meal-box">
          <h4 class="mealType">Other</h4>
            <meal-mini v-bind:mealId="userMealPlan.tuesdayOther" :mealTimeColumn="mealTime.tuoColumn" :mealTime="mealTime.tuoMealTime" />
        </div>
      </span>
      <span class="WedOth"><div class="meal-box">
          <h4 class="mealType">Other</h4>
            <meal-mini v-bind:mealId="userMealPlan.wednesdayOther" :mealTimeColumn="mealTime.woColumn" :mealTime="mealTime.woMealTime" />
        </div>
      </span>
      <span class="ThurOth"><div class="meal-box">
          <h4 class="mealType">Other</h4>
            <meal-mini v-bind:mealId="userMealPlan.thursdayOther" :mealTimeColumn="mealTime.thoColumn" :mealTime="mealTime.thoMealTime" />
        </div>
      </span>
      <span class="FriOth"><div class="meal-box">
          <h4 class="mealType">Other</h4>
            <meal-mini v-bind:mealId="userMealPlan.fridayOther" :mealTimeColumn="mealTime.foColumn" :mealTime="mealTime.foMealTime" />
        </div>
      </span>
      <span class="SatOth"><div class="meal-box">
          <h4 class="mealType">Other</h4>
            <meal-mini v-bind:mealId="userMealPlan.saturdayOther" :mealTimeColumn="mealTime.saoColumn" :mealTime="mealTime.saoMealTime" />
        </div>
      </span>
      <span class="SunOth"><div class="meal-box">
          <h4 class="mealType">Other</h4>
            <meal-mini v-bind:mealId="userMealPlan.sundayOther" :mealTimeColumn="mealTime.suoColumn" :mealTime="mealTime.suoMealTime" />
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
        mbMealTime: "Monday Breakfast",
        mlColumn: "mondayLunch",
        mlMealTime: "Monday Lunch",
        mdColumn: "mondayDinner",
        mdMealTime: "Monday Dinner",
        moColumn: "mondayOther",
        moMealTime: "Monday Other",

        tubColumn: "tuesdayBreakfast",
        tubMealTime: "Tuesday Breakfast",
        tulColumn: "tuesdayLunch",
        tulMealTime: "Tuesday Lunch",
        tudColumn: "tuesdayDinner",
        tudMealTime: "Tuesday Dinner",
        tuoColumn: "tuesdayOther",
        tuoMealTime: "Tuesday Other",

        wbColumn: "wednesdayBreakfast",
        wbMealTime: "Wednesday Breakfast",
        wlColumn: "wednesdayLunch",
        wlMealTime: "Wednesday Lunch",
        wdColumn: "wednesdayDinner",
        wdMealTime: "Wednesday Dinner",
        woColumn: "wednesdayOther",
        woMealTime: "Wednesday Other",

        thbColumn: "thursdayBreakfast",
        thbMealTime: "Thursday Breakfast",
        thlColumn: "thursdayLunch",
        thlMealTime: "Thursday Lunch",
        thdColumn: "thursdayDinner",
        thdMealTime: "Thursday Dinner",
        thoColumn: "thursdayOther",
        thoMealTime: "Thursday Other",

        fbColumn: "fridayBreakfast",
        fbMealTime: "Friday Breakfast",
        flColumn: "fridayLunch",
        flMealTime: "Friday Lunch",
        fdColumn: "fridayDinner",
        fdMealTime: "Friday Dinner",
        foColumn: "fridayOther",
        foMealTime: "Friday Other",

        sabColumn: "saturdayBreakfast",
        sabMealTime: "Saturday Breakfast",
        salColumn: "saturdayLunch",
        salMealTime: "Saturday Lunch",
        sadColumn: "saturdayDinner",
        sadMealTime: "Saturday Dinner",
        saoColumn: "saturdayOther",
        saoMealTime: "Saturday Other",

        subColumn: "sundayBreakfast",
        subMealTime: "Sunday Breakfast",
        sulColumn: "sundayLunch",
        sulMealTime: "Sunday Lunch",
        sudColumn: "sundayDinner",
        sudMealTime: "Sunday Dinner",
        suoColumn: "sundayOther",
        suoMealTime: "Sunday Other",
      }
      
    };
  },
  created() {
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