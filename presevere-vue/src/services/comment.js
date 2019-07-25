import axios from 'axios'

export default {
  /**
   * 查询单条数据
   * @param {number | string} key
   * @param {function} success
   * @param {function} error
   */
  queryByKey(key, success, error) {
    axios.get(`/app/comment/${key}`)
      .then(response => {
        if (response.data.code === 0) {
          success(response.data)
        } else {
          error()
        }
      }).catch(() => error())
  },

  /**
   * 查询多条数据
   * @param {object} params
   * @param {function} success
   * @param {function} error
   */
  queryAll(params, success, error) {
    axios.get('/app/comment/', params)
      .then(response => {
        if (response.data.code === 0) {
          success(response.data)
        } else {
          error()
        }
      }).catch(() => error())
  },

  /**
   * 新增数据
   * @param {object} params
   * @param {function} success
   * @param {function} error
   */
  add(params, success, error) {
    axios.post('/app/comment/', params)
      .then(response => {
        if (response.data.code === 0) {
          success(response.data)
        } else {
          error()
        }
      }).catch(() => error())
  },

  /**
   * 修改数据
   * @param {object} params
   * @param {function} success
   * @param {function} error
   */
  modify(params, success, error) {
    axios.patch('/app/comment/', params)
      .then(response => {
        if (response.data.code === 0) {
          success(response.data)
        } else {
          error()
        }
      }).catch(() => error())
  },

  /**
   * 删除数据
   * @param {number | string} key
   * @param {function} success
   * @param {function} error
   */
  delByKey(key, success, error) {
    axios.delete(`/app/comment/${key}`)
      .then(response => {
        if (response.data.code === 0) {
          success(response.data)
        } else {
          error()
        }
      }).catch(() => error())
  }
}
