import Vue from 'vue'
import App from './App.vue'
import router from './router'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import './assets/gloable.css'
Vue.config.productionTip = false

import request from "@/utils/request"
Vue.prototype.request = request


Vue.use(ElementUI, {size:"mini"});

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
