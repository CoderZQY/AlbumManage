<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: 86138
  Date: 2021/1/18
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">照片评论区</h1>
<h3 align="right">请文明发言</h3>
<%
    Vector vr=new Vector();
    vr=(Vector)application.getAttribute("message");//获取application域中的留言信息
    //for(int i=0;i<vr.size();i++){//遍历vector集合
    for(int i=vr.size()-1;i>=0;i--){
        String ss=(String)vr.get(i);
        String st[]=ss.split("#");//截取出来留言信息
        for(int j=0;j<st.length;j++){
            out.print(st[j]+"<br/>");
        }
        out.print("<hr/>");//分割线
    }
%>
<a href="showAlbum.jsp">返回主页</a>

</body>
</html>
