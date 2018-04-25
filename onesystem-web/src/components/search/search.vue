<template>
  <div>

    <header class="mint-header">
      <div class="mint-header-button is-left"><a href="#/" class="router-link-active">
        <button class="mint-button mint-button--default mint-button--normal"><span class="mint-button-icon"><i
          class="mintui mintui-back"></i></span></button>
      </a></div>
      <h1 class="mint-header-title">搜索</h1>
      <div class="mint-header-button is-right"></div>
    </header>

    <div class="search-bg">
      <div class="over search-box">
        <div class="over lf search-box-key">
          <img src="./img/icon_search.png" class="icon-search" alt="">
          <input type="text" class="search-input" placeholder="输入关键字搜索" v-model="searchKey">
          <img class="lf icon-eliminate" src="./img/icon_Eliminate.png" alt="">
        </div>
        <div class="rt search-btn">
          <router-link :to="{path:'/searchKey',
          query:{
              key:this.searchKey,
              type:this.type
          }
        }" style="color: #fff;">搜索
          </router-link>
        </div>
      </div>
    </div>

    <p class="search-key-title">搜索指定内容</p>
    <div class="over search-key-box">
      <p class="lf search-key key-border" @click="getType(1)">   <router-link :to="{path:'/searchKey',
          query:{
              key:this.searchKey,
              type:1
          }
        }" style="color: #0fa1ff;">疾病
      </router-link></p>
      <p class="lf search-key key-border" @click="getType(2)">药品</p>
      <p class="lf search-key" @click="getType(3)">文章</p>
    </div>
  </div>
</template>
<script>
  import './search.css'
  export default{
    data(){
      return {
        searchKey:'',
        type:""
      }
    },
    methods:{
        getType(num){
            this.type = num;
        }
    }
  }
</script>
<style type='text/css'>

</style>
