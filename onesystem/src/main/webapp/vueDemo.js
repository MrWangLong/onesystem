var userName = new Vue({
	el   :'#message',
	data : {
		helloWorld : 'Hello World!'
	}
});
var title = new Vue({
	el   : '#now',
	data : {
		title: '页面加载于 ' + new Date().toLocaleString()
	}
});