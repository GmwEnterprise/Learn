import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import URL from '@/constants/url.js'

Vue.prototype.URL = URL

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
