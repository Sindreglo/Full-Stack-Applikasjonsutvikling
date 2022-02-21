<template>
  <div class="kontaktskjema">
    <h1>Kontaktskjema for tilbakemelding</h1>
    <div class="form-container">
      <form @submit.prevent="onSubmit">
        <label>Navn</label>
        <input
          v-model="name"
          type="text"
          placeholder="name"
        >

        <label>Epost</label>
        <input
          v-model="epost"
          type="text"
          placeholder="epost"
        />
        <label>Melding</label>
        <div>
          <textarea
            id="meldinginput"
            v-model="melding"
            type="text"
            placeholder="Melding"
          />
        </div>
        <button :disabled="name === '' || epost === '' || melding === ''" class="submit" type="submit">{{ submit }}</button>
      </form>
    </div>
  </div>
</template>

<script>

export default {

  data() {
    return {
      name: '',
      epost: '',
      melding: '',
      submit: 'Submit'
    }
  },
  mounted() {
    this.name = this.$store.getters.getName;
    this.epost = this.$store.getters.getEpost;
  },
  methods: {
    onSubmit() {

      this.submit = 'Sender...'
      setTimeout(() => {
        this.submit = 'Sendt'
      }, 1000);
      this.$store.dispatch('SETNAME', this.name)
      this.$store.dispatch('SETEPOST', this.epost)
    }
  }
}

</script>

<style>

.submit {
  padding: 10px 30px 10px 30px;
}

.form-container {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  margin-bottom: 10%;
}

.submit:disabled {
  border: red 2px solid;
}

</style>

