<template>
  <div id="instructions">
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

</style>