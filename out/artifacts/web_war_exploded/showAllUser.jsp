<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showAllUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#f5f5f5">
    <form>
    	<table border="1" cellpadding="0" cellspacing="0" bordercolor="black" width="800px">
    		<tr>
    			<th colspan="5">用户信息</th>
    		</tr>
    		<tr>
    			<th><input type="checkbox" id="ck" onclick="selectAll()"></th>
    			<th>用户名</th>
    			<th>密码</th>
    			<th>等级</th>
    			<th>操作</th>
    		</tr>
    		<c:forEach items="${list}" var="user">
    			<tr onmouseover="this.bgColor='lightblue'" onmouseout="this.bgColor=''" style="cursor:pointer">
    				<td><input type="checkbox" name="userNo"></td>
    				<td>${user.uname }</td>
    				<td>*******</td>
    				<td>
    					<c:if test="${user.uflag == 1}">
    						管理员
    					</c:if>
    					<c:if test="${user.uflag == 0}">
    						普通用户
    					</c:if>
    				</td>
    				<td>
    					<a href=""><img src="img/show.png" alt="查看" border="0"></a>
    					<a href=""><img src="img/remove.png" alt="删除" border="0"></a>
    					<a href=""><img src="img/admin.png" alt="设为管理员" border="0"></a>
    				</td>
    			</tr>
    		</c:forEach>
    		<tr>
    			<td align="right" colspan="5">
    				<a href="ShowUserServlet?currentPage=1">首页</a>
    				<a href="ShowUserServlet?currentPage=${currentPage-1}">上一页</a>
    				<a href="ShowUserServlet?currentPage=${currentPage+1}">下一页</a>
    				<a href="ShowUserServlet?currentPage=${totalPage}">尾页</a>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
  <script>
  	function selectAll(v){
  		//获取所有指定名称的复选框对象
  		var allUser = document.getElementsByName("userNo");
  		//获得全选框对象
  		var ck = document.getElementById("ck");
  		for(var i=0;i<allUser.length;i++){
  			if(allUser[i].type=="checkbox" && ck.checked==true){
  				allUser[i].checked=true;	
  			}else if(ck.checked==false){
  				allUser[i].checked=false;
  			}
  		}
  	}
  </script>
</html>
