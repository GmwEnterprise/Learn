import axios from 'axios'

export function queryAll(params, success, error) {
  axios.get('/app/account/', {
    params
  }).then(response => {
    if (response.data.code === 0) {
      success(response.data)
    } else {
      error()
    }
  }).catch(() => error())
}