<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="jay.user.User, java.util.*, jay.user.team.Team"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Our Team</title>

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
			<li><a href="prod">Books</a></li>
			<li><a href="#">About Us</a></li>
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
				<a href="vieword">View Orders</a> <a href="editprof">Edit
					Profile</a> <a href="logoutuser">Logout</a>
			</div>

		</div>
		<%
		}
		%>

	</header>



	<section class="skill" id="team">
		<div class="title">
			<h2>Our Team</h2>
			<i class="fa-solid fa-people-group"></i>
		</div>

		<div class="box">

			<%
			@SuppressWarnings("unchecked")
			ArrayList<Team> team = (ArrayList<Team>) request.getAttribute("team");
			Iterator<Team> it = team.iterator();
			while (it.hasNext()) {
				Team t = it.next();
				String path = "img\\" + t.getPic();
			%>

			<div class="card">
				<img src="<%=path%>" alt="">
				<h5><%=t.getName()%></h5>
				<p><%=t.getAbout()%></p>
				<p style="text-align: center;">
					<a href="<%=t.getfLink()%>"><i class="fa-brands fa-facebook-f"></i></a>
					<a href="<%=t.getxLink()%>"><i class="fa-brands fa-twitter"></i></a>
					<a href="<%=t.getiLink()%>"><i class="fa-brands fa-instagram"></i></a>
				</p>
			</div>

			<%
			}
			%>


			<div class="btna">
				<a href="form_fill.html" class="btn">Join Us</a> <a href="prod"
					class="btn">Donate Books</a>
			</div>
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