<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=10">
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- base -->
<link rel="stylesheet" href="${basePath}bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${basePath}js/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}bootstrap/js/bootstrap.min.js"></script>
<!-- article -->
<link href="${basePath}css/bui-article.css" rel="stylesheet" />
<!-- bui-base -->
<link href="${basePath}css/bui-base.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}js/bui-base.js"></script>
<!-- alert -->
<link href="${basePath}css/jquery-alert.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}js/jquery-alert.js"></script>
<!-- toast -->
<script type="text/javascript" src="${basePath}js/jquery.miniToast.js"></script>
<!-- kkpager -->
<link href="${basePath}bootstrap/kkpager/kkpager_blue.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}bootstrap/kkpager/kkpager.min.js"></script>

<title>article</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-0 col-sm-4 col-md-3 col-lg-2">
				<jsp:include page="nav.jsp" />
			</div>
			<div class="col-xs-12 col-sm-8 col-md-9 col-lg-7">
				<div class="top_position">
					<script type="text/javascript">
						$(function() {
							$(".top_position").navigation([
								{
									"text" : "首页",
									"url" : "${basePath}article/bui/index"
								},
								{
									"text" : "文章",
									"url" : "#"
								},
							]);
						})
					</script>
				</div>
				<!-- 最新最热 -->
				<p class="htitle">
					<span>最新文章</span>
				</p>

				<c:forEach items="${articles}" var="article">
					<div class="articlelists row">
						<!-- 配图结构 -->
						<div class="col-xs-5 col-sm-5 col-md-4">
							<img class="article-pic scale"
								src="${basePath}${article.articlePic}" alt="${article.articleTitle}" />
						</div>
						<!-- /配图结构 -->
						<!-- 标题内容摘要与信息 -->
						<div class="col-xs-7 col-sm-7 col-md-8">
							<dl>
								<dt class="article-title">
									<a
										href="javascript:void(0);" 
										onclick="url('article/bui/articleDetail',{'articleId':'${article.articleId}'})"
										>
										${article.articleTitle} </a>
								</dt>
								<dd class="article-tag">
									<span onclick="url('article/bui/article',{'type':'${article.blogSortArticle.sortArticleName}'})" class="label label-default" title="所属分类:&nbsp;${article.blogSortArticle.sortArticleName}">${article.blogSortArticle.sortArticleName}</span>
									<span class="label label-primary" title="原创">原创</span> 
									<c:if test="${article.articleSupport==1}">
										<span class="label label-success" title="强烈推荐文章">强烈推荐</span>
									</c:if>
									<c:forEach items="${hotlists}" var="hot" varStatus="status">
										<c:if test="${hot.articleId eq article.articleId}">
											<span class="label label-warning" title="点击量达:${article.articleClick}">HOT</span>
										</c:if>
									</c:forEach>
								</dd>
								<dd>
									<div class="article-content">${article.articleContent}</div>
								</dd>
								<dd class="article-msg">
									<span class="glyphicon glyphicon-time "></span><span
										class="time" title="发布时间">${article.articleTime}</span> <span
										class="glyphicon glyphicon-eye-open "></span><span
										class="watch" title="浏览量">${article.articleClick}</span> <span
										class="glyphicon glyphicon-pencil "></span><span
										class="author" title="作者">${article.blogUser.userName}</span>
								</dd>
							</dl>
						</div>
						<!-- /标题内容摘要与信息 -->
					</div>
				</c:forEach>
				<!-- /最新最热 -->
				<!-- 分页 -->
					<div id="kkpager" data-page="${nowPage}" data-max="${maxPage}" data-url="${basePath}article/bui/article" data-type="${articleType}" data-search="${search}"></div>
				<!-- /分页 -->
			</div>
			<div class="aside-div col-xs-0 col-sm-0 col-md-0 col-lg-3">
				<jsp:include page="aside.jsp" />
			</div>
		</div>
	</div>
	<!-- <div style="width:100px;height:100px;cursor:text;background: red;" contentEditable="true">
	</div> -->
	<script type="text/javascript" src="${basePath}js/bui-footer.js"></script>
</body>
</html>