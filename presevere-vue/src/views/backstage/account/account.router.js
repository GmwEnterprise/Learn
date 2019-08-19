export default [
  {
    path: 'accountList',
    name: 'accountList',
    component: () => import('@/views/backstage/account/AccountList.vue')
  }, {
    path: 'accountEdit',
    name: 'accountEdit',
    component: () => import('@/views/backstage/account/AccountEdit.vue')
  }
]