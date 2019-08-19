export default [
  {
    path: 'account/list',
    name: 'accountList',
    component: () => import('@/views/backstage/account/List.vue')
  }, {
    path: 'account/edit',
    name: 'accountEdit',
    component: () => import('@/views/backstage/account/Edit.vue')
  }
]