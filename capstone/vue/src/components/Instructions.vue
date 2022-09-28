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
    font-size: 1.5em;
    margin: auto;
    width: 50%;
    text-align: left;
}

li {
    padding-bottom: 1em;
}

</style>