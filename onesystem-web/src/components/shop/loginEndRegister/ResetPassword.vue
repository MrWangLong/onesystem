<template>
	<div class="login">

		<Nav title="重置密码" :show="show"></Nav>
		<div class="phone">
			<span>手机号码</span><br/>
			<input type="text" name="" placeholder="请输入手机号" v-model="phone">
		</div>
		<div class="checkCode clearfloat">
			<span>验证码</span><br/>
			<input type="text" name="" placeholder="请输入验证码" v-model="checkCode">
			<button @click="getCode">获取验证码</button>
		</div>
		<div class="phone">
			<span>输入密码</span><br/>
			<input type="text" name="" placeholder="请输入密码" v-model="password">
		</div>
		<div class="phone">
			<span>确认密码</span><br/>
			<input type="text" name="" placeholder="请确认密码" v-model="surePassword">
		</div>
		<div class="submit">
			<button @click="submit">确定</button>
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
               password:'',
               surePassword:'',
               checkCode:''
			}
		},
		components:{
			Nav
		},
		methods:{
			getCode:function(){
				if (this.phone.length>10) {
					var obj = {
            handleCode:'getCheckCode',
            phonenumber:this.phone
          }
          var url = '/api/xtgl000Action.do';
          this.$http.post(url,{jsonData:JSON.stringify(obj)},{emulateJSON:true})
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
			submit:function(){
        if (this.password!='' && this.surePassword!='' && this.password==this.surePassword) {
          if (this.phone=='') {
            Toast({
						  message: '手机号不能为空',
						  position: 'center',
						  duration: 1000
						});
          }else if (this.checkCode=='') {
            Toast({
						  message: '验证码不能为空',
						  position: 'center',
						  duration: 1000
						});
          }else {
            this.resetPassword()
          }

        }else if (this.password=='') {
                    Toast({
					  message: '密码不能为空',
					  position: 'center',
					  duration: 1000
					});
        }else if ( this.surePassword=='') {
          Toast({
					  message: '请确认密码',
					  position: 'center',
					  duration: 1000
					});
        }else{
          Toast({
					  message: '两次密码设置不一致',
					  position: 'center',
					  duration: 1000
					});
        }
			},
			resetPassword:function(){
				var data1 = {
		          handleCode:'resetPassword',
		          phonenumber:this.phone,
		          newUserpassword:this.password,
		          checkCode:this.checkCode
        }
        var url = '/api/xtgl000Action.do';
        this.$http.post(url,{jsonData:JSON.stringify(data1)},{emulateJSON:true})
          .then(
		            function(result){
			            if (result.body.msg=='密码重置成功') {
			              	setTimeout(() => {
								this.$router.push('/login')
							},300)
			            }else{
			            	Toast({
							  message: result.body.msg,
							  position: 'center',
							  duration: 1000
							});
			            };
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
