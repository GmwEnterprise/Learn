<template>
  <div id="app">
    <router-view />
    <date-picker v-model="value"></date-picker>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      value: ''
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
}
</style>
