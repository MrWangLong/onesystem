<template>
  <div class="login-page">
    <div class="page-container">
      To be number one.
    </div>
   <form class="login-form">
    <div class="form-item">
      <span>手机号码</span><br/>
      <input type="text" name="" placeholder="请输入手机号码" v-model="phone">
    </div>
   </form>
  </div>
</template>

<style>
  .login-page{
    width: 100%;
    height: 100%;
    background: url(../../assets/img/user/bg_login_user.png) no-repeat;
    background-size: cover;
    color: #ffffff
  }
  .login-form div{
    padding: 0rem 1.5rem;
  }
  .page-container{
   height: 15rem;
  }
  .form-item{
    text-align: left;
  }
  .form-item span{
    font-size: 1.7rem;
  }
  .form-item input{
    font-size: 1.7rem;
    color: #ffffff;
    border: none;
    background: none;
    border-bottom: 0.01rem solid #ffffff;
    margin-top: 0.42rem;
    width: 100%;
    padding-bottom: 0.1rem;
  }
</style>

<script>
  export default {
    name: 'login',
    data() {
      return {
        phone : ""
      };
    },
    methods:{

    }
  };
</script>
