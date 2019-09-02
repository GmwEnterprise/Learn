<template>
  <div class="form-control"></div>
</template>

<script>
export default {
  name: 'QueryFormControlItem',
  props: {
    /**
     * 确定输入框的类型, 有text/number/date-range/single-select/multipart-select
     */
    type: String,

  }
}
</script>