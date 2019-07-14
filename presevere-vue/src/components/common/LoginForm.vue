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
export default {
  name: 'LoginForm',
  data() {
    return {
      phone: ''
    }
  },
  methods: {
    submit() {}
  }
}
</script>

<style>
</style>
