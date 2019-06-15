<template>
  <div id="app">
    <header>
      <app-header></app-header>
    </header>
    <main>
      <router-view></router-view>
    </main>
  </div>
</template>

<script>
import AppHeader from '@/components/AppHeader.vue'

export default {
  name: 'app',
  components: {
    AppHeader
  }
}
</script>

<style>
header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 100;
  height: 60px;
  padding: 0 15px;
  box-sizing: border-box;
  background-color: white;
}
main {
  margin-top: 60px;
  background-color: #f7f7f7;
  overflow: auto;
}
</style>
