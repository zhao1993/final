/**
 * alert();
 * customHTML type:html  自定义的html内容
 * submit type:function  点击确定按钮执行的事件alert为弹出框对象
 * cancle type:function  点击取消按钮执行的事件alert为弹出框对象
 * close 同上
 * 	titleMsg:'自定义弹框',
	submitMsg:'确定按钮信息',
	cancleMsg:'取消按钮信息',
 */
(function($){
	$.extend({
	Alert:function(options){
		var defaults = {
			customHTML:'',
			submit:function(alert){
				return true;
			},
			cancle:function(alert){
				return true;
			},
			close:function(alert){
				return true;
			},
			titleMsg:'自定义弹框',
			submitMsg:'confirm',
			cancleMsg:'cancle',
		}
		var option = $.extend(defaults,options);
		//-----节点控件
		var alert_shadow = $('<div></div>').attr({id:'id_alert_shadow'});
		var alert_bg = $('<div></div>').attr({id:'id_alert_bg'}).addClass('class_alert_bg');
		var alert_title = $('<p></p>').attr({id:'id_alert_title'}).addClass('class_alert_title').html(option.titleMsg);
		var alert_close = $('<span><span>').attr({id:'id_alert_close'}).addClass('class_alert_close').html('&times;');
		var alert_body = $('<div></div>').attr({id:'id_alert_body'}).addClass('class_alert_body').html(option.customHTML);
		var alert_footer =$('<div></div>').attr({id:'id_alert_submit'}).addClass('class_alert_footer');
		var alert_submit = $('<div></div>').attr({id:'id_alert_submit'}).addClass('class_alert_submit').html(option.submitMsg);
		var alert_cancle = $('<div></div>').attr({id:'id_alert_cancle'}).addClass('class_alert_cancle').html(option.cancleMsg);
		alert_bg.append(alert_title.append(alert_close))
				.append(alert_body)
				.append(alert_footer.append(alert_cancle));
		alert_cancle.before(alert_submit);
		//------追加
		var show = function(){
			$('html').mouseenter(function(){
				$(this).mouseout();
			});
			$('html').append(alert_shadow).append(alert_bg);
			center();
		}
		//-----定位样式
		alert_shadow.css({
			margin:'0px',
			position: 'fixed',
			width:$(window).width()+'px',
			height:$(window).height()+'px',
			left: '0px',
			top: '0px',
			filter:'alpha(opacity:10)',
			opacity:0.1,
			background: '#AAAAAA',
			'z-index': 999998,
		});
		var center  = function(){
			alert_shadow.css({
				width:$(window).width()+'px',
				height:$(window).height()+'px'
			});
			alert_bg.css({
				position:'fixed',
				'z-index':999999,
				left:($(window).width()-alert_bg.width())/2,
				top:($(window).height()-alert_bg.height())/2
			});
		}
		
		//-----事件监听
		alert_close.click(function(){
			option.close(alert_bg)
				destroy();
		})
		alert_submit.click(function(){
			option.submit(alert_bg)
				destroy();
		})
		alert_cancle.click(function(){
			option.cancle(alert_bg)
				destroy();
		})
		//-----事件
		$(window).on('scroll resize',function(){
			center();
		});
		var destroy = function(){
			alert_bg.fadeOut('fast',function(){
				alert_shadow.remove();
				$(this).remove();
			});
		}
		show();
	}
	})
})(jQuery)