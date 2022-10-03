<template>
  <div  class="main-look">
    <div id="recipe-editor">
      <br>
      
      <add-recipe />
      
      <finish-recipe v-show="$store.state.workingId > 0"/>
        <div class="loader"></div>
    </div>
    
      
    
  </div>
</template>

<script>
import AddRecipe from '../components/AddRecipe.vue'
import FinishRecipe from '../components/FinishRecipe.vue'
export default {
  components: { AddRecipe, FinishRecipe },
  data() {
      return {

      }
  },

}
</script>

<style>
#recipe-editor {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas: 
    "new-name new-name new-name new-name" 
    ". new-pic new-ingredients new-ingredients" 
    "instructions instructions instructions instructions" 
    "add-ingredients add-ingredients add-instructions add-instructions";
}

#recipe-editor {
  margin-top: 10%;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: auto;
  max-width: 50%;
  max-height: 100%;
  border: 4px solid;
  border-radius: 15px;

}

/* Swiggly Bois */

.loader {
  --s: 40px; /* control the size */
  --b: 18px; /* control the border thickness */

  width: calc(8*var(--s));
  aspect-ratio: 4;
  display: grid;
  
  
  
  
}
.loader::before,
.loader::after {
  content: "";
  grid-area: 1/1;
  background: 
    linear-gradient(#BD1550 50%,#249492 0) no-repeat,
    linear-gradient(#03B2DB 50%,#249492 0) no-repeat;
  background-size: 50% 200%;
  --_g: calc(-.45*var(--s)), #0000 calc(99% - var(--b)),#000 calc(101% - var(--b)) 99%,#0000 101%;
  --_s: calc(4*var(--s)) var(--s) repeat-x;
  --_r: calc(1.096*var(--s) + var(--b)/2);
  -webkit-mask:
    radial-gradient(var(--_r) at left 50% bottom var(--_g)) 
      calc(50% - 2*var(--s)) calc(50% - var(--s)/2)/var(--_s),
    radial-gradient(var(--_r) at left 50% top    var(--_g)) 
      50%                    calc(50% + var(--s)/2)/var(--_s);
  animation: 
    back 6s   infinite steps(1),
    load 1.5s infinite linear alternate;
}
.loader::after {
  transform: scaleY(-1);
  animation-delay: -1.5s;
}

@keyframes load {
  0%{clip-path: inset(0 75% 0 0)}
  to{clip-path: inset(0 0 0 75%)}
}
@keyframes back {
  0%,
  100%{background-position: 0%   0%,100% 0%  }
  25% {background-position: 0% 100%,100% 0%  }
  50% {background-position: 0% 100%,100% 100%}
  75% {background-position: 0%   0%,100% 100%}
}


body {
  margin: 0;
  min-height: 100vh;
  display: grid;
  place-content: center;
  
}

</style>