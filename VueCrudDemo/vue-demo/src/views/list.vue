<template>
  <div id="list">
    <el-table :data="dataList" border>
      <el-table-column prop="id" label="编号" width="140"></el-table-column>
      <el-table-column prop="name" label="姓名" width="140"></el-table-column>
      <el-table-column prop="sex" label="性别" width="140"></el-table-column>
      <el-table-column prop="role" label="职业" width="140"></el-table-column>
      <el-table-column label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row.id)" type="text" size="small">编辑</el-button>
          <el-button @click="del(scope.row.id)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="operation-box">
      <el-button @click="toAdd()" type="primary">添加新成员</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'List',
  data() {
    return {
      dataList: []
    }
  },
  methods: {
    edit(id) {
      this.$router.push(`/edit/${id}`)
    },
    del(id) {
      console.log(id)
      const that = this
      that.axios.delete(`/app/people/${id}`).then(response => {
        if (response.data > 0) {
          // 删除成功
          that.initData()
          this.$message.success('删除成功')
        } else {
          this.$message.error('删除失败')
        }
      })
    },
    toAdd() {
      this.$router.push('/add')
    },
    initData() {
      const that = this
      this.axios.get('/app/people').then(response => {
        that.dataList = response.data
      })
    }
  },
  created() {
    this.initData()
  }
}
</script>

<style>
.operation-box {
  padding: 20px 0;
  float: right;
}
</style>
