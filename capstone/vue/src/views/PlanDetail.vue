<template>
  <div class="main-look">
    <div id="week-display">
      <span class="Monday">Monday</span>
      <span class="Tuesday">Tuesday</span>
      <span class="Wednesday">Wednesday</span>
      <span class="Thursday">Thursday</span>
      <span class="Friday">Friday</span>
      <span class="Saturday">Saturday</span>
      <span class="Sunday">Sunday</span>
      <span class="MonBre">Breakfast</span>
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
export default {
    name: "planDetail",
    props: ['plan'],
    data() {
        return {
            detailedPlan: {
                mealplanId: 0,
                createdBy: 0,
                title: "",
                mealList: {}
            },
            MondayBreakfast: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            MondayLunch:  {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            MondayDinner: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            MondayOther: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            TuesdayBreakfast: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            TuesdayLunch: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            TuesdayDinner: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            TuesdayOther: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            WednesdayBreakfast: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            WednesdayLunch: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            WednesdayDinner: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            WednesdayOther: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            ThursdayBreakfast: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            ThursdayLunch: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            ThursdayDinner: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            ThursdayOther: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            FridayBreakfast: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            FridayLunch: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            FridayDinner: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            FridayOther: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            SaturdayBreakfast: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            SaturdayLunch: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            SaturdayDinner: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            SaturdayOther: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            SundayBreakfast: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            SundayLunch: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            SundayDinner: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
            SundayOther: {
                mealId: 0,
                recipeId: 0,
                mealType: "",
                dayOfWeek: ""
            },
        }
    }

};
</script>

<style>
#week-display {
    margin-top: 5%;
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