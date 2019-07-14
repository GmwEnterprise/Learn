import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('@/views/home/Home.vue')
    }, {
      path: '/about',
      name: 'about',
      component: () => import('@/views/about/About.vue')
    }, {
      path: '/writer',
      name: 'writer',
      component: () => import('@/views/writer/Writer.vue')
    }, {
      path: '/article',
      name: '/article',
      component: () => import('@/views/article/Article.vue')
    }
  ]
})
