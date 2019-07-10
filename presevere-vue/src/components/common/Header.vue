<template>
  <div class="header">
    <b-container>
      <b-row class="head-content">
        <b-col class="icon-wrapper">
          <a class="icon-link" href="javascript:void(0)" title="点击返回首页">
            <img class="icon" src="@/assets/persevere.png" style="height: 50px;" />
          </a>
        </b-col>
        <b-col class="media-hidden"></b-col>
        <b-col class="icon-wrapper right">
          <a class="icon-link" href="javascript:void(0)" title="个人信息">
            <img class="icon" :src="headPath" style="height: 35px;" />
          </a>
        </b-col>
      </b-row>
    </b-container>
    <b-modal id="sign-in-out">
      
    </b-modal>
  </div>
</template>

<script>
export default {
  name: 'commonHeader',
  data() {
    return {
      online: true
    }
  },
  computed: {
    headPath() {
      if (this.online) {
        return process.env.BASE_URL + 'head-online.png'
      }
      return process.env.BASE_URL + 'head-offline.png'
    }
  },
  methods: {
    openSignInOutBox() {
      
    }
  }
}
</script>

<style>
@media (max-width: 576px) {
  .media-hidden {
    display: none;
  }
}

.header {
  width: 100%;
  position: fixed;
  left: 0;
  top: 0;
  box-shadow: 0 1px 3px rgba(26, 26, 26, 0.1);
  background-color: white;
  z-index: 100;
}
.head-content {
  padding: 10px 0;
}
.icon-wrapper {
  display: flex;
  align-items: center;
}
.icon-link {
  display: inline-block;
}
.icon {
  display: block;
}
.right {
  justify-content: flex-end;
}
</style>
