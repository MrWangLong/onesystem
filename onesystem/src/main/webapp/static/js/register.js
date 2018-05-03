new Vue({
  el : '#registerForm',
  data : {
	  telephone : '',
	  checkCode : "123456"
  },
  methods:{
	  submitForm:function(){
		  alert(this.telephone + ":::::"  + this.checkCode);
		  return;
	  }
  }
});