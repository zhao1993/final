var urlReg =  /^((https?|ftp|news):\/\/)?([a-z]([a-z0-9\-]*[\.。])+([a-z]{2}|aero|arpa|biz|com|coop|edu|gov|info|int|jobs|mil|museum|name|nato|net|org|pro|travel)|(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]))(\/[a-z0-9_\-\.~]+)*(\/([a-z0-9_\-\.]*)(\?[a-z0-9+_\-\.%=&]*)?)?(#[a-z][a-z0-9_]*)?$/; //网址
var userYzmReg = /^[A-Za-z0-9]{4}$/; //验证码基本格式
var validate_data = [
	{
		selector : "linkDescript", 
		regExp : null,
		msg : '请简要描述您的网站', 
		nul : false 
	},
	{
		selector : "linkUrl", 
		regExp : urlReg,
		ajax : ["link/bui/existurl","网址已经是友链了!!"],
		msg : '网址格式有误',
		nul : false 
	},
	{
		selector : "linkName",
		regExp : null,
		msg : '请输入网站名字',
		nul : false 
	},
	{
		selector : "validateCode",
		regExp : userYzmReg,
		ajax : ["yzvalidate","验证码错误",function(flag){
			if(!flag){
				//在apply-link.jsp末尾中有定义函数
				changeImg();
			}
		}],
		msg : "验证码格式有误",
		nul : false
	},
	{
		selector : "loginUser",
		regExp : null,
		ajax : ["user/bui/hasuser","",function(flag){
			if(!flag){
				loginUI();
				return false;
			}
		}],
		msg :"",
		nul : false
	},
];
$('#apply-link-form').validator(validate_data,true);
