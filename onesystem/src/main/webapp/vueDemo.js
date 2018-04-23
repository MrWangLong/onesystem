var userName = new Vue({
	el   :'#message',
	data : {
		helloWorld : 'Hello Vue!'  
	}
});
var title = new Vue({
	el   : '#now',
	data : {
		title: '页面加载于 ' + new Date().toLocaleString()
	}
});
 new Vue({ 
	el   : '#demo-3',
	data : {
		seen: true
	}
});       
 new Vue({ 
	 el   : '#demo-4',
	 data : {
		// users: ["江可星","王龙","饮酒知冷暖","Max"]
         users: [{text:"江可星"},{text:"王龙"},{text:"饮酒知冷暖"},{text:"Max"}]
	 }
 });
 new Vue({ 
	 el   : '#demo-5',
	 data : {
		message : "Linux is very much!",
		joke    : "上海自来水来自海上"
	 },
     methods:{
    	reverseMessage:function(){
    		this.message = this.message.split('').reverse().join('')
    	} 
     }
 });
 new Vue({ 
	 el   : '#demo-6',
	 data : {
		 message : "Linux is very much!",
	 }
 });
  /*                                                  component                                      */
 Vue.component('todo-item', {
	  props : ['todo'],
	  template: '<li>{{todo.text}}</li>'
	})
	
	/*new Vue({
		el : '#demo-7',
		}	
	});*/
	 new Vue({
		 el : '#demo-8',
		 data :{
			 items :[{
				id : 0,
				text:'德玛西亚皇子'
			 },{
				id : 1,
				text:'诺克萨斯之手' 
			 },{
				id : 2,
				text:'放逐之刃' 
			 }]
		 }
		 
	 });
 
 