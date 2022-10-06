<template>
  <div id="add-instructions">
    <form>
      <h3>Add Instructions</h3>
      <textarea
        id="add-instruction"
        v-model="instructionText"
        placeholder="Enter your instructions one step at a time."
      />
      <button @click.prevent.stop="addInstructionToWorkingRecipe">
        Add Instruction to Recipe
      </button>
    </form>
  </div>
</template>

<script>
import RecipeService from "../services/RecipeService";
export default {
  name: "addInstructions",
  data() {
    return {
      instructionText: "",
    };
  },
  methods: {
    addInstructionToWorkingRecipe() {
      let workingInstruction = {
        recipeId: this.$store.state.workingId,
        sequence: this.sequence,
        instruction_text: this.instructionText,
      };

      RecipeService.addInstructionToRecipe(workingInstruction).then(
        (response) => {
          this.$store.commit(
            "ADD_INSTRUCTION_TO_WORKING_RECIPE",
            workingInstruction
          );
          this.instructionText = "";
          return response.data;
        }
      );
    },
  },
};
</script>

<style>
#add-instructions {
  position: absolute;
  left: 0;
  right: 0;
  margin: auto;
  width: 50%;
  box-shadow: -5px 3px 3px darkslategray;
  border-radius: 15px;
  background-color: white;
  z-index: 99999;
}
</style>