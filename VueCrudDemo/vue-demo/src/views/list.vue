<template>
  <div id="list">
    <el-table :data="page.list" border>
      <template slot="default">
        <el-table-column prop="id" label="编号" width="60"></el-table-column>
        <el-table-column prop="name" label="姓名" width="120"></el-table-column>
        <el-table-column prop="sex" label="性别" width="60"></el-table-column>
        <el-table-column prop="role" label="职业" width="200"></el-table-column>
        <el-table-column label="操作" width="100">
          <!-- 解构插槽Prop -->
          <template v-slot="{ row }">
            <el-button @click="edit(row.id)" type="text" size="small">编辑</el-button>
            <el-button @click="del(row.id)" type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </template>
    </el-table>
    <el-pagination
      style="margin-top: 10px;"
      :layout="'sizes, prev, pager, next, jumper, ->, total'"
      :total="page.total"
      :page-size="page.pageSize"
      :page-sizes="[5, 10, 15]"
      :current-page="page.pageNum"
      @current-change="currentPageChanges"
      @size-change="sizeChanges"
    ></el-pagination>
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
      page: {},
      pageSize: 5
    }
  },
  methods: {
    sizeChanges(pageSize) {
      this.pageSize = pageSize
      this.currentPageChanges(1)
    },
    currentPageChanges(current) {
      this.initData(current, this.pageSize)
    },
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
    initData(startPage = 1, pageSize = 5) {
      this.$store.commit('modalChange')
      const that = this
      this.axios
        .get('/app/people', {
          params: {
            startPage,
            pageSize
          }
        })
        .then(response => {
          that.page = response.data
          this.$store.commit('modalChange')
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
