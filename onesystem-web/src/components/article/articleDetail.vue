<template>
  <div>
    <header class="mint-header">
      <div class="mint-header-button is-left">
        <router-link to="/article" class="router-link-active">
          <button class="mint-button mint-button--default mint-button--normal"><span class="mint-button-icon"><i
            class="mintui mintui-back"></i></span></button>
        </router-link>
      </div>
      <h1 class="mint-header-title">{{articleDetail.MessageTitle}}</h1>
      <div class="mint-header-button is-right">
        <button class="mint-button mint-button--default mint-button--normal"><span class="mint-button-icon"><i
          class="mintui mintui-more"></i></span> <label class="mint-button-text"></label></button>
      </div>
    </header>
    <div class="distance" style="text-align: left;">
      <p class="article-detail-title">{{articleDetail.MessageTitle}}</p>
      <div class="over">
        <p class="lf article-detail-source">{{articleDetail.Source}}</p>
        <p class="lf article-detail-source">{{articleDetail.PublishTime}}</p>
        <!--<p class="lf article-detail-source">-->
        <!--<img src="./img/icon_Read.png" class="article-detail-read" alt="">12</p>-->
      </div>
      <div>
        {{articleDetail.content}}
      </div>
      <!--未点赞-->
      <div class="article-thumb-box"  v-if="thrumbupState == false" @click="thumbUpInfor()" style="border: 1px solid #0fa1ff;">
        <img
             src="./img/thumb.png"
             class="article-thumb-img" alt="">


        <p>{{thumbupNum}}</p>


      </div>
      <!--已点赞-->
      <div class="article-thumb-box" @click='thumbUpInfor()' v-if="thrumbupState == true" style="border: 1px solid #ffc107;">
        <img
             src="./img/thumbed.png"
             class="article-thumb-img" alt="">
      <p>{{thumbupNum}}</p>
      </div>
    </div>
  </div>
</template>
<script>
  export default{
    data(){
      return {
        articleDetail: {},
        thrumbupState: '',
        thumbupNum:''
      }
    },
    methods: {
      getArticleDetail(){
        this.$http.post('http://192.168.0.222:7001/zxgl050Action.do', {
          jsonData: JSON.stringify({
            handleCode: 'getBolgDetail',
            messageID: this.$route.query.id
          })
        }, {emulateJSON: true}).then(function (res) {
//          console.log(res);
          if (res.body.code === '0000') {
            this.articleDetail = res.body.data.info;
            this.thumbupNum = res.body.data.info.thumbup;
          }
        })
      },
      //        点赞资讯
      thumbUpInfor(){
        if (sessionStorage.getItem('userInfo') !== undefined && sessionStorage.getItem('userInfo') !== "" && sessionStorage.getItem('userInfo') !== null) {
          var csThumbUp = {
            handleCode: 'thrumbupCriticsByUser',
            criticsmessageid: this.$route.query.id
          };
          this.$http.post('/api/zxgl002Action.do', {
            jsonData: JSON.stringify(csThumbUp)
          }, {emulateJSON: true}).then(function (res) {
//            console.log(res);
            if (res.body.code === '0000') {
              this.thrumbupState = res.body.data.thrumbupState;
              if(res.body.data.thrumbupState === true){
                  this.thumbupNum ++;
              }
              if(res.body.data.thrumbupState === false){
                this.thumbupNum --;
              }
            }
          })
        } else {
          this.$router.push({path: '/login'})
        }
      },
    },
    mounted(){
      this.getArticleDetail();
    }
  }
</script>
<style type='text/css'>

</style>
