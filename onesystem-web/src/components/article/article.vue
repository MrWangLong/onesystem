<template>
  <div>
    <div>
      <ul class="over distance" style="margin-bottom: .3rem;">
        <li class="lf article-title" v-for="(type,index) in articleType" :class='{choose:article==index}'
            @click="getChoosed(index);getTypeBolgList(type.id)">{{type.caption}}
        </li>
        <!--<li class="lf article-title" :class='{choose:article==2}' @click="getChoosed(2)">今日热点</li>-->
        <!--<li class="lf article-title" :class='{choose:article==3}' @click="getChoosed(3)">医学前言</li>-->
        <!--<li class="lf article-title" :class='{choose:article==4}' @click="getChoosed(4)">学术期刊</li>-->
      </ul>
      <div v-show="article === isShow" style="text-align: left;">
        <div class="over article-box" v-for="article in articleList">
          <router-link :to="{
              path:'/articleDetail',
              query:{
                id:article.messageid
              }}"><img class="lf article-box-img" :src="article.thumbnail" style="background-color: #0fa1ff;"
                                                alt=""></router-link>
          <div class="lf article-box-rt">
            <p style="font-size: .28rem">
              <router-link :to="{
              path:'/articleDetail',
              query:{
                id:article.messageid
              }}">{{article.title}}
              </router-link>
            </p>
            <div class="over article-box-list">
              <!--<p class="lf classify-btn">医疗头条</p>-->
              <!--<p class="lf classify-btn">今日热点</p>-->
              <p class="lf" style="margin-right: .2rem;"><img src="./img/icon_Fabulous.png" class="article-thumb" alt="">{{article.thumbup}}点赞</p>
              <p class="lf">{{article.publishtime}}</p>
            </div>
          </div>
        </div>
        <!---->
        <!--<div class="over article-box">-->
          <!--<img class="lf article-box-img" src="" style="background-color: #0fa1ff;"-->
               <!--alt="">-->
          <!--<div class="lf article-box-rt">-->
            <!--<p style="font-size: .28rem">抗癌药品零关税后，药改还有哪些动作？</p>-->
            <!--<div class="over article-box-list">-->
              <!--<p class="lf classify-btn">医疗头条</p>-->
              <!--<p class="lf classify-btn">今日热点</p>-->
              <!--<p class="lf"><img src="./img/icon_Fabulous.png" class="article-thumb" alt="">308点赞</p>-->
            <!--</div>-->
          <!--</div>-->
        <!--</div>-->
        <!--<div class="over article-box">-->
          <!--<img class="lf article-box-img" src="" style="background-color: #0fa1ff;"-->
               <!--alt="">-->
          <!--<div class="lf article-box-rt">-->
            <!--<p style="font-size: .28rem">抗癌药品零关税后，药改还有哪些动作？</p>-->
            <!--<div class="over article-box-list">-->
              <!--<p class="lf classify-btn">医疗头条</p>-->
              <!--<p class="lf classify-btn">今日热点</p>-->
              <!--<p class="lf"><img src="./img/icon_Fabulous.png" class="article-thumb" alt="">308点赞</p>-->
            <!--</div>-->
          <!--</div>-->
        <!--</div>-->
        <!--<div class="over article-box">-->
          <!--<img class="lf article-box-img" src="" style="background-color: #0fa1ff;"-->
               <!--alt="">-->
          <!--<div class="lf article-box-rt">-->
            <!--<p style="font-size: .28rem">抗癌药品零关税后，药改还有哪些动作？</p>-->
            <!--<div class="over article-box-list">-->
              <!--<p class="lf classify-btn">医疗头条</p>-->
              <!--<p class="lf classify-btn">今日热点</p>-->
              <!--<p class="lf"><img src="./img/icon_Fabulous.png" class="article-thumb" alt="">308点赞</p>-->
            <!--</div>-->
          <!--</div>-->
        <!--</div>-->
        <!---->
      </div>
      <!--<div v-show="article === 1" style="text-align: left;">-->
      <!--<div class="over article-box">-->
      <!--<img class="lf article-box-img" src="" style="background-color: #0fa1ff;"-->
      <!--alt="">-->
      <!--<div class="lf article-box-rt">-->
      <!--<p style="font-size: .28rem">今日热点</p>-->
      <!--<div class="over article-box-list">-->
      <!--<p class="lf classify-btn">医疗头条</p>-->
      <!--<p class="lf classify-btn">今日热点</p>-->
      <!--<p class="lf"><img src="./img/icon_Fabulous.png" class="article-thumb" alt="">308点赞</p>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--&lt;!&ndash;&ndash;&gt;-->
      <!--<div class="over article-box">-->
      <!--<img class="lf article-box-img" src="" style="background-color: #0fa1ff;"-->
      <!--alt="">-->
      <!--<div class="lf article-box-rt">-->
      <!--<p style="font-size: .28rem">抗癌药品零关税后，药改还有哪些动作？</p>-->
      <!--<div class="over article-box-list">-->
      <!--<p class="lf classify-btn">医疗头条</p>-->
      <!--<p class="lf classify-btn">今日热点</p>-->
      <!--<p class="lf"><img src="./img/icon_Fabulous.png" class="article-thumb" alt="">308点赞</p>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--<div class="over article-box">-->
      <!--<img class="lf article-box-img" src="" style="background-color: #0fa1ff;"-->
      <!--alt="">-->
      <!--<div class="lf article-box-rt">-->
      <!--<p style="font-size: .28rem">抗癌药品零关税后，药改还有哪些动作？</p>-->
      <!--<div class="over article-box-list">-->
      <!--<p class="lf classify-btn">医疗头条</p>-->
      <!--<p class="lf classify-btn">今日热点</p>-->
      <!--<p class="lf"><img src="./img/icon_Fabulous.png" class="article-thumb" alt="">308点赞</p>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--<div class="over article-box">-->
      <!--<img class="lf article-box-img" src="" style="background-color: #0fa1ff;"-->
      <!--alt="">-->
      <!--<div class="lf article-box-rt">-->
      <!--<p style="font-size: .28rem">抗癌药品零关税后，药改还有哪些动作？</p>-->
      <!--<div class="over article-box-list">-->
      <!--<p class="lf classify-btn">医疗头条</p>-->
      <!--<p class="lf classify-btn">今日热点</p>-->
      <!--<p class="lf"><img src="./img/icon_Fabulous.png" class="article-thumb" alt="">308点赞</p>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--&lt;!&ndash;&ndash;&gt;-->
      <!--</div>-->
      <!--<div v-show="article === 2" style="text-align: left;">-->
      <!--<div class="over article-box">-->
      <!--<img class="lf article-box-img" src="" style="background-color: #0fa1ff;"-->
      <!--alt="">-->
      <!--<div class="lf article-box-rt">-->
      <!--<p style="font-size: .28rem">医学前言</p>-->
      <!--<div class="over article-box-list">-->
      <!--<p class="lf classify-btn">医疗头条</p>-->
      <!--<p class="lf classify-btn">今日热点</p>-->
      <!--<p class="lf"><img src="./img/icon_Fabulous.png" class="article-thumb" alt="">308点赞</p>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--&lt;!&ndash;&ndash;&gt;-->
      <!--<div class="over article-box">-->
      <!--<img class="lf article-box-img" src="" style="background-color: #0fa1ff;"-->
      <!--alt="">-->
      <!--<div class="lf article-box-rt">-->
      <!--<p style="font-size: .28rem">抗癌药品零关税后，药改还有哪些动作？</p>-->
      <!--<div class="over article-box-list">-->
      <!--<p class="lf classify-btn">医疗头条</p>-->
      <!--<p class="lf classify-btn">今日热点</p>-->
      <!--<p class="lf"><img src="./img/icon_Fabulous.png" class="article-thumb" alt="">308点赞</p>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--<div class="over article-box">-->
      <!--<img class="lf article-box-img" src="" style="background-color: #0fa1ff;"-->
      <!--alt="">-->
      <!--<div class="lf article-box-rt">-->
      <!--<p style="font-size: .28rem">抗癌药品零关税后，药改还有哪些动作？</p>-->
      <!--<div class="over article-box-list">-->
      <!--<p class="lf classify-btn">医疗头条</p>-->
      <!--<p class="lf classify-btn">今日热点</p>-->
      <!--<p class="lf"><img src="./img/icon_Fabulous.png" class="article-thumb" alt="">308点赞</p>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--<div class="over article-box">-->
      <!--<img class="lf article-box-img" src="" style="background-color: #0fa1ff;"-->
      <!--alt="">-->
      <!--<div class="lf article-box-rt">-->
      <!--<p style="font-size: .28rem">抗癌药品零关税后，药改还有哪些动作？</p>-->
      <!--<div class="over article-box-list">-->
      <!--<p class="lf classify-btn">医疗头条</p>-->
      <!--<p class="lf classify-btn">今日热点</p>-->
      <!--<p class="lf"><img src="./img/icon_Fabulous.png" class="article-thumb" alt="">308点赞</p>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--&lt;!&ndash;&ndash;&gt;-->
      <!--</div>-->
      <!--<div v-show="article === 3" style="text-align: left;">-->
      <!--<div class="over article-box">-->
      <!--<img class="lf article-box-img" src="" style="background-color: #0fa1ff;"-->
      <!--alt="">-->
      <!--<div class="lf article-box-rt">-->
      <!--<p style="font-size: .28rem">学术期刊</p>-->
      <!--<div class="over article-box-list">-->
      <!--<p class="lf classify-btn">医疗头条</p>-->
      <!--<p class="lf classify-btn">今日热点</p>-->
      <!--<p class="lf"><img src="./img/icon_Fabulous.png" class="article-thumb" alt="">308点赞</p>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--&lt;!&ndash;&ndash;&gt;-->
      <!--<div class="over article-box">-->
      <!--<img class="lf article-box-img" src="" style="background-color: #0fa1ff;"-->
      <!--alt="">-->
      <!--<div class="lf article-box-rt">-->
      <!--<p style="font-size: .28rem">抗癌药品零关税后，药改还有哪些动作？</p>-->
      <!--<div class="over article-box-list">-->
      <!--<p class="lf classify-btn">医疗头条</p>-->
      <!--<p class="lf classify-btn">今日热点</p>-->
      <!--<p class="lf"><img src="./img/icon_Fabulous.png" class="article-thumb" alt="">308点赞</p>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--<div class="over article-box">-->
      <!--<img class="lf article-box-img" src="" style="background-color: #0fa1ff;"-->
      <!--alt="">-->
      <!--<div class="lf article-box-rt">-->
      <!--<p style="font-size: .28rem">抗癌药品零关税后，药改还有哪些动作？</p>-->
      <!--<div class="over article-box-list">-->
      <!--<p class="lf classify-btn">医疗头条</p>-->
      <!--<p class="lf classify-btn">今日热点</p>-->
      <!--<p class="lf"><img src="./img/icon_Fabulous.png" class="article-thumb" alt="">308点赞</p>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--<div class="over article-box">-->
      <!--<img class="lf article-box-img" src="" style="background-color: #0fa1ff;"-->
      <!--alt="">-->
      <!--<div class="lf article-box-rt">-->
      <!--<p style="font-size: .28rem">抗癌药品零关税后，药改还有哪些动作？</p>-->
      <!--<div class="over article-box-list">-->
      <!--<p class="lf classify-btn">医疗头条</p>-->
      <!--<p class="lf classify-btn">今日热点</p>-->
      <!--<p class="lf"><img src="./img/icon_Fabulous.png" class="article-thumb" alt="">308点赞</p>-->
      <!--</div>-->
      <!--</div>-->
      <!--</div>-->
      <!--&lt;!&ndash;&ndash;&gt;-->
      <!--</div>-->
    </div>
  </div>
