<template>
  <div class="form-control">
    <template v-if="type === 'number'">
      
    </template>
    <template v-else-if="type === 'date-range'">
      
    </template>
    <template v-else-if="type === 'single-select'">
      
    </template>
    <template v-else-if="type === 'multipart-select'">
      
    </template>
    <template v-else>
      <label for=""></label>
      <input type="text" :value="value" @input="emitEvent">
    </template>
  </div>
</template>

<script>
export default {
  name: 'QueryFormControlItem',
  props: {
    // 确定输入框的类型, 有text/number/date-range/single-select/multipart-select
    type: {
      type: String,
      required: false,
      default: 'text'
    },
    // label 标签
    label: {
      type: String,
      required: true
    },
    // value 绑定的值，类型为any
    value: {
      required: true
    }
  },
  methods: {
    /**
     * @param {Event} e
     */
    emitEvent(e) {
      this.$emit('input', e.target.value)
    }
  }
}
</script>