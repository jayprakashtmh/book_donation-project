<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
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
		<h2>Enter Product Details</h2>
		<form action="addprod" method="post" enctype="multipart/form-data">
			<input type="text" name="name" placeholder="Product Name">
			<input type="text" name="descr" placeholder="Product Description">
			<input type="text" name="price" placeholder="Product Price">
			<input type="text" name="qty" placeholder="Product Quantity">
			<input type="text" name="category" placeholder="Product Category">
			<input type="file" name="pic" placeholder="Product Picture">
			<input type="submit" value="Add Product">
		</form>
	</section>
</body>
</html>