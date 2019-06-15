<template>
  <div id="bloglist">
    <ul class="item-box">
      <li class="item" v-for="blog of blogList" :key="blog.id">
        <el-card class="box-card" shadow="hover">
          <router-link :to="`/blog/${blog.id}`">{{ blog.title }}</router-link>
        </el-card>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'AppBlogList',
  data() {
    return {
      blogList: [
        { id: 1, title: '这是一个博客的标题' },
        { id: 2, title: '这是一个博客的标题' },
        { id: 3, title: '这是一个博客的标题' },
        { id: 4, title: '这是一个博客的标题' },
        { id: 5, title: '这是一个博客的标题' },
        { id: 6, title: '这是一个博客的标题' },
        { id: 7, title: '这是一个博客的标题' },
        { id: 8, title: '这是一个博客的标题' },
        { id: 9, title: '这是一个博客的标题' },
        { id: 10, title: '这是一个博客的标题' },
        { id: 11, title: '这是一个博客的标题' },
        { id: 12, title: '这是一个博客的标题' }
      ]
    }
  }
}
</script>

<style>
.item-box {
  max-width: 700px;
  min-width: 300px;
  width: calc(100% - 200px);
  padding-top: 0.1px;
  margin: 0 auto;
}
.item {
  margin: 30px 0;
}
.box-card {
  width: 100%;
  text-align: center;
}
a {
  color: #444;
}
a:hover {
  text-decoration: none;
}
</style>
