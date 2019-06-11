<template>
  <div id="test">
    <base-slot>
      <template v-slot="defaultScope">这个是默认插槽：{{ defaultScope.uname }}</template>
      <template v-slot:firstSlot="namedScope">这个是具名插槽：{{ namedScope.passwd }}</template>
    </base-slot>
  </div>
</template>

<script>
import BaseSlot from './base-slot.vue'

export default {
  name: 'Test',
  components: {
    BaseSlot //: () => import('@/src/testviews/base-slot.vue')
  }
}
</script>
