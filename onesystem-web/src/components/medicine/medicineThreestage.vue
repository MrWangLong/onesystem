<template>
  <div style="text-align: left;">
    <header class="mint-header">
      <div class="mint-header-button is-left"><a href="#/" class="router-link-active">
        <button class="mint-button mint-button--default mint-button--normal"><span class="mint-button-icon"><i
          class="mintui mintui-back"></i></span></button>
      </a></div>
      <h1 class="mint-header-title">{{title}}</h1>
      <div class="mint-header-button is-right"></div>
    </header>

    <!--西药-->
    <ul>
      <li class="medicine-classify" v-for="drug in drugsSecond" @click="goDetail(drug)">{{drug.caption}}</li>
      <!--<li class="medicine-classify">皮肤科用药</li>-->
      <!--<li class="medicine-classify">消化系统用药</li>-->
      <!--<li class="medicine-classify">眼科用药</li>-->
      <!--<li class="medicine-classify">皮肤科用药</li>-->
      <!--<li class="medicine-classify">消化系统用药</li>-->
    </ul>

  </div>
</template>
<script>
  export default{
    data(){
      return {
        title: this.$route.query.name,
        drugsSecond: []
      }
    },
    methods: {
      //        三级药品分类
      getMedicineSecond(drugId){
        this.$http.post('http://192.168.0.159:7001/ylgl001Action.do', {
          jsonData: JSON.stringify({
            handleCode: 'getDrugByPid',
            drugId: drugId,
            pageNum: '1',
            pageSize: '30',
          })
        }, {emulateJSON: true}).then(function (res) {
          console.log(res);
          if (res.body.code === "0000") {
            this.drugsSecond = res.body.data.drugs;
          }
        })
      },
//      跳转药品详情
      goDetail(drug){
        this.$router.push({
          path: '/medicineDetail', query: {
            name: drug.caption,
            id: drug.id,
          }
        })
      }
    },
    mounted(){
      console.log(this.$route.query);
      this.getMedicineSecond(this.$route.query.id)
    }
  }
</script>
<style type='text/css'>

</style>
