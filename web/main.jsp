<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'main.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	-->
  </head>
  <frameset rows="20%,*" border="5px" bordercolor="black" frameborder="yes">
  	<frame src="top.jsp" name="top" noresize scrolling="no"/>
  	<frameset cols="15%,*">
  		<frame src="left.jsp" name="left" noresize/>
  		<frame src="FindAlbumByUserServlet?op=showAlbum&currentPage=1" name="right"/>
  	</frameset>
  </frameset>
</html>
