<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>

export default {

}

</script>

<style>

#nav {
  display: flex;
  background-color: #249492;
    border-radius: 40px;
    align-items: center;
    justify-content: center;
    color: white;
    font-weight: bold;
    width: 20%;
    height: 40px;
    margin: auto 3em 3em 3em;
    z-index: 900;
}


</style>

