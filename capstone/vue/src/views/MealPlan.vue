<template>
    <div id="meal-plan" class="main-look">
        <header>
            <h1>My Meal Plan</h1>
        </header>

        <week-display/>

        <!-- Vue Carousel -->
        <div>
            
        </div>


  

        <!-- Meal Plan View -->
        <div class="days-of-week-container">
            <div class="Sunday" >Sunday</div>
            <div class="Monday">Monday</div>
            <div class="Tuesday">Tuesday</div>
            <div class="Wednesday">Wednesday</div>
            <div class="Thursday">Thursday</div>
            <div class="Friday">Friday</div>
            <div class="Saturday">Saturday</div>
        </div>
        <div class="meals-for-the-day-container">
        </div>
        <body class="week-view-container">
            
                
        </body>
</div>
</template>

<script>
import WeekDisplay from '../components/WeekDisplay.vue'
    

export default {
  components: { WeekDisplay },
    name: "MealPlan",

}
</script>

<style>
    
    .main-look {
  border-color: white;
  border-style: solid;
  border-width: 5px;
  border-radius: 40px;
  background-image: url("../assets/mainback.png");
  background-position: center;
  background-repeat: repeat-y;
  background-size: 75% auto;
  width: 80%;
  margin-right: auto;
  margin-left: auto;
  margin-top: -9em;
  padding-top: 6em;
  color: #249492;
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
  text-align: center;
  min-height: 100vh;
  z-index: -2;
}

.sidebar-left {
    

}

.days-of-week-container {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr;
    /* grid-template-rows: 1fr 1fr 1fr 1fr 1fr; */
    gap: 20px;
    text: bold;

}

.days-of-week-container div {
grid-template-rows: 1fr 1fr 1fr 1fr;
background-color:blanchedalmond;
}


</style>