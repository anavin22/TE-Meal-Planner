<template>
  <div id="instructions">
      <h4>Instructions</h4>
      <ul>
          <li v-for="instruction in instructions" :key="instruction.id">{{ instruction }}</li>
      </ul>
  </div>
</template>

<script>
export default {
    name: "instructions",
    props: ['instructions']
}
</script>

<style>
#instructions {
    border-color: grey;
    border-style: solid;
    border-width: 1px;
    border-radius: 30px;
    background-color: #FFFFFF40;
    margin: auto;
    width: 50%;
    padding: 3%;
    font-size: 2em;
    margin: auto;
    width: 50%;
    text-align: left;
}

li {
    padding-bottom: 1em;
}

</style>