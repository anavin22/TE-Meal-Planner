<template>
  <div id="add-recipe">
      <form v-show="!submitted" @submit.prevent="addRecipeToDB">
          <label for="RecipeName">Recipe Name</label>
          <input type="text" id="RecipeName" v-model="newName" placeholder="Recipe Name" required />

          <label for="ImageUrl">Image URL</label>
          <input type="text" id="ImageUrl" v-model="imageUrl" placeholder="Provide a link to an image for this recipe" required />

          <button type="submit">Add This Recipe</button>
      </form>
      <span v-show="submitted">
          <h2 id="new-name">{{ newName }}</h2>
          <img id="new-pic" :src="imageUrl">
      </span>

  </div>
</template>

<script>
import RecipeService from '../services/RecipeService'
export default {
    name: "addRecipe",
    data(){
        return {
            submitted: false,
            newName: '',
            imageUrl: '',
            recipe: {
                recipeName: '',
                image: ''
            }
        }
    },

    methods: {
        addRecipeToDB(){
            this.recipe.recipeName = this.newName;
            this.recipe.image = this.imageUrl;
            RecipeService
            .addRecipeToDB(this.recipe)
            .then(response => {
                if(response.status == 200) {
                    this.submitted = true;
                    this.$store.commit('UPDATE_WORKING_ID', response.data);
                } else {
                    alert("Something went wrong.")
                }
            });
        }
    }
}
</script>

<style>
#new-pic {
    grid-area: new-pic;
  max-width: 100%;
  height: auto;
  border-radius: 30px;
  box-shadow: 20px 16px teal;
}

#new-name {
    grid-area: new-name;
}

</style>