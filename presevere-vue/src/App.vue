<template>
  <div id="app">
    <router-view />
    <date-time-picker @value-submit="getVal"></date-time-picker>
  </div>
</template>

<script>
import DateTimePicker from '@/components/DateTimePicker.vue'
export default {
  name: 'App',
  components: { DateTimePicker },
  methods: {
    getVal(year, month, dayOfMonth) {
      console.log(`${year}-${month}-${dayOfMonth}`)
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
}
</style>
