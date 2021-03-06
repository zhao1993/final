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
<!-- alert -->
<link href="${basePath}css/jquery-alert.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}js/jquery-alert.js"></script>
<!-- toast -->
<script type="text/javascript" src="${basePath}js/jquery.miniToast.js"></script>
<!-- reply -->
<link href="${basePath}css/reply-style.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}js/jquery.reply.js"></script>
<style>
.column{
	width:260px;
}
.column img{
	width:100%;
}
</style>
<title>album</title>
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
					{"text":"相册","url":"#"},	
					]);
				})
				</script>
			</div>
			<p class="htitle"><span>相册集</span></p>
			<div class="column-container clearfix"> 
				<c:forEach items="${albums}" var="album">
					
					<div class="column"> 	
						<div class="block block-2x block-raspberry" data-scroll-reveal="enter bottom over 0.5s and move 100px">
							<span>${album.albumTime}</span>
								<span>
									${album.albumId}
									<img src="${album.albumSrc}"/>
								</span>
							</div>
						</div>
				
				
				</c:forEach>	
				</div>
			</div>
		<div class="aside-div col-xs-0 col-sm-0 col-md-0 col-lg-3">
			<jsp:include page="info.jsp"/>
		</div>
	</div>
</div>
<script type="text/javascript" src="${basePath}js/bui-footer.js"></script>
<script type="text/javascript" src="${basePath}js/scrollReveal.js"></script>
<script>
(function(){
	window.scrollReveal = new scrollReveal({ reset: true, move: '50px'});
})();
</script>
</body>
</html>