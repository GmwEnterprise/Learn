<template>
  <div id="base">
    <div style="color: red;">
      <!-- 第一个插槽，具名插槽 -->
      <slot name="firstSlot" :uname="username"></slot>
    </div>
    <div style="color: blue;">
      <!-- 第二个插槽，默认插槽 -->
      <slot :passwd="password"></slot>
    </div>
  </div>
</template>

<script>
export default {
  name: 'baseSlot',
  data() {
    return {
      username: 'GmwEnterprise',
      password: 'gan1ming2wei3'
    }
  }
}
</script>
