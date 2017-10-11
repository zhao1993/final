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
<!-- core -->
<link rel="stylesheet" href="${basePath}bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${basePath}js/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}bootstrap/js/bootstrap.min.js"></script>
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
<title>about</title>
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
					{"text":"关于","url":"#"},	
					]);
				})
				</script>
			</div>
			<p class="htitle"><span>关于博客</span></p>
			<div class="about-blog">
		    	<p>这里是关于博客说明这里是关于博客说明这里是关于博客说明这里是关于博客说明，这里是关于博客说明这里是关于博客说明</p>
        		<p>这里是关于博客说明这里是关于博客说明这里是关于博客说明这里是关于博客说明这里是关于博客说明这里是关于博客说明，这里是关于博客
        		说明这里是关于博客说明这里是关于博客说明这里是关于博客说明这里是关于博客说明</p>
        		<p>这里是关于博客说明这里是关于博客说明这里是关于博客说明</p>
        		<p>这里是关于博客说明这里是关于博客说明这里是关于博客说明，这里是关于博客说明</p>
        		<p>这里是关于博客说明这里是关于博客说明这里是关于博客说明这里，是关于博客说明这里是关于博客说明这里是关，于博
        		客说明这里是关于博客说明这里是关于博客说明这里是关于博客说明</p>
			</div>
			</div>
		<div class="aside-div col-xs-0 col-sm-0 col-md-0 col-lg-3">
			<jsp:include page="info.jsp"/>
		</div>
	</div>
</div>
<script type="text/javascript" src="${basePath}js/bui-footer.js"></script>
</body>
</html>