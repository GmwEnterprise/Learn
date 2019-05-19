import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/login',
      name: 'home',
      component: () => import('@/views/Login.vue')
    },
    {
      path: '/home',
      name: 'login',
      component: () => import('@/views/Home.vue')
    }
  ]
})
