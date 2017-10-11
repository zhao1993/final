<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${basePath}bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${basePath}js/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}bootstrap/js/bootstrap.min.js"></script>
<!-- bui-base -->
<link href="${basePath}css/bui-base.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}js/bui-base.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.miniToast.js"></script>
<title>forget</title>
<style type="text/css">
.welcomelogin {
	font-family: 'microsoft yahei';
	font-size: 24px;
	height: 60px;
	line-height: 60px;
	text-indent: 10px;
	text-align: left;
	background-color: #87CEEB;
}

.login {
	border-bottom: 1px solid #bacce9;
	background-color: #fff;
}

ul:after, div:after {
	content: ".";
	clear: both;
	display: block;
	height: 0;
	font-size: 0;
	line-height: 0;
	overflow: hidden;
	visibility: hidden;
}

.msgparent {
	background: none repeat scroll 0 0 #fff;
	padding: 20px;
}

.msgcontainer {
	clear: both;
	margin-bottom: 30px;
	overflow: hidden;
}

.tabs {
	height: 30px;
	line-height: 30px;
}

.tabs ul {
	float: left;
	overflow: hidden;
	line-height: 30px;
}

ul, div {
	zoom: 1;
}

ul, ol, li {
	padding: 0;
	margin: 0;
	list-style: none;
}

.tabs .tabc .curr {
	border: solid #cccccc;
	border-top-width: medium;
	border-right-width: medium;
	border-bottom-width: medium;
	border-left-width: medium;
	border-top-color: rgb(204, 204, 204);
	border-width: 2px 1px 0;
	border-top-color: #3e7cd4;
	height: 30px;
	background-color: #fff;
	line-height: 27px;
	color: #000000;
	margin-bottom: -1px;
	position: relative;
}

.tabs .tabc li {
	overflow: hidden;
	float: left;
	width: 120px;
	font: 18px/29px "microsoft yahei";
	border: 1px solid #cccccc;
	color: #000000;
	background-color: #eff5fd;
	cursor: pointer;
	text-align: center;
}

.msgtitle {
	color: #333333;
	font-size: 16px;
	font-weight: normal;
	padding-bottom: 15px;
}

img {
	border: none;
	vertical-align: top;
}

.msgcontainer dd {
	color: #333;
	font-size: 14px;
	line-height: 25px;
	width: 400px;
}

dl, dt, dd {
	padding: 0;
	margin: 0;
}

a {
	color: #3F419E;
}

.inputText1 {
	width: 230px;
	height: 40px;
	padding: 10px;
	*padding: 14px 10px 10px 10px;
	border: solid 1px #e4e4e4;
	background: #fff;
	font-size: 14px;
	color: #999;
}

input, select {
	vertical-align: middle;
}

.msgparent button {
	font-size: 16px;
	height: 40px;
	line-height: 20px;
	min-width: 110px;
	margin: 0 0 60px 292px;
	background-color: #7C99C7;
	border: medium none;
	border-radius: 0;
	color: #fff;
}

button {
	padding: 0;
	margin: 0;
	vertical-align: middle;
	cursor: pointer;
}
</style>
</head>
<body>
<div class="container">
		<div class="row">
		 <div class="col-xs-0 col-sm-4 col-md-3 col-lg-2">
		</div> 
		<div class="col-xs-12 col-sm-8 col-md-9 col-lg-7" >
		 <div class="top_position">
		  <script type="text/javascript">
				$(function(){
					$(".top_position").navigation([
					{"text":"首页","url":"${basePath}article/bui/index"},
					{"text":"密码找回","url":"#"},
					]);
				})
				</script>
		  </div>
		 <div class="welcomelogin">
			    找回密码
		</div>
