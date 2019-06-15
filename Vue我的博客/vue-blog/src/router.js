import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      redirect: '/index'
    }, {
      path: '/index',
      component: () => import('@/views/AppBlogList.vue')
    }, {
      path: '/blog/:id',
      component: () => import('@/views/AppBlog.vue')
    }, {
      path: '/about',
      component: () => import('@/views/About.vue')
    }
  ]
})
