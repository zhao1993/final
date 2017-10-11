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
<script type="text/javascript" src="${basePath}bootstrap/js/bootstrap.min.js"></script>p4jsc/web-plugin-head.jsp"/>
<!-- bui-base -->
<link href="${basePath}css/bui-base.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}js/bui-base.js"></script>
<!-- alert -->
<link href="${basePath}css/jquery-alert.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}js/jquery-alert.js"></script>
<!-- toast -->
<script type="text/javascript" src="${basePath}js/jquery.miniToast.js"></script>
<!-- validator -->
<link href="${basePath}bootstrap/validator/css/bootstrapValidator.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}bootstrap/validator/js/bootstrapValidator.js"></script>
<!-- reply -->
<link href="${basePath}css/reply-style.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}js/jquery.reply.js"></script>
<title>regist</title>
</head>
<body>
<div class="container">
		<div class="row">
		 <div class="col-xs-0 col-sm-4 col-md-3 col-lg-2">
			<jsp:include page="nav.jsp"/>
		</div> 
		<div class="col-xs-12 col-sm-8 col-md-9 col-lg-7" >
		<div class="top_position">
				<script type="text/javascript">
				$(function(){
					$(".top_position").navigation([
					{"text":"首页","url":"${basePath}article/bui/index"},
					{"text":"注册","url":"#"},
					]);
				})
				</script>
			</div>
			<p class="htitle"><span>注册声明</span></p>
			<div class="about-blog">
		    	<p>注册说明注说明</p>
		    	<p>注册说明注说明</p>
		    	<p>注册说明注说明</p>
		    	<p>注册说明注说明</p>
		    	<p>注册说明注说明</p>
			</div>
		<p class="htitle"><span>注册</span></p>
		<div class="regist-user-div">
			<p class="ctitle"><span>必填项</span></p>
			<form action="user/bui/register" role="form" id="regist-user-form" class="form-horizontal" method="post">
				<div class="col-xs-10 col-sm-10 col-md-6 col-lg-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3 col-lg-offset-3"><!-- 必填区域 -->
				<div class="form-group">
                     <label for="userName" class="col-sm-4 col-md-4 col-lg-4">用户名:</label>
                      <div class="input-group">
                     	<input type="text" id="userName" class="form-control" name="userName" placeholder="展示给网友的名字">
	                 </div>
                 </div>
                 <div class="form-group">
	                 	<label for="userAcc" class="col-sm-4 col-md-4 col-lg-4">登录账号:</label>
	                 	<div class="input-group">
	                    <input type="text" id="userAcc" class="form-control" name="userAcc" placeholder="账号">
                 </div>
                 </div>
                 <div class="form-group">
	                	 <label for="userPwd" class=" col-sm-4 col-md-4 col-lg-4">登录密码:</label>
	                	 <div class="input-group">
	                     <input type="text" id="userPwd" class="form-control" name="userPwd" placeholder="密码">
                 </div>
                 </div>
                 <div class="form-group">
	                	 <label for="userEmail" class=" col-sm-4 col-md-4 col-lg-4">联系邮箱:</label>	
	                	 <div class="input-group">
	                     <input type="text" id="userEmail" class="form-control" name="userEmail" placeholder="邮箱">
                 </div>
                 </div>
                 </div><!-- /必填区域 -->
                 <p class="ctitle"><span>选填项</span></p>
                 <div class="col-xs-10 col-sm-10 col-md-6 col-lg-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3 col-lg-offset-3">
                 <!-- 选填区域[处理方式] -->
                   <div class="form-group">
	                	 <label for="userBirthday" class=" col-sm-4 col-md-4 col-lg-4">选择头像:</label>	
	                	 <div class="input-group">
	                	 	<input type="hidden" name="userImageUrl" id="userImageUrl" value="${basePath}image/p2.jpg"/>
	                     <span class="critique-head-pic">
	                    	 <img src="${basePath}image/p2.jpg" alt="头像 预览" title="头像" id="userImageUrlPreview" onclick="changeImage()" style="cursor:pointer"/>
	                     </span>
                 	</div>
                 </div>
                  <div class="form-group">
	                	 <label for="userBirthday" class=" col-sm-4 col-md-4 col-lg-4">性别:</label>	
	                	 <div class="input-group form-inline">
	                     <div class="radio">
							<label><input type="radio" name="userSex" id="userSex-man" value="男" checked>娘娘腔</label>
						</div>
						<div class="radio">
							<label> <input type="radio" name="userSex" id="userSex-lady" value="女">女汉子</label>						</div>
                 </div>
                 </div>
                 <div class="form-group">
	                	 <label for="userBirthday" class=" col-sm-4 col-md-4 col-lg-4">生日:</label>	
	                	 <div class="input-group">
	                     <input type="text" id="userBirthday" class="form-control" name="userBirthday" placeholder="生日" >
                 </div>
                 </div>
                 <div class="form-group">
	                	 <label for="userQq" class="col-sm-4 col-md-4 col-lg-4">QQ:</label>	
	                	 <div class="input-group">
	                     <input type="text" id="userQq" class="form-control" name="userQq" placeholder="QQ">
                 </div>
                 </div>
                 <div class="form-group">
	                	 <label for="userPhone" class=" col-sm-4 col-md-4 col-lg-4">联系电话:</label>	
	                	 <div class="input-group">
	                     <input type="text" id="userPhone" class="form-control" name="userPhone" placeholder="电话">
                 </div>
                 </div>
                 <div class="form-group">
	                	 <label for="userAddress" class=" col-sm-4 col-md-4 col-lg-4">地址:</label>	
	                	 <div class="input-group">
	                     <input type="text" id="userAddress" class="form-control" name="userAddress" placeholder="地址">
                 </div>
                 </div>
                 <div class="form-group">
	                	 <label for="userDescription" class=" col-sm-4 col-md-4 col-lg-4">个人简介:</label>	
	                	 <div class="input-group">
           				 <textarea  id="userDescription" class="form-control" name="userDescription" placeholder="个人简介"></textarea>
                 </div>
                 </div>
                 <div class="form-group">
                  <label for="yzm" class="col-sm-4 col-md-4 col-lg-4">验证码:</label>	
               		  <div class="input-group">		
               		  	<img id="yzm" src="validateCode" alt="验证码" onclick="changeImg()"/>
               		  </div>
	               	  <div class="input-group">
	                     <input type="text" id="validateCode" class="form-control" name="validateCode" placeholder="验证码" >
	                 </div>
                 </div>
	                  <div class="form-group">
	                  	<button type="submit" class="btn btn-primary btn-md col-xs-offset-4 col-sm-offset-4 col-md-offset-4 col-lg-offset-4" title="注册">注册</button>
	                 </div>
                 </div><!-- /选填区域 -->
			</form>
		</div>
		</div>
		<div class="aside-div col-xs-0 col-sm-0 col-md-0 col-lg-3">
			<jsp:include page="info.jsp"/>
		</div>
	</div>
</div>
<script type="text/javascript" src="${basePath}js/bui-footer.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.custom-validator.js"></script>
<script type="text/javascript" src="${basePath}js/bui-user-regist.js"></script>
<script type="text/javascript">  
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
</body>
</html>