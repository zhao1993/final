<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <div class="aside fs16 visible-lg">
	 <div class="board">
	 		<span class="board-title">每日一语</span>
			<span class="board-date"></span>
			<p class="board-content">显示一些简短的语句、显示一些简短的语句、显示一些简短的语句</p>
	 </div>
		<div id="search">
		 <p class="htitle"><span>站内搜索</span></p>
			<form action="article/bui/search" method="post">
				<div class="input-group">
					<input type="text" class="form-control" name="search" placeholder="翻页太麻烦,试试搜索?"/>
					<span class="input-group-addon">
						<input class="btn btn-info btn-search" value="搜索" type="submit"/>
					</span>
					<!-- 这里可以表单提交也可以超链接提交 -->
				</div>
			</form>
	 	</div>
	 	<p class="htitle"><span>热门排行</span></p>
		<ul class="hot">
		<c:forEach items="${hotlists}" var="article" varStatus="status">
	        <li><a href="javascript:void(0);" onclick="url('article/bui/articleDetail',{'articleId':'${article.articleId}'})" class="effect">
	        		<span class="index index_${status.index+1}" title="阅读量:${article.articleClick}">${status.index+1}</span> 
	        		<span class="text article-content" title="${article.articleTitle}">${article.articleTitle}</span>
	        	</a>
	        </li>
		</c:forEach>
	  </ul>
	<p class="htitle"><span>精彩推荐</span></p>
	<ul class="hot">
			<c:forEach items="${supportlists}" var="article" varStatus="status">
	        <li><a href="javascript:void(0);" onclick="url('article/bui/articleDetail',{'articleId':'${article.articleId}'})">
	        		<span class="index" title="${status.index+1}">${status.index+1}</span> 
	        		<span class="text article-content">${article.articleTitle}</span>
	        	</a>
	        </li>
		</c:forEach>
	  </ul>
<%-- 	  <p class="htitle"><span>其他</span></p>
	<ul class="hot">
		<c:forEach begin="1" step="1" end="4" var="i">
	        <li><a href="index.html">
	        		<span class="pic"><img src="${basePath}image/p1.jpg"/></span>
	        		<span class="text">这里是文章标题、这里是文章标题</span>
	        		<span class="eyes">阅读量(999)</span>
	        	</a>
	        </li>
		</c:forEach>
	  </ul> --%>
 </div>