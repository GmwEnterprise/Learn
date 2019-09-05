<template>
  <div>edit</div>
</template>

<script>
import accountService from './account.service.js'
export default {
  name: 'AccountEdit',
  data() {
    return {
      // 1-add, 2-modify
      editType: 1,
      data: {
        id: null,
        accountId: null,
        accountType: null,
        nickname: null,
        sex: null,
        age: null,
        introduction: null,
        phone: null,
        email: null
      }
    }
  },
  methods: {
    async queryData(key) {
      const response = await accountService.queryByKey(key)
      console.log(response)
    }
  },
  mounted() {
    this.data.id = this.$route.params.rowId
    if (this.data.id) {
      this.editType = 2
      this.queryData(this.data.id)
    } else {
      this.editType = 1
    }
  }
}
</script>