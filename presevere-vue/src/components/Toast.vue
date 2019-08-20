<template>
  <div id="toast-wrapper" ref="toast-wrapper"></div>
</template>

<script>
import { setTimeout } from 'timers'
export default {
  name: 'CustomizeToast',
  computed: {
    toastObj() {
      return this.$store.state.toast
    }
  },
  watch: {
    toastObj() {
      switch (this.toastObj.toastType) {
        case 'info':
          this.infoToast(this.toastObj.message)
          break
        case 'danger':
          this.dangerToast(this.toastObj.message)
          break
        case 'warning':
          this.warningToast(this.toastObj.message)
          break
        case 'success':
          this.successToast(this.toastObj.message)
          break
        default:
          this.infoToast(this.toastObj.message)
      }
    }
  },
  methods: {
    successToast(value) {
      this.toast(
        `
        <div
          class="custom-toast-header"
          style="color: #0b690b;background-color: #bee2d4;"
        >success message</div>
        <div
          class="custom-toast-body"
          style="background-color: #eaf7ea;color: #2d5f2d;"
        >${value}</div>`,
        '1px solid rgba(126, 181, 127, 0.42)'
      )
    },
    warningToast(value) {
      this.toast(
        `
        <div
          class="custom-toast-header"
          style="color: #948934;background-color: #fff7c4;"
        >warning message</div>
        <div
          class="custom-toast-body"
          style="background-color: #ffffeb;color: #adad1d;"
        >${value}</div>`,
        '1px solid rgba(253, 227, 149, 0.5)'
      )
    },
    dangerToast(value) {
      this.toast(
        `
        <div
          class="custom-toast-header"
          style="color: #770000;background-color: #ffcfcf;"
        >danger message</div>
        <div
          class="custom-toast-body"
          style="background-color: #ffe5e5;color: #8c0000;"
        >${value}</div>`,
        '1px solid rgba(255, 172, 172, 0.5)'
      )
    },
    infoToast(value) {
      this.toast(
        `
        <div
          class="custom-toast-header"
          style="color: white;background-color: #71d2ff;"
        >info message</div>
        <div
          class="custom-toast-body"
          style="background-color: #fff;color: #333;"
        >${value}</div>`,
        '1px solid rgba(131, 216, 255, 0.5)'
      )
    },
    toast(value, borderStyle) {
      const dom = document.getElementById('toast-wrapper')
      // console.log(dom)
      const divElement = document.createElement('div')
      divElement.innerHTML = value
      divElement.style.border = borderStyle
      divElement.classList.add(
        'custom-toast',
        'animated',
        'bounceInRight',
        'fast'
      )
      dom.appendChild(divElement)
      setTimeout(() => {
        divElement.classList.add('bounceOutRight')
        setTimeout(() => dom.removeChild(divElement), 800)
      }, 2500)
    }
  }
}
</script>

<style>
#toast-wrapper {
  position: fixed;
  top: 0;
  right: 0;
  width: 16rem;
  height: auto;
  min-height: 5rem;
  background-color: rgba(0, 0, 0, 0);
}
.custom-toast {
  border-radius: 0.25rem;
  overflow: hidden;
  box-sizing: border-box;
  height: auto;
  width: 15rem;
  background-color: rgb(255, 255, 255);
  margin-top: 1rem;
}
.custom-toast-header {
  font-size: 0.9em;
  line-height: 1.8rem;
  font-weight: bold;
  padding: 0.2rem 0.7rem;
}
.custom-toast-body {
  padding: 0.7rem;
  font-size: 0.85em;
}
</style>