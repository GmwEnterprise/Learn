import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    toast: {
      message: '',
      type: 'info'
    }
  },
  mutations: {
    toast(state, toastOptions) {
      state.toast = {
        message: toastOptions.message || '空',
        type: toastOptions.type || 'info'
      }
    }
  },
  actions: {

  }
})
