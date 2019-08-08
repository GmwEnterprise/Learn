<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import session from '@/services/session-store.js'
export default {
  name: 'App',
  created() {
    if (session.exist('identification')) {
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
