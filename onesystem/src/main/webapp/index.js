var JsonReqData = {
	blhName : "Sqhd005BLH",
	passWord : "1",
	sjHm : "13770324906",
	xm : "杨希",
	platform:"android",
	md5:"d6542207945784d6b461773e363ef380",
	cert:"1848625308",
	handleCode : "queryData",
	data : {
//		zjHm:"320124197210203211",
		zjhm:"32010519811205183X",
		lsh:"0D909FCC54943DF40154943DF4580000",
		sfzhm:"32010519811205183X",
		zjlxdm:"06",
		sfzlxdm:"06",
		uuid:"0D90B369534EBF4601534EBF464F0000",
		nf:"2014",
		mx_xh:"1",
		ssqq:"2016-03-01",
		ssqz:"2016-03-31",
//		swglm:"320500610000629",
		swglm:"320100620230674",
//		swglm:"320100000208362",
//			swglm:"321200000100482",//未申报
//			swglm:"320100004071969",//已申报
//			gljgdm:"23212501500"//未申报
				gljgdm:"23201381200"//已申报
	}
};


$(document).ready(function() {
	alert(1);
	// 示例一，简写模式JSON
	//
	/*
	 * $.post("http://localhost:7001/ZBAction.do", { jsonData :
	 * $.toJSON(JsonReqData) }, function(data, status) {
	 * alert($.evalJSON(data).msg); });
	 */

	// 示例二，详细模式JSON
	$.ajax({
		url : "http://localhost:7003/ZBAction.do",
		// 默认采用异步模式访问,async=false时timeout参数将无效
		async : true,
		dataType : "json",
		data : {
			jsonData : $.toJSON(JsonReqData)
		},
		// 查询类用get，提交类用post
		type : 'get',
		timeout : 500000,
		error : function(jqXHR, textStatus, errorThrown) {
			alert(1111);
		},
		success : function(responseText, textStatus, XMLHttpRequest) {
			alert(JSON.stringify(responseText));
			console.log(JSON.stringify(responseText));
		}
	});
	// 示例三，详细模式JSONP
	// $.ajax({
	// url : "http://localhost:7001/ZBAction.do",
	// // 默认采用异步模式访问,async=false时timeout参数将无效
	// async : true,
	// dataType : "jsonp",
	// data : {
	// jsonData : $.toJSON(JsonReqData)
	// },
	// // 查询类用get，提交类用post
	// type : 'get',
	// timeout : 5000000,
	// // 此参数相当于xx.do?callback=
	// jsonp : "callback",
	// // 如无此参数,JQUERY会自动生成一个函数名
	// // 即使定义此参数，也不一定需要定义此函数(JQUery会自动生成)，除非有特别处理过程
	// // 此参数推荐不配置
	// jsonpCallback : "test",
	// // textStatus 可能的返回值
	// // " timeout", "error", "abort", "parsererror"
	// // 如textStatus=="timeout" 可明确提示用户“此操作超时”
	// // errorThrown 错误描述
	// error : function(XMLHttpRequest, textStatus,
	// errorThrown) {
	// alert(errorThrown);
	// alert(textStatus);
	// alert(jqXHR);
	// },
	// success : function(responseText, textStatus,
	// XMLHttpRequest) {
	// alert(responseText);
	// alert(responseText.code);
	// }
	// });

});
