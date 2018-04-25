<template>
  <div style="text-align: left;">
    <header class="mint-header">
      <div class="mint-header-button is-left"><a href="#/" class="router-link-active">
        <button class="mint-button mint-button--default mint-button--normal"><span class="mint-button-icon"><i
          class="mintui mintui-back"></i></span></button>
      </a></div>
      <h1 class="mint-header-title">药品分类</h1>
      <div class="mint-header-button is-right"></div>
    </header>
    <ul class="over medicine-title-ul">
      <li class="lf medicine-title-li" v-for="(drug,index) in drugsFirst"><span class="medicine-title"
                                                                                @click="medicineType(index);getMedicineSecond(drug.id)"
                                                                                :class="{medicinechoose:classifyChoose===index}"
                                                                                style="">{{drug.caption}}</span></li>
      <!--<li class="lf medicine-title-li"><span class="medicine-title" @click="medicineType(2)"-->
      <!--:class="{medicinechoose:classifyChoose===2}">中成药</span></li>-->
    </ul>
    <!--西药-->
    <ul>
      <li class="medicine-classify" @click="goWhere(drugs)" v-for="drugs in drugsSecond">
        {{drugs.caption}}
      </li>
      <!--<li class="medicine-classify">-->
      <!--<router-link to="/medicineTwostage">皮肤科用药</router-link>-->
      <!--</li>-->
      <!--<li class="medicine-classify">消化系统用药</li>-->
      <!--<li class="medicine-classify">眼科用药</li>-->
      <!--<li class="medicine-classify">皮肤科用药</li>-->
      <!--<li class="medicine-classify">消化系统用药</li>-->
    </ul>
    <!--&lt;!&ndash;中成药&ndash;&gt;-->
    <!--<ul v-if="classifyChoose===2">-->
    <!--<li class="medicine-classify">中成药眼科用药</li>-->
    <!--<li class="medicine-classify">中成药皮肤科用药</li>-->
    <!--<li class="medicine-classify">中成药消化系统用药</li>-->
    <!--<li class="medicine-classify">中成药眼科用药</li>-->
    <!--<li class="medicine-classify">中成药皮肤科用药</li>-->
    <!--<li class="medicine-classify">中成药消化系统用药</li>-->
    <!--</ul>-->
  </div>
</template>
<script>
  import './medicine.css'
  export default{
    data(){
      return {
        classifyChoose: 0,
        drugsFirst: [],//一级药品
        drugsSecond: [],
      }
    },
    methods: {
      medicineType(which){
        this.classifyChoose = which;
      },
//          一级药品分类
      getMedicineType(drugId){
        this.$http.post('http://192.168.0.159:7001/ylgl001Action.do', {
          jsonData: JSON.stringify({
            handleCode: 'getDrugByPid',
            drugId: drugId,
            pageNum: '1',
            pageSize: '30',
          })
        }, {emulateJSON: true}).then(function (res) {
          if (res.body.code === "0000") {
            this.drugsFirst = res.body.data.drugs;
            this.getMedicineSecond(res.body.data.drugs[0].id);
          }
        })
      },
//        二级药品分类
      getMedicineSecond(drugId){
        this.$http.post('http://192.168.0.159:7001/ylgl001Action.do', {
          jsonData: JSON.stringify({
            handleCode: 'getDrugByPid',
            drugId: drugId,
            pageNum: '1',
            pageSize: '30',
          })
        }, {emulateJSON: true}).then(function (res) {
          if (res.body.code === "0000") {
            this.drugsSecond = res.body.data.drugs;
          }
        })
      },
//      跳转下个分类还是详情
      goWhere(drugs){
        if (drugs.hasnext === 'true') {
          this.$router.push({
            path: '/medicineTwostage',
            query: {
              id: drugs.id,
              name: drugs.caption
            },
          })
        }
        if (drugs.hasnext === 'false') {
          this.$router.push({
            path: '/medicineDetail',
            query: {
              name: drugs.caption,
              id: drugs.id,
            }
          })
        }
      }
    },
    mounted(){
      this.getMedicineType(401349);
    },
  }
</script>
<style type='text/css'>
  .medicinechoose {
    border-bottom: .03rem solid #0fa1ff;
    color: #0fa1ff;
  }
</style>
