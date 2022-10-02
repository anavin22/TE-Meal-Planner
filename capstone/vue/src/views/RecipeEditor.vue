<template>
  <div  class="main-look">
    <div id="recipe-editor">
      <add-recipe />
      <finish-recipe v-show="$store.state.workingId > 0"/>

    </div>
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
/* #recipe-editor {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas: 
    "new-name new-name new-name new-name" 
    ". new-pic new-ingredients new-ingredients" 
    "instructions instructions instructions instructions" 
    "add-ingredients add-ingredients add-instructions add-instructions";
} */

#recipe-editor {
  margin-top: 10%;
  margin-left: auto;
  margin-right: auto;
  max-width: 75%;

}

</style>