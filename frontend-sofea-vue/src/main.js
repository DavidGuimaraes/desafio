import Vue from 'vue'
import App from './App.vue'
import VueFeatherIcon from 'vue-feather-icon'

Vue.config.productionTip = false
Vue.use(VueFeatherIcon)

new Vue({
  render: h => h(App),
}).$mount('#app')
