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
          <a id="head-link" class="icon-link" href="javascript:void(0)" :title="headTitle" @click="signInOut">
            <img class="icon" :src="headPath" style="height: 35px;" />
          </a>
        </b-col>
      </b-row>
    </b-container>
    <b-modal id="sign-in-out" hide-footer hide-header>
      <login-form v-if="!isLogin"></login-form>
    </b-modal>
    <b-popover
      target="head-link"
      title="Prop Examples"
      triggers="hover focus"
      content="Embedding content using properties is easy"
    >Hello <strong>World!</strong></b-popover>
  </div>
</template>

<script>
import LoginForm from '@/components/common/LoginForm.vue'
export default {
  name: 'commonHeader',
  components: { LoginForm },
  data() {
    return {
      headTitle: '标题',
    }
  },
  computed: {
    headPath() {
      return (
        process.env.BASE_URL +
        (this.isLogin ? 'head-online.png' : 'head-offline.png')
      )
    },
    isLogin() {
      return this.$store.state.isLogin
    }
  },
  watch: {
    isLogin() {
      this.$bvModal.hide('sign-in-out')
    }
  },
  methods: {
    signInOut() {
      if (!this.isLogin) {
        this.$bvModal.show('sign-in-out')
      }
    }
  },
  created() {}
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
