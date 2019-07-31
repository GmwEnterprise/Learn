<template>
  <div>
    <b-form>
      <b-form-group>
        <b-form-input id="input-email" v-model="signForm.email" required placeholder="输入你的邮箱"></b-form-input>
      </b-form-group>
      <b-button type="button" @click="sign()" variant="primary" style="float: right;">确定</b-button>
    </b-form>
  </div>
</template>

<script>
import Validator from '@/tools/validator.js'
import Account from '@/services/account.js'
export default {
  name: 'LoginForm',
  data() {
    return {
      signForm: {
        email: ''
      }
    }
  },
  methods: {
    sign() {
      const email = this.signForm.email
      if (Validator.validEmail(email)) {
        // 邮箱验证通过
        Account.sign(
          {
            email
          },
          response => {
            console.log(response)
          },
          () => {
            console.error('error')
          }
        )
      } else {
        // 邮箱验证失败
        alert('请重新输入合法的邮箱')
      }
    }
  }
}
</script>
