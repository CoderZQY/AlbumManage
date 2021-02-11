<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Vector" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//日期转换
    String sdate=df.format(new Date());//获取当前时间
%>
<%
    String name=request.getParameter("name");//获取留言人
    String title=request.getParameter("title");//获取留言标题
    String text=request.getParameter("text");//获取留言内容
    String s="第"+i+"楼"+"#"+"留言人："+name+"#"+"留言标题："+title+"#"+"留言内容："+text+"#"+"留言时间："+sdate;//拼接留言信息，用#隔开
    add(s);//调用add()函数
    System.out.print(s);
%>

<%!
    int i=1;
    Vector ve=new Vector();//因为留言信息比较多，选择vector集合存入
    synchronized void add(String str) {
        ServletContext application = getServletConfig().getServletContext();
        i++;
        ve.add(str);
        application.setAttribute("message",ve);
    }
%>
<a href="convert.jsp">查看全部留言</a>

</body>
</html>
