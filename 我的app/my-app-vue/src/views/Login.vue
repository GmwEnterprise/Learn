<template>
  <div class="login">
    <el-card class="box-card" shadow="hover">
      <el-form v-model="inputData" ref="form" label-width="80px">
        <el-form-item label="手机号">
          <el-input v-model="inputData.phone"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="inputData.password" type="password"></el-input>
        </el-form-item>
        <el-form-item label="再次输入" v-show="regMode">
          <el-input v-model="inputData.password2" type="password"></el-input>
        </el-form-item>
        <el-form-item label="昵称" v-show="regMode">
          <el-input v-model="inputData.username"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submit()">
            <span v-show="logMode">登陆</span>
            <span v-show="regMode">注册</span>
          </el-button>
          <span class="remind" v-show="logMode">
            没有账户？
            <a @click="modeChange()">注册</a>一个
          </span>
          <span class="remind" v-show="regMode">
            已有账户？直接
            <a @click="modeChange()">登陆</a>
          </span>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
const MODE_LOG = 1,
  MODE_REG = 2;

export default {
  name: "login",
  data() {
    return {
      mode: MODE_LOG,
      inputData: {
        username: "",
        password: "",
        password2: "",
        phone: ""
      }
    };
  },
  computed: {
    logMode: function() {
      return this.mode === MODE_LOG;
    },
    regMode: function() {
      return this.mode === MODE_REG;
    }
  },
  methods: {
    modeChange() {
      this.mode = this.mode === MODE_LOG ? MODE_REG : MODE_LOG;
    },
    submit() {
      const data = {
        phone: this.inputData.phone,
        password: this.inputData.password
      };
      if (this.logMode) {
        this.$axios.post(this.REQUEST_URL.LOGIN, data).then(response => {
          console.log(response.data);
        });
      } else if (this.regMode) {
        data.username = this.inputData.username;
        this.$axios.post(this.REQUEST_URL.REG, data).then(response => {
          console.log(response.data);
        });
      }
    }
  }
};
</script>

<style>
.remind > a {
  color: #409eff;
  cursor: pointer;
}
.remind {
  float: right;
  font-size: 0.9em;
  color: gray;
}
.box-card {
  width: 350px;
}
.el-form {
  padding: 20px 20px 0 0;
}
</style>
