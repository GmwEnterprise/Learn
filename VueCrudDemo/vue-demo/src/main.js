import Vue from 'vue'
import App from './App.vue'
import router from './router'

import Axios from 'axios'
import VueAxios from 'vue-axios'

import 'element-ui/lib/theme-chalk/index.css'
import Element from 'element-ui'

Vue.use(VueAxios, Axios)
Vue.use(Element)

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
