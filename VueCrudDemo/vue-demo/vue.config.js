module.exports = {
  devServer: {
    proxy: {
      '/app': {
        target: 'http://127.0.0.1:4200/vue-demo',
        ws: true,
        changeOrigin: true,
        pathRewrite: {
          '^/app': '/'
        }
      }
    }
  }
};