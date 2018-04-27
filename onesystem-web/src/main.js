// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'

import App from './App'
import router from './router'
import VueResource from 'vue-resource'
import $ from 'jquery'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'

import Mint from 'mint-ui';
import 'mint-ui/lib/style.css';

Vue.use(VueResource);

Vue.use(Mint);

Vue.http.options.xhr = { withCredentials: true };

Vue.config.productionTip = false;
/* eslint-disable no-new */
 new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
});

// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.

