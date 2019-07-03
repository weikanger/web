// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App'
import router from './router'
import axios from 'axios'

// axios 默认配置
axios.defaults.baseURL = 'http://localhost:8080'

Vue.prototype.axios = axios

Vue.config.productionTip = false

Vue.use(ElementUI)

// router.beforeEach()

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
