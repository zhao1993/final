<%@page pageEncoding="UTF-8"%>
 <div class="aside fs16 visible-lg">
	 <div class="board">
	 		<span class="board-title">标签标题</span>
			<span class="board-date"></span>
			<p class="board-content">显示一些简短的语句、显示一些简短的语句、显示一些简短的语句</p>
	 </div>
	 	<p class="htitle"><span>关注我</span></p>
		 <div class="person-info">
		 	这里可以展示QQ或者微信二维码等
		 </div>
	 	<p class="htitle"><span>个人信息</span></p>
	 	<div class="person-info">
	 		<p><span>姓名:</span><span>小明</span></p>
	 		<p><span>常用网名:</span><span>小明明</span></p>
	 		<p>籍贯：<span>各种学习课本</span></p>
	 		<p>职业:<span>少先队员</span></p>
	 		<p>QQ:<span>110119112</span></p>
	 		<p>Email:<span>xm@163.com</span></p>
	 		<p>信条:<span>别拿我打比方</span></p>	
	 	</div>
	 	<p class="htitle"><span>友情链接</span><a href="link/bui/toapply">+申请 </a></p>
	 	<div class="links-info">
	 	</div>
	 	<script type="text/javascript">
	 		$(function(){
	 			jQuery.ajax({
	 				url:"link/bui/all",
	 				type:"post",
	 				success:function(links){
	 					$(links).each(function(index,link){
	 						$('.links-info').append( $("<span><a class='link-a-"+index+"'></a></span>") );
	 						$('.link-a-'+index).attr({
	 							"href":link.linkUrl,
	 							"title":link.linkDescript,
	 							"target":"_blank"
	 						}).html(link.linkName);
	 					});
	 				}
	 			});
	 		});
	 	</script>
 </div>