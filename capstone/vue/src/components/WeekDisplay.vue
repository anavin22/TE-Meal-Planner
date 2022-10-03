<template>
  <div class="week-display">
      <my-saved-recipes/>
      <add-to-meal-plan-form/>
  </div>
</template>

<script>
import AddToMealPlanForm from './AddToMealPlanForm.vue'
import MySavedRecipes from './MySavedRecipes.vue'
export default {
    name: "WeekDisplay",
    components: {MySavedRecipes, AddToMealPlanForm},
    props: [],
    methods: {

    }
}
</script>

<style>

</style>