/**
 * Created by Administrator on 9/27/2017.
 */
$(function(){
    var setCookie = function(name,val){
        document.cookie = name+'='+val;
    }
    var getCookie = function(name){
        for(var i=0;i<document.cookie.split(';').length;i+=1){
            if (arr[i].split('=')[0] == name) {
                return arr[i].split('=')[1];
            }
        }
        return null
    }
    $("a[target]").each(function(index,tagA){
        var _this = $(tagA);
        var _container = _this.attr('target');
        var _url = _this.attr('href');
        _this.attr('href','javascript:;')
             .click(function(){
                $("#"+_container).load(_url);
        });
    });
})