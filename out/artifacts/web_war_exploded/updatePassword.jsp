<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatePassword.jsp' starting page</title>
    
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
  .input{
  		height:30px;
		width:250px; 
		font-size:20px; 	
  	}
  	table{
  		position:absolute;
  		left:30%;
  		border:2px solid purple;
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
  <body bgcolor="#f5f5f5">
    <form onsubmit="return check()" name="form1">
    	<table>
    		<tr>
    			<th colspan="3" style="font-size:25;font-style: oblique">登陆密码更改</th>
    		</tr>
    		<tr>
    			<th colspan="3" style="color:green">${success}</th>
    		</tr>
    		<tr>
    			<td align="right">原始密码:</td>
    			<td><input type="password" name="oldpass" class="input"></td>
    			<td width="200px" id="e1" style="color:red;font-weight:bold">${error}</td>
    		</tr>
    		<tr>
    			<td align="right">新密码:</td>
    			<td><input type="password" name="newpass" class="input"></td>
    			<td width="200px" id="e2" style="color:red;font-weight:bold"></td>
    		</tr>
    		<tr>
    			<td align="right">重复密码:</td>
    			<td><input type="password" name="repass" class="input" onblur="return reCheck()"></td>
    			<td width="200px" id="e3" style="color:red;font-weight:bold"></td>
    		</tr>
    		<tr>
    			<th colspan="3">
    				<input type="submit" value="提交" class="btn"/>
    				<input type="button" value="取消" class="btn"/>
    			</th>
    		</tr>
    	</table>
    </form>
  </body>
  <script>
  	function reCheck(){
  		//获得当前表单对象
  		var form1 = document.form1;
  		//获得新密码
  		var newpass = form1.newpass.value;
  		//获得重复密码
  		var repass = form1.repass.value;
  		//错误信息提示位置
  		var e3 = document.getElementById("e3");
  		if(repass.length<1){
  			e3.innerText="请输入重复密码";
  			return false;
  		}else{
  			if(repass != newpass){
  				e3.innerText="两次密码不一致";
  				return false;
  			}else{
  				e3.innerText="";
  				return true;
  			}
  		}
  	}
  
  	function check(){
  		//获得当前表单对象
  		var form1 = document.form1;
  		//获得原始密码
  		var oldpass = form1.oldpass.value;
  		//获得新密码
  		var newpass = form1.newpass.value;
  		var e1 = document.getElementById("e1");
  		var e2 = document.getElementById("e2");
  		var e3 = document.getElementById("e3");
  		//判断原始密码是否填写
  		if(oldpass.length<1){
  			e1.innerText="请输入原始密码";
  			return false;
  		}else{
  			e1.innerText="";
  		}
  		//判断新密码是否填写
  		if(newpass.length<1){
  			e2.innerText="请输入新密码";
  			return false;
  		}else{
  			e2.innerText="";
  		}
  		//验证重复密码
  		var v = reCheck();
  		if(v==false){
  			return false;
  		}
  		
  		if(oldpass == newpass){
  			e2.innerText = "密码未被改变"
  			return false;
  		}else{
  			e2.innerText="";
  		}
  		form1.action="UpdatePassWordServlet";
  	}
  </script>
</html>
