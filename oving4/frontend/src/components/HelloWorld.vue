<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <main id = "app" class="main">
      <div class="calculator">
        <div class="result">{{ variable1 }}</div>
        <button v-on:click= "C" class="button">C</button>
        <button v-on:click= "ANS" class="button">ANS</button>
        <button v-on:click= "DEL" class="button">DEL</button>
        <button v-on:click= "addition" class="button">+</button>
        <button v-on:click= "ONE" class="button">1</button>
        <button v-on:click= "TWO" class="button">2</button>
        <button v-on:click= "THREE" class="button">3</button>
        <button v-on:click= "subtraction" class="button">-</button>
        <button v-on:click= "FOUR" class="button">4</button>
        <button v-on:click= "FIVE" class="button">5</button>
        <button v-on:click= "SIX" class="button">6</button>
        <button v-on:click= "multiplication" class="button">*</button>
        <button v-on:click= "SEVEN" class="button">7</button>
        <button v-on:click= "EIGHT" class="button">8</button>
        <button v-on:click= "NINE" class="button">9</button>
        <button v-on:click= "division" class="button">/</button>
        <button class="button" disabled></button>
        <button v-on:click= "ZERO" class="button">0</button>
        <button v-on:click= "COMMA" class="button">.</button>
        <button v-on:click= "equal" class="equal">=</button>
      </div>
      <div class="log">
        <ol>
          <li v-for= "logItem in log" v-bind:key="logItem"> {{ logItem }}</li>
        </ol>
      </div>
    </main>
  </div>

  <footer>
    <div class="footer">
      <p> A Brilliant Website by Sindre Glomnes.</p>
    </div>
  </footer>

</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data(){
    return{
      variable1: "",
      log: [],
      reset: false,
      sum: "0",
    }
  },
  methods: {
    ONE(){
      if(this.reset) {
        this.variable1 = ""
        this.reset = false
      }
      this.variable1 += 1
    },
    TWO(){
      if(this.reset) {
        this.variable1 = ""
        this.reset = false
      }
      this.variable1 += 2
    },
    THREE(){
      if(this.reset) {
        this.variable1 = ""
        this.reset = false
      }
      this.variable1 += 3
    },
    FOUR(){
      if(this.reset) {
        this.variable1 = ""
        this.reset = false
      }
      this.variable1 += 4
    },
    FIVE(){
      if(this.reset) {
        this.variable1 = ""
        this.reset = false
      }
      this.variable1 += 5
    },
    SIX(){
      if(this.reset) {
        this.variable1 = ""
        this.reset = false
      }
      this.variable1 += 6
    },
    SEVEN(){
      if(this.reset) {
        this.variable1 = ""
        this.reset = false
      }
      this.variable1 += 7
    },
    EIGHT(){
      if(this.reset) {
        this.variable1 = ""
        this.reset = false
      }
      this.variable1 += 8
    },
    NINE(){
      if(this.reset) {
        this.variable1 = ""
        this.reset = false
      }
      this.variable1 += 9
    },
    ZERO(){
      if(this.reset) {
        this.variable1 = ""
        this.reset = false
      }
      this.variable1 += 0
    },
    COMMA(){
      if(this.reset) {
        this.variable1 = ""
        this.reset = false
      }
      this.variable1 += "."
    },
    addition(){
      if(this.reset) {
        this.variable1 = ""
        this.reset = false
      }
      this.variable1 += "+"
    },
    subtraction(){
      if(this.reset) {
        this.variable1 = ""
        this.reset = false
      }
      this.variable1 += "-"
    },
    multiplication(){
      if(this.reset) {
        this.variable1 = ""
        this.reset = false
      }
      this.variable1 += "*"
    },
    division(){
      if(this.reset) {
        this.variable1 = ""
        this.reset = false
      }
      this.variable1 += "/"
    },

    C(){
      this.variable1 = ""
    },
    ANS(){
      this.variable1 = this.sum + ""
      this.reset = false
    },
    DEL(){
      if(this.reset) {
        this.variable1 = ""
        this.reset = false
      }
      this.variable1 = this.variable1.substring(0, this.variable1.length - 1);
    },
    equal() {
      this.reset = true

      this.handleEquals()

    },
    async handleEquals() {
      const response = await fetch('http://localhost:8080/calculation', {
        method: "POST",
        mode: "cors",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ calculationString: this.variable1 }),
      });

      const data = await response.json()

      this.sum = data.answer
      this.log.push(this.variable1 + ' = ' + this.sum)
    },
  },

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

button{
  font-family: Arial, fantasy;
  font-size: 20px;
  max-block-size: 60px;
  border-radius: 5%;
}

.main div{
  font-family: Arial, fantasy;
  font-size: 20px;
  text-align: center;
}

.calculator{

  margin-left: auto;
  margin-right: auto;
  margin-top: 50px;
  grid-area: calc;
  border: 3px solid black;
  display: grid;
  height: 400px;
  width: 300px;

  grid-template-areas: "result result result result"
    "C ANS DEL PLUS"
    "ONE TWO THREE MINUS"
    "FOUR FIVE SIX GANGE"
    "SEVEN EIGHT NINE DELE"
    "EMPTY ZERO COMMA EQUAL";
  grid-template-columns: 25% 25% 25%;
}

.log{
  margin-left: auto;
  margin-right: auto;
  grid-area: log;
  margin-top: 20px;
  min-height: 40px;
  border: 3px solid black;
  width: 300px;
}

.result{grid-area: result;
  margin-top: 40px;
  height: 40px;
  width: 300px;}


.footer{
  text-align: center;
  margin-top: 100px;
}

</style>
