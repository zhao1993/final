
var lgnxzq = "alert-login-form";
var accxzq = "alert-input-account";
var pwdxzq = "alert-input-password";
var forgetPwd = "user/bui/forget";
var regist = "user/bui/toregist";
jsstr = "<div id=%lgnxzq class=%lgnxzq ><form><div><label for=%accxzq>账号</label><input id=%accxzq class=%accxzq type='text' /></div>" +
		"<div><label for=%pwdxzq>密码</label><input id=%pwdxzq class=%pwdxzq type='text'/></div></form>" +
		"<div><a href='%forgetPwd' >忘记密码?</a></div>" +
		"<div><a href='%regist' >快速注册</a></div>" +
		"</div>";
jsstr = jsstr
.replace(/%forgetPwd/g, forgetPwd)
.replace(/%regist/g, regist)
.replace(/%lgnxzq/g, lgnxzq)
.replace(/%accxzq/g, accxzq)
.replace(/%pwdxzq/g, pwdxzq);

function loginUI(){
	jQuery.Alert({
		customHTML:jsstr,
		submit:function(alert){
 			$.ajax({
 				url:"user/bui/login",
 				type:'post',
 				data:{'userAcc':alert.find('#'+accxzq).val(),'userPwd':alert.find('#'+pwdxzq).val()},
 				success:function(flag){
 					if(flag==true){
 						jQuery.Toast({
 							 displayTime:1500,
			 				 fontSize:'16px',
			 				 bgColor:'#87CEEB',
 					         showMsg:'登录成功',
 					         displayTime:800,
 					         success:function(){
 					        	 window.location.reload();
 					         }
 					      });
 					}else{
 						toast("登录失败!账号或密码错误")
 					}
 				},
 			})
 		},
 		titleMsg:'请先登录',
 		submitMsg:'登录',
 		cancleMsg:'取消',
	});
}
/**
 * 回复函数抽取
 * @method reply
 * @param {Element} [container] 容器选择器
 * @param {Number} [type] 回复类型 0,1,2
 * @param {Number} [typeid] 当前类型的id  
 * @param {Object} [user] 当前登录的用户;
 * */
function reply(container,type,typeid,user){
	$(container).reply({
		 url_init:'critique/bui/initreply',
		 url_deck:'critique/bui/deckreply',
		 data:{'replyType':type,'replyTypeId':typeid},
		 eventCustom:{reply:function(text,cid){
		 if(user==''){
		 	loginUI();
		 	return false;
		 }
		 if(text!="" && !/^\s+$/.test(text) ){
		 	$.ajax({
		 		url:'critique/bui/addreply',
		 		type:'post',
		 		data:{'blogCritique.replyId':cid,replyTypeId:typeid,replyContent:text},
		 		async:false,
		 		success:function(flag){
			 		 if(flag==true){
			 			jQuery.Toast({
			 				 displayTime:1500,
			 				 fontSize:'16px',
			 				 bgColor:'#87CEEB',
					         showMsg:'添加评论成功',
					         displayTime:500,
					         success:function(){
					        	 window.location.reload();
					         }
					      });
			 		}  
		 		}
		 	});
		 }else{
		 		  toast('不能回复空内容');
		 	}
		 }
		},
	});
}
