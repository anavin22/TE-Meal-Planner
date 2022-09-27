<template>
  <div id="home">
    <h1>Latest Recipes</h1>
    <!-- <p>You must be authenticated to see this</p> -->
    <button>Add New Recipe</button>
  

    <div class="recipes-browse">
      <div class="card" v-for="recipe in recipes" :key="recipe.Id">
        <h2>{{recipe.title}}</h2>
        <p>{{recipe.description}}</p>
        <!-- <router-link :to> -->
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
  data() {
    return {
      recipe: {
        recipe_id: 1,
        created_by: 1,
        recipe_name: 'test-recipe',
        recipe_img: '',
        ingredients: [
          { ingredient_id: 1,
            name: 'ingredient1',
            quantity: 1,
            unit: 'whole',
        }
        ],
        instructions: ['instructions1', 'instructions2']
      }
    }
  }
  


};
</script>

<style>

#home {
  border-color: white;
  border-style: solid;
  border-width: 5px;
  border-radius: 40px;
  background-image: url("../assets/mainback2.png");
  background-position: left;
  background-repeat: repeat-x;
  background-size: cover, contain;
  position: fixed;
  top: 3em;
  bottom: 3em;
  right: 3em;
  left: 20%;
  color: #249492;
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
}

</style>