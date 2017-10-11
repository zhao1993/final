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
<link href="${basePath}css/aos.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}js/bui-base.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.teff.js"></script>

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
					{"text":"心情日志","url":"#"},	
					]);
				})
				</script>
			</div>
			<!-- <p class="htitle"><span>心情随笔</span></p>
			<span class="sss">这是内容扯犊子这是内容扯犊子这是内容扯犊子这是这是内容扯犊子这是内容扯犊子这是这是内容扯犊子这是内容扯犊子这是这是内容扯犊子这是内容扯犊子这是这是内容扯犊子这是内容扯犊子这是这是内容扯犊子这是内容扯犊子这是这是内容扯犊子这是内容扯犊子这是这是内容扯犊子这是内容扯犊子这是这是内容扯犊子这是内容扯犊子这是这是内容扯犊子这是内容扯犊子这是这是内容扯犊子这是内容扯犊子这是这是内容扯犊子这是内容扯犊子这是这是内容扯犊子这是内容扯犊子这是内容扯犊子这是内容扯犊子这是内</span>
 -->		<section class="section section--code">
				<div class="container">
				</div>
			</section>
			</div>
		<div class="aside-div col-xs-0 col-sm-0 col-md-0 col-lg-3">
			<jsp:include page="info.jsp"/>
		</div>
	</div>
</div>
<script type="text/javascript" src="${basePath}js/bui-footer.js"></script>
<script type="text/javascript" src="${basePath}js/aos.js"></script>
<script>
(function() {
		var pagenum  = 1;
		var pagesize = 10;
		var loadDailys = function(pn,ps){
			jQuery.ajax({
				url:"daily/bui/dailys",
				type:"post",
				data:{pagenum:pagenum++,pagesize:pagesize},
				success:function(dailys){
					$(dailys).each(function(index,daily){
						var html = $("<div class='code code--small code--left' data-aos='flip-down'	>"+
						"<span>"+daily.dailyTime+"</span><span>"+daily.dailyId+"-->"+daily.dailyContent+"</span></div>");
						$(".section > .container").append(html);
						AOS.init({
							easing: 'back-out-ease',
							duration: 500
						});
					});
				}
			});
		}
		loadDailys();
		$(window).on("resize scroll", function() {
			var $currentWindow = $(window);
			var windowHeight = $currentWindow.height();      
			var scrollTop = $currentWindow.scrollTop();       
			var docHeight = $(document).height(); 
			if (scrollTop + windowHeight +140 >= docHeight) {
				loadDailys(pagenum,pagesize);
			}
		});
	})();
		AOS.init({
			easing: 'back-out-ease',
			duration: 500
		});
</script>
</body>
</html>