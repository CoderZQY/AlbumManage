<%@ page language="java" import="java.util.*,com.softeem.pp.dto.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'QueryPhoto.jsp' starting page</title>

  </head>
  
  <body bgcolor="#f5f5f5">
  <%
  	List<Album> list = (List<Album>)request.getAttribute("list");
   %>
    <form action="QueryPhotoServlet"> 
    	<input type="hidden" name="currentPage" value="1"/>
    	照片名称:<input type="text" name="pname">
    	相册:<select name="aid">
    			<option value="0">==请选择==</option>
    			<%for(Album a:list){ %>
    				<option value="<%=a.getAid() %>"><%=a.getAname()%></option>
    			<%} %>
    		</select>
    		<input type="submit" value="查询">
    </form>	
  </body>
</html>
