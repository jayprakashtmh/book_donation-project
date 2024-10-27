<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="jay.admin.content.SponsorContent"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Sponsor</title>
</head>
<link rel="stylesheet" href="adminstyle.css">
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
		SponsorContent sc = (SponsorContent) request.getAttribute("sponsor");
		%>
		<form action="updatesponsor" method="post" enctype="multipart/form-data">
			<label>Text 1</label>
			<input type="text" name="text1" value="<%=sc.getText1()%>">
			<label>Text 2</label>
			<input type="text" name="text2" value="<%=sc.getText2()%>">
			<label>Text 3</label>
			<input type="text" name="text3" value="<%=sc.getText3()%>">
			<label>Picture</label>
			<input type="file" name="pic">
			<label>Box Text 1</label>
			<input type="text" name="atext1" value="<%=sc.getaText1()%>">
			<label>Box Text 1 Link</label>
			<input type="text" name="atext1url" value="<%=sc.getaText1Url()%>">
			<label>Box Text 2</label>
			<input type="text" name="atext2" value="<%=sc.getaText2()%>">
			<label>Box Text 2 Link</label>
			<input type="text" name="atext2url" value="<%=sc.getaText2Url()%>">
			<input type="submit" value="Update">
		</form>
	</section>
</body>
</html>