import Vue from 'vue'
import DateTimePicker from './DateTimePicker.vue'
import QueryForm from './QueryForm.vue'
import FormControl from './FormControl.vue'
import PageComponent from './Page.vue'

QueryForm.install = v => v.component('query-form', QueryForm)
FormControl.install = v => v.component('form-control', FormControl)
DateTimePicker.install = v => v.component('date-picker', DateTimePicker)
PageComponent.install = v => v.component('page-component', PageComponent)

Vue.use(QueryForm)
Vue.use(FormControl)
Vue.use(DateTimePicker)
Vue.use(PageComponent)
