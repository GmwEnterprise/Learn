<template>
  <div>
    <form class="inputModelForm" @submit="submitModel">
      <div class="form-group">
        <label for="tableName">表名：</label>
        <input
          class="form-control"
          id="tableName"
          type="text"
          v-model="inputModel.tableName"
          required
        />
        <small id="tableNameHelp" class="form-text text-muted">将显示在左侧数据管理内容栏中作为标题</small>
      </div>
      <div class="form-group">
        <label for="tableServiceLink">链接：</label>
        <input
          class="form-control"
          id="tableServiceLink"
          type="text"
          v-model="inputModel.tableServiceLink"
          required
        />
        <small
          id="tableNameHelp"
          class="form-text text-muted"
        >该表对应的请求链接，值为相应Controller中RequestMappint指定的value</small>
      </div>
      <button type="submit" class="btn btn-primary">添加</button>
    </form>
  </div>
</template>

<script>
import tableListService from '@/services/interface/sysTableList.js'
export default {
  name: 'AddServiceLink',
  data() {
    return {
      inputModel: {
        tableName: '',
        tableServiceLink: ''
      }
    }
  },
  methods: {
    submitModel(event) {
      event.preventDefault()
      if (this.inputModel.tableName && this.inputModel.tableServiceLink) {
        tableListService.add(
          this.inputModel,
          () => {
            alert('添加成功')
          },
          () => {
            alert('添加失败')
          }
        )
      } else {
        alert('请输入值')
      }
    }
  }
}
</script>

<style>
.form-control {
  width: 40rem;
}
</style>