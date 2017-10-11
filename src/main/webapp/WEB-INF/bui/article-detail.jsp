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
<script type="text/javascript" src="${basePath}bootstrap/js/bootstrap.min.js"></script>s
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
					{"text":"文章","url":"${basePath}article/bui/article"},	
					{"text":"文章正文","url":"#"},
					]);
				})
				</script>
			</div>
			<p class="htitle"><span>正文</span></p>
			<div>
				<p class="article-title">${article.articleTitle}</p>
				<div class="article-info">
				<span>编辑:</span>
				<span>${article.blogUser.userName}</span>
				<span>时间:</span>
				<span>${article.articleTime}</span>
				<span>浏览:</span>
				<span>${article.articleClick}</span>
				</div>
				<div class="article-content">
						${article.articleContent}
				</div> <!-- 正文结束 -->
				<!-- 上下文 -->				
				<div class="article-prenext	">
					<c:if test="${!empty apre}">
						<span>上一篇:</span><a class="article-pre" href="javascript:void(0);" 
						onclick="url('article/bui/articleDetail',{'articleId':'${apre.articleId}'})"
						>${apre.articleTitle}</a>
					</c:if>
					<c:if test="${!empty anext}">
						<span>下一篇:</span><a class="article-next" href="javascript:void(0);" 
						onclick="url('article/bui/articleDetail',{'articleId':'${anext.articleId}'})"
						>${anext.articleTitle}</a>
					</c:if>
				</div>
			</div>
			<p class="htitle"><span>最新评论</span></p>
			<!-- 回复框容器 -->
			<div class="reply_container">
			</div>
		</div>		
		<div class="aside-div col-xs-0 col-sm-0 col-md-0 col-lg-3">
			<jsp:include page="aside.jsp"/>
		</div>
	</div>
</div>
<script type="text/javascript" src="${basePath}js/bui-footer.js"></script>
<script type="text/javascript" src="${basePath}js/bui-login.js"></script>
	<script type="text/javascript">
		$(function(){
			reply($(".reply_container"), 0, '${article.articleId}','${loginUser}');
		})
	</script>
</body>
</html>