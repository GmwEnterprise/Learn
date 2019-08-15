import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'index',
      component: () => import('@/views/index/Index.vue')
    }, {
      path: '/sys',
      name: 'system',
      component: () => import('@/views/backstage/Main.vue'),
      children: [
        {
          path: '/account',
          component: () => import('@/views/backstage/models/Account.vue')
        }
      ]
    }
  ]
})
