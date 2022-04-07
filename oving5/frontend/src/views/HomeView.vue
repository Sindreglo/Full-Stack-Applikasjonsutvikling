<template>
  <div class="home">
    <HeaderComponent/>
    <CalculatorComponent/>
  </div>
</template>

<script>
// @ is an alias to /src
import HeaderComponent from "@/components/MainHeader";
import CalculatorComponent from "@/components/CalculatorComponent";

export default {
  name: 'HomeView',
  components: {
    HeaderComponent,
    CalculatorComponent,
  }
}
</script>

<style>
.home {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
