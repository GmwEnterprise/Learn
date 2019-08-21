import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    toast: {
      message: '默认消息',
      type: 'info',
      title: '提示',
      duration: 2500
    },
    messageBox: {
      title: '',
      detail: '',
      btnName: '按钮',
      event: () => {
        console.log('没有事件传递')
      }
    }
  },
  mutations: {
    toast(state, toastOptions) {
      state.toast = {
        message: toastOptions.message || '空',
        type: toastOptions.type || 'info',
        title: toastOptions.title,
        duration: (toastOptions.duration && toastOptions.duration > 1600) ? toastOptions.duration : 2500
      }
    },
    message(state, messageValue = {}) {
      state.messageBox = {
        title: messageValue.title || '未设置标题',
        detail: messageValue.detail || '未设置详细内容',
        btnName: messageValue.btnName || '确定',
        // event: messageValue.event || (() => {
        //   console.log('没有事件传递')
        // }),
        event: messageValue.event ? () => new Promise(resolve => {
          messageValue.event(resolve)
        }) : null
      }
    }
  },
  actions: {

  }
})
