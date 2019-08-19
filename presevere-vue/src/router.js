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
          path: 'tableList/:tableId',
          name: 'tableList',
          component: () => import('@/views/backstage/TableList.vue')
        }, {
          path: 'tableEdit/:tableId',
          name: 'tableEdit',
          component: () => import('@/views/backstage/TableEdit.vue')
        }, {
          path: 'addLink',
          name: 'addServiceLink',
          component: () => import('@/views/backstage/AddServiceLink.vue')
        }
      ]
    }
  ]
})