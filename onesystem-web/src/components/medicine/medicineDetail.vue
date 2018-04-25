<template>
  <div>
    <header class="mint-header">
      <div class="mint-header-button is-left"><a href="#/" class="router-link-active">
        <button class="mint-button mint-button--default mint-button--normal"><span class="mint-button-icon"><i
          class="mintui mintui-back"></i></span></button>
      </a></div>
      <h1 class="mint-header-title">药品详情</h1>
      <div class="mint-header-button is-right"></div>
    </header>

    <div class="medicine-general-box">
      <p class="medicine-general"><span class="lf" style="color: #0fa1ff;">{{drugName}}</span><span class="rt">价格</span>
      </p>
      <p class="medicine-general"><span class="lf" style="color: #858484;">{{drugDetail.companyname}}</span><span class="rt"
                                                                                                style="color: #0fa1ff;">{{drugDetail.drugprice}}元</span>
      </p>
    </div>
    <div>
      <p class="medicine-analyse-caption">适应症</p>
      <div class="medicine-analyse-discription">
       {{drugDetail.drugindication}}
      </div>

      <p class="medicine-analyse-caption">用法用量</p>
      <div class="medicine-analyse-discription">
       {{drugDetail.drugusagedosage}}
      </div>

      <p class="medicine-analyse-caption">禁忌</p>
      <div class="medicine-analyse-discription">
        {{drugDetail.drugtaboo}}
      </div>

      <p class="medicine-analyse-caption">不良反应</p>
      <div class="medicine-analyse-discription">
       {{drugDetail.druguntowardeffect}}
      </div>
    </div>
  </div>
</template>
<script>
  export default{
    data(){
      return {
        drugDetail: {},
        drugId:this.$route.query.id,
        drugName:this.$route.query.name,
      }
    },
    methods: {
      getArticleDetail(){
        this.$http.post('http://192.168.0.159:7001/ylgl001Action.do', {
          jsonData: JSON.stringify({
            handleCode: 'getDrugDetailById',
            drugId: this.drugId,
          })
        }, {emulateJSON: true}).then(function (res) {
          console.log(res);
          if(res.body.code === '0000'){
              this.drugDetail = res.body.data.drug;
          }
        })
      }
    },
    mounted(){
        this.getArticleDetail();
    }
  }
</script>
<style type='text/css'>

</style>
