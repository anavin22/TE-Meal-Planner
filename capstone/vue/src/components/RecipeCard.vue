<template>
  <div id="recipe-card" >
       <h3 class="card-title">{{recipe.recipeName}}</h3>
      <img id="thumb" v-bind:src="recipe.image">

  </div>
</template>

<script>
export default {
    name: "recipeCard",
    props: ['recipe']
}
</script>

<style>
#recipe-card {
background: rgb(36,148,146);
background: linear-gradient(90deg, rgba(36,148,146,1) 70%, rgba(30,70,69,1) 100%);
height: 15em;
width: 10em;
border-radius: 20px;
color: white;
overflow: hidden;
position: relative;
margin-right: -10px;
z-index: 200;
box-shadow: -5px 3px 3px darkslategray;
}

#recipe-card:hover {
    margin-right: 20px;
    margin-left: 20px;
    margin-bottom: 50px;
    margin-top: -50px;
    transform: rotate(-0.025turn);
}

#thumb {
    z-index: 1;
    height: 100%;
    width: 100%;
    object-fit: cover;
    display: block;
    opacity: .8;
}

.card-title {
    z-index: 100;
    position: absolute;
    top: 0;
    padding: 2%;
    background-color: #00000075;
}

</style>