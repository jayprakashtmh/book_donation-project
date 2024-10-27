<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Choose Option</title>
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
		<div class="box">
			<a href="showprod">Product</a> <a href="homepage">Home Page
				Content</a> <a href="sponsorcontent">Sponsor Content</a> <a
				href="showteam">Our Team</a>
		</div>
	</section>
</body>
</html>