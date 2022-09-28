<template>
  <div id="card-box">
      <recipe-card v-bind:recipe="recipe" v-for="recipe in recipes" v-bind:key="recipe.id" />
  </div>
</template>

<script>
import RecipeCard from './RecipeCard.vue'
export default {
  components: { RecipeCard },
    name: "cardBox",
    data() {
        return {
            recipes: [
                {
        recipe_id: 1,
        created_by: 1,
        recipe_name: 'test-recipe',
        recipe_img: 'https://static01.nyt.com/images/2021/02/17/dining/17tootired-grilled-cheese/17tootired-grilled-cheese-articleLarge.jpg',
        ingredients: [
          { ingredient_id: 1,
            name: 'ingredient1',
            quantity: 1,
            unit: 'whole',
        }
        ],
        instructions: ['instructions1', 'instructions2']
      },
      {
        recipe_id: 1,
        created_by: 1,
        recipe_name: 'test-recipe',
        recipe_img: 'https://static01.nyt.com/images/2021/02/17/dining/17tootired-grilled-cheese/17tootired-grilled-cheese-articleLarge.jpg',
        ingredients: [
          { ingredient_id: 1,
            name: 'ingredient1',
            quantity: 1,
            unit: 'whole',
        }
        ],
        instructions: ['instructions1', 'instructions2']
      },
                      {
        recipe_id: 1,
        created_by: 1,
        recipe_name: 'test-recipe',
        recipe_img: 'https://static01.nyt.com/images/2021/02/17/dining/17tootired-grilled-cheese/17tootired-grilled-cheese-articleLarge.jpg',
        ingredients: [
          { ingredient_id: 1,
            name: 'ingredient1',
            quantity: 1,
            unit: 'whole',
        }
        ],
        instructions: ['instructions1', 'instructions2']
      },
      {
        recipe_id: 1,
        created_by: 1,
        recipe_name: 'test-recipe',
        recipe_img: 'https://static01.nyt.com/images/2021/02/17/dining/17tootired-grilled-cheese/17tootired-grilled-cheese-articleLarge.jpg',
        ingredients: [
          { ingredient_id: 1,
            name: 'ingredient1',
            quantity: 1,
            unit: 'whole',
        }
        ],
        instructions: ['instructions1', 'instructions2']
      }
            ]
        }
    }
}
</script>

<style>
#card-box {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}

</style>