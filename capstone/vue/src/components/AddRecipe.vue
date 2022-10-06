<template>
  <div id="add-recipe" v-if="!submitted">
    <form v-show="!submitted" @submit.prevent="addRecipeToDB">
      <label for="RecipeName">Recipe Name: </label>
      <input
        type="text"
        id="RecipeName"
        v-model="newName"
        placeholder="What are you making?"
        required
      /><br />

      <label for="ImageUrl">Image URL: </label>
      <input
        type="text"
        id="ImageUrl"
        v-model="imageUrl"
        placeholder="Paste the image URL here"
        required
      /><br />

      <button type="submit">Add Recipe</button
      ><button @click.prevent="submitted = true">Close</button>
    </form>

    <h3>Image Preview</h3>
    <img id="new-pic" :src="imageUrl" />

    <!-- <span v-show="submitted">
      <h2 id="new-name">{{ newName }}</h2>
      <img id="new-pic" :src="imageUrl" />
    </span> -->
  </div>
</template>

<script>
import RecipeService from "../services/RecipeService";
export default {
  name: "addRecipe",
  data() {
    return {
      submitted: false,
      newName: "",
      imageUrl: "",
      recipe: {
        recipeName: "",
        image: "",
      },
    };
  },

  methods: {
    addRecipeToDB() {
      this.recipe.recipeName = this.newName;
      this.recipe.image = this.imageUrl;
      RecipeService.addRecipeToDB(this.recipe).then((response) => {
        if (response.status == 200) {
          this.submitted = true;
          this.$store.commit("UPDATE_WORKING_ID", response.data);
        } else {
          alert("Something went wrong.");
        }
      });
    },
  },
};
</script>

<style>
#add-recipe {
  position: fixed;
  right: 5%;
  top: 5%;
  margin: auto;
  padding: 5px;
  width: 40%;
  box-shadow: -5px 3px 3px darkslategray;
  border-radius: 15px;
  background-color: aliceblue;
  z-index: 99999;
}

#new-pic {
  max-width: 80%;
  height: auto;
  border-radius: 30px;
  box-shadow: -5px 3px 3px darkslategray;
}

#new-name {
  grid-area: new-name;
}

button {
  display: inline-block;
  outline: none;
  cursor: pointer;
  margin-top: 20 px;
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
  font-size: 14px;
  line-height: 1;
  border-radius: 500px;
  transition-property: background-color, border-color, color, box-shadow, filter;
  transition-duration: 0.3s;
  border: 1px solid transparent;
  letter-spacing: 2px;
  min-width: 160px;
  text-transform: uppercase;
  white-space: normal;
  font-weight: 700;
  text-align: center;
  padding: 16px 14px 18px;
  color: #ffffff;
  box-shadow: inset 0 0 0 1px #000000;
  background-color: teal;
  height: 48px;
}

button:hover {
  color: #fff;
  background-color: #616467;
}

input {
  padding: 5px 12px;
  font-size: 14px;
  line-height: 20px;
  color: #24292e;
  vertical-align: middle;
  background-color: #ffffff;
  background-repeat: no-repeat;
  background-position: right 8px center;
  border: 1px solid #e1e4e8;
  border-radius: 6px;
  outline: none;
  box-shadow: rgba(225, 228, 232, 0.2) 0px 1px 0px 0px inset;
}

input:focus {
  border-color: #0366d6;
  outline: none;
  box-shadow: rgba(3, 102, 214, 0.3) 0px 0px 0px 3px;
}

#Img-Url {
  margin-bottom: 15px;
}
</style>