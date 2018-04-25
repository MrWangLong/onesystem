<template>
	<div>
	    <div class="nav clearfloat">
	    	<span class="left" @click="back">{{backName}}</span>
	    	<span class="center">{{title}}</span>
	    	<span class="right" v-if="show">{{}}</span>
	    </div>
	</div>
</template>
<script>
	export default{
		data(){
			return{
               
				
			}
		},
		props:{
			backName:{

			},
			title:{

			},
			show:{
				type:Boolean
			}
		},
		methods:{
            back:function () {
            	this.$router.go(-1)
            }
		}
	
	}
</script>
<style scoped>
    .clearfloat:after{display:block;clear:both;content:"";visibility:hidden;height:0rem} 
	.clearfloat{zoom:1}
	.nav{
		height: 0.96rem;
		line-height: 0.96rem;
		background-color: #0fa1ff;
		padding: 0rem 0.24rem

	}
	.nav .left{
		float: left;
		height: 0.96rem;
		padding-left: 0.3rem;
		background: url(../img/common/back.png) no-repeat left center;
		background-size: 0.22rem 0.4rem
       
	}
	.nav .center{
        color: #ffffff;
        font-size: 0.36rem;
        letter-spacing: 0.02rem;
	}
	.nav .right{
		float: right;
       
	}
</style>