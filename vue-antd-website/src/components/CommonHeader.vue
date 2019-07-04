<template>
  <header id="common-header">
    <div class="head-content">
      <a-row>
        <a-col :span="6">
          <a href="javascript:void(0)" class="logo-wrapper" title="主页">
            <img class="logo" src="@/assets/persevere.png" alt />
          </a>
        </a-col>
        <a-col :span="9"></a-col>
        <a-col :span="3"></a-col>
        <a-col :span="6">
          <a-avatar :size="36" style="backgroundColor:#0072bc" icon="user" />
        </a-col>
      </a-row>
    </div>
  </header>
</template>

<style>
#common-header {
  height: 60px;
  width: 100%;
  box-shadow: 0 2px 8px #f0f1f2;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 10;
  background-color: white;
}
.head-content {
  width: 960px;
  margin: 0 auto;
  height: 100%;
}
.ant-row {
  height: 100%;
  widows: 100%;
}
.ant-row > div {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.logo-wrapper {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.logo {
  height: 70%;
}
/* .title {
  margin: 15px;
  line-height: 30px;
  height: 30px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
} */
</style>
