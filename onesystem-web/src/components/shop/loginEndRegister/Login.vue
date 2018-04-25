<template>
	<div class="login">
		<div class="register">
			<router-link style="color:#ffffff" to="/register">用户注册</router-link>
		</div>
		<div class="hello">
			<span>Hello！</span>
		</div>
		<div class="welcome">
			<span>欢迎来到天渡健康</span>
		</div>
		<div class="phone">
			<span>手机号码</span><br/>
			<input type="text" name="" placeholder="请输入手机号码" v-model="phone">
		</div>
		<div class="password">
			<span>密码</span><br/>
			<input type="password" name="" placeholder="请输入密码" v-model="password">
		</div>
		<div class="submit">
			<button @click="submit">登录</button>
		</div>
		<div class="fogetPasswordEndcheckLogin clearfloat">
			<router-link class="fogetPassword" to="/resetPassword">忘记密码？</router-link>
			<router-link class="checkLogin" to="/checkLogin">验证码登录</router-link>
		</div>
	</div>
</template>
<script>
    import md5 from 'js-md5'
    import { Toast } from 'mint-ui';
	export default{
		data(){
			return{
                username:'',
				phone:'',
				password:''

			}
		},
		methods:{
			submit:function(){
        if (this.phone=='') {
          Toast({
					  message: '手机号不能为空',
					  position: 'top',
					  duration: 800
					});
        }else if (this.password=='') {
          Toast({
					  message: '密码不能为空',
					  position: 'top',
					  duration: 800
					});
        }else{
          this.login()
        }
			},
			login:function(){
        var obj = {
			          handleCode:'userPasswodLogin',
			          phonenumber:this.phone,
			          userpassword:md5(this.password),
			          userType:2
        }
        var url = '/api/xtgl000Action.do';
        this.$http.post(url,{jsonData:JSON.stringify(obj)},{emulateJSON:true}).then(
          function(result){
            if (result.body.msg=='登录成功') {

              sessionStorage.setItem("phonenumber",result.data.data.userInfo.phonenumber);
              sessionStorage.setItem("photoaddress",result.data.data.userInfo.photoaddress);
              sessionStorage.setItem("userInfo",JSON.stringify(result.data.data.userInfo))
              sessionStorage.setItem('key','认证成功')
              this.$router.push('/');
            }else{
              Toast({
                message: result.body.msg,
                position: 'top',
                duration: 1000
              });
            }
          },
          function(err){
            console.log(err)
          }
        )
      }
		}
	}
</script>
<style scoped>
    .clearfloat:after{display:block;clear:both;content:"";visibility:hidden;height:0rem}
	.clearfloat{zoom:1}
	.login{
		width: 100%;
		height: 100%;
		background: url(../img/loginEndRegister/bg_login_doctor.png) no-repeat;
		background-size: cover;
		color: #ffffff
	}
	.login div{
		padding: 0rem 0.4rem;
	}
	.login .register{
        padding-top: 1.04rem;
        text-align: right;
       /* background: red*/
	}
	.login .hello{
		text-align: left;
		font-size: 0.5rem;
		letter-spacing: 0.05rem;
	}
	.login .welcome{
		text-align: left;
		font-size: 0.38rem;
		letter-spacing: 0.03rem;
		margin: 0.1rem 0rem 1.04rem 0rem;
	}
	.login .phone{
       text-align: left;

	}
	.login .phone span{
		font-size: 0.3rem;
	}
	.login .phone input{
		font-size: 0.36rem;
		color: #ffffff;
		border: none;
		background: none;
		border-bottom: 0.01rem solid #ffffff;
		margin-top: 0.42rem;
		width: 100%;
		padding-bottom: 0.1rem;
	}
	.login .password{
		text-align: left;
		margin-top: 0.42rem;
	}
	.login .password span{
		font-size: 0.3rem;
	}
	.login .password input{
		font-size: 0.36rem;
		color: #ffffff;
		border: none;
		background: none;
		border-bottom: 0.01rem solid #ffffff;
		margin-top: 0.42rem;
		width: 100%;
		padding-bottom: 0.1rem;
	}
	.login .submit{
		width: 5.9rem;
		height: 0.88rem;
		background-color: #0fa1ff;
		border-radius: 0.08rem;
		text-align: center;
		line-height:  0.88rem;
		margin: 0.6rem auto 0rem;
	}
	.login .submit button{
		font-size: 0.36rem;
		color: #ffffff;
		letter-spacing: 0.1rem;
	}
	.login .fogetPasswordEndcheckLogin{
		margin-top: 0.6rem
	}
	.login .fogetPasswordEndcheckLogin .fogetPassword{
		float: left;
		color: #ffffff
	}
	.login .fogetPasswordEndcheckLogin .checkLogin{
		float: right;
		color: #ffffff
	}

</style>