</template>
<script>
  import "./article.css"
  export default{
    data(){
      return {
        article: 0,
        isShow: 0,
        articleType: [],
        articleList: []
      }
    },
    methods: {
      getChoosed(which){
        this.article = which;
        this.isShow = which;
      },
//      获取文章类别
      getBolgCatalog(){
        this.$http.post('http://192.168.0.222:7001/zxgl050Action.do', {
          jsonData: JSON.stringify({
            handleCode: 'getBolgCatalog'
          })
        }, {emulateJSON: true}).then(function (res) {
          console.log(res);
          if (res.body.code === '0000') {
            this.articleType = res.body.data.info;
            this.getTypeBolgList(res.body.data.info[0].id)
          }
        })
      },
//      获取相应类别的文章
      getTypeBolgList(id){
        this.$http.post('http://192.168.0.222:7001/zxgl050Action.do', {
          jsonData: JSON.stringify({
            handleCode: 'getBolgList',
            categoryID: id,
            pageNum: 1,
            pageSize: 10
          })
        }, {emulateJSON: true}).then(function (res) {
          console.log(res);
          this.articleList = res.body.data.info.resultList
        })
      }
    },
    mounted(){
      this.getBolgCatalog();
    }
  }
</script>
<style type='text/css'>
  .choose {
    border-bottom: 3px solid #0fa1ff;
  }
</style>
