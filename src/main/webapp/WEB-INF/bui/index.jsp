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
<!--pgwslider  -->
<link href="${basePath}css/pgwslider.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}js/pgwslider.js"></script>
<!-- kkpager -->
<link href="${basePath}bootstrap/kkpager/kkpager_blue.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}bootstrap/kkpager/kkpager.min.js"></script>
<!-- breakingNews -->
<link href="${basePath}css/BreakingNews.css" rel="stylesheet" />
<script type="text/javascript" src="${basePath}js/BreakingNews.js"></script>
<title>index</title>
</head>
<body>
<div class="container">
		<div class="row">
		 <div class="col-xs-0 col-sm-4 col-md-3 col-lg-2">
			<jsp:include page="nav.jsp"/>
		</div> 
		<div class="col-xs-12 col-sm-8 col-md-9 col-lg-7" >
		<!-- 图片展示 -->
		<div>
			<ul class="pgwSlider">
			    <li><img src="${basePath}image/q1.jpg" alt="图片展示一" data-description="图片展示一des"></li>
			    <li><img src="${basePath}image/q2.jpg" alt="图片展示二" data-large-src="${basePath}image/q2.jpg"></li>
			    <li> <img src="${basePath}image/q3.jpg"> <span>图片展示三</span> </li>
			    <li> <a href="http://www.jq22.com" target="_blank"> <img src="${basePath}image/q4.jpg"> <span>spanspan</span> </a> </li>
			</ul>
			<script type="text/javascript">
				$(function(){
					$('.pgwSlider').pgwSlider();
				})
			</script>
		</div>
<!-- /图片展示 -->
<div  id="blog-notice">
		<div id="bn-title">公告:</div>
		<ul id="notice-lists">
			<li><a href="http://www.dowebok.com/42.html">1. jQuery时间轴/时光轴插件jqtimeline</a></li>
			<li><a href="http://www.dowebok.com/118.html">2. onepage-scroll – jQuery单页/全屏滚动插件</a></li>
			<li><a href="http://www.dowebok.com/48.html">3. jQuery响应式图片画廊插件S Gallery</a></li>
			<li><a href="http://www.dowebok.com/92.html">4. iOS 7标签栏图标Tab Bar Icons iOS 7</a></li>
			<li><a href="http://www.dowebok.com/82.html">5. jQuery Lightbox效果插件Boxer</a></li>
			<li><a href="http://www.dowebok.com/106.html">6. Select-or-Die – jQuery下拉框美化插件</a></li>
			<li><a href="http://www.dowebok.com/103.html">7. 制作网易2014世界杯史话/世界杯时间轴效果</a></li>
		</ul>
	</div>
	<script type="text/javascript">
		function AutoScroll(obj) {
            $(obj).animate({
                marginTop: "-24px"
            }, 1000, function () {
                $(this).css({ marginTop: "0px" }).find("li:first").appendTo($(this));
            });
        }
	        $(document).ready(function () {
	            var myar = setInterval('AutoScroll("#notice-lists")', 3500);
	            //当鼠标放上去的时候，滚动停止，鼠标离开的时候滚动开始
	            $("#notice-lists").hover(function () { 
	            		clearInterval(myar); 
	            	}, 
	            function () { 
	            	myar = setInterval('AutoScroll("#notice-lists")', 3500);
	             }
	          );
        })
	</script>
	            <div class="row">
	            	<div class="col-md-6">
	                    <div class="tab" role="tabpanel">
	                        <!-- Nav tabs -->
	                        <ul class="nav nav-tabs" role="tablist">
	                            <li role="presentation" class="active"><a href="#Section1" aria-controls="home" role="tab" data-toggle="tab"><i class="fa fa-user"></i>Section 1</a></li>
	                            <li role="presentation"><a href="#Section2" aria-controls="profile" role="tab" data-toggle="tab"><i class="fa fa-envelope"></i>Section 2</a></li>
	                    		<li role="presentation"><a href="#Section4" aria-controls="messages" role="tab" data-toggle="tab"><i class="fa fa-comment"></i>Section 4</a></li>
	                        </ul>
	                        <!-- Tab panes -->
	                        <div class="tab-content tabs">
	                            <div role="tabpanel" class="tab-pane fade in active" id="Section1">
	                                <ul style="list-style:disc;">
	                                	<li><a href="#">显示信息0000000044400000000111111</a></li>
	                                	<li><a href="#">显示信息44444444444444444444444</a></li>
	                                	<li><a href="#">显示信息44444444444444444444444444</a></li>
	                                	<li><a href="#">显示信息000004444400000000000111111</a></li>
	                                	<li><a href="#">显示信息000004444400000000000111111</a></li>
	                                	<li><a href="#">显示信息00000444400000000000111111</a></li>
	                                	<li><a href="#">显示信息0000044444400000000000111111</a></li>
	                                </ul>	                            
	                             </div>
	                            <div role="tabpanel" class="tab-pane fade" id="Section2">
	                                 <ul style="list-style: disc;">
	                                	<li><a href="#">显示信息0000000000000004440111111</a></li>
	                                	<li><a href="#">显示信息0000000000000004440111111</a></li>
	                                	<li><a href="#">显示信息00000000000000044440111111</a></li>
	                                	<li><a href="#">显示信息00000000000000044440111111</a></li>
	                                	<li><a href="#">显示信息00000000000000444400111111</a></li>
	                                	<li><a href="#">显示信息00000000000000444400111111</a></li>
	                                	<li><a href="#">显示信息00000000000000444400111111</a></li>
	                                </ul>		                            
	                               </div>
	                             <div role="tabpanel" class="tab-pane fade" id="Section4">
	                                 <ul style="list-style: disc;">
	                                	<li><a href="#">显示信息0000000000044044440000111111</a></li>
	                                	<li><a href="#">显示信息0000000000040440000111111</a></li>
	                                	<li><a href="#">显示信息000000000004404440000111111</a></li>
	                                	<li><a href="#">显示信息000000000004444400000111111</a></li>
	                                	<li><a href="#">显示信息0000000000044440400000111111</a></li>
	                                	<li><a href="#">显示信息0000000000444000000111111</a></li>
	                                	</ul>		                           
	                                 </div>
	                      	  	</div>
	                   		 </div>
	                    </div>
	                    <div class="col-md-5">
	                    	<div class="indexPng">
	                         <img src="image/index.png">
	                        </div>
	                   </div><!-- col -->
	                </div><!-- //row -->
			<!-- </div> -->
			<!-- /其他展示 -->
			<!-- 最新最热 -->
			<p class="htitle"><span>最新文章</span></p>
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
									<span class="label label-default" title="所属分类:&nbsp;${article.blogSortArticle.sortArticleName}">${article.blogSortArticle.sortArticleName}</span>
									<span class="label label-primary" title="原创">原创</span> 
									<c:if test="${article.articleSupport==1}"> <span class="label label-success" title="强烈推荐文章">强烈推荐</span> </c:if>
									<c:forEach items="${hotlists}" var="hot" varStatus="status"> <c:if test="${hot.articleId eq article.articleId}"> <span class="label label-warning" title="点击量达:${article.articleClick}">HOT</span></c:if></c:forEach>
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
				<kkpager data-page="2" data-max="10">
					<div id="kkpager"></div>  
			<!-- /分页 -->
		</div>
		<div class="aside-div col-xs-0 col-sm-0 col-md-0 col-lg-3">
			<jsp:include page="aside.jsp"/>
		</div>
	</div>
</div>
	<script type="text/javascript" src="${basePath}js/bui-footer.js"></script>
</body>
</html>