$(function(){
	//<a href="#" onClick="getCheckCode();">获取验证码</a>
});
function getCheckCode(){
	$.ajax({
		url:'user/getCheckCode.do',
		data:{'phoneNumber':'15324490545'},
		type:'post',
		success:function(data){
			alert('success->'+ data);
		},
		error:function(){
			console.log('ajax调用失败');
		}
	});
}