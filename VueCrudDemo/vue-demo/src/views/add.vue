<template>
  <div id="add">
    <el-form :label-position="'left'" :label-width="'60px'" :model="people">
      <el-form-item label="姓名">
        <el-input v-model="people.name"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-radio v-model="people.sex" :label="1">男</el-radio>
        <el-radio v-model="people.sex" :label="2">女</el-radio>
      </el-form-item>
      <el-form-item :label="'职位'">
        <el-input v-model="people.role"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="add()">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'add',
  data() {
    return {
      people: {
        name: '',
        sex: 1,
        role: ''
      }
    }
  },
  methods: {
    add() {
      this.axios
        .post('/app/people', {
          name: this.people.name,
          sex: this.people.sex,
          role: this.people.role
        })
        .then(response => {
          if (response.data.id) {
            this.$message.success('添加成功')
            this.$router.go(-1)
          }
        })
    }
  }
}
</script>
