<template>
  <div class="home">
    <common-header></common-header>
    <b-container class="main">
      <b-row>
        <b-col cols="9" class="item-list-wrapper">
          <item-list></item-list>
        </b-col>
        <b-col cols="3" class="webmaster-wrapper">
          <webmaster-intro></webmaster-intro>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import CommonHeader from '@/components/common/Header.vue'
import ItemList from './ItemList.vue'
import WebmasterIntro from './WebmasterIntro'
export default {
  name: 'home',
  components: {
    CommonHeader,
    ItemList,
    WebmasterIntro
  }
}
</script>

<style>
.main {
  margin-top: 80px;
}
@media (max-width: 576px) {
  .webmaster-wrapper {
    display: none;
  }
  .item-list-wrapper {
    flex: 0 0 100%;
    max-width: 100%;
    padding: 0;
  }
}
</style>
