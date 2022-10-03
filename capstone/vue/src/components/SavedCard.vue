<template>
  <div id="recipe-card">
            <h3 class="card-title">{{recipe.recipeName}}</h3>
      <img id="thumb" v-bind:src="recipe.image">

    <button class="add-to-mealplan-btn">
        Add To Meal Plan
    </button>
  </div>
</template>

<script>
export default {
    name: "recipeCard",
    props: ['recipe']

}
</script>

<style>
#recipe-card {
background: rgb(36,148,146);
background: linear-gradient(90deg, rgba(36,148,146,1) 70%, rgba(30,70,69,1) 100%);
height: 15em;
width: 10em;
border-radius: 20px;
color: white;
    overflow: hidden;
    position: relative;
}

.add-to-mealplan-btn {
    position: absolute;
    bottom: 0;
    margin-left: 50%;
    margin-right: 50%; 
    z-index: 100;
}

</style>