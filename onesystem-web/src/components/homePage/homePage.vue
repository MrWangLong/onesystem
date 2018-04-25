<template>
  <div class="">
    <div>
      <mt-cell class="page-title" title="天渡医生"/>
    </div>
    <div>
      <input type="text" value="输入关键字搜索" style="height:25px;width:85%;margin-top:15px;border-radius: 10px;">
    </div>
    <ul class='ul_functionClassify'>
      <li>
        <img style='width:50px;height:50px;' src="../../assets/img/home/icon_disease_inquiry.png">
        <p>疾病查询</p>
      </li>
      <li>
        <img style='width:50px;height:50px;' src="../../assets/img/home/icon_drug_inquiries.png">
        <p>药品查询</p>
      </li>
      <li>
        <router-link to="/healthTools">
          <img style='width:50px;height:50px;' src="../../assets/img/home/icon_health_calculation.png">
          <p>医学计算</p>
        </router-link>
      </li>
      <li>
        <img style='width:50px;height:50px;' src="../../assets/img/home/icon_medical_statistics.png">
        <p>医学统计</p>
      </li>
    </ul>
    <div class="page-swipe" style="margin-top: 0.25rem;">
      <mt-swipe>
        <mt-swipe-item class="slide1">
          <router-link to="/mine">
            <img src="../healthTools/img/commentStar.png"/>
          </router-link>
        </mt-swipe-item>
        <mt-swipe-item class="slide2">
          <router-link to="/product">
            <img src="../healthTools/img/commentStar.png"/>
          </router-link>
        </mt-swipe-item>
        <mt-swipe-item class="slide3">
          <router-link to="/detailPage">
            <img src="../healthTools/img/commentStar.png"/>
          </router-link>
        </mt-swipe-item>
      </mt-swipe>
    </div>
    <div>
      <mt-navbar class="page-part" v-model="selected">
        <router-link to="/search"> <mt-tab-item id="医疗头条">医疗头条</mt-tab-item> </router-link>
        <mt-tab-item id="今日热点">今日热点</mt-tab-item>
        <mt-tab-item id="医学前沿">医学前沿</mt-tab-item>
        <mt-tab-item id="学术期刊">学术期刊</mt-tab-item>
      </mt-navbar>
      <!-- tab-container -->
      <mt-tab-container v-model="selected">
        <mt-tab-container-item id="医疗头条">
          <mt-cell v-for="n in 10" :title="'content ' + n" />
        </mt-tab-container-item>
        <mt-tab-container-item id="今日热点">
          <mt-cell v-for="n in 4" :title="'content ' + n" />
        </mt-tab-container-item>
        <mt-tab-container-item id="医学前沿">
          <mt-cell v-for="n in 6" :title="'content ' + n" />
        </mt-tab-container-item>
        <mt-tab-container-item id="学术期刊">
          <mt-cell v-for="n in 6" :title="'content ' + n" />
        </mt-tab-container-item>
      </mt-tab-container>
    </div>

  </div>
</template>

<style>
  .page-wrap {
    overflow: auto;
    height: 100%;
    padding-bottom: 100px;
  }

  .ul_functionClassify li {
    margin-top: 0.25rem;
    margin-left: 35px;
    float:left;
    list-style: none;
  }

  .page-tabbar {
    overflow: hidden;
    height: 100vh;
  }

  .mint-swipe {
    width: 100%;
    height: 170px;
    color: #fff;
    font-size: 30px;
    text-align: center;
  }

  .mint-swipe a {
    display: block;
    height: 200px;
  }

  .slide1 {
    background-color: #0089dc;
    color: #fff;
    position: relative;
  }
  .slide2 {
    background-color: #ffd705;
    color: #000;
    position: relative;
  }

  .slide3 {
    background-color: #ff2d4b;
    color: #fff;
    position: relative;
  }
</style>

<script>
  export default {
    data() {
      return {
        selected: '医疗头条'
      };
    },
    methods:{

    }
  };
</script>
