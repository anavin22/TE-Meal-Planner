<template>
  <div id="recipe-card">
      <img id="thumb" v-bind:src="recipe.image">
      <h3>{{recipe.recipeName}}</h3>
      <input type="checkbox" id="save" name="saved" value="saved">
      <label for="saved">Save Recipe</label>
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
}

#thumb {
    max-height: 10em;
    width: auto;
    margin: .5em;
    border-radius: 15px;
}

</style>