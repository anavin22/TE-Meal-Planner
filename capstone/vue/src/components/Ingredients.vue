<template>
  <div id="ingredients">
      <table>
          <tr v-for="ingredient in ingredients" :key="ingredient.id">
              <td>{{ingredient.name}}</td>
              <td>{{ingredient.quantity}} {{ingredient.unit}}</td>
          </tr>
      </table>
  </div>
</template>

<script>
export default {
    name: "ingredients",
    props: ['ingredients']
}
</script>

<style>

</style>