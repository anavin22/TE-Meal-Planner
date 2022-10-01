<template>
  <div id="recipe-editor">
      <add-recipe />
      <finish-recipe />
  </div>
</template>

<script>
import AddRecipe from '../components/AddRecipe.vue'
import FinishRecipe from '../components/FinishRecipe.vue'
export default {
  components: { AddRecipe, FinishRecipe },
  data() {
      return {

      }
  },

}
</script>

<style>

</style>