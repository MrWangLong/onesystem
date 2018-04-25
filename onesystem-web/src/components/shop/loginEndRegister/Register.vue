<template>
	<div class="login">

		<Nav title="医生注册" :show="show"></Nav>
		<div class="phone">
			<span>手机号码</span><br/>
			<input type="text" name="" placeholder="请输入手机号" v-model="phone">
		</div>
		<div class="checkCode clearfloat">
			<span>验证码</span><br/>
			<input type="text" name="" placeholder="请输入验证码" v-model="checkCode">
			<button @click="getCheckCode">获取验证码</button>
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
			<button @touchend="submit1">提交</button>
		</div>
		<div class="provision">
			<label for="1" :class="{label:checked}">
				<input id="1" type="checkbox" name="" style="display:none" v-model="checked">
			</label>
			<span>阅读并同意</span><span class="tiaokuan">《天渡健康服务条款》</span>

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
               checked:'',
               a:'ddd',
               activeClass:'label',
               phone:'',
               checkCode:'',
               password:'',
               surePassword:''
			}
		},
		components:{
			Nav
		},
		methods:{
			getCheckCode:function(){
				if (this.phone.length>10) {
					console.log('ffffffffff')
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
			submit1:function(){
				if (this.password!='' && this.surePassword!='' && this.password==this.surePassword) {
           this.submit()
				}else{
           this.active()
				}
			},
			submit:function(){
				var data1 = {
		           handleCode:'registerUser',
		           phonenumber:this.phone,
		           userpassword:this.password,
		           checkCode:this.checkCode
		        }
		        var url = '/api/xtgl000Action.do';
		        this.$http.post(url,{jsonData:JSON.stringify(data1)},{emulateJSON:true})
		        .then(
		            function(result){
		              console.log(result)
		                if (result.body.msg=='注册成功') {
		                	Toast({
                      message: result.body.msg,
                      iconClass: 'icon icon-success',
                      duration: 1000
                    });
                    setTimeout(() => {
                      this.$router.push('/login')
                    }, 1200);
			            }else{
			            	Toast(result.body.msg);
			            };

		            },
		            function(err){
		                console.log(err)
		            }
		        )
			},
			active:function(){
				if (this.password!='' && this.surePassword!='' && this.password!=this.surePassword) {
					Toast({
					  message: '两次密码设置不一致',
					  position: 'center',
					  duration: 1000
					});
				}

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
	.submit button{
		text-align: center;
		width: 6.7rem;
		height: 0.88rem;
		background-color: #0fa1ff;
		border-radius: 0.08rem;
		margin-top: 0.72rem;
		letter-spacing: 0.1rem;
	    color: #ffffff;
	    font-size: 0.36rem;
	}
	.provision{
		margin-top: 0.36rem;
		text-align: center;
		font-size:0.28rem;
		letter-spacing: 0.02rem;
	}
	.provision label{
		margin-right: 0.06rem;
		padding-left: 0.36rem;
		background: url(../img/loginEndRegister/btn_log_disagree.png) no-repeat left center;
		background-size: contain;
	}
	.provision .label{
		background: url(../img/loginEndRegister/btn_log_agree.png) no-repeat left center;
		background-size: contain;
	}
	.provision .tiaokuan{
		color: #0fa1ff;
	}



</style>
