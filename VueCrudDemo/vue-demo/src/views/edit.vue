<template>
  <div id="edit">
    <el-form :model="data" :label-position="`left`" label-width="60px">
      <el-form-item :label="'编号'">
        <el-input v-model="data.id" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="data.name"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-radio v-model="data.sex" :label="1">男</el-radio>
        <el-radio v-model="data.sex" :label="2">女</el-radio>
      </el-form-item>
      <el-form-item :label="'职位'">
        <el-input v-model="data.role"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="edit()">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'Edit',
  data() {
    return {
      data: {
        id: 0,
        name: '',
        sex: 0,
        role: ''
      }
    }
  },
  methods: {
    edit() {
      const that = this
      this.axios.patch('/app/people', {
        ...this.data
      }).then(response => {
        if (typeof response.data === 'object') {
          that.$message.success('修改信息成功！')
          that.$router.go(-1)
        } else {
          that.$message.error('修改信息失败')
        }
      })
    }
  },
  created() {
    const that = this
    this.axios
      .get(`/app/people/${this.$route.params.id}`)
      .then(response => (that.data = response.data))
  }
}
</script>
