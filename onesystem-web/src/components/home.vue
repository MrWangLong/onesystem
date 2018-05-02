<template>
  <div>
    <!--内容start-->
    <div>
      <router-view></router-view>
    </div>
    <!--内容end-->
    <!-- 底部导航栏 start -->
    <div class="page-tab" >
      <mt-tabbar v-model="selected" fixed>
        <mt-tab-item id="mt_tab_index">
          <img v-if="index_selected === 1" slot="icon" src="../assets/img/home/temp_icon_white.png"/>
          <img v-if="index_selected === 0" slot="icon" src="../assets/img/home/temp_icon_black.png"/>
          首页
        </mt-tab-item>
        <mt-tab-item id="mt_tab_circle">
          <img v-if="circle_selected === 1" slot="icon" src="../assets/img/home/temp_icon_white.png"/>
          <img v-if="circle_selected === 0" slot="icon" src="../assets/img/home/temp_icon_black.png"/>
          圈子
        </mt-tab-item >
        <mt-tab-item id="mt_tab_chat">
          <img v-if="chat_selected === 1" slot="icon" src="../assets/img/home/temp_icon_white.png"/>
          <img v-if="chat_selected === 0" slot="icon" src="../assets/img/home/temp_icon_black.png"/>
          聊天
        </mt-tab-item>
        <mt-tab-item id="mt_tab_mine">
          <img v-if="mine_selected === 1" slot="icon" src="../assets/img/home/temp_icon_white.png"/>
          <img v-if="mine_selected === 0" slot="icon" src="../assets/img/home/temp_icon_black.png"/>
          我的
        </mt-tab-item>
      </mt-tabbar>
    </div>
    <!-- 底部导航栏 end -->
  </div>
</template>

<style>
  .page-tab {
    overflow: hidden;
    height: 100vh;
  }
</style>

<script>
  export default {
    name: 'page-tab',
    data() {
      return { //  mt-circle mt-chat mt-mine
        selected: 'mt_tab_index',
        index_selected: 1,
        circle_selected: 0,
        chat_selected: 0,
        mine_selected: 0
      };
    },
    watch: {
      selected: function (val) {
         this.index_selected = 0;
         this.circle_selected =  0;
         this.chat_selected = 0;
         this.mine_selected =  0;
         switch (val){
          case "mt_tab_index": this.index_selected = 1 ; break;
          case "mt_tab_circle": this.circle_selected = 1; break; //this.$router.push({path:'/circle'});
          case "mt_tab_chat": this.chat_selected = 1;  break; // this.$router.push({path:'/chat'});
          case "mt_tab_mine": this.mine_selected = 1; break; //this.$router.push({path:'/mine'});
          default: this.index_selected = 1 ;
        }
       //this.$router.push({path:'/myself'});
      }
    },
    mounted: function(){
      // 默认路由到首页
      this.$router.push({path:'/'});
    },
    methods:{

    }
  };
</script>
