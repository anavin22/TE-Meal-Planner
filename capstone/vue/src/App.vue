<template>
  <div id="app">
    <img id="logo" src="./assets/vector_long_logo_dRAGON.png">
    <div id="nav" v-show="checkLogin">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link> | 
      <router-link v-bind:to="{ name: 'myStuff' }">Edit My Recipes</router-link> | 
      <router-link v-bind:to="{name: 'planDetail'}">My Meal Plan</router-link> | 
      <router-link v-bind:to="{name: 'groceryList'}">Grocery List</router-link> | 
      <router-link v-bind:to="{name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  name: "app",
  data() {
    return {
      
    }
  },
    computed: {
    checkLogin() {
      return this.$store.state.token !== "";
    },
  },
}

</script>

<style>

#app {
  text-align: center;
  position: relative;
  z-index: 900;
  margin-top: 2em;
}

#nav {
  display: flex;
  background-color: #249492;
  position: relative;
    border-radius: 40px;
    align-items: center;
    justify-content: space-evenly;
    color: white;
    font-weight: bold;
    font-size: 1.5em;
    max-width: 75%;
    height: 40px;
    margin-top: -13px;
    margin-right: auto;
    margin-left: auto;
    z-index: 1000;
}

a:link {
  text-decoration: none;
}

a:visited {
  color: white;
}

a:hover {
  text-shadow: -5px 3px 3px darkslategray;
}

#logo {
  position: relative;
  margin-top: 3em;
  z-index: 9000;
  width: 50%;
  height: auto;
}

::-webkit-scrollbar {
  background-color: transparent;
  width: 5px;
}

::-webkit-scrollbar-thumb {
  background-color: #24949240;
  border-radius: 15px;
}


</style>

