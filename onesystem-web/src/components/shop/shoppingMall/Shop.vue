<template>
  <div class="shop">
    <Nav title="商城" :show="show"></Nav>
    <div class="tdsc">
      <div class="tdscTop">天渡商城</div>
      <div class="tdscBottom">
        <div class="floatLeft coin">
          <span class="coin1">5200</span>
          <span class="coin2">健康币</span>
        </div>
        <div class="floatRight record">
          <span>兑换记录</span>
        </div>
      </div>
    </div>
    <div class="pic"><img src="../img/shop/icon_Advertising_position.png"/></div>
    <div class="list">
      <p class="p1">精选商品</p>
      <p class="p2">严选美物随心兑换</p>
      <div class="clearfloat ul1">
        <div class="li1">
          <div class="picFood"><img  src="../img/shop/icon_Default_diagram.png"/></div>
          <p class="title">沁园饮水机立式无胆速</p>
          <p class="hCoin"><span>300</span> 健康币</p>
        </div>
        <div class="li1" >
          <div class="picFood"><img  src="../img/shop/icon_Default_diagram.png"/></div>
          <p class="title">沁园饮水机立式无胆速</p>
          <p class="hCoin"><span>300</span> 健康币</p>
        </div>
        <div class="li1" >
          <div class="picFood"><img  src="../img/shop/icon_Default_diagram.png"/></div>
          <p class="title">沁园饮水机立式无胆速</p>
          <p class="hCoin"><span>300</span> 健康币</p>
        </div>
        <div  class="li1">
          <div class="picFood"><img  src="../img/shop/icon_Default_diagram.png"/></div>
          <p class="title">沁园饮水机立式无胆速</p>
          <p class="hCoin"><span>300</span> 健康币</p>
        </div>
      </div>
    </div>

  </div>
</template>
<script>
  import Nav from '../common/Nav'
  import { Toast } from 'mint-ui';
  export default{
    data(){
      return{
        show:false
      }
    },
    components:{
      Nav
    }

  }
</script>
<style scoped="true">
  .clearfloat:after{display:block;clear:both;content:"";visibility:hidden;height:0rem}
  .clearfloat{zoom:1}
  .floatLeft{
    float: left;
  }
  .floatRight{
    float: right;
  }
  .tdsc{
    padding:.4rem .42rem 0rem;
  }
  .tdsc .tdscTop{
    font-size: 0.48rem;
    color: #333333;
    text-align: left;
  }
  .tdsc .tdscBottom{
    line-height: 0.98rem;
    height: 0.98rem;

  }
  .tdsc .tdscBottom .coin1{
    padding-left: 0.46rem;
    background: url("../img/shop/icon_healthcoin.png") no-repeat;
    background-size: 0.36rem 0.36rem;
    font-size: 0.36rem;
    color: #ffa912;
  }
  .tdsc .tdscBottom .coin2{
    font-size: 0.3rem;
    color: #333333;
  }
  .tdsc .tdscBottom .record span{
    font-size: 0.3rem;
    color: #6e6e6e;
    padding-right: 0.3rem;
    background: url("../img/shop/icon_Arrow.png") no-repeat right;
    background-size: 0.15rem 0.26rem;
  }
  .pic{
    width: 100%;
    height: 2.6rem;
  }
  .pic img{
    width: 100%;
    height: 2.6rem;
    border: none;

  }
  .list{
    margin: 0.4rem 0rem;
  }
  .list .p1{
    font-size: 0.32rem;
    color: #333333;
  }
  .list .p2{
    font-size: 0.24rem;
    color: #c0c0c0;
    margin-top: 0.2rem;
  }
  .list .ul1{
    text-align: left;
    padding: 0.3rem 0.15rem;
  }
  .ul1 .li1{
    float: left;
    padding: 0.1rem 0.15rem;
  }
  .ul1 .li1 .picFood img{
    width: 3.3rem;
    height: 2.18rem;
  }
  .ul1 .li1 .title{
    font-size: 0.3rem;
    color: #1e1e1e;

  }
  .ul1 .li1.hCoin{
    font-size: 0.28rem;
    color: #ffa912;
  }
  .ul1 .li1 .hCoin span{
    padding-left: 0.32rem;
    background: url("../img/shop/icon_healthcoin.png") no-repeat;
    background-size: 0.3rem 0.3rem;
  }


</style>
