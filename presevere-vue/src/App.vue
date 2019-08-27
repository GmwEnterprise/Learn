<template>
  <div id="app">
    <router-view />
    <date-time-picker></date-time-picker>
  </div>
</template>

<script>
import DateTimePicker from '@/components/DateTimePicker.vue'
export default {
  name: 'App',
  components: { DateTimePicker }
}
</script>


<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
}
</style>
