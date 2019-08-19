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
// import 'bootstrap/dist/css/bootstrap.min.css'

// // my css
// import '@/assets/global.css'

// // font-awesome
// import '@fortawesome/fontawesome-free/css/all.min.css'

// // 后台模型控制专用
// import '@/assets/backstage.css'

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