<div class="login">
    <div class="msgparent">
        <div class="msgcontainer">
            <div class="tabs">
                <ul class="tabc">
                    <li class="curr">邮箱找回</li>
                    <li style="margin-left: 5px;">
                        <a style="text-decoration: none;" href="javascript:void(0);" onclick="$.Toast({showMsg:'暂不支持!',displayTime:1000})">手机找回</a>
                    </li>
                </ul>
            </div>
            <dl style="border-top: 1px solid #cccccc; padding: 20px 0;">
                <dt class="msgtitle">
                    <img src="image/step${step eq '2'?2:step eq '3'?3:step eq '4'?3:1}.jpg">
                </dt>
                <dd style="width:100%;">
                    <div style="margin:0 auto;width:416px;">
                        <form id="appform" action="${step eq '4'?'article/bui/index':'user/bui/forget4step'}" method="post">
                            <c:if test="${step eq '1' || empty step}">
	                            <div style="padding:10px 0">
	                            	 <div>
	                                	<input class="inputText1" id="userEmail" name="userEmail" placeholder="请输入邮箱" value="" type="text">
	                            	</div>
	                            </div>
                            	<div style="padding:10px 0">
	                            <div>
	                                <input class="inputText1" id="validateCode" name="validateCode" placeholder="请输入验证码" value="" type="text">
	                                <img alt="验证码" style="cursor:pointer; margin-top:3px;" id="yzm" onclick="changeImg()" src="validateCode" />
	                            </div>
                            </div>
                            </c:if>
                             <c:if test="${step eq '2'}">
                             	 <div style="padding:10px 0">
	                            	 <div>
	                                	<input class="inputText1" id="yzCode" name="yzCode" placeholder="请输入验证码" value="" type="text">
	                            	</div>
	                            </div>
                             </c:if>
                             <c:if test="${step eq '3'}">
                             	 <div style="padding:10px 0">
	                            	 <div>
	                                	<input class="inputText1"  id="newPwd" name="newPwd" placeholder="请输入新的密码" value="" type="text">
	                            	</div>
	                            </div>
                             </c:if>
                            <c:if test="${step ne '4'}">
                            	<button id="submitbtn" style="margin:30px 0 0;" type="submit">下一步</button>
                            	</c:if>
                            <c:if test="${step eq '4'}">
					                            	<span style="padding: 5px; display: block;">密码修改成功!! </span>
                            	<button id="submitbtn" style="margin:30px 0 0;" type="submit">返回首页</button>
                            </c:if>
                        </form>
                    </div>
                </dd>
		            </dl>
		        </div>
		    </div>
		</div>
		 </div>
		<div class="aside-div col-xs-0 col-sm-0 col-md-0 col-lg-3">
		</div>
	</div>
</div>
<script type="text/javascript" src="${basePath}js/bui-footer.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.custom-validator.js"></script>
<script type="text/javascript">  
	if('${msg}'!=""){
		toast('${msg}');
	}
    function changeImg() {  
        var imgSrc = $("#yzm");  
        var src = imgSrc.attr("src");  
        imgSrc.attr("src", chgUrl(src));  
    }
    function chgUrl(url) {  
        var timestamp = (new Date()).valueOf();  
        url = url.substring(0, 17);  
        if ((url.indexOf("&") >= 0)) {  
            url = url + "×tamp=" + timestamp;  
        } else {
            url = url + "?timestamp=" + timestamp;  
        }  
        return url;  
    }  
</script>  
<script type="text/javascript">
var userYzmReg = /^[A-Za-z0-9]{4}$/;
var yzCodeReg = /^[1-9][0-9]{5}$/;
var userPwdReg = /^[a-zA-Z]\w{5,11}$/; 
var userEmailReg = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
var validate_data = [
	{
		selector : "userEmail",
		regExp : userEmailReg,
		ajax : ["user/bui/yeexist","邮箱没有注册记录!"],
		msg : '错误的邮箱格式',
		nul : false
	},
	{
		selector : "validateCode",
		regExp : userYzmReg,
		ajax : ["yzvalidate","验证码错误",function(flag){
			if(!flag){
				changeImg();
			}
		}],
		msg : "验证码格式有误",
		nul : false
	},
];
var validate_data2 = [
	{
		selector : "yzCode",
		regExp : yzCodeReg,
		msg : '错误的验证码格式',
		nul : false
	}
];
var validate_data3 = [
	{
		selector : "newPwd",
		regExp : userPwdReg,
		msg : '密码只能以字母开头，长度在6~18之间，只能包含字母、数字和下划线',
		nul : false
	},
];
if('${step}'=='1'){
	$('#appform').validator(validate_data,true);
}else if('${step}'=='2'){
	$('#appform').validator(validate_data2,true);
}else if('${step}'=='3'){
	$('#appform').validator(validate_data3,true);
}
 </script>
</body>
</html>