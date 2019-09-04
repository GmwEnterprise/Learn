import Vue from 'vue'
import DateTimePicker from './DateTimePicker.vue'
import QueryForm from './QueryForm.vue'
import FormControl from './FormControl.vue'

QueryForm.install = v => v.component('query-form', QueryForm)
FormControl.install = v => v.component('form-control', FormControl)
DateTimePicker.install = v => v.component('date-picker', DateTimePicker)

Vue.use(QueryForm)
Vue.use(FormControl)
Vue.use(DateTimePicker)
