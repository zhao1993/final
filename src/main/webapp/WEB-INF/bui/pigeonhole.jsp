<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${basePath}bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${basePath}js/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}bootstrap/js/bootstrap.min.js"></script>
<!-- base -->
<link href="${basePath}css/bui-base.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}js/bui-base.js"></script>
<!-- pigeonhole -->
<link href="css/bui-pigeonhole.css" rel="stylesheet" >
<title>pigeonhole</title>
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
					{"text":"个人归档","url":"#"},	
					]);
				})
				</script>
			</div>
			<p class="htitle"><span>归档</span></p>
		<div class="box">
		<div class="row">
			<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
				<ul class="event_year">
					<c:forEach items="${piges}" var="pige" varStatus="status">
						<li class=${status.index==0?'current':''}><label for="${pige.key}">${pige.key}</label></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
	<ul class="event_list">
			<c:forEach items="${piges}" var="pige" varStatus="status">
			<div><!-- div start -->
				<h3 id="${pige.key}">${pige.key}</h3>
					<c:forEach items="${pige.value}" var="pdto">
						<li> 
						<span><fmt:formatDate value="${pdto.createTime}" pattern="MM-dd"/></span>
						 <p> <a href="#"><span>${pdto.pTitle}</span></a></p>
						 </li>
					</c:forEach>
				</div><!-- /div -->
			</c:forEach>
			</ul><!-- /event_list -->
		</div>
		</div>
	<div class="clearfix"></div>
	</div>
			</div>
		<div class="aside-div col-xs-0 col-sm-0 col-md-0 col-lg-3">
			<jsp:include page="info.jsp"/>
		</div>
		<script type="text/javascript" src="${basePath}js/bui-footer.js"></script>
		<script type="text/javascript">
			$(function(){
				$('label').click(function(){
					$('.event_year>li').removeClass('current');
					$(this).parent('li').addClass('current');
					var year = $(this).attr('for');
 					/* $('#'+year).parent().prevAll('div').slideUp(500);
					$('#'+year).parent().slideDown(500).nextAll('div').slideDown(500); */
					$('html,body').animate({
						scrollTop:$('#'+year).offset().top
					},'fast');
				});
			});
		</script>
	</div>
</div>
<script type="text/javascript">
	$('.event_year').autoPosition("event_year_fixed");
</script>
</body>
</html>