<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">   <!--清除浏览器中的缓存-->
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	-->

  </head>
  <style>
  	h1{
  		font-size:45px;
  		font-family:华文行楷;
  		color:black
  	}
  	#time{
  		position:absolute;
  		left:75%;
  	}
  </style>
  <body bgcolor="#ffdead" onload="getNowTime()">
    <div style="text-align: center;"><h1>个人电子相册管理系统(PersonalAlbumSystem)</h1></div>
    <span style="text-indent:3cm">欢迎你,${user.uname}</span>
    <span id="time">当前时间: <span id="nowtime"></span>&nbsp;&nbsp;<a href="javascript:window.location.replace('loginAndRegister.jsp')" target="_top">退出系统</a></span>
  </body>
  <script>
		function getNowTime(){
			//获得显示时间的位置
			var showtime = document.getElementById("nowtime");
			//获取当前系统时间
			var date = new Date();
			//获取年月日时分秒
			var year = date.getFullYear();
			var month = date.getMonth()+1;
			if(month.toString().length  < 2){
				month = "0"+month;
			}
			var day = date.getDate();
			if(day.toString().length  < 2){
				day = "0"+day;
			}
			var hour = date.getHours();
			if(hour.toString().length  < 2){
				hour = "0"+hour;
			}
			var minu = date.getMinutes();
			if(minu.toString().length < 2){
				minu = "0"+minu;
			}
			var second = date.getSeconds();
			if(second.toString().length <2){
				second = "0"+second;
			}
			var nowtime = year+"/"+month+"/"+day+" "+hour+":"+minu+":"+second;
			showtime.innerHTML="<font color='black'>"+nowtime+"</font>";
			window.setTimeout("getNowTime()",1000);
		}
  </script>
</html>
