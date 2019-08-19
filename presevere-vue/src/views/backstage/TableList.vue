<template>
  <div id="table-list-vue">
    <h3>{{ table.tableName }}</h3>
    <table class="table table-striped" style="width: auto;">
      <thead class="thead-dark">
        <tr>
          <th class="back-th-td">操作</th>
          <th
            class="back-th-td"
            v-for="(tableMsg, idx) of table.detailMsg"
            :key="idx"
          >{{ tableMsg.columnComment }}</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item, idx) of tableData.list" :key="idx">
          <td class="back-th-td back-btn-cell" style="padding: 0;">
            <span class="back-temp-td-operator">占位符</span>
            <div class="back-btn-box">
              <button class="back-btn-operation back-btn-edit" style="left: 0;">编辑</button>
              <span>/</span>
              <button class="back-btn-operation back-btn-delete" style="right: 0;">删除</button>
            </div>
          </td>
          <td
            class="back-th-td"
            v-for="(tableMsg, id1) of table.detailMsg"
            :key="id1"
          >{{ item[tableMsg.fieldName] }}</td>
        </tr>
      </tbody>
    </table>
    <page-component></page-component>
  </div>
</template>

<script>
import tableListService from '@/services/sysTableList.js'
import PageComponent from '@/components/Page.vue'
export default {
  name: 'tableList',
  components: {
    PageComponent
  },
  data() {
    return {
      objectService: null,
      table: {
        detailMsg: {}
      },
      tableData: {
        list: []
      }
    }
  },
  created() {
    tableListService
      .queryByKeyWithFieldMsg(this.$route.params.tableId)
      .then(response => {
        this.table = response.data
        this.objectService = require(`@/services/${this.table.tableServiceLink}.js`).default
        return this.objectService.queryPage({
          currentPage: 1,
          pageSize: 10
        })
      })
      .then(objectResponse => {
        this.tableData = objectResponse.data
      })
  }
}
</script>