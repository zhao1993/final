<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>1708座位表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  <style>
  	th input,td input{width: 80px;height:30px;}
  	th,td,input{text-align: center;}
  	table,span{ margin:10px; }
  	span{border: 2px solid; padding: 5px 15px;position: relative;}
  	div{width: 400px;position: absolute; left: 30%;}
  	</style>
  </head>
  <body>
  <lis>
  <c:forEach items="${users}" var="user">
  	<i id="${user.userAcc}" value="${user.userPwd}"></i>
  </c:forEach>
  </lis>
  <div>
  <form id="form" action="save1708" method="post"> 
    <table>
    	<c:forEach begin="1" end="11" step="1" varStatus="col">
    		<tr>
    		<c:forEach begin="1" end="6" step="1" varStatus="row">
    		<c:if test="${row.index=='3' || row.index=='5'}">
    			<c:if test="${col.index=='1'}">
    				<td style="width:60px;padding: 0px 30px;border:2px solid;" rowspan="11">
    				</td>
    				</c:if>
    		</c:if>
    			<td>
    				<input class="${col.index}${row.index}" name="userAcc" value="${col.index}${row.index}" type="hidden"/>
    				<input class="${col.index}${row.index}" name="userPwd" type="text" value=""/>
    			</td>
    		  </c:forEach>
    		</tr>
    	</c:forEach>
    			<tr>
    				<td colspan="2" style="border:2px solid">助教</td>
    				<td></td>
    				<td colspan="2" style="border:2px solid">讲师</td>
    				<td></td>
    			</tr>
    </table>
   	 <button style="margin-left:70%" type="submit">保存</button>
    </form>
    </div>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script>
    		$(function(){
    			$("lis i").each(function(index,i){
    				$('.'+$(i).attr("id")).attr("disabled","disabled")
    				$('.'+$(i).attr("id")+"[name='userPwd']").val($(i).attr("value")).attr('title','学员:'+$(i).attr("value")+"-->座位:"+$(i).attr("id")); 
    			});
    			var  index_q = 0;
    			$('#form').submit(function(){
    				$('input[name="userPwd"]').each(function(i,input){
    					if($(input).attr("disabled")!="disabled" && $(input).val()!="" ){
    						var id = $(input).attr("class");
    						$('.'+id+"[name='userAcc']").attr("name","user["+(index_q)+"].userAcc");
    						$('.'+id+"[name='userPwd']").attr("name","user["+(index_q++)+"].userPwd");
    					}else{
    						var id = $(input).attr("class");
    						$('.'+id+"[name='userAcc']").removeAttr("name");
    						$('.'+id+"[name='userPwd']").removeAttr("name");
    					}
    				})
    				return true;
    			});	
    		});
    </script>
  </body>
</html>
