<template>
<div>
  <!--上边栏start-->
  <Nav title="兑换记录" :show="show"></Nav>
  <!--上边栏end-->
  <!--兑换记录start-->
  <div class="exchange-record-item">
    <ul class="divided-line">
      <li class="clear-float fade-message li-top">
        <span class="float-left">2018-03-20</span>
        <span class="float-right" >订单编号：339485921049</span>
      </li>
      <li class="clear-float li-top">
        <div class="left-side">
           <img src="../img/shop/exchange_product_1.png" class="product-img" />
        </div>
        <div class="right-side" >
          <p class="product-message" >沁园饮水机立式无园园饮水机立式园饮水机园饮水机立式无立式无无饮水机立式无胆热</p >
          <p class="health-coin">
            <span class="float-left golden-message">3400健康币</span>
            <span class="float-right exchange-state">兑换成功</span>
          </p>
        </div>
      </li>
      <li class="clear-float li-top">
        <span class="float-left fade-message">中通快递：339485921049</span>
      </li>
    </ul>
  </div>
  <!--兑换记录end-->
  <!--底部start-->
  <div class="li-top">
  <span class="fade-message">已经没有更多数据了！</span>
  </div>
  <!--底部end-->
</div>
</template>

<script>
  import Nav from '../common/Nav'
  export default{
      data(){
          return {
             show:false
          }
      },
     components:{
       Nav
     }
  }
</script>

<style scoped>
  .health-coin{
   margin-top:0.18rem;
   text-align:left
  }
  .product-message{
    text-align:left;
    line-height: 0.4rem;
    height: 0.8rem;
    overflow: hidden;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    font-size: 0.28rem;
    color: #323233;
    font-family: PingFang-SC-Bold;
  }
  .left-side{
    float: left;
    width:2rem;
    height: 1.33rem
  }
  .right-side{
    float: right;
    width:4.8rem;
    height: 1.33rem
  }
  .product-img{
    width:2rem;height: 1.33rem
  }
  .divided-line{
    border-bottom: 0.01rem solid #c5c5c5;
    padding-bottom: 0.3rem
  }
 .clear-float:after{
   display:block;
   clear:both;
   content:"";
   visibility:hidden;
   height:0rem}
 .clear-float{
   zoom:1
 }
 .float-left{
   float: left;
 }
 .float-right{
   float: right;
 }
 .exchange-record-item{
   padding: 0rem 0.3rem;
 }
 .li-top{
   margin-top: 0.3rem;
 }
 .fade-message{
   font-size: 0.28rem;
   color: #acaeb2;
   font-family: MicrosoftYaHei;
 }
 .golden-message{
   font-size: 0.28rem;
   color: #f49c03;
   padding-left: 0.36rem;
   background: url("../img/shop/icon_healthcoin.png") no-repeat left center ;
   background-size: 0.3rem 0.3rem;

 }
  .exchange-state{
    font-size: 0.26rem;
    color: #0fa1ff;
  }
</style>
