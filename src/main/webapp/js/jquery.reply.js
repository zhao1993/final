
/*   int replyId;
	 int userId;
	 String userName;
	 String replyContent;
	 String userImg;
	 int replyTypeId;
	 byte replyType;
	 int replyTime;*/
(function($){
	$.fn.reply = function(option){
		var $this =  $(this);
		var pagenum = 1;
		/*|||||||||||||参数定义||||||||||||*/
		var defaults = {
				url_init:'critique/bui/initreply',//初始化地址
				url_add:'add_reply',//添加评论的访问地址
				url_deck:'critique/bui/deckreply',//楼中楼加载地址
				data:{pagenum:pagenum,pagesize:2},//请求时的携带数据
				showPraise:false,//显示点赞按钮
				showComplain:true,//显示投诉按钮
				showDrop:false,//显示删除按钮
				morePageNum:6,//加载更多每次加载数据
				infoa:{
					//info bar 的四个链接按钮  [回复,删除,赞,投诉]
					reply:'javascript:void(0);',
					drop:'javascript:void(0);',
					praise:'javascript:void(0);',
					complain:'javascript:void(0);',
				},
				face:{//子插件表情参数
					path:'image/face/',//表情存放路径
					parse:'critique-content',//需要进行解析的容器选择器建议是类选择器
				},
				text:{
					empty:'说点什么吧...',
					reply:'回复',
					cancelReply:'取消回复',
					drop:'删除',
					praise:'点赞',
					complain:'投诉',
					more:'加载更多评论>>'
				},
				text_title:{
					reply:'告诉他你的看法',
					cancelReply:'我在想想..',
					drop:'删除评论',
					praise:'为他点赞',
					complain:'投诉这条评论',
					more:'查看更多评论'
				},
				eventCustom:{
					//自定义事件[一般会被覆盖默认 没有执行任何操作]
					reply:function(text,cid){
						//自定义提交方法text指当前输入框里面的值
						//deck至当前楼层【层】
					},
					//当插件在运行[回复等]还没有结果时这个区间将执行这个函数包装ajaxstart-ajaxstop期间
					load:function(){
						//暂未实现
					}
				},
				event:{
					//插件内部事件 [不推荐覆盖！]
					reply: function(n){
						//n指代控件所在的楼层[info]
						if(n.attr('reply-panel-toggle')=="true"){
							n.attr('reply-panel-toggle',false);
							n.find('.info-reply').attr('title',options.text_title.reply).text(options.text.reply);
							n.next().animate({height:'0px'},50,function(){
								this.remove();
							});
						}else{
							n.attr('reply-panel-toggle',true);
							n.find('.info-reply').attr('title',options.text_title.cancelReply).text(options.text.cancelReply);
							n.after(inputbox());
							n.next().animate({height:'150px'},50);
						}
						return false;
					},
					drop:function(n){
						alert('正在施工...');
						return false;
					},
					praise:function(n){
						alert('正在施工...');
						return false;
					},
					complain:function(n){
						alert('正在施工...');
						return false;
					}
				},
		}
		var options = $.extend(defaults,option);
		/*|||||||||||||参数定义结束||||||||||||*/
		/*|||||||||||||时间格式化||||||||||||*/
		var fd = function(time){
			var date = new Date(time);
			return date.getYear()>1900?date.getYear():(date.getYear()+1900)
			+'-'+date.getMonth()
			+'-'+date.getDate()
			+' '
			+date.getHours()
			+':'+date.getMinutes()
			+':'+date.getSeconds();
		}
		/*|||||||||||||时间格式化||||||||||||*/
		var fd2 = function(date){
			return date.getYear()>1900?date.getYear():(date.getYear()+1900)
					+'-'+date.getMonth()
					+'-'+date.getDate()
					+' '
					+date.getHours()
					+':'+date.getMinutes()
					+':'+date.getSeconds();
		}
		/*||||||||||||||||||||||||||||||||表情子插件开始||||||||||||||||||||||||||||||*/
		$.fn.face = function(option){
			var face = $(this);
			var defaults = {
					container:'critique-plugin-content',//编辑器的id[这里使用textarea]
			}
			var optionf = $.extend(defaults,option);
			face.click(function(){
				var faceBasePanel = $("<div></div>");
				faceBasePanel.attr({'class':'face-panel'}).css({position:'absolute',top:face.offset().top+'px',left:face.offset().left+'px'});
				var faceList = $("<table></table>");
				faceList.attr({'class':'face-list'});
				var tdlist = "<tr>";
				for (var i = 1; i < 73; i++) {
					tdlist += "<td><img data-index='face_"+i+"'  class='face-img' src='"+options.face.path+i+".gif'/><td>";
					if(i%12==0){ tdlist += "</tr><tr>"; }
				}
				tdlist+="</tr>"
				faceList.append(tdlist);
				faceBasePanel.append(faceList);
				$('body').append(faceBasePanel);
				//写入
				$('.face-img').click(function(){
					$('#'+optionf.container).val($('#'+optionf.container).val()+"["+$(this).attr('data-index')+"]");
				})
				//关闭
				faceBasePanel.mouseleave(function(){
					if(faceBasePanel.is(':visible')){
						faceBasePanel.animate({width:0,height:0},200,function(){
							faceBasePanel.remove();
						});
					}
				});
			});
		}
		/*||||||||||||||||||||||||||||||||表情解析代码开始[需要将异步加载功能关闭使用同步加载(否则楼中楼表请无法被解析到)]||||||||||||||*/
		var parseFace = function(){
			$("."+options.face.parse+",#"+options.face.parse+","+options.face.parse).each(function(i,dom){
				$(dom).html($(dom).html().replace(new RegExp(/\[face_(\d*)\]/g), "<img src='"+options.face.path+"$1.gif'/>"));
			});
		}
		/*||||||||||||||||||||||||||||||||表情解析代码结束||||||||||||||||||||||||||||||*/

		/*||||||||||||||||||||||||||||||||表情子插件结束||||||||||||||||||||||||||||||*/
		/*||||||||||||||||||| 仿唯一随机选择器 |||||||||||||||||||*/
		var ramSelector = function(fix){
			return fix+"-"+Math.floor(Math.random()*68686868);
		}
		/* |||||||||||||||||||输入框生成|||||||||||||||||||*/
		var inputbox = function(){
			var baseBox = $("<div></div>");
			var inputBox = $("<div></div>");
			var funBar = $("<div></div>");
			baseBox.attr({'class':'base-box',});
			inputBox.attr({'class':'input-box',});
			funBar.attr({'class':'fun-bar',});
			baseBox.append(inputBox).append(funBar);
			inputBox.html("<textarea id='"+ramSelector('critique-plugin-content')+"' placeholder='"+options.text.empty	+"'></textarea>");
			funBar.html("<a></a><a></a>")
			funBar.find('a:first-child').attr({title:'表情',href:'javascript:void(0)','class':'fun-bar-face',}).text('表情')
			.face({container:inputBox.find('textarea').attr('id')});
			funBar.find('a:last-child').attr({title:'回复',href:'javascript:void(0)','class':'fun-bar-reply',}).text('回复');
			return baseBox;
		}
		
		/*|------输入框的回复按钮功能开始------|*/
		//为 未来元素绑定事件[取值->提交->响应—>关闭输入框->刷新]因为参数携带无法
		$("body").delegate("a.fun-bar-reply","click",function(){
			options.eventCustom.reply(
					$(this).parent().prev().find('textarea').val(),
					$(this).parentsUntil("div[class^='critique-lists']").parent().attr('data-critique-id')
			);
			if($(this).parentsUntil('.base-box').parent().parent().attr('class')!=$this.attr('class')){
				options.event.reply($(this).parent().parent().prev());
			}
			//执行关闭窗口功能
		});
		/*|------回复按钮功能结束------|*/
		/*|||||||||||||||||||为每个楼层取别名|||||||||||||||||||*/
		var deckno = function(index){
			return index==0?'沙发'
					:index==1?'板凳'
					:index>=2?'地板':'未知';
		}
		/*||||||||||||||||||| * 楼中楼加载 ajax地址 层主 容器* |||||||||||||||||||*/
		var loadDeck = function(deck_url,parnet,container){
			$.ajax({
				type:'post',
				url:deck_url,
				data:{replyId:parnet.replyId},
				dataType:'json',
				async:false,//配合表情解析插件的使用，将异步加载功能关闭！
				success:function(data){
					$.each(data,function(i,critique){
						panel(critique,false,container,parnet);
					});
				}
			});
		}
		/*--------------创建查看更多按钮------------- */
		var morebtn = function(more){
			$('#critique-more').remove();
			if(!more){
				return ;
			}
			$("<a></a>")
			.text(options.text.more)
			.attr({'id':'critique-more','href':'javascript:void(0)',title:options.text_title.more})
			.click(function(){
				options.data['pagenum'] = ++pagenum;
				options.data['pagesize'] = options.morePageNum;
				load(options);
			}).appendTo($this);
		}
		/*--------------创建查看更多按钮的事件------------- */
		
		
		/*||||||||||||||||||| 创建一个回复面板 回复对象 是否是层主 容器  层主 *||||||||||||||||||| */
		var panel = function(critique,isFirst,container,parent){
			/** * 基本节点 * */
			var basePanel = $("<div class='critique-lists"+(!isFirst?'-d':'')+"'><div>");
			var headPic = $("<span class='critique-head-pic"+(!isFirst?'-d':'')+"'></span>");
			var user = $("<div class='critique-user"+(!isFirst?'-d':'')+"'></div>");
			var right = $("<div class='critique-right"+(!isFirst?'-d':'')+"'></div>");
			var info = $("<div class='critique-info'></div>");
			var content = $("<div class='critique-content'></div>");
			/* |||||||||||||||||||基础面板属性  |||||||||||||||||||*/
			basePanel.attr({
				'data-critique-id':critique.replyId,
				'data-user-id':critique.userId
			})
			/* |||||||||||||||||||文档操作  |||||||||||||||||||*/
			basePanel.append(headPic).append(right);
			right .append(user) .append(content) .append(info);
			/* |||||||||||||||||||info 控件|||||||||||||||||||*/
			info.html("<a></a><a></a><a></a><a></a>");
			/*|||||||||||||||||||回复面板是否展开|||||||||||||||||||*/
			info.attr('reply-panel-toggle',false);
			
			info.find("a:nth-child(4)").attr({
				href:options.infoa.reply,
				title:options.text_title.reply,
				'class':'info-reply'
			}).click(function(){
						return options.event.reply(info);})
			.text(options.text.reply);
			info.find("a:nth-child(3)").attr({
				href:options.infoa.praise,
				title:options.text_title.praise,
				'class':'info-praise'
			}).click(function(){
						return options.event.praise(info);})
			.text(options.text.praise) .css('display',(!options.showPraise?'none':''));
			info.find("a:nth-child(2)").attr({
				href:options.infoa.drop,
				title:options.text_title.drop,
				'class':'info-drop'
			}).click(function(){
						return options.event.drop(info);})
			.text(options.text.drop).css('display',(!options.showDrop?'none':''));
			info.find("a:nth-child(1)").attr({
				href:options.infoa.complain,
				title:options.text_title.complain,
				'class':'info-complain'
			}).click(function(){
						return options.event.complain(info);})
			.text(options.text.complain).css('display',(!options.showComplain?'none':''));
			/* |||||||||||||||||||头部面板 |||||||||||||||||||*/
			user.html("<span></span><span></span><span></span><span><span/>");
			user.find("span:nth-child(1)").attr({
				title:'#'+(critique.index+1)+'楼',
				'class':'user-deck',
			}).text(deckno(critique.index));
			user.find("span:nth-child(2)").attr({
				title:critique.userName,
				'class':'user-name',
			}).text(critique.userName);
			user.find("span:nth-child(3)").attr({
				title:!isFirst&&parent!=null?parent.userName:'',
				'class':'user-name',
			}).text(!isFirst&&parent!=null?parent.userName:'')
			.before('回复')
			.after('说:');
			user.find("span:nth-child(4)").attr({
				title:'回复时间',
				'class':'user-time',
			}).text(fd(new Date(parseInt(critique.replyTime))));
			/*|||||||||||||||||||文档追加方式|||||||||||||||||||*/
			content.html("<span>"+critique.replyContent+"</span>");
			if(isFirst){
				headPic.append("<img src='"+critique.userImg+"'/>");
			}else{
				user.find('span:first-child').remove();
			}
			if(!isFirst){
				container.after(basePanel);
			}else{
				container.append(basePanel);
			}
			/** * 楼中楼加载 * */
			loadDeck(options.url_deck,critique,info);
			return basePanel;
		}
		//初始化
		var load = function(options){
			options.data['pagenum'] = pagenum;
			options.data['pagesize'] = options.morePageNum;
			$.ajax({
				type:'post',
				url:options.url_init,
				data:options.data,
				async:false,
				dataType:'json',
				success:function(data){
					$.each(data,function(i,critique){
						critique.index = i;
						panel(critique,true,$this,null);
					});
					parseFace();
					//默认会一直显示????
					morebtn(true);
				}
			});
		}
		/*自动运行代码区 */
		$this.append(inputbox());
		load(options);
		parseFace();
	};
})(jQuery)
