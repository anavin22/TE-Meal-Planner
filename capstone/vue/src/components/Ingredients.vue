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

    border-color: grey;
    border-style: solid;
    border-width: 1px;
    border-radius: 30px;
    margin: auto;
    width: 50%;
    padding: 3%;
    font-size: 1.5em;
}

tr {
    position: relative;
    text-align: left;
    margin: auto;
    padding-left: 20%;
}


</style>