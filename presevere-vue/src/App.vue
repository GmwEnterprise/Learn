<template>
  <div id="app">
    <router-view />
    <customize-toast></customize-toast>
  </div>
</template>

<script>
import CustomizeToast from '@/components/Toast.vue'
export default {
  name: 'App',
  components: { CustomizeToast }
}
</script>


<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
}
</style>
