import { createStore } from 'vuex'

export default createStore({
  state: {
    user: {
      name: '',
      address: '',
      username: null,
      password: null,
      email: '',
      phone: ''
    }
  },
  mutations: {
    REGISTER(state, payload) {
      this.state.user = payload
    }
  },
  actions: {
    register({commit}, user) {
      commit('REGISTER', user)
    }
  },
  modules: {},
  getters: {
    getUsername: state => state.user.username,
    getPassword: state => state.user.password
  }
})
