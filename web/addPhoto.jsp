<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addPhoto.jsp' starting page</title>

  </head>
  <style>
	table{
		position:absolute;
		top:5%;
		left:30%;
		width:500px;
		height:400px;
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
  <script>
  	function checkFile(){
  		//获取表单对象
  		var form1 = document.form1;
  		//获得文件控件中的信息(路径)
  		var path = form1.file.value;
  		//获得错误信息显示的位置
  		var e = document.getElementById("error");
  		if(path.length<1){
  			e.innerText="请选择图片路径";
  			return false;
  		}else{
  			e.innerText="";
  		}
  		form1.action="PhotoUploadServlet";
  	}
  </script>
  <body bgcolor="#f5f5f5">
  <%
  	String id = request.getParameter("aid");
   	int aid = Integer.parseInt(id);
   %>
    <form name="form1" onsubmit="return checkFile()" method="post" enctype="multipart/form-data">
    	<input type="hidden" value="<%=aid%>" name="aid"/>
    	<table border="1">
    		<tr bgcolor="#1E90FF">
    			<th colspan="2" style="font-size:25;font-style: oblique">上传照片</th>
    		</tr>
    		<tr>
    			<th colspan="2">
    				<img id="p" width="150" height="150" />
    			</th>
    		</tr>
    		<tr>
    			<th colspan="2" id="error" style="color:red"></th>
    		</tr>
    		<tr>
    			<th colspan="2">
    				<input type="file" name="file" id="s" style="width:300px" onchange="showImg()"/>
    			</th>
    		</tr>
    		<tr>
    			<td>照片描述</td>
    			<td>
    				<textarea rows="5" name="pdiscription" cols="30"></textarea>
    			</td>
    		</tr>
    		<tr>
    			<th colspan="2">
    				<input type="submit" value="上传" class="btn"/>
    				<input type="button" value="取消" class="btn"/>
    			</th>
    		</tr>
    	</table>
    </form>
  </body>
  <script>
  	function showImg(){
		//图片预览
		var files=document.getElementById("s");
		var picture=document.getElementById("p");
		//定义图片加载对象
		var reader=new FileReader();
		//读取图片
		reader.readAsDataURL(files.files[0]);
		//当图片加载完毕之后，自动触发
		reader.onload=function(e){
			//得到图片的路径 result
			var result=this.result;
			console.log(result);
			//将结果放到img标签上
			picture.src=result;
		}
	}
  </script>
</html>
