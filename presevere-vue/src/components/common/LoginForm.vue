<template>
  <div>
    <b-form @submit="submit()">
      <b-form-group>
        <b-form-input id="input-phone" v-model="phone" required placeholder="输入你的手机号码"></b-form-input>
      </b-form-group>
      <b-button type="submit" variant="primary" style="float: right;">确定</b-button>
    </b-form>
  </div>
</template>

<script>
import validator from '@/tools/validator.js'
import accountService from '@/services/account.js'
import store from '@/services/local-store.js'
export default {
  name: 'LoginForm',
  data() {
    return {
      phone: ''
    }
  },
  methods: {
    submit() {
      if (validator.validPhone(this.phone)) {
        accountService.sign(this.phone, data => {
          store.set('identification', data)
          this.$store.commit('changeLoginStatus')
        }, () => {
          console.error('登陆报错')
        })
      }
    }
  }
}
</script>

<style>
</style>
