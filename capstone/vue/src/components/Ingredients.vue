<template>
  <div id="ingredients">
      <h4>Ingredients</h4>
      <table>
          <tr v-for="ingredient in ingredients" :key="ingredient.id">
             <td>{{ingredient.quantity}} {{ingredient.unit}}</td>
              <td>{{ingredient.name}}</td>

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
#ingredients {
    width: 50%;
    font-size: 2em;
    text-align: left;
}

tr {
    position: relative;
    text-align: left;
    margin: auto;
    padding-left: 20%;
}


</style>