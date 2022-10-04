<template>
  <div id="mini-fave">
            <h3 class="mini-fave-title">{{recipe.recipeName}}</h3>
      <img id="mini-thumb" v-bind:src="recipe.image">

    <!-- <button class="add-to-mealplan-btn">
        Add To Meal Plan
    </button> -->
  </div>
</template>

<script>
export default {
    name: "miniCard",
    props: ['recipe']

}
</script>

<style>
#mini-fave {
background: rgb(36,148,146);
background: linear-gradient(90deg, rgba(36,148,146,1) 70%, rgba(30,70,69,1) 100%);
height: 8em;
width: 5em;
border-radius: 20px;
color: white;
overflow: hidden;
position: relative;
/* margin-right: -10px; */
z-index: 200;
box-shadow: -5px 3px 3px darkslategray;
}

#mini-fave:hover {
    /* margin-right: 20px;
    margin-left: 20px;
    margin-bottom: 50px;
    margin-top: -80px; */
    transform: rotate(-0.025turn);
}

#mini-thumb {
    z-index: 1;
    height: 100%;
    width: 100%;
    object-fit: cover;
    display: block;
    opacity: .8;
}

.mini-fave-title {
    z-index: 100;
    position: absolute;
    top: 0;
    padding: 2%;
    background-color: #00000075;
    font-size: 1em;
}

</style>