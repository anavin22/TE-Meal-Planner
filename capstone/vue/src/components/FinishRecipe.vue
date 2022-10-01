<template>
  <div id="ingredients-instructions">

    <section id="new-ingredients">
      <table>
          <tr v-for="ingredient in $store.state.workingRecipe.ingredientList" :key="ingredient.id">
             <td>{{ingredient.quantity}} {{ingredient.unit}}</td>
              <td>{{ingredient.name}}</td>
              <td>Button to remove ingredient will go here</td>

          </tr>
      </table>
    </section>



    <section id="new-instructions">
      <ol>
        <li v-for="inst in $store.state.workingRecipe.instructions" :key="inst.id"></li>
      </ol>
    </section>


    <section id="add-ingredients">
      <h3>Add Ingredients:</h3>


<div>
        <form id="add-an-ingredient-to-working-recipe" @submit.prevent="addIngredientToWorkingRecipe">
        <label for="ingredient-to-add">Ingredient: </label>
          <input id="ingredient-to-add" name="ingredient-to-add" type="text" :value="selectedIngredient.name" required readonly="readonly" />

        <br>

        <label for="enter-quantity">Quantity: </label>
        <input id="enter-quantity" name="enter-quantity" type="number" step="0.01" v-model="quantity" required=">0" />

        <br>

        <label for="enter-unit">Unit: </label>
        <input id="enter-unit" name="enter-unit" type="text" v-model="unit" required />

        <button>Add To Recipe</button>


      </form>

</div>

        <div class="dropdown">
          <input
            class="ingredient-search-entry"
            v-model="ingredientSearch"
            type="text"
            name="ingSearch"
            id="ingSearch"
            placeholder="Search Ingredient Database"
          />
          <div class="options">
            <ul>
              <li
                v-for="ingredient in filteredIngredient"
                :key="ingredient.id"
                @click="selectIngredient(ingredient)"
              >
                {{ ingredient.name }}
              </li>
            </ul>
          </div>
          <div id="addIngredient" v-if="filteredIngredient.length === 0">
            <h4>Can't find the ingredient you need?</h4>
            <input
              v-model="newIngredient.name"
              type="text"
              id="addIngred"
              placeholder="Add a new Ingredient"
            />
            <button @click.prevent="addNewIngredient">Add It</button>
          </div>
        </div>
        

    </section>

    <section id="add-instructions">
      <form>
        <h3>Instructions</h3>
      </form>
    </section>
  </div>
</template>

<script>
import RecipeService from "../services/RecipeService";
export default {
  name: "finishRecipe",
  data() {
    return {
      recIngs: [],
      allIngredients: [],
      recInst: [],
      ingredientSearch: "",
      sequence: 0,
      quantity: 0.0,
      unit: "",
      selectedIngredient: {
        ingredientId: "",
        name: "",
      },
      newIngredient: {
        name: "",
      }
    };
  },
  computed: {
    filteredIngredient() {
      const ingQuery = this.ingredientSearch.toLowerCase();
      if (this.ingredientSearch === "") {
        return this.allIngredients;
      }
      return this.allIngredients.filter((ingredient) => {
        return Object.values(ingredient).some((word) =>
          String(word).toLowerCase().includes(ingQuery)
        );
      });
    },
  },
  created() {
    RecipeService.getAllIngredients().then((response) => {
      this.allIngredients = response.data;
    });
  },
  methods: {
    selectIngredient(ingredient) {
      this.selectedIngredient.ingredientId = ingredient.ingredientId;
      this.selectedIngredient.name = ingredient.name;
    },
    addNewIngredient() {
      RecipeService.addIngredientToDB(this.newIngredient).then((response) => {
        if (response.status === 200) {
          this.selectedIngredient.name = this.newIngredient.name;
          this.selectedIngredient.ingredientId = response.data;
        } else {
          alert("Something went wrong.");
        }
      });
    },
    sequenceIterator() {
      this.sequence = this.sequence + 1;
    },
    addIngredientToWorkingRecipe() {
        let workingIngredient =
            {
        ingredientId: this.selectedIngredient.ingredientId,
        name: this.selectedIngredient.name,
        type: "",
        quantity: this.quantity,
        unit: this.unit
            };
        this.$store.commit('ADD_INGREDIENT_TO_WORKING_RECIPE', workingIngredient)
        this.quantity = 0.0;
        this.unit = "";
        this.selectedIngredient = {
        ingredientId: "",
        name: "",
      };

    }
  },
};
</script>

<style>
/* .ingwrapper {
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
} */

.dropdown {
  border: 2px solid lightgray;
  top: 46px;
  left: 0;
  right: 0;
  background-color: white;
}

.ingredient-search-entry {
  width: 90%;
  height: 30px;
  border: none;
  font-size: 16px;
  margin: auto;
  position: relative;
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

#new-ingredients {
  grid-area: new-ingredients;
  min-height: 20vh;
}

#new-instructions {
  grid-area: new-instructions;
}

#add-ingredients {
  grid-area: add-ingredients;
  position: relative;
  bottom: 0;
  right: 0;
}

#add-instructions {
  grid-area: add-instructions;
}

#ingredient-to-add, #enter-quantity, #enter-unit {
    width: 50%;
    height: 20px;
    font-size: 18px;
    margin-bottom: 20px;
    margin-right: 20px;
}
</style>