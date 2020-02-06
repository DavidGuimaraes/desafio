import Vue from 'vue'
import App from './App.vue'
import VueFeatherIcon from 'vue-feather-icon'
import router from '@/router'

Vue.config.productionTip = false
Vue.use(VueFeatherIcon)

new Vue({
  render: h => h(App),
  router,
  VueFeatherIcon
}).$mount('#app')
