import Vue from 'vue'
import DateTimePicker from './DateTimePicker.vue'
import QueryForm from './QueryForm.vue'

QueryForm.install = v => v.component('query-form', QueryForm)
DateTimePicker.install = v => v.component('date-picker', DateTimePicker)

Vue.use(QueryForm)
Vue.use(DateTimePicker)
