import Vue from 'vue'
import Router from 'vue-router'
import _ from 'lodash'

Vue.use(Router)

const moduleRoutes = (() => {
  const r = require.context('./', true, /\.router\.js$/)
  const routes = r.keys().map(key => r(key).default)
  return _.flatten(routes)
})()

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
        ...moduleRoutes,
        {
          path: 'addLink',
          name: 'addServiceLink',
          component: () => import('@/views/backstage/AddServiceLink.vue')
        }, {
          path: 'tableList/:tableId',
          name: 'tableList',
          component: () => import('@/views/backstage/TableList.vue')
        }, {
          path: 'tableEdit/:tableId',
          name: 'tableEdit',
          component: () => import('@/views/backstage/TableEdit.vue')
        }
      ]
    }
  ]
})