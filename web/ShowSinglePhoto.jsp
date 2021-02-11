<%@ page language="java" import="java.util.*,com.softeem.pp.dto.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShowSinglePhoto.jsp' starting page</title>

  </head>
  <script>
  	//定义一个XMLHttpRequest对象
  	var xmlReq;
  	//判断浏览器
  	function getBrowse(){
  		if(window.ActiveXObject){
  			//IE内核
  			xmlReq =new ActiveXObject("microsoftEdge.XMLHttp");
  		}else{
  			//其他浏览器
  			xmlReq = new XMLHttpRequest();
  		}
  	}
  	function getAname(){
  		getBrowse();
  		//获取当前相册的id
  		var aid = document.getElementById("aid").value;
  		var url = "FindAlbumServlet?aid="+aid;
  		//一个访问对象
  		xmlReq.open("post", url, true);
  		//当访问状态发生改变,调用回调函数
  		xmlReq.onreadystatechange = goback;
  		//执行
  		xmlReq.send(null);
  	}
  
  	function goback(){
  		//判断请求状态
  		if(xmlReq.readyState === 4){
  			//获取服务器端响应状态
  			if(xmlReq.status === 200){
  				//服务器端响应过来的信息
  				var aname = xmlReq.responseText;
  				//将相册名写入到指定位置
  				document.getElementById("aname").innerHTML=aname;
  			}
  		}
  	}
  </script>
  <body bgcolor="#f5f5f5" onload="getAname()">
  <% 
  	List<Photo> photos = (List<Photo>)request.getAttribute("photos");
  	Photo p = (Photo)request.getAttribute("p");
  	int p_index = 1;
  	for (int i = 0; i < photos.size(); i++) {
  		if(p.getPid() == photos.get(i).getPid()){
  			p_index = i;
  		}
  	}
  %>
  	<center>
   			<input type="hidden" id="aid" value="${p.aid}"/>
   		<table width="500px" height="400px">
   			<tr>
   				<td valign="middle" onmouseover="show('up')" onmouseout="hide('up')" width="50px">
					<%if(p_index>0){%>
						<a href="ShowSinglePhotoServlet?pid=<%=photos.get(p_index-1).getPid() %>&aid=<%=photos.get(p_index-1).getAid()%>">
					<%}%><img id="up" src="img/up.jpg" alt="上一张" border="0" style="display:none"></a></td>

   					<th><img src="photos/${p.pname}"/></th>

   				<td valign="middle" onmouseover="show('down')" onmouseout="hide('down')" width="50px">
					<%if(p_index+1 < photos.size()){%>
						<a href="ShowSinglePhotoServlet?pid=<%=photos.get(p_index+1).getPid() %>&aid=<%=photos.get(p_index+1).getAid()%>">
					<%}%><img id="down" src="img/down.jpg" alt="下一张" border="0" style="display:none"></a></td>
   			</tr>
   			<tr>
   				<td align="right" colspan="3">
   					上传时间:${p.puploadTime}&nbsp;&nbsp;
   					所属相册:<span id="aname"></span>
   				</td>
   			</tr>
   			<tr>
   				<td align="right" colspan="3">
   					名称:${p.pname}&nbsp;&nbsp;
   					<a href="">删除</a>
   					<a href="">编辑</a>
   				</td>
   			</tr>
   			<tr>
   				<td colspan="3">
					<%if(p_index>0){%>
						<a href="ShowSinglePhotoServlet?pid=<%=photos.get(p_index-1).getPid() %>&aid=<%=photos.get(p_index-1).getAid()%>">上一张</a>
					<%}else {%>
						<a>上一张</a>
					<%}%>

   					<%for(int i=1;i<=photos.size();i++){ %>
   						<!-- 判断当前浏览的照片是否和集合中的某一张照片吻合,如果是同一张,则当前照片的序号变为普通文本 -->
						<%if(p.getPid() != photos.get(i-1).getPid()){ %>
   							<a href="ShowSinglePhotoServlet?pid=<%=photos.get(i-1).getPid() %>&aid=<%=photos.get(i-1).getAid()%>">[<%=i%>]</a>
   						<%}else{ %>
   								<%=i%>
   						<%} %>
   					<%} %>

					<%if(p_index+1 < photos.size()){%>
						<a href="ShowSinglePhotoServlet?pid=<%=photos.get(p_index+1).getPid() %>&aid=<%=photos.get(p_index+1).getAid()%>">下一张</a>
					<%}else {%>
						<a>下一张</a>
					<%}%>
   				</td>
   			</tr>
   		</table>
		<form action="show.jsp">
			评论昵称：
			<input type="text" name="name"><br/>
			评论标题：
			<input type="text" name="title"><br/>
			评论内容：<br/>
			<textarea rows="10" cols="30" name="text"></textarea><br/>
			<input type="submit" value="提交">
		</form>
		<br/>
		<form action="convert.jsp">
			<input type="submit" value="查看全部留言">
		</form>
   	</center>
  </body>
  <script>
  	//对图标显示
  	function show(v){
  		if(v === "up"){
  			document.getElementById("up").style.display="block";
  		}else if(v === "down"){
  			document.getElementById("down").style.display="block";
  		}
  	}
  	
  	//对图标隐藏
  	function hide(v){
  		if(v === "up"){
  			document.getElementById("up").style.display="none";
  		}else if(v === "down"){
  			document.getElementById("down").style.display="none";
  		}
  	}
  </script>
</html>
