<template>
	<div class="login">

		<Nav title="验证码登录" :show="show"></Nav>
		<div class="phone">
			<span>手机号码</span><br/>
			<input type="text" name="" placeholder="请输入手机号" v-model="phone">
		</div>
		<div class="checkCode clearfloat">
			<span>手机号码</span><br/>
			<input type="text" name="" placeholder="请输入验证码" v-model="checkCode">
			<button @click="getCheckCode">获取验证码</button>
		</div>
		<div class="submit">
			<button @click="submit">登录</button>
		</div>
	</div>
</template>
<script>
    import Nav from '../common/Nav'
    import { MessageBox } from 'mint-ui';
    import { Toast } from 'mint-ui';
	export default{
		data(){
			return{
               show:false,
               phone:'',
               checkCode:''
			}
		},
		components:{
			Nav
		},
		methods:{
			getCheckCode:function(){
				if (this.phone.length>10) {
					var data1 = {
			          handleCode:'getCheckCode',
			          phonenumber:this.phone
			        }
			        var url = '/api/xtgl000Action.do';
			        this.$http.post(url,{jsonData:JSON.stringify(data1)},{emulateJSON:true})
			        .then(
			            function(result){
			            	MessageBox('提示', '验证码'+result.data.data.checkCode);
			            },
			            function(err){
			              console.log(err)
			            }
			        )
				}else{
					Toast({
					  message: '手机号不正确',
					  position: 'center',
					  duration: 1000
					});

				}

			},
			submit(){
				if (this.phone=='') {
          Toast({
					  message: '手机号不能为空',
					  position: 'top',
					  duration: 800
					});
				}else if(this.checkCode==''){
					Toast({
					  message: '验证码不能为空',
					  position: 'top',
					  duration: 800
					});
				}else{
					this.login()
				}

			},
			login:function(){
		    	var obj = {
			          handleCode:'userCheckCodeLogin',
			          phonenumber:this.phone,
			          checkCode:this.checkCode,
			          userType:2
			        }
          var url = '/api/xtgl000Action.do';
          this.$http.post(url,{jsonData:JSON.stringify(obj)},{emulateJSON:true}).then(
		            function(result){
			            if (result.body.msg=='登录成功') {

                    sessionStorage.setItem("phonenumber",result.data.data.userInfo.phonenumber);
                    sessionStorage.setItem("photoaddress",result.data.data.userInfo.photoaddress);
                    sessionStorage.setItem("userInfo",JSON.stringify(result.data.data.userInfo))

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

	}
	.phone,.checkCode,.submit{
		margin: 0rem 0.42rem;
	}
	.phone{
		text-align: left;
		margin-top: 0.62rem;
		border-bottom: 1px solid  #bcbcbc;
		padding-bottom: 0.12rem

	}
	.phone span{
		font-size: 0.3rem;
		color: #333333;
	}
	.phone input{
		font-size: 0.36rem;
		color: #333333;
		width: 100%;
		margin-top: 0.46rem;
		border: none;
		padding: 0rem 0.04rem

	}
	.checkCode{
		text-align: left;
		margin-top: 0.46rem;
		line-height: 0.9rem;

	}
	.checkCode input{
		font-size: 0.36rem;
		width: 3.14rem;
		border: none;
		padding: 0rem 0.04rem;
		border-bottom: 1px solid  #bcbcbc;
		padding-bottom: 0.12rem
	}
	.checkCode button{
		width: 2.3rem;
		height: 0.88rem;
		background-color: #0fa1ff;
		border-radius: 0.1rem;
		color: #ffffff;
		font-size: 0.36rem;
		float: right;


	}
	.submit{
		text-align: center;
		width: 6.7rem;
		line-height: 0.88rem;
		height: 0.88rem;
		background-color: #0fa1ff;
		border-radius: 0.08rem;
		margin-top: 0.72rem


	}
	.submit button{
		letter-spacing: 0.1rem;
	    color: #ffffff;
	    font-size: 0.36rem;
	}



</style>
