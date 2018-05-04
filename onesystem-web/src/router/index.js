import Vue from 'vue'
import Router from 'vue-router'

import Home from  '@/components/home'
import Login from  '@/components/user/login'


Vue.use(Router);

export default new Router({
  routes: [{
    path : '/',
    name : Home,
    component : Home
  },{
    path : '/login',
    name : Login,
    component : Login
  }]
})



