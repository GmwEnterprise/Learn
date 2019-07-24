<template>
  <div class="item-list">
    <div class="item-wrapper">
      <item></item>
    </div>
  </div>
</template>

<script>
import Item from './Item.vue'
import { queryAll as queryAllAccount } from '@/services/account.js'
export default {
  name: 'itemList',
  components: { Item },
  created() {
    queryAllAccount(null, data => console.log(data), () => console.error('error ajax !'))
  }
}
</script>

<style>
.item-list {
  background-color: white;
  width: 100%;
  box-shadow: 0 1px 3px rgba(26,26,26,.1);
}
</style>
