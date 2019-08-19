// import ArticleList from '@/views/backstage/article/article.list.vue'
// import ArticleEdit from '@/views/backstage/article/article.edit.vue'

export default [
  {
    path: 'articleList',
    name: 'articleList',
    // component: ArticleList
    component: () => import('@/views/backstage/article/ArticleList.vue')
  }, {
    path: 'articleEdit',
    name: 'articleEdit',
    // component: ArticleEdit
    component: () => import('@/views/backstage/article/ArticleEdit.vue')
  }
]