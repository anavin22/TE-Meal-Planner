import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    recipeSaved: false,
    workingId: 0,
    savedRecipes: []
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_RECIPE_SAVED(state, newValue) {
      state.recipeSaved = newValue;
    },
    GET_SAVED_LIST(state, recipeList) {
      state.savedRecipes = recipeList;
    },
    CHECK_SAVED_LIST(state, id) {
      if(state.savedRecipes.includes(id)){
        return true;
      }
    },

    ADD_SAVED_RECIPE(state, id) {
      state.savedRecipes.push(id);
    },

    REMOVE_SAVED_RECIPE(state, id) {
      state.savedRecipes = this.state.savedRecipes.filter(recipe => recipe !== id);
    },

    UPDATE_WORKING_ID(state, id) {
      state.workingId = id;
    }
  }
})
