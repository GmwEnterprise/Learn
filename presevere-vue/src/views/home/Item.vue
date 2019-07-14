<template>
  <div class="item-card">
    <div class="item-head"></div>
    <div class="item-title">
      <router-link to="/article" class="article-link">这里是标题</router-link>
    </div>
    <div class="item-foot">
      <div class="left">
        <router-link to="/writer" class="writer-link">{{ writer }}</router-link>
        创作于 {{ createTime }}
      </div>
      <div class="right">{{ `阅读量 300，点赞 40` }}</div>
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
  }
}
</script>

<style>
.item-card {
  padding: 20px;
  background-color: white;
}
.item-title {
  font-size: 22px;
  height: 50px;
  line-height: 50px;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}
.item-foot {
  font-style: italic;
  font-size: 14.5px;
  color: #888;
  display: flex;
  justify-content: space-between;
}
.article-link {
  color: #222;
}
.writer-link {
  color: #888;
}
.writer-link:hover {
  color: #444;
}
</style>
