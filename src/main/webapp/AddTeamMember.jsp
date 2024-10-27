<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Team Member</title>
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
		<h2>Enter Team Member Details</h2>
		<form action="addteam" method="post" enctype="multipart/form-data">
			<input type="text" name="name" placeholder="Enter Name Team Member">
			<input type="text" name="about" placeholder="Enter About Team Member">
			<input type="file" name="pic" placeholder="Enter Team Member Pic">
			<input type="text" name="flink" placeholder="Enter Facebook Link">
			<input type="text" name="xlink" placeholder="Enter X Link"> <input
				type="text" name="ilink" placeholder="Enter Instagram Link">
			<input type="submit" value="Add Team Member">
		</form>
	</section>
</body>
</html>