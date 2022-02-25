<template>
  <div class="about">
    <h1>Register yourself!</h1>
  </div>

  <form @submit.prevent="onSubmit">
    <div id="input_field2">
      <div class="form-group">
        <label>Full name:</label>
        <input data-testid="inputName" v-model="user.name" />
      </div>

      <div class="form-group">
        <label>Address:</label>
        <input data-testid="inputAddress" v-model="user.address" />
      </div>

      <div class="form-group">
        <label>Username:</label>
        <input data-testid="inputUsername" v-model="user.username" />
      </div>

      <div class="form-group">
        <label>Password:</label>
        <input data-testid="inputPassword" v-model="user.password" />
      </div>

      <div class="form-group">
        <label>Email:</label>
        <input data-testid="inputEmail" v-model="user.email" type="email" />
      </div>

      <div class="form-group">
        <label>Phone:</label>
        <input data-testid="inputPhone" v-model="user.phone" />
      </div>

      <button :disabled="user.username === '' && user.password === ''" type="submit">Register</button>
    </div>
  </form>
</template>

<script>
export default {
  data() {
    return {
      user: {
        name: '',
        address: '',
        username: '',
        password: '',
        email: '',
        phone: ''
      }
    }
  },
  methods: {
    onSubmit() {
      this.$store.dispatch('register', this.user)
      this.$router.push({
        name: 'Login'
      })
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
