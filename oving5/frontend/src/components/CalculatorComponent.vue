<template>
  <h1 id="calcDisplay">{{ display }}</h1>
  <div class="Calculator" id="Calculator">
    <button
        v-bind:class="button.class"
        v-bind:id="button.id"
        v-bind:key="button.id"
        v-for="button in buttonList"
        @click="addToDisplay(button.id)"
    >
      {{ button.id }}
    </button>
  </div>
  <div id="dbLogg">
    <h3>DB Log</h3>
    <ul>
      <li v-bind:key="dbLogg[expression]" v-for="expression in dbLogg">
        {{ expression }}
      </li>
    </ul>
  </div>
  <button v-on:click="startNr - 4; this.setLogg2">Forrige</button>
  <button v-on:click="startNr + 4; this.setLogg2">Nesten</button>
  <div id="dbLogg2">
    <h3>DB Log</h3>
    <ul>
      <li v-bind:key="dbLogg2[expression]" v-for="expression in dbLogg2">
        {{ expression }}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dbLogg: [],
      dbLogg2: [],
      startNr: 0,
      pageOfItems: [],
      display: "",
      buttonList: [
        { id: "7", class: "nr-button" },
        { id: "8", class: "nr-button" },
        { id: "9", class: "nr-button" },
        { id: "/", class: "operator-button" },
        { id: "4", class: "nr-button" },
        { id: "5", class: "nr-button" },
        { id: "6", class: "nr-button" },
        { id: "*", class: "operator-button" },
        { id: "1", class: "nr-button" },
        { id: "2", class: "nr-button" },
        { id: "3", class: "nr-button" },
        { id: "-", class: "operator-button" },
        { id: "0", class: "nr-button" },
        { id: ".", class: "nr-button" },
        { id: "=", class: "function-button" },
        { id: "+", class: "operator-button" },
        { id: "AC", class: "function-button" },
        { id: "DEL", class: "function-button" },
      ],
      answer: 0,
      reset: false
    };
  },
  async created() {
    await this.getDBLogg();
    this.setLogg2();
  },
  methods: {
    addToDisplay(buttonsId) {
      if (this.reset) {
        this.display = "";
        this.reset = false;
      }
      if (buttonsId === "AC") {
        this.display = "";
      } else if (buttonsId === "DEL") {
        this.display = this.display.substring(0, this.display.length - 1);
      } else if (buttonsId === "=") {
        try {
          this.calculate();
        } catch (e) {
          this.display = Error("Something in your Syntax is wrong");
        }
        this.reset = true;
      } else {
        this.display += buttonsId;
      }
    },
    async calculate() {
      const response = await fetch("/api/calculate", {
        method: "POST",
        mode: "cors",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ expression: this.display }),
      });
      const data = await response.json();
      this.answer = data.answer;
      this.display = this.display + "=" + this.answer;
      await this.getDBLogg();
      this.setLogg2();
    },
    async getDBLogg() {
      const response = await fetch("/api/expressions", {
        method: "GET",
        mode: "cors",
        headers: {
          "Content-Type": "application/json",
        },
      });
      const data = await response.json();
      this.dbLogg = [];
      for (let i = 0; i < data.length; i++) {
        this.dbLogg.unshift(
            "User: " +
            data[i].username +
            ", " +
            " Expression: " +
            data[i].expression +
            "=" +
            data[i].answer
        );
      }
    },
    setLogg2() {
      let a = this.startNr;
      this.dbLogg2[0] = this.dbLogg[a]
      this.dbLogg2[1] = this.dbLogg[a+1]
      this.dbLogg2[2] = this.dbLogg[a+2]
      this.dbLogg2[3] = this.dbLogg[a+3]
    }
  }
}
</script>

<style>
#Calculator {
  width: 400px;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  border: solid black;
  height: 31vw;
  background-color: #008b8b;
  gap: 0.5vw;
}

#calcDisplay {
  height: 50px;
}

button {
  font-size: 20px;
}
</style>
