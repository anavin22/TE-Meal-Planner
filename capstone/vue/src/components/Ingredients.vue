<template>
  <div id="ingredients">

      <table>
          <tr>
              <th></th>
              <th>Quantity</th>
              <th>Ingredient</th>
          </tr>
          <tr v-for="ingredient in ingredients" :key="ingredient.id">
              <td></td>
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
    font-size: 2em;
    text-align: left;
}

tr {
    position: relative;
    text-align: left;
    margin: auto;

}


</style>