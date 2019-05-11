<template>
  <div class="home">
    <el-card class="container">
      <div slot="header" class="clearfix">
        <span>登陆</span>
      </div>
      <el-form ref="form" :model="form" label-width="60px">
        <el-form-item label="用户名">
          <el-input placeholder="请输入用户名" v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input placeholder="请输入密码" v-model="form.password" show-password></el-input>
        </el-form-item>
        <div class="btn-box">
          <el-button class="submit" type="primary" @click="login()">登陆</el-button>
        </div>
      </el-form>
    </el-card>
  </div>
</template>

<script>
// @ is an alias to /src
import md5 from 'js-md5'

export default {
  name: "home",
  data() {
    return {
      form: {
        username: '',
        password: ''
      }
    }
  },
  components: {},
  methods: {
    login() {
      this.axios.post(this.URL.login, {
        username: this.form.username,
        password: md5(this.form.password)
      }).then(response => console.log(response))
    }
  }
};
</script>

<style>
.btn-box {
  display: flex;
  justify-content: center;
  padding: 15px 0;
}
.submit {
  width: 85%;
}
.clearfix {
  text-align: center;
}
.container {
  width: 350px;
}
.home {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
