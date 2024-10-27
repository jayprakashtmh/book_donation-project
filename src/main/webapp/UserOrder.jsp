<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*, jay.user.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trust Website</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="ostyle.css">
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
					<li><a href="prod">Books</a></li>
					<li><a href="ourteam">About Us</a></li>
				</ul>

				<%
				User u = (User)session.getAttribute("user");
				if(u==null){
				%>
					<a href="login.html" class="h-btn">Login</a>
				<%
				}else{
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



	<div class="cont">

		<h2>You have Donated</h2>

		<%
		@SuppressWarnings("unchecked")
		ArrayList<OrderDetails> od = (ArrayList<OrderDetails>) request.getAttribute("order");

		Iterator<OrderDetails> it = od.iterator();
		while (it.hasNext()) {
			OrderDetails o = it.next();
			String path = "img\\" + o.getPic();
		%>

		<div class="box">
			<div class="box-l">
				<img src="<%=path%>" alt="">
			</div>
			<div class="box-r">
				<div class="in-data">
					<h5>Name</h5>
					<p><%=o.getName()%></p>
				</div>
				<div class="in-data">
					<h5>Qty</h5>
					<p><%=o.getQty()%></p>
				</div>
				<div class="in-data">
					<h5>Price</h5>
					<p><%=o.getPrice()%></p>
				</div>
				<div class="in-data">
					<h5>Total Price</h5>
					<p><%=o.getQty() * o.getPrice()%></p>
				</div>
				<div class="in-data">
					<h5>Date</h5>
					<p><%=o.getDate()%></p>
				</div>

			</div>
		</div>



		<%
		}
		%>

	</div>





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