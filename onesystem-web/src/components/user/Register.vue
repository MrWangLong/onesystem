<template>
  <div class="register-page">
    <div class="page-top">
      <p>Pretend have a logo.</p>
    </div>
    <form class="register-form">
      <div class="form-item">
        <label for="phone">手机号码</label>
        <input type="text" id="phone" placeholder="请输入手机号码" v-model="phone" />
      </div>
      <div class="form-item">
        <label for="checkCode">验证码</label><br>
        <input type="text" id="checkCode"  placeholder="请输入验证码"  v-model="checkCode" />
        <button type="button" @click="getCheckCode()">获取验证码</button>
      </div>
      <div class="form-item">
        <label for="password">输入密码</label>
        <input type="password" id="password"  placeholder="请输入密码" v-model="password" />
      </div>
      <div class="form-item">
        <label for="rePassword">输入密码</label>
        <input type="password" id="rePassword"  placeholder="请确认密码" v-model="rePassword" />
      </div>
      <button class="register-submit" type="submit" @click="register()" >注册账号</button>
    </form>
  </div>
</template>

<script>
  import { Toast } from 'mint-ui';
  import {MessageBox} from 'mint-ui';

export default {
    name: 'Register',
    data() {
      return {
            phone:"",
        checkCode:"",
        password :"",
        rePassword:""
      };
    },
    methods:{
      getCheckCode(){
        //正则校验手机号
        if(!(/^1[34578]\d{9}$/.test(this.phone))){
          Toast("手机号不正确");
          this.phone = "";
          return ;
        }
        //获取验证码
        var url = "/onesystem/user/getCheckCode.do";
       this.$http.post(url,{phoneNumber:this.phone},{emulateJSON:true})
       //this.$axios.post(url,{phoneNumber:JSON.stringify(this.phone)},{emulateJSON:true})
        .then(
            function(data){
              MessageBox(
                '提示',
                '验证码' + data.data.code
              )
            },
            function (error) {
              console.log(error.data);
            }
        )
      },
      register(){
        //数据校验
        var isValidated =  this.validate();
        if(isValidated){
        //校验成功 保存
          this.save();
        }
      },
      validate(){
         //校验数据
        if(!(/^1[34578]\d{9}$/.test(this.phone))){
          Toast("手机号不正确");
          return false;
        }
        if(this.checkCode == ''){
          Toast("请输入验证码");
          return false;
        }
        if(this.password == ''){
          Toast("请输入密码");
          return false;
        }
        if(this.password.length < 6){
          Toast("密码长度不能小于6");
          return false;
        }
        if(this.rePassword == ''){
          Toast("请确认密码");
          return false;
        }
        if(this.password != this.rePassword){
          Toast("两次输入密码不一致");
          return false;
        }
        return true;
      },
      save(){
         var url = '/onesystem/user/register.do';
         var data = {
           telephone:this.phone,
           password:this.password,
           code:this.checkCode
         }
         this.$http.post(url,data,{emulateJSON:true}).then(
         function(success){
             alert(success + 'success')
         },
         function(error){
             alert(error + 'error')
         }
         )
      }
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only.-->
<style scoped>
  /* 背景图 */
  .register-page{
    width: 100%;
    height: 100%;
    background-image: url(../../assets/img/user/bg_register.png);
    background-size: cover;
    color: #ffffff;
    /*opacity: 0.9;*/
  }
  /* 整体样式 */
  .register-form div{
    padding: 0rem 1.5rem;
  }
  /* 页面上部分 */
  .page-top{
    line-height: 8rem;
  }

  /* 注册表单部分 */
  .form-item{
    text-align: left;
    margin: 1.5rem auto;
  }
  .form-item label{
    font-size: 1.2rem;
  }
  .form-item input{
    font-size: 1.2rem;
    color: #ffffff;
    border: none;
    background: none;
    border-bottom: 0.01rem solid #ffffff;
    margin-top: 0.42rem;
    width: 100%;
    padding-bottom: 0.1rem;
    margin-top: 0.6rem ;
  }
  .form-item button{
    width: 6rem;
    height: 2.1rem;
    background-color: #0fa1ff;
    border-radius: 0.9rem;
    color: #ffffff;
    font-size: 0.96rem;
    float: right;
  }
  /* 特殊样式 */
  #checkCode{
    width: 13rem;
  }
  .register-submit{
    width: 6rem;
    height: 2.1rem;
    background-color: #0fa1ff;
    border-radius: 0.9rem;
    color: #ffffff;
    font-size: 0.96rem;
  }

</style>
