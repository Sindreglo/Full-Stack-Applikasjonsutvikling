<template>
  <div class="about">
    <h1>Please Login</h1>
  </div>

  <form @submit.prevent="onSubmit">
    <div id="input_field">
      <div class="form-group">
        <label>Username:</label>
        <input data-testid="inputName" v-model="username" />
      </div>
      <div class="form-group">
        <label>Password:</label>
        <input data-testid="inputPassword" v-model="password" type="password" />
      </div>
      <button>Sign in</button>
    </div>
    <p v-show="failed">
      Not registered yet! <router-link to="/register">Register</router-link>
    </p>
  </form>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
      failed: false
    }
  },
  methods: {
    onSubmit() {
      if (
        this.$store.getters.getUsername === this.username &&
        this.$store.getters.getPassword === this.password
      ) {
        this.$router.push({
          name: 'Home'
        })
      } else {
        this.failed = true
      }
    }
  }
}
</script>

<style>
form {
  background-color: #fff;
  height: 600px;
  width: 600px;
  margin-right: auto;
  margin-left: auto;
  margin-top: 0px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
  padding: 0px;
}

label {
  font-size: 18px;
  color: #333;
  height: 20px;
  width: 200px;
  margin-top: 20px;
  margin-left: 10px;
  text-align: right;
  margin-right: 15px;
  float: left;
}
input {
  height: 20px;
  width: 300px;
  border: 1px solid #000;
  margin-top: 20px;
}

button {
  margin-top: 20px;
  margin-left: 30%;
  padding: 5px 30px 5px 30px;
  font-size: 18px;
}
</style>
