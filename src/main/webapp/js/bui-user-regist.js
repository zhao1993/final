var userNameReg = /^[\u4E00-\u9FA5A-Za-z0-9_]{3,8}$/; //用户名
var userAccReg = /^[A-Za-z0-9]{6,12}$/; //账号
var userYzmReg = /^[A-Za-z0-9]{4}$/; //验证码基本格式
var userPwdReg = /^[a-zA-Z]\w{5,11}$/; //密码
var userEmailReg = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/; //邮箱
var userAddressReg = /^[\u4E00-\u9FA5A-Za-z0-9_]{3,8}$/;//地址
var	userPhoneReg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;//手机
var userQqReg = /^[1-9][0-9]{4,14}$/;//qq
var validate_data = [
	{
		selector : "userName", //选择器
		regExp : userNameReg, //验证规则
		ajax : ["user/bui/nexist","用户名已经存在,想一个独有的吧"],//ajax验证地址,服务器返回结果应该为boolean
		msg : '用户名只能是3-8位的汉字`字母`数字`下划线组合', //不通过提示
		nul : false //为false 不能为空且必须通过验证 为 true 要么为空 要么通过验证
	},
	{
		selector : "userAcc",
		regExp : userAccReg,
		ajax : ["user/bui/aexist","账号名已经存在"],
		msg : '账号只能是6-12位字母或者数字',
		nul : false
	},
	{
		selector : "userPwd",
		regExp : userPwdReg,
		msg : '密码只能以字母开头，长度在6~18之间，只能包含字母、数字和下划线',
		nul : false
	},
	{
		selector : "userEmail",
		regExp : userEmailReg,
		ajax : ["user/bui/eexist","邮箱已经被使用"],
		msg : '错误的邮箱格式',
		nul : false
	},
	{
		selector : "userQq",
		regExp : userQqReg,
		msg : '错误的QQ号格式',
		nul : true
	},
	{
		selector : "userPhone",
		regExp : userPhoneReg,
		msg : '错误的电话号码格式',
		nul : true
	},
	{
		selector : "userAddress",
		regExp : userAddressReg,
		msg : '您是住火星吗?',
		nul : true
	},
	{
		selector : "userBirthday",
		regExp : null,
		msg : "",
		nul : true
	},
	{
		selector : "userDescription",
		regExp : null,
		msg : "",
		nul : true	
	},
	{
		//验证码借用账号的验证规则
		selector : "validateCode",
		regExp : userYzmReg,
		ajax : ["yzvalidate","验证码错误",function(flag){
			if(!flag){
				//在regist.jsp末尾中有定义函数
				changeImg();
			}
		}],
		msg : "验证码格式有误",
		nul : false
	},
];
//选择头像的处理
function changeImage(){
	//头像加载
	var html = $('<div class="headpic-preview"></div>');
	for (var int = 2; int <= 6; int++) {
		html.append($("<span class='critique-head-pic-s'><img class='scale' src='image/p"+int+".jpg'/></span>"));
	}
	//头像框弹出
	jQuery.Alert({
 		customHTML:html,
 		submit:function(alert){
 			var src = alert.find('.headpic-preview img[alt="1"]').attr('src');
 			$("#userImageUrl").val(src);
 			$("#userImageUrlPreview").attr('src',src);
 		},
 		titleMsg:'请选择喜欢的头像',
 		submitMsg:'确认',
 		cancleMsg:'取消'
 	});
	//图片选择效果
	$('.headpic-preview img').on('click',function(){
		$('.headpic-preview img').css('box-shadow','none').attr('alt','');
		$(this).attr('alt','1').css('box-shadow','0 0 1px 1px #5BC0DE');
	});
}

$('#regist-user-form').validator(validate_data,true);
