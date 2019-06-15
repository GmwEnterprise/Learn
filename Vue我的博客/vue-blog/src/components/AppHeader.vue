<template>
  <div id="app-header">
    <span>路不该是疑问句</span>
    <div class="link-box">
      <router-link :to="'/'">博客</router-link>
      <router-link :to="'/about'">关于</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AppHeader',
  methods: {
    toBlogList() {
      alert(1)
      console.log(this.$route)
      console.log(this.$router)
      // this.$router.push('/index')
    },
    toAbout() {
      alert(2)
    }
  }
}
</script>

<style>
#app-header {
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-size: 1.3em;
}
.link-box {
  display: flex;
  justify-content: space-around;
  width: 100px;
  font-size: 15px;
}
</style>
