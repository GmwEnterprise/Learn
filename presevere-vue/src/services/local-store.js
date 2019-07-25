export default {
  set(key, val) {
    localStorage.setItem(key, val)
  },

  get(key) {
    return localStorage.getItem(key)
  },

  exist(key) {
    return localStorage.getItem(key) !== null
  },

  remove(key) {
    localStorage.removeItem(key)
  }
}