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
<link href="${basePath}css/bui-article.css" rel="stylesheet"/>
<!-- bui-base -->
<link href="${basePath}css/bui-base.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}js/bui-base.js"></script>
<!-- alert -->
<link href="${basePath}css/jquery-alert.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}js/jquery-alert.js"></script>
<!-- toast -->
<script type="text/javascript" src="${basePath}js/jquery.miniToast.js"></script>
<!-- reply -->
<link href="${basePath}css/reply-style.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}js/jquery.reply.js"></script>
<title>article-detail</title>
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
					{"text":"申请友情链接","url":"#"},
					]);
				})
				</script>
			</div>
			<p class="htitle"><span>友情链接</span></p>
			<div class="links-info">
				<%-- <c:forEach items="${links}" var="link">
					<span><a href="${link.linkUrl}" title="${link.linkDescript}">${link.linkName}</a></span>
				</c:forEach> --%>
	 		</div>
			<p class="htitle"><span>申请说明</span></p>
			<div class="apply-explain" style="margin-left: 30px">
				<ol>
					<li>在您申请本站友情链接之前请先做好本站链接，谢谢！</li>			
					<li>网站内容无意义，百度收录5页都没有的暂不交换！</li>			
					<li>淘宝、色情、反动、病毒、擦边球、纯商业、违法中华人民共和国法律的网站暂不交换！</li>			
					<li>申请成功后请毋随意撤下链接，其他原因撤下请通知我，否则本站也会删除对应链接！</li>			
					<li>我会对成功的链接经常访问，对于被K的站点，暂时会将链接撤回内页，正常后恢复！</li>			
				</ol>
			</div>
			<p class="htitle"><span>申请</span></p>
			<div class="apply-link-div">
			<form action="link/bui/apply" role="form" id="apply-link-form" class="form-horizontal"  method="post">
			     <div class="form-group">
	                	 <label for="userQq" class="col-sm-4 col-md-4 col-lg-4">网站名字:</label>	
	                	 <div class="input-group">
	                     <input type="text" id="linkName" class="form-control" name="linkName" placeholder="网站名字">
                 </div>
                 </div>
                 <div class="form-group">
	                	 <label for="userPhone" class=" col-sm-4 col-md-4 col-lg-4">网站地址:</label>	
	                	 <div class="input-group">
	                     <input type="text" id="linkUrl" class="form-control" name="linkUrl" placeholder="网址">
                 </div>
                 </div>
                 <div class="form-group">
	                	 <label for="userAddress" class=" col-sm-4 col-md-4 col-lg-4">网站描述:</label>	
	                	 <div class="input-group">
	                     <input type="text" id="linkDescript" class="form-control" name="linkDescript" placeholder="描述">
                 </div>
                 </div>
                 <div class="form-group">
	                	 <label for="userDescription" class=" col-sm-4 col-md-4 col-lg-4">备注信息:</label>	
	                	 <div class="input-group">
           				 <textarea  id="userDescription" class="form-control" name="userDescription" placeholder="	"></textarea>
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
                  	<input type="hidden" id="loginUser" value="time"/>
                  	<button type="submit" class="btn btn-primary btn-md col-xs-offset-3 col-sm-offset-3 col-md-offset-3 col-lg-offset-3" title="提交">提交</button>
                 </div>
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
<script type="text/javascript" src="${basePath}js/bui-login.js"></script>
<script type="text/javascript" src="${basePath}js/bui-link-apply.js"></script>
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
</body>
</html>