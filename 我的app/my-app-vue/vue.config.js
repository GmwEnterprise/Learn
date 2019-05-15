module.exports = {
  devServer: {
    proxy: {
      '/app': {
        target: 'http://localhost:4200/app',
        ws: true,
        changeOrigin: true,
        pathRewrite:{
            '^/app':'/'
        }
      }
    }
  }
};