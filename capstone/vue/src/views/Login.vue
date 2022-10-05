<template>
  <div id="back">
    <div id="login" class="text-center">
      <form class="form-signin" @submit.prevent="login">
        <h1 class="h3 mb-3 font-weight-normal">Welcome back!</h1>
        <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
          Thank you for registering, please sign in.
        </div>
        <label for="username" class="sr-only">Username: </label>
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        /><br />
        <label for="password" class="sr-only">Password: </label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        /><br />

        <button type="submit">Sign in</button><br />
        <button>
        <router-link class="registerLink" :to="{ name: 'register' }">Need an account?</router-link></button>
      </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style>

#login {
  border-color: white;
  border-style: solid;
  border-width: 5px;
  border-radius: 40px;
  background-image: url("../assets/Back2.png");
  background-position: left;
  background-repeat: no-repeat;
  background-size: cover, contain;
  position: fixed;
  top: 3em;
  bottom: 3em;
  right: 3em;
  left: 3em;
  color: #249492;
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
}

h1 {
  font-size: 4em;
}

form {
  position: absolute;
  left: 5%;
  top: 5%;
  font-size: 1.5em;
  text-align: left;
}

#registerLink a {
  color: #249492;
}

</style>