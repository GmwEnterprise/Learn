<template>
  <div class="item-card">
    <h4 class="title">这里是标题</h4>
    <div class="content">这里是内容</div>
    <div class="item-foot">
      {{ `${writer} 发表于 ${createTime}` }}
    </div>
  </div>
</template>

<script>
export default {
  name: 'item',
  data() {
    return {
      writer: 'GmwEnterprise',
      createTime: '2019-07-10 15:00:00'
    }
  },
}
</script>

<style>
.item-card {
  padding: 10px;
  background-color: white;
}
</style>
