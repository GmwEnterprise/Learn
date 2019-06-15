<template>
  <div id="blog">
    <div class="article-box">
      <h2 class="title">这里是标题。</h2>
      <hr>
      <div class="content">这里是内容。</div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AppBlog'
}
</script>

<style>
#blog {
  width: 700px;
  margin: 0 auto;
}
.title {
  font-size: 35px;
  padding: 30px 0;
}
.content {
  margin-top: 40px;
  margin-bottom: 100px;
  font-size: 18px;
}
</style>
