<template>
  <div id="modify-instruct">

      <textarea class="ModifyInstructionText" type="text" v-model="$props.instruction.instruction_text" /><button @click.prevent="updateInstructions">Update Step</button>
      <!-- <button @click.prevent="removeInstructions">Remove Step</button> -->


  </div>
</template>

<script>
import RecipeService from '../services/RecipeService'
export default {
    name: "modifyInstructions",
    props: ['instruction'],
    data() {
        return {
            instructionText: this.$props.instruction.instruction_text
        }
    },

    methods: {
        updateInstructions() {
            RecipeService
            .modifyInstructions(this.$props.instruction, this.$props.instruction.instruction_id)
            .then(response => {
                if(response.status == 200) {
                    alert("Step Updated!");
                } else {
                    alert("Please try again later.");
                }
            });
        },
        removeInstructions(){
            RecipeService
            .removeInstruction(this.$props.instruction.instruction_id)
                        .then(response => {
                if(response.status == 200) {
                    alert("Step Removed!");
                } else {
                    alert("Please try again later.");
                }
            });
        }
    }

}
</script>

<style>

</style>