export default {
  set(key, val) {
    sessionStorage.setItem(key, val)
  },

  get(key) {
    return sessionStorage.getItem(key)
  },

  exist(key) {
    return sessionStorage.getItem(key) !== null
  },

  remove(key) {
    sessionStorage.removeItem(key)
  }
}