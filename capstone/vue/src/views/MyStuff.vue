<template>
  <div class="main-look">
      <created-by-me />
    <button id="newRecBtn" @click.prevent="setAddNew">Add a New Recipe</button>
    <add-recipe v-if="addNew" />
  </div>
</template>

<script>
import AddRecipe from '../components/AddRecipe.vue'
import CreatedByMe from '../components/CreatedByMe.vue'
export default {
  components: { CreatedByMe, AddRecipe },
  name: "editRecipes",
  data() {
    return {
      addNew: false
    }
  },
  methods: {
    setAddNew() {
      this.addNew = true;
    }
  }

}
</script>

<style>
#newRecBtn {
  position: absolute;
  top: 10%;
  right: 15%;
}

</style>