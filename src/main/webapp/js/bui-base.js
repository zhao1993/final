//a 标签参数隐藏[原理点击a标签生成表单通过表单提交]
/**
 * funciton goto(url,data)
 * url 跳转的地址
 * data 携带参数{'key':'value'}
 * */
function url(url,data){
/*	var form = document.createElement("form");
	for(var key in data){
		var input = document.createElement("input");
		input.setAttribute("name",key);
		input.setAttribute("value", data[key]);
		form.appendChild(input);
	}
	document.body.appendChild(form);
	form.setAttribute("method","post");
	form.setAttribute("action",url);
	form.submit();
	document.body.removeChild(form);*/
	jsstr = "";
	for(var key in data){
		jsstr = jsstr + key +"="+data[key]+"&";
	}
	window.location.href = url+"?"+jsstr;
}

(function($){
	/*元素浮动功能
	 * $('#search').autoPosition("search_fixed");
	 * search_fixed:浮动后的class
	 * */
		//params[clas]浮动后的类选择器
		$.fn.autoPosition = function(clas){
			var auto = function(elem){
				//记录元素到顶部的距离
				var top = elem.position().top;
				/*console.info(top);*/
				//记录元素的初始定位方式
				var ptn = elem.css('position');
				/*console.info(ptn);*/
				//绑定滚动监听事件
				$(window).scroll(function(){
					//滚动距离
					var distance = $(this).scrollTop();
					//当页面顶部触碰到元素的顶部时开始重新定位
					if(distance > top){
						elem.addClass(clas);
					}else{
						elem.removeClass(clas);
					}
				});
			}
			//针对多元素绑定
			$(this).each(function(){
				auto($(this));	
			})
		}
		
		/*
		 * 生成导航功能
		 * <div class="top_position">
		<script type="text/javascript">
			$(function() {
				$(".top_position").navigation([
					{"text" : "首页",
						"url" : "${basePath}blog/bui/index"
					},
					{"text" : "文章",
						"url" : "#"
					},
				]);
			})
		</script>
	</div>*/
	$.fn.navigation = function(prms){
		var container = $(this);
		var params = $.extend(prms,[]);
		if(params.length==0){ return ; }
		container.empty();
		container.append('<span class="glyphicon glyphicon-map-marker"></span>');
		var html = '当前位置:';
		$.each(params,function(i,obj){
			if(i<params.length-1){
				html += '<a href='+obj.url+' title='+obj.text+'>'+obj.text+'</a>';
				html += '&gt;';
			}else{
				html += '<span title='+obj.text+'>'+obj.text+'</span>';
			}
		});
		container.append(html);
		container.css({
			'letter-spacing':'.2em',
			'font-size':'18px'})
			.find('a').css({
				'display':'inline-block',
				'text-decoration':'underline',
				'color':'blue'});
	}
})(jQuery)