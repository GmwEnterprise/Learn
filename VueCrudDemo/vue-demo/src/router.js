import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    { path: '/test', component: () => import('@/testviews/test.vue') },
    {
      path: '/',
      component: () => import('@/views/list.vue')
    }, {
      path: '/add',
      component: () => import('@/views/add.vue')
    }, {
      path: '/edit/:id',
      component: () => import('@/views/edit.vue')
    }
  ]
})
