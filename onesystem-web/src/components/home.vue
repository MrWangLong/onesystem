<template>
  <div>
    <!--内容-->
    <div>
      <router-view></router-view>
    </div>
    <!-- 底部导航栏 -->
    <div class="page-tabbar">
      <mt-tabbar v-model="selected" fixed>
        <mt-tab-item id="mt_tab_item_homePage">
          <img v-if="homePage_selected === 1" slot="icon" src="../assets/img/home/icon_homePage_selected.png">
          <img v-if="homePage_selected === 0" slot="icon" src="../assets/img/home/icon_homePage_unchecked.png">
          首页
        </mt-tab-item>
        <mt-tab-item id="mt_tab_item_shop">
          <img v-if="shop_selected === 1" slot="icon" src="../assets/img/home/icon_shop_selected.png">
          <img v-if="shop_selected === 0" slot="icon" src="../assets/img/home/icon_shop_unchecked.png">
          商城
        </mt-tab-item>
        <mt-tab-item id="mt_tab_item_appDownload">
          <img v-if="appDownload_selected === 1" slot="icon" src="../assets/img/home/icon_appDownload_selected.png">
          <img v-if="appDownload_selected === 0" slot="icon" src="../assets/img/home/icon_appDownload_unchecked.png">
          App下载
        </mt-tab-item>
        <mt-tab-item id="mt_tab_item_me">
          <img v-if="me_selected === 1" slot="icon" src="../assets/img/home/icon_me_selected.png">
          <img v-if="me_selected === 0" slot="icon" src="../assets/img/home/icon_me_unchecked.png">
          我的
        </mt-tab-item>
      </mt-tabbar>
    </div>
  </div>
</template>

<style>
  .page-tabbar {
    overflow: hidden;
    height: 100vh;
  }
</style>

<script>
  export default {
    name: 'page-tabbar',
    data() {
      return {
        selected: 'mt_tab_item_homePage',
        homePage_selected: 1,
        shop_selected: 0,
        appDownload_selected: 0,
        me_selected: 0
      };
    },
    watch: {
      selected: function (val, oldVal) {
        // <router-link to="/searchHistory"></router-link>
        if(val=='mt_tab_item_homePage'){
          this.homePage_selected = 1;
          this.shop_selected = 0;
          this.appDownload_selected = 0;
          this.me_selected = 0;
        }else if(val=='mt_tab_item_shop'){
          this.homePage_selected = 0;
          this.shop_selected = 1;
          this.appDownload_selected = 0;
          this.me_selected = 0;
          this.$router.push({path:'/shoppingMall'});
        }else if(val=='mt_tab_item_appDownload'){
          this.homePage_selected = 0;
          this.shop_selected = 0;
          this.appDownload_selected = 1;
          this.me_selected = 0;
          this.$router.push({path:'/article'});
        }else if(val=='mt_tab_item_me'){
          this.homePage_selected = 0;
          this.shop_selected = 0;
          this.appDownload_selected = 0;
          this.me_selected = 1;
          this.$router.push({path:'/myself'});
        }
      }
    },
    mounted: function(){
      // 默认路由到首页
      this.$router.push({path:'/home/homePage'});
    },
    methods:{

    }
  };
</script>
