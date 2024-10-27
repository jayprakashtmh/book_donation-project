<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="jay.common.Product, java.util.*,jay.user.User"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Books</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="drop-style.css">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">
</head>
<body>


	<header>
		<a href="#" class="logo"><span>Dil Tak</span><b>|</b>Foundation</a>
		<div class="fa-solid fa-bars" id="menu-icon"></div>
		<ul class="navbar">
			<li><a href="index.jsp">Home</a></li>
			<li><a href="#">Books</a></li>
			<li><a href="ourteam">About Us</a></li>
		</ul>

		<%
		User u = (User) session.getAttribute("user");
		if (u == null) {
		%>
		<a href="login.html" class="h-btn">Login</a>
		<%
		} else {
		%>
		<div class="dropdown">
			<button class="dropbtn"><%=u.getFname()%></button>
			<div class="dropdown-content">
			  <a href="vieword">View Orders</a>
			  <a href="editprof">Edit Profile</a>
			  <a href="logoutuser">Logout</a>
			</div>
		</div>
		<%
		}
		%>

	</header>

	<section class="skill" id="causes">
		<div class="title">
			<h2>Books</h2>
			<i class="fa-solid fa-hand-holding-heart"></i>
		</div>

		<div class="box">
			<%
			@SuppressWarnings("unchecked")
			ArrayList<Product> prod = (ArrayList<Product>) request.getAttribute("prod");
			if (!prod.isEmpty()) {
				Iterator<Product> it = prod.iterator();
				while (it.hasNext()) {
					Product p = it.next();
					String path = "img\\" + p.getPic_url();
			%>
			<div class="card">
				<img src="<%=path%>" alt="">
				<h5><%=p.getName()%></h5>
				<h5>
					&#8377;<%=p.getPrice()%></h5>
				<p><%=p.getDescr()%></p>

				<p style="text-align: center;">
					<%
					if (u == null) {
					%>
					<a class="button" href="login.html">Login to Donate</a>
					<%
					} else {
					%>
					<a class="button" href="pay?uid=<%=u.getId()%>&pid=<%=p.getId()%>">Donate
						Book</a>

					<%
					}
					%>
				</p>
			</div>


			<%
			}
			}
			%>

		</div>
	</section>


	<script type="text/javascript">
		window.addEventListener("scroll", function(){
			var header =document.querySelector("header");
			header.classList.toggle("sticky", window.scrollY > 0);
		})
		
		let menu = document.querySelector('#menu-icon')
		let navbar = document.querySelector('.navbar')

		menu.onclick = () => {
			menu.classList.toggle('fa-xmark');
			navbar.classList.toggle('active');
		};

		window.onscroll = () => {
			menu.classList.remove('fa-xmark');
			navbar.classList.remove('active');
		}
	</script>
</body>
</html>