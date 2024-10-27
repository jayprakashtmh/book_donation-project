<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="jay.user.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trust</title>
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
			<li><a href="#">Home</a></li>
			<li><a href="prod">Books</a></li>
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
				<a href="vieword">View Orders</a> <a href="editprof">Edit
					Profile</a> <a href="logoutuser">Logout</a>
			</div>

		</div>
		<%
		}
		%>

	</header>

	<section class="home" id="home">
		<div class="home-text">
			<h4>We can change it together lets do it Now!</h4>
			<a href="form-fill.jsp">Join Us</a>
		</div>
	</section>

	<section class="about" id="causes">
		<div class="about-img">
			<img src="foun-img/Sponser.jpg">
		</div>

		<div class="about-text">
			<h5>Sponsor This Entire Project</h5>
			<h2>
				Give Education to <span>100 Children</span>
			</h2>
			<p>Good study skills can increase your confidence, competence,
				and self-esteem. They can also reduce anxiety about tests and
				deadlines. By developing effective study skills, you may be able to
				cut down on the numbers of hours spend studying, leaving more time
				for other things in your life.</p>
			<div class="btna">
				<a href="#" class="btn">Know More</a> <a href="mail.jsp" class="btn">Mail
					Us</a>
			</div>
		</div>
	</section>

	<section class="last">
		<div class="txt">
			<h2>Change Their World. Change Yours. This Changes Everything.</h2>
		</div>
		<div class="bx">
			<a href="form-fill.jsp" class="btn">Become Volunteer</a>
			<p>Or</p>
			<a href="prod" class="btn">Buy Happiness</a>

		</div>

	</section>

	<footer>
		<p>
			<span>Dil Tak</span> Foundation
		</p>
		<p>Help Children Living in Poverty Get The Education They Deserve.
			Click the Link to Buy and Learn More of what we have accomplished.
			Passionate For Education. Save Children's Lives. Building Schools.
			Helping Make An Impact. Unique Solutions.</p>
		<div class="social">
			<a href="https://www.facebook.com/profile.php?id=100082151803138"><i
				class="fa-brands fa-facebook-f"></i></a> <a
				href="https://www.instagram.com/designmakers.in/"><i
				class="fa-brands fa-instagram"></i></a> <a
				href="https://wa.me/7061501101"><i class="fa-brands fa-whatsapp"></i></a>
		</div>
		&copy; 2022 by <a href="https://www.designmakers.in/">Jay Prakash</a>
	</footer>




	<script type="text/javascript">
   <%String msg = (String) request.getAttribute("msg");%>
   if(msg!=null)
   alert("msg");
   </script>


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