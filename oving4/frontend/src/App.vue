<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Calculator</router-link> |
      <router-link to="/kontaktskjema">Kontaktskjema</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

button {
  align-items: center;

  background: #5FC314;
  color: #ffffff;
  border: white 2px solid;

  font-size: 18px;
  font-weight: 800;
  cursor: pointer;
  transition: all 0.2s linear;
}

button:hover {
  background: #57af15;
  -webkit-transform: scale(1.02);
  transform: scale(1.01);
  box-shadow: 0 3px 12px 0 rgba(0, 0, 0, 0.2);
}

h2 {
  font-size: 40px;
  font-weight: 700;
}

h3 {
  font-size: 25px;
  font-weight: 700;
}

h4 {
  font-size: 20px;
  font-weight: 700;
}

input {
  display: block;
  height: 30px;
  margin-bottom: 24px;
}

input[type=text] {
  padding: 0px 10px;
}

textarea {
  display: block;
  height: 100px;
  margin-bottom: 24px;
  max-width: 160px;
  min-width: 160px;
}

input:focus {
  border-color: #5FC314;
  outline: 0;
}


#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

select:focus {
  border-color: #16c0b0;
  outline: 0;
}
</style>
