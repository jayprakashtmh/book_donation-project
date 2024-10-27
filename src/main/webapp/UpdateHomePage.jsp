<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="jay.admin.content.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page Content</title>
<link rel="stylesheet" href="adminstyle.css">
</head>
<body>
	<%
	String name = (String)session.getAttribute("name");
	if(name==null){
		request.getRequestDispatcher("AdminLogin.html").forward(request, response);
	}
	%>
	<div class="nav">
		<p>
			Hello,
			<%=name%></p>
		<a href="logoutadmin">Logout</a>
	</div>

	<section class="container">
		<%
		IndexData id = (IndexData) request.getAttribute("index");
		%>
		<form action="updateindexpage" method="post"
			enctype="multipart/form-data">
			<label>Logo Name</label> <input type="text" name="logo"
				value="<%=id.getLogo()%>"> <label>Header Text</label> <input
				type="text" name="htext" value="<%=id.gethText()%>"> <label>Picture</label>
			<input type="file" name="pic"> <label>Description</label> <input
				type="text" name="descr" value="<%=id.getDescr()%>"> <label>Facebook
				Link</label> <input type="text" name="flink" value="<%=id.getfLink()%>">
			<label>X Link</label> <input type="text" name="xlink"
				value="<%=id.getxLink()%>"> <label>Instagram Link</label> <input
				type="text" name="ilink" value="<%=id.getiLink()%>"> <input
				type="submit" value="Update">

		</form>
	</section>
	>

</body>
</html>