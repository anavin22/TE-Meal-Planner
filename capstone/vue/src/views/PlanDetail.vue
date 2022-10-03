<template>
  <div class="main-look">
              <h1 class="plan0title"> {{detailedPlan.title}} </h1> 
    <div id="week-display">
      <span class="Monday"><h3 class="weekday">Monday</h3></span>
      <span class="Tuesday"><h3 class="weekday">Tuesday</h3></span>
      <span class="Wednesday"><h3 class="weekday">Wednesday</h3></span>
      <span class="Thursday"><h3 class="weekday">Thursday</h3></span>
      <span class="Friday"><h3 class="weekday">Friday</h3></span>
      <span class="Saturday"><h3 class="weekday">Saturday</h3></span>
      <span class="Sunday"><h3 class="weekday">Sunday</h3></span>
      <span class="MonBre">
          <div class="meal-box">
              <h4>Breakfast</h4>
              <h4>{{ mondayBreakfast.name }}</h4>
              <img src="" alt="" class="meal-thumb">
          </div>



      </span>
      <span class="TueBre">Breakfast</span>
      <span class="WedBre">Breakfast</span>
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
import MealService from '../services/MealService'
import RecipeService from '../services/RecipeService';
export default {
    name: "planDetail",
    props: ['plan'],
    data() {
        return {
            detailedPlan: {
                mealplanId: 0,
                createdBy: 0,
                title: "",
                mealList: []
            },
            mondayBreakfast: {
                id: 0,
                name: "",
                img: ""
            },
            mondayLunch:  0,
            mondayDinner: 0,
            mondayOther: 0,
            tuesdayBreakfast: 0,
            tuesdayLunch: 0,
            tuesdayDinner: 0,
            tuesdayOther: 0,
            wednesdayBreakfast: 0,
            wednesdayLunch: 0,
            wednesdayDinner: 0,
            wednesdayOther: 0,
            thursdayBreakfast: 0,
            thursdayLunch: 0,
            thursdayDinner: 0,
            thursdayOther: 0,
            fridayBreakfast: 0,
            fridayLunch: 0,
            fridayDinner: 0,
            fridayOther: 0,
            saturdayBreakfast: 0,
            saturdayLunch: 0,
            saturdayDinner: 0,
            saturdayOther: 0,
            sundayBreakfast: 0,
            sundayLunch: 0,
            sundayDinner: 0,
            sundayOther: 0
        }
    },
    computed: {
        mondayBreakfastName(){
            return this.getRecipeName(this.mondayBreakfast.id)
        }

    },

    // watch: {
    //     mondayBreakfastName() 
    // },

    methods: {
        assignMeals(){
            this.detailedPlan.mealList.forEach(meal => {
                if(meal.dayOfWeek === 'Monday') {
                    if(meal.mealType === "Breakfast") {
                        this.mondayBreakfast.id = meal.recipeId;
                        this.mondayBreakfast.name = this.getRecipeName(meal.recipeId);
                    } if (meal.mealType === "Lunch"){
                        this.mondayLunch = meal.recipeId;
                        
                    }
                }
            });
        },

        getRecipeName(recipeId) {
            RecipeService.getRecipeById(recipeId).then(response=> {
                console.log(response.data.recipeName)
                this.mondayBreakfast.name = response.data.recipeName;
                return response.data.recipeName;
            })
        },

        getRecipeImage(recipeId) {
            return this.getRecipeInfo(recipeId).image;
        },
    },
    created() {
    MealService.getPlanById(parseInt(this.$route.params.id)).then(
      (response) => {
          this.detailedPlan = response.data;
                this.assignMeals();
      });
    }

};
</script>

<style>
#week-display {
    background-color: #FFFFFF;
    right: 0;
    margin-top: 5%;
    margin-left: .5em;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr;
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