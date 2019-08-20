export default [
  {
    path: 'modules/account',
    name: 'accountList',
    component: () => import('@/views/backstage/account/AccountList.vue')
  }, {
    path: 'modules/account/edit',
    name: 'accountEdit',
    component: () => import('@/views/backstage/account/AccountEdit.vue')
  }
]