<template>
  <div id="recipe-card">
            <h3>{{recipe.recipeName}}</h3>
      <img id="thumb" v-bind:src="recipe.image">

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

</style>