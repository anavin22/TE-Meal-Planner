<template>
<div id="modifiable">
  <div
    id="recipe-card-vertical"
    @click="selectCard"
    v-bind:class="{ selected: $store.state.workingId === selectedModifyId }"
  >
    <h3 class="card-title">{{ recipe.recipeName }}</h3>
    <img id="thumb-vertical" v-bind:src="recipe.image" />
  </div>
    <div id="changeBox" v-if="$store.state.workingId === selectedModifyId">

  <modify-recipe />
    </div>
</div>
</template>

<script>
import ModifyRecipe from './ModifyRecipe.vue';
export default {
  name: "createdRecipeCard",
  props: ["recipe"],
components: { ModifyRecipe },
  data() {
    return {
      selectedModifyId: this.$props.recipe.recipeId,
    };
  },
  methods: {
    selectCard() {
      if (this.$store.state.workingId === this.selectedModifyId) {
        this.$store.commit("UPDATE_WORKING_ID", 0);
      } else {
        this.$store.commit("UPDATE_WORKING_ID", this.selectedModifyId);
      }
    },
  },
};
</script>

<style>
/* #modifiable {
  display: flex;
  justify-content: center;
} */

#recipe-card-vertical {
  background: rgb(36, 148, 146);
  background: linear-gradient(
    90deg,
    rgba(36, 148, 146, 1) 70%,
    rgba(30, 70, 69, 1) 100%
  );
  height: 15em;
  width: 10em;
  border-radius: 20px;
  color: white;
  overflow: hidden;
  position: relative;
  margin-bottom: -8em;
  margin-left: 10%;
  z-index: 200;
  box-shadow: -5px 3px 3px darkslategray;
}

#recipe-card-vertical:hover {
  transform: rotate(0.025turn);
}

.selected {
  transform: rotate(0.05turn);
}

#thumb-vertical {
  z-index: 1;
  height: 100%;
  width: 100%;
  object-fit: cover;
  display: block;
  opacity: 0.8;
}

.card-title {
  z-index: 100;
  position: absolute;
  top: 0;
  padding: 2%;
  background-color: #00000075;
}
</style>