<template>
  <div id="header">
    <h1>{{ msg }}</h1>
  </div>
</template>

<script>
export default {
  data() {
    return {
      msg: "",
    };
  },
  mounted() {
    fetch("/api/header")
        .then((response) => response.text())
        .then((data) => {
          this.msg = data;
        });
  },
};
</script>