<template>
  <div>
    <h3>{{ table.tableName }}</h3>
    <table class="table table-bordered" style="width: auto;">
      <thead>
        <tr>
          <th scope="col" v-for="(tableMsg, idx) of table.detailMsg" :key="idx">
            {{ `${tableMsg.columnComment}[${tableMsg.fieldName}]` }}
          </th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item, idx) of tableData.list" :key="idx">
          <td v-for="(tableMsg, id1) of table.detailMsg" :key="id1">{{ item[tableMsg.fieldName] }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import tableListService from '@/services/interface/sysTableList.js'
export default {
  name: 'tableList',
  data() {
    return {
      objectService: null,
      table: {},
      tableData: {}
    }
  },
  created() {
    tableListService.queryByKeyWithFieldMsg(
      this.$route.params.tableId,
      response => {
        this.table = response.data
        this.objectService = require(`@/services/interface/${this.table.tableServiceLink}.js`).default
        // console.log(this.objectService)
        this.objectService.queryAll(
          {
            currentPage: 1,
            pageSize: 10
          },
          response => {
            this.tableData = response.data
            console.log(this.tableData)
          },
          error => console.error(error)
        )
      }
    )
  }
}
</script>

<style></style>