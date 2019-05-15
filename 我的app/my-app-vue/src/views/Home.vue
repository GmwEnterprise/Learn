<template>
  <div class="home">
    <h2>Home page</h2>
    <p>{{ userMsg }}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      userMsg: ""
    };
  },
  created() {
    const token = sessionStorage.getItem('token');
    console.log('home page: token = ' + token);
    if (token) {
      this.$axios.get('/app/user/getUserByToken?token=' + token).then(response => console.log(response));
    }
  }
}
</script>

