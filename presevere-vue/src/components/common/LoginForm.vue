<template>
  <div>
    <div v-if="isLogin">{{ JSON.stringify(currentUser) }}</div>
    <b-form v-else>
      <b-form-group>
        <b-form-input id="input-phone" v-model="phone" required placeholder="输入你的手机号码"></b-form-input>
      </b-form-group>
      <b-button type="button" @click="loginSubmit" variant="primary" style="float: right;">确定</b-button>
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
      phone: '',

      currentUser: {}
    }
  },
  computed: {
    isLogin() {
      return this.$store.state.isLogin
    }
  },
  watch: {
    isLogin() {
      if (this.isLogin) {
        this.currentUser = store.get('identification')
      } else {
        this.currentUser = {}
      }
      console.log(this.currentUser)
    }
  },
  methods: {
    loginSubmit() {
      if (validator.validPhone(this.phone)) {
        accountService.sign(
          this.phone,
          response => {
            console.log(response)
            store.set('identification', response.data)
            this.$store.commit('changeLoginStatus')
          },
          () => {
            console.error('登陆报错')
          }
        )
      }
    }
  }
}
</script>

<style>
</style>
