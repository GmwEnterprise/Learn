<template>
  <div class="container-fluid">
    <div class="row" style="background-color: white;box-shadow: 0 1px 3px rgba(26, 26, 26, 0.1);">
      <div class="col-12" style="display: flex;">
        <a href="javascript:void(0)" class="logo" :style="logoStyle"></a>
      </div>
    </div>
    <div class="row" style="margin-top: 1rem;">
      <div class="col-2 catalog"></div>
      <div class="col-10" style="padding: 0;">
        <div class="content-wrapper">
          <router-view></router-view>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import logo from '@/assets/persevere.png'
export default {
  data() {
    return {
      logoStyle: {
        backgroundImage: `url(${logo})`,
        backgroundSize: 'contain',
        display: 'inline-block',
        width: '24rem',
        height: '5.5rem',
        backgroundRepeat: 'no-repeat',
        margin: '.5rem'
      }
    }
  }
}
</script>

<style>
div.catalog {
  margin: 0;
  padding: 0;
  height: calc(100vh - 7.5rem);
  background-color: white;
  box-shadow: 0 1px 3px rgba(26, 26, 26, 0.1);
}
div.content-wrapper {
  height: calc(100vh - 7.5rem);
  background-color: white;
  box-shadow: 0 1px 3px rgba(26, 26, 26, 0.1);
  width: calc(100% - 1.1rem);
  margin-left: 1.1rem;
}
</style>