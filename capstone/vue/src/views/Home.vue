<template>
  <div class="home">
    <h1>Browse Recipes</h1>
    <!-- <p>You must be authenticated to see this</p> -->
    <button>Add New Recipe</button>
  

    <div class="recipes-browse">
      <div class="card" v-for="recipe in $store.state.recipes" :key="">
        <h2>{{recipe.title}}</h2>
        <p>{{recipe.description}}</p>
        <!-- <router-link :to -->
          <button>View Recipe</button>
          <button>Save Recipe</button>
        <!-- </router-link> -->
      </div>
    </div>
  </div>
</template>



<script>
export default {
  name: "home",


};
</script>

