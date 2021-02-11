<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addAlbum.jsp' starting page</title>

  </head>
  <style>
  	table{
  		position:absolute;
  		top:20%;
  		left:30%;
  		heigth:380px;
  		width:450px;
  	}
  	.input{
  		width:260px;
  		height:30px;
  		font-size:20px;
  	}
  	.btn{
  		cursor:pointer;
  		height:40px;
  		width:70px;
  		font-size:20px;
  		font-weight: bold;
  		border:0;
  		background-color: green;
  		color:white;
  	}
  </style>
  <script>
	function checkName(){
		//获取输入的相册名
		var aname = document.form1.aname.value;
		//获取显示错误提示信息的位置
		var error = document.getElementById("error");
		if(aname.length<1){
			error.innerText="请输入相册名";
			return false;
		}else{
			error.innerText="";
		}
		//验证通过,提交到后台
		document.form1.action="AddAlbumServlet";
	}  
  </script>
  <body bgcolor="#f5f5f5">
    <form onsubmit="return checkName()" name="form1">
    	<table border="1">
    		<tr bgcolor="#1E90FF">
    			<th colspan="2" style="font-size:25;font-style: oblique">新建相册</th>
    		</tr>
    		<tr>
    			<th id="error" colspan="2" style="color:red">${msg}</th>
    		</tr>
    		<tr>
    			<td align="right">相册名:</td>
    			<td>
    				<input type="text" name="aname" class="input"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right" valign="top">相册描述:</td>
    			<td>
    				<textarea rows="5" cols="30" name="adiscription"></textarea>
    			</td>
    		</tr>
    		<tr>
    			<th colspan="2">
    				<input type="submit" value="新建" class="btn"/>
    				<input type="button" value="返回" class="btn" onclick="history.back()"/>
    			</th>
    		</tr>
    	</table>
    </form>
  </body>
</html>
