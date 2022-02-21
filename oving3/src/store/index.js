import { createStore } from 'vuex'

export default createStore({
  state: {
    name: '',
    epost: ''
  },
  mutations: {
    setName(state, payload) {
      state.name = payload
    },
    setEpost(state, payload) {
      state.epost = payload
    }
  },
  actions: {
    SETNAME( { commit }, name) {
      commit('setName', name)
    },
    SETEPOST( { commit }, epost) {
      commit('setEpost', epost)
    }

  },
  modules: {},
  getters: {
    getName: state => state.name,
    getEpost: state => state.epost

  }
})
