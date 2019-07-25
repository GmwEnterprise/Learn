<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import store from '@/services/local-store.js'
export default {
  name: 'App',
  created() {
    if (store.exist('identification')) {
      this.$store.commit('changeLoginStatus')
    }
  }
}
</script>


<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
}
</style>
