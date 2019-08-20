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

// 我写的插件
import Toast from './plugins/toast.js'
Vue.prototype.$toast = new Toast()

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
