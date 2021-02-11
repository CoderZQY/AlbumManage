<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--引入标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showAlbum.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style>
  	a{
  		text-decoration: none;
  	}
  	a:HOVER {
		color:green;
		text-decoration: underline;
		background-color: red;
	}
	a:VISITED {
		color: black;
	}
  </style>
  <body bgcolor="#f5f5f5">
    <form>
    	<table border="0">
    		<c:forEach items="${list}" var="photo" varStatus="num">
    			<c:if test="${num.index%4==0}">
    				<tr>
    			</c:if>
	    			<td>
						<table>
							<tr>
								<th>
									<a href="ShowSinglePhotoServlet?pid=${photo.pid}&aid=${photo.aid}"><img src="photos/${photo.pname}" border="0" width="130px" height="130px"/></a>
								</th>
							</tr>
							<tr>
								<td bgcolor="pink" width=80px>${photo.pname}</td>
							</tr>
							<tr><td>上传时间:${photo.puploadTime}</td></tr>
							<tr>
								<td align="right">
									<a href="javascript:del('${photo.pid}','${photo.aid}')">删除</a>
									<a href="">编辑</a>
								</td>
							</tr>
						</table>  			
	    			</td>
    			<c:if test="${num.index%4==3 || num.last}">
    				</tr>
    			</c:if>
    		</c:forEach>
    			<tr>
    				<td colspan="4" align="right">
    					<a href="ShowPhotoByAlbumServlet?aid=${aid}&currentPage=1">首页</a>
    					<a href="ShowPhotoByAlbumServlet?aid=${aid}&currentPage=${currentPage-1}">上一页</a>
    					
    					<a href="ShowPhotoByAlbumServlet?aid=${aid}&currentPage=${currentPage+1}">下一页</a>
    					<a href="ShowPhotoByAlbumServlet?aid=${aid}&currentPage=${totalPage}">尾页</a>
    				</td>
    			</tr>
    	</table>
    </form>
  </body>
  <script>
  	function del(v1,v2){
		if(window.confirm("确认删除")){
			window.location.href="DelPhotoServlet?pid="+v1+"&aid="+v2;	
		}
  	}
  </script>
</html>
