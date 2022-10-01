<template>
  <div id="ingredients-instructions">
      <ul>
          <li v-for="ing in recIngs" :key="ing.id"></li>
      </ul>
      <ol>
          <li v-for="inst in recInst" :key="inst.id"></li>
      </ol>
      <form>
          
          <section class="ingwrapper">
            <h3>Ingredients:</h3>

            <div class="dropdown">
                <input class="inginput" v-model="ingredientSearch" type="text" name="ingSearch" id="ingSearch">
                <div class="options">
                    <ul>
                        <li v-for="ingredient in allIngredients" :key="ingredient.id">{{ ingredient.name }}</li>
                    </ul>
                </div>
            </div>

          </section>
          
          <input type="text" id="addIngred" placeholder="Add an Ingredient">

        <h3>Instructions</h3>

      </form>
  </div>
</template>

<script>
import RecipeService from '../services/RecipeService'
export default {
    name: "finishRecipe",
    data() {
        return {
            recIngs: [],
            allIngredients: [],
            recInst: [],
        }
    },
    created() {
        RecipeService
        .getAllIngredients()
        .then(response => {
            this.allIngredients = response.data;
        });
    }
}
</script>

<style>

.ingwrapper {
    max-width: 350px;
    position: relative;
    margin: 0 auto;
    height: 40px;
    border: 2px solid lightgray;
    border-radius: 15px;
    padding: 5px 10px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-size: 20px;
    font-weight: 500;
}

.dropdown {
    position: absolute;
    border: 2px solid lightgray;
    top: 46px;
    left: 0;
    right: 0;
    background-color: white;
}

.inginput {
    width: 90%;
    height: 30px;
    border: 2px solid lightgray;
    font-size: 16px;
    padding-left: 5px;
}

.options {
    width: 100%;
}

.options ul {
    list-style: none;
    text-align: left;
    padding-left: 8px;
    max-height: 180px;
    overflow-y: scroll;
    overflow-x: hidden;
    border: 1px solid lightgray;
}

.options li {
    width: 100%;
    border-bottom: 1px solid lightgray;
    padding: 10px;
    cursor: pointer;
}

.options li:hover {
    background-color: darkslategray;
    color: white;
    font-weight: bold;
}

</style>