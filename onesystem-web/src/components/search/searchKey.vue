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

    <div class="search-bg" style="height: 100%;">
      <div class="over search-box">
        <div class="over lf search-box-key">
          <img src="./img/icon_search.png" class="icon-search" alt="">
          <input type="text" class="search-input" placeholder="输入关键字搜索" v-model="key">
          <img class="lf icon-eliminate" src="./img/icon_Eliminate.png" alt="">
        </div>
        <div class="rt search-btn">
          <p style="color: #fff;">搜索</p>
        </div>
      </div>

    </div>
    <div v-if="diseaseList!=undefined" style="border-top: .15rem solid #f5f5f5;">
      <p class="disease-list">疾病</p>
      <p v-for="disease in diseaseList" class="disease-list">{{disease.diseasename}}</p>
    </div>
    <div v-if="drugList!=undefined" style="border-top: .15rem solid #f5f5f5;">
      <p class="disease-list">药品</p>
      <p v-for="drug in drugList" class="disease-list" @click="goDetail(drug)">
        {{drug.drugname}}
      </p>
    </div>
    <div v-if="essayList!=undefined" style="border-top: .15rem solid #f5f5f5;">
      <p class="disease-list">资讯</p>
      <p v-for="essay in essayList" class="disease-list">
        <router-link :to="{
              path:'/articleDetail',
              query:{
                id:essay.criticsmessageid
              }}">{{essay.criticsmessagetitle}}
        </router-link>
      </p>
    </div>

  </div>
</template>
<script>
  import {MessageBox} from 'mint-ui';
  export default{
    data(){
      return {
        key: this.$route.query.key,
        diseaseList: [],
        drugList: [],
        essayList: []
      }
    },
    methods: {
      getSearchList(key, type){
        this.$http.post('http://192.168.0.200:7001/ylgl040Action.do', {
          jsonData: JSON.stringify({
            handleCode: 'searchVaguenessbyDoctor',
            searchKey: key,
            type: type,
            pageNum: 1,
            pageSize: 100
          })
        }, {emulateJSON: true}).then(function (res) {
          console.log(res);
          this.diseaseList = [];
          if (res.body.code === '0000') {
            this.diseaseList = res.body.data.diseaseList;
            this.drugList = res.body.data.drugList;
            this.essayList = res.body.data.essayList;
            console.log(this.essayList);
          } else {
            MessageBox('提示', res.body.msg);
          }
        })
      },
      //      跳转药品详情
      goDetail(drug){
        this.$router.push({
          path: '/medicineDetail', query: {
            name: drug.diseasename,
            id: drug.diseaseid,
          }
        })
      }
    },
    mounted(){
      this.getSearchList(this.$route.query.key, this.$route.query.type)
    }
  }
</script>
<style type='text/css'>

</style>
