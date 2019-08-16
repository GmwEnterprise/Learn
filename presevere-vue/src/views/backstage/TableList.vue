<template>
  <div>{{ JSON.stringify(table) }}</div>
</template>

<script>
import tableListService from '@/services/interface/sysTableList.js'
export default {
  name: 'tableList',
  data() {
    return {
      objectService: null,
      table: {}
    }
  },
  created() {
    tableListService.queryByKey(this.$route.params.tableId, response => {
      this.table = response.data
      this.objectService = require(`@/services/interface/${this.table.tableServiceLink}.js`).default
      console.log(this.objectService)
      this.objectService.queryAll(
        {
          currentPage: 1,
          pageSize: 10
        },
        response => {
          console.log(response.data)
        },
        error => {
          console.error(error)
        }
      )
    })
  }
}
</script>