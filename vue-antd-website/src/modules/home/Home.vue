<template>
  <div id="home">
    <common-header></common-header>
    <main>
      <a-row>
        <a-col :span="16">
          <article-list></article-list>
        </a-col>
        <a-col :span="8">
          <web-master-intro></web-master-intro>
        </a-col>
      </a-row>
    </main>
  </div>
</template>

<script>
import CommonHeader from '@/components/CommonHeader.vue'
import ArticleList from './ArticleList'
import WebMasterIntro from './WebMasterIntro'
export default {
  name: 'Home',
  components: {
    CommonHeader,
    ArticleList,
    WebMasterIntro
  },
  data() {
    return {
      title: 'Hello world'
    }
  }
}
</script>

<style>
main {
  width: 960px;
  margin: 70px auto 0;
}
</style>

