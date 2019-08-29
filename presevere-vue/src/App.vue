<template>
  <div id="app">
    <router-view />
    <date-time-picker :year="year" :month="month" @value-submit="getVal"></date-time-picker>
  </div>
</template>

<script>
import DateTimePicker from '@/components/DateTimePicker.vue'
export default {
  name: 'App',
  data() {
    return {
      year: 2019,
      month: 8
    }
  },
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
