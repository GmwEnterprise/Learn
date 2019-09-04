<template>
  <div id="table-list-vue">
    <h3>{{ table.className + ' 表' }}</h3>
    <query-form @submit="querySubmit">
      <form-control v-model="formParam.nickname" label="昵称" id="nickname" />
      <form-control v-model="formParam.phone" label="手机号" id="phone" />
      <form-control v-model="formParam.accountId" label="用户ID" id="account-id" />
      <form-control v-model="formParam.introduction" label="简介" id="introduction" />
    </query-form>
    <table class="table table-striped" style="width: auto;font-size: .9em;">
      <thead class="thead-dark">
        <tr>
          <th class="back-th-td">序号</th>
          <th class="back-th-td">操作</th>
          <th
            class="back-th-td"
            v-for="(column, index) of table.columns"
            :key="index"
            v-show="column.show"
            :title="column.code"
          >{{ column.name }}</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(row, index) of tableData.list" :key="index">
          <td class="back-th-td">{{ index + 1 + tableData.pageSize * (tableData.currentPage - 1) }}</td>
          <td class="back-th-td back-btn-cell" style="padding: 0;">
            <span class="back-temp-td-operator">占位符</span>
            <div class="back-btn-box">
              <button
                class="back-btn-operation back-btn-edit"
                style="left: 0;"
                @click="editRow(row.id)"
              >编辑</button>
              <span>/</span>
              <button
                class="back-btn-operation back-btn-delete"
                style="right: 0;"
                @click="deleteRow(row.id)"
              >删除</button>
            </div>
          </td>
          <td
            class="back-th-td"
            v-for="(column, columnIndex) of table.columns"
            :key="columnIndex"
            :title="row[column.code]"
            v-show="column.show"
          >
            <template v-if="column.type === 'string'">{{ row[column.code] }}</template>
            <template v-else-if="column.type === 'number'">
              <span class="back-column-number">{{ row[column.code] }}</span>
            </template>
            <template v-else-if="column.type === 'date'">
              <span class="back-column-date">{{ row[column.code].substring(0, 10) }}</span>
            </template>
            <template v-else-if="column.type === 'string'">{{ row[column.code] }}</template>
            <div
              class="back-column-customize-box"
              v-else-if="column.type === 'customize'"
              v-html="column.customize(row[column.code])"
            ></div>
            <template v-else class="back-column-othertype">{{ row[column.code] }}</template>
          </td>
        </tr>
      </tbody>
    </table>
    <page-component v-on:jump="pageJump" :param="tableData"></page-component>
  </div>
</template>

<script>
import PageComponent from '@/components/Page.vue'
import accountService from './account.service.js'
import { setTimeout } from 'timers'
export default {
  name: 'AccountModule',
  components: { PageComponent },
  data() {
    return {
      formParam: {
        accountId: '',
        accountType: -1,
        nickname: '',
        sex: -1,
        age: -1,
        introduction: '',
        phone: ''
      },
      table: {
        className: 'Account',
        columns: [
          { code: 'id', name: '主键', type: 'number', show: false },
          { code: 'accountId', name: '账户ID', type: 'string', show: true },
          { code: 'nickname', name: '昵称', type: 'string', show: true },
          {
            code: 'sex',
            name: '性别',
            type: 'customize',
            show: true,
            customize: origin => {
              let target
              switch (origin) {
                case 1:
                  target = '男'
                  break
                case 2:
                  target = '女'
                  break
                default:
                  target = '保密'
              }
              const style = `
                display: flex;
                font-size: .8em;
                background: #0072bc;
                color: white;
                padding: 0 .5rem;
                height: 100%;
                justify-content: center;
                align-items: center;
              `
              return `<span class="rounded-circle-1" style="${style}">${target}</span>`
            }
          },
          {
            code: 'createDatetime',
            name: '字段创建时间',
            type: 'date',
            show: true,
            customize: origin => origin
          },
          {
            code: 'updateDatetime',
            name: '字段更新时间',
            type: 'date',
            show: true
          }
        ]
      },
      tableData: {},
      currentEvent: null
    }
  },
  created() {
    this.initTable()
  },
  methods: {
    querySubmit() {
      console.log('submit event !')
    },
    async pageJump(pageValue) {
      if (!this.currentEvent) {
        this.currentEvent = 1
        this.tableData.currentPage = pageValue
        await this.initTable()
        setTimeout(() => {
          this.currentEvent = null
        }, 100)
      }
    },
    editRow(rowId) {
      console.log(rowId)
    },
    deleteRow(rowId) {
      this.$message({
        type: 'warning',
        title: '确定删除吗？',
        detail: '该操作将不可逆！',
        btnName: '删除',
        event: async close => {
          await accountService.delByKey(rowId)
          this.$toast.success('删除成功')
          await this.initTable()
          close()
        }
      })
    },
    async initTable() {
      const response = await accountService.queryPage({
        currentPage: this.tableData.currentPage || 1,
        pageSize: this.tableData.pageSize || 8
      })
      this.tableData = response.data || {}
    }
  }
}
</script>