var go_top;
function toast(msg){
	$.Toast({
	 showMsg:msg,
	 displayTime:1500,
	 fontSize:'16px',
	 bgColor:'#87CEEB'
	});
}

$(function(){
	//搜索框的浮动定位效果[base-js中定义的函数]
	$('#search').autoPosition("search_fixed");
	/*回顶部按钮效果开始*/
	//<div id="topbar" onclick="go_top()">至顶</div>
	var topbar = document.createElement("div");
	topbar.setAttribute("id", "topbar");
	topbar.innerHTML = "至顶";
	document.getElementsByTagName("body")[0].appendChild(topbar);
	topbar.onclick = function(){
		var start = window.setInterval(function() {
			window.scrollBy(0, -106);
			if(window.scrollY<=0){
				window.clearInterval(start);
			}
		}, 6);
	}
	//
	window.onscroll = function(){
		/*回顶部监听*/
		if(window.scrollY>=100){
			topbar.style.display = "block";
		}else{
			topbar.style.display = "none";
		}
	}
	//分页插件(当在文档 中发现kkpager标签时插入分页按钮分页按钮)
		if($('#kkpager').length==1){
			kkpager.generPageHtml({
				pno : $('#kkpager').attr('data-page'),
				total : $('#kkpager').attr('data-max'),
				hrefFormer : $('#kkpager').attr('data-url'),
				getLink : function(n){
					var data = {'pagenum':n};
					if($('#kkpager').attr('data-type')!=""){
						data['type'] = $('#kkpager').attr('data-type');
					}
					if($('#kkpager').attr('data-search')!=""){
						this.hrefFormer = "article/bui/search";
						data['search'] = $('#kkpager').attr('data-search');
					}
				return "url('"+this.hrefFormer+"',"+JSON.stringify(data)+")";
			} 
		});
	}
		//时间
		$.ajax({
			complete:function(x){
				var date = new Date(x.getResponseHeader("Date"));
				var xq = ["","一","二","三","四","五","六","七"];
				var datestr = (date.getYear()+1900)+"年"+(1+date.getMonth())+"月"+date.getDate()+"日  星期"+xq[date.getDay()];
				$(".board-date").html(datestr);
			}
		});
})

