// css
import '@/assets/css.import.js'

// sys
import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'

// bootstrap
import 'bootstrap'

Vue.config.productionTip = false

// toast全局命令
Vue.prototype.$toast = {
  success(message) {
    store.commit('toast', { message, type: 'success' })
  },
  warning(message) {
    store.commit('toast', { message, type: 'warning' })
  },
  danger(message) {
    store.commit('toast', { message, type: 'danger' })
  },
  info(message) {
    store.commit('toast', { message, type: 'info' })
  }
}

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
