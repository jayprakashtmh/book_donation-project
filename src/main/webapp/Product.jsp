<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="jay.common.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
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
			<div class="container-box">
				<h1>Products</h1>

				<%
				@SuppressWarnings("unchecked")
				ArrayList<Product> alp = (ArrayList<Product>) session.getAttribute("products");
				Iterator<Product> it = alp.iterator();
				while (it.hasNext()) {
					Product p = it.next();
				%>
				<div class="box-img">
					<%
					String path = "img\\" + p.getPic_url();
					%>
					<div class="content-l">
						<p>
							<span>Product Name :</span>
							<%=p.getName()%></p>
						<p>
							<span>Product Description :</span>
							<%=p.getDescr()%></p>
						<p>
							<span>Product Category :</span>
							<%=p.getCategory()%></p>
						<p>
							<span>Product Price :</span>
							<%=p.getPrice()%></p>
						<p>
							<span>Product Quantity :</span>
							<%=p.getQty()%></p>

					</div>
					<div class="content-r">

						<img alt="Yaha Product Photo Hona Chahiye Tha!!!" src="<%=path%>">
					</div>
				</div>

				<div class="btn">
					<a href="editprod?pcode=<%=p.getId()%>">Edit</a>
					<a href="delprod?pcode=<%=p.getId()%>">Delete</a>
				</div>

				<%
				}
				%>

			</div>
		</div>
		<a href="AddProduct.jsp">Add Product</a>
	</section>

</body>
</html>