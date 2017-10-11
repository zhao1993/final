/**
var userYzmReg = /^[A-Za-z0-9]{4}$/; //验证码基本格式
var userEmailReg = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/; //邮箱
var validate_data = [
	{
		selector : "validate-emmail",
		regExp : userEmailReg,
		ajax : ["user/bui/eexist","邮箱已经被使用"],
		msg : '错误的邮箱格式',
		nul : false
	},
	{
		selector : "userName", //选择器
		regExp : userNameReg, //验证规则
		ajax : ["user/bui/nexist","用户名已经存在,想一个独有的吧"],//ajax验证地址,服务器返回结果应该为boolean
		msg : '用户名只能是3-8位的汉字`字母`数字`下划线组合', //不通过提示
		nul : false //为false 不能为空且必须通过验证 为 true 要么为空 要么通过验证
	},
	{
		//验证码借用账号的验证规则
		selector : "validateCode",
		regExp : userYzmReg,
		ajax : ["yzvalidateCode","验证码错误",function(flag){//加入函数之后除了提示验证不通过还会执行这个自定义函数里面的内容
			if(!flag){
				changeImg();
			}
		}],
		msg : "验证码格式有误",
		nul : false
	},
];
选中表单
$('#appform').validator(validate_data,true);
 */
//本地验证处理
(function($){
	/**
	 * form 表单控件
	 * vdarr 验证数据
	 * snv 是否阻止提交空属性
	 * */
	$.fn.validator = function(vdarr,snv){
	var form = $(this);
	var findInput = function(selector) {
		return $("#" + selector);
	}
	var eeffect = function(doc) {
		var count = 0;
		var eff = setInterval(function() {
			if (count % 2 == 0) {
				doc.css('outline', '1px solid yellow');
			} else {
				doc.css('outline', '1px solid blue');
			}
			if (count++ > 5) {
				doc.css('outline', 'none');
				clearInterval(eff);
			}
		}, 200);
	}
	var hint = function(input, msg) {
		input.parent().after($("<span>" + msg + "</span>"));
		eeffect(input);
	}
	var restore = function(input) {
		input.parent().nextAll().remove();
	}
	var validate_reg = function(doc) {
		var input = findInput(doc.selector);
		var reg = doc.regExp;
		var msg = doc.msg;
		var nul = doc.nul;
		var ajax = doc.ajax;
		restore(input);
		if(nul && (input.val()==null || input.val()=="")){
			return true;
		}
		if(!nul && (input.val()==null || input.val()=="")){
			hint(input, "不能为空项");
			return false;
		}
		if (null!=reg && !reg.test(input.val())) {
			hint(input, msg);
			return false;
		}
		//ajax 
		var bl = true;
		if(ajax!=null){
			var data = {}
			data[input.attr('name')] = input.val();
			$.ajax({
				url:ajax[0],
				type:'post',
				dataType:'json',
				data:data,
				async:false,
				success:function(flag){
					if(!flag){
						hint(input,ajax[1]);
						if(ajax[2]!=null && typeof(ajax[2])=="function"){
							ajax[2]();
						}
						bl =  false;
					}
				}
			})
		}
		return bl;
	}
		$(vdarr).each(function(index, data) {
			findInput(data.selector).blur(function() {
				validate_reg(data);
			});
			findInput(data.selector).focus(function() {
				restore($(this));
			});
		});
		form.submit(function() {
			var result = true;
			$(vdarr).each(function(index, data) {
				//单&  在[所有条件为true]的情况下返回1 其他情况均返回 0
				result = (result & validate_reg(data))==1;
			});
			//指针对设置过的表单数据进行空值屏蔽
			//如果提交表单 且 不提交空数据则进行处理
			if(result && snv){
				$(vdarr).each(function(index, data) {
					var input = findInput(data.selector);
					if(data.nul && input.val()==null || input.val()==""){
						input.attr('disabled',true);
					}
				});
			}
			return result;
		});
	}
})(jQuery)