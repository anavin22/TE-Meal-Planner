<template>
  <div class="home">
    <h1>Browse Recipes</h1>
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

