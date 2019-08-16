import axios from 'axios'

export default {
  /**
   * 查询单条数据
   * @param {number | string} key
   * @param {function} success
   * @param {function} error
   */
  queryByKey(key, success, error) {
    axios.get(`/app/sysTableList/${key}`, {
      timeout: 5000
    }).then(response => {
      if (response.data.code === 0) {
        success(response.data)
      } else {
        error(new Error(response.data.msg))
      }
    }).catch(err => error && error(err))
  },
  
  /**
   * 查询多条数据
   * @param {object} params
   * @param {function} success
   * @param {function} error
   */
  queryAll(params, success, error) {
    axios.get('/app/sysTableList', {
      params,
      timeout: 5000
    }).then(response => {
      if (response.data.code === 0) {
        success(response.data)
      } else {
        error(new Error(response.data.msg))
      }
    }).catch(err => error && error(err))
  },
  
  /**
   * 新增数据
   * @param {object} params
   * @param {function} success
   * @param {function} error
   */
  add(params, success, error) {
    axios.post('/app/sysTableList', params, {
      timeout: 5000
    }).then(response => {
      if (response.data.code === 0) {
        success(response.data)
      } else {
        error(new Error(response.data.msg))
      }
    }).catch(err => error && error(err))
  },
  
  /**
   * 修改数据
   * @param {object} params
   * @param {function} success
   * @param {function} error
   */
  modify(params, success, error) {
    axios.patch('/app/sysTableList', params, {
      timeout: 5000
    }).then(response => {
      if (response.data.code === 0) {
        success(response.data)
      } else {
        error(new Error(response.data.msg))
      }
    }).catch(err => error && error(err))
  },
  
  /**
   * 删除数据
   * @param {number | string} key
   * @param {function} success
   * @param {function} error
   */
  delByKey(key, success, error) {
    axios.delete(`/app/sysTableList/${key}`, {
      timeout: 5000
    }).then(response => {
      if (response.data.code === 0) {
        success(response.data)
      } else {
        error(new Error(response.data.msg))
      }
    }).catch(err => error && error(err))
  }
}
