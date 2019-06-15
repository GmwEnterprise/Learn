<template>
  <div id="app">
    <router-view/>
    <div class="modal" v-show="show"></div>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'App',
  computed: mapState({
    show: state => state.showModal
  })
}
</script>


<style>
#app {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 50px;
}
.modal {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  opacity: 0.5;
  background-color: white;
  z-index: 10000;
}
</style>
