<template>
  <div id="table-list-vue">
    <h3>{{ table.tableName }}</h3>
    <table class="table table-striped" style="width: auto;">
      <thead class="thead-dark">
        <tr>
          <th>操作</th>
          <th v-for="(tableMsg, idx) of table.detailMsg" :key="idx">{{ tableMsg.columnComment }}</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item, idx) of tableData.list" :key="idx">
          <td class="btn-cell" style="padding: 0;">
            <span class="temp">占位符</span>
            <div class="btn-box">
              <button class="btn-operation btn-edit" style="left: 0;">编辑</button>
              <button class="btn-operation btn-delete" style="right: 0;">删除</button>
            </div>
          </td>
          <td v-for="(tableMsg, id1) of table.detailMsg" :key="id1">{{ item[tableMsg.fieldName] }}</td>
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

<style>
th,
td {
  white-space: nowrap;
  max-width: 12rem;
  overflow: hidden;
  text-overflow: ellipsis;
}
.btn-operation {
  box-sizing: border-box;
  border: 0;
  width: 45%;
  font-size: 0.8rem;
  background-color: rgba(209, 209, 209, 0);
  padding: 0;
  transition: 0.4s;
}
.btn-edit:hover {
  color: blue;
}
.btn-delete:hover {
  color: red;
}
.btn-cell {
  position: relative;
}
.btn-box {
  position: absolute;
  top: 0;
  bottom: 0;
  width: 100%;
  display: flex;
  justify-content: space-around;
  align-items: center;
  padding: 0 0.5rem;
}
span.temp {
  display: inline-block;
  width: 6rem;
  opacity: 0;
}
</style>