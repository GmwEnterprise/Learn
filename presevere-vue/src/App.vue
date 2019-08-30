<template>
  <div id="app">
    <router-view />
    <date-picker v-model="value" :width="width"></date-picker>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      value: '',
      width: '15rem'
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
}
</style>
