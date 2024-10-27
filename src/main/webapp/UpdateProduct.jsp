<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="jay.common.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>
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
		<h2>Update Product</h2>
		<%
		@SuppressWarnings("unchecked")
		ArrayList<Product> prod = (ArrayList<Product>) session.getAttribute("products");
		int code = Integer.parseInt(request.getParameter("pcode"));
		Iterator<Product> it = prod.iterator();
		while (it.hasNext()) {
			Product p = it.next();
			if (p.getId() == code) {
		%>
		<div>
			<form action="updateprod" method="post">
				<input type="hidden" name="id" value="<%=p.getId()%>">
				<label>Update Description</label>
				<input type="text" name="descr" value="<%=p.getDescr()%>">
				<label>Update Price</label>
				<input type="text" name="price" value="<%=p.getPrice()%>">
				<label>Update Quantity</label>
				<input type="text" name="qty" value="<%=p.getQty()%>">
				<input type="submit" value="Update">
			</form>
		</div>

		<%
		break;
		}
		}
		%>
	</section>
</body>
</html>