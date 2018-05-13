<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
  /* 容器基本样式 */
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  width: 100%;
  height: 100%;
}
 /* 重新定义html原始标签的样式 */
html {
  -ms-overflow-style:none;
  overflow:-moz-scrollbars-none;
}

html::-webkit-scrollbar{width:0px}

body, ul, li, h1, h2, h3, h4, h5, h6, p, form, dl, dt, dd, input, ol, textarea{
  margin: 0px;
  padding: 0px;
  font-size: 12px;
  font-weight: normal;
}

ul {
  list-style: none;
}

img {
  border-style: none;
}

a {
  text-decoration: none;
  color: #333;
}

html,body{
  width: 100%;
  height: 100%;
}

input{
  outline: none
}

button{
  background: none;
  border: none;
  outline: none;
}

/* 全局浮动样式 */
.left-float{
  float: left;
}

.right-float{
  float: right;
}
</style>
