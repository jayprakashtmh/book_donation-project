<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="jay.common.Product,jay.user.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
<link rel="stylesheet" href="pay-style.css">
<link rel="stylesheet" href="drop-style.css">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">
</head>
<body onload="slider()">



	<header>
		<a href="#" class="logo"><span>Dil Tak</span><b>|</b>Foundation</a>
		<div class="fa-solid fa-bars" id="menu-icon"></div>
		<ul class="navbar">
			<li><a href="index.jsp">Home</a></li>
			<li><a href="prod">Books</a></li>
			<li><a href="ourteam">About Us</a></li>
		</ul>

		<%
		User u = (User) session.getAttribute("user");
		if (u == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
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


	<section id="home">
		<div class="slider">
			<img src="foun-img/s1.jpg" id="slideImg">
		</div>

		<div class="content">

			<h2>Thank You</h2>



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

	<script>
    var slideImg = document.getElementById("slideImg");

    var images = new Array(
        "foun-img/s1.jpg",
        "foun-img/s2.jpg",
        "foun-img/s3.jpg",
        "foun-img/s4.jpg"
    );

    var len = images.length;
    var i = 0;

    function slider(){
        if(i > len-1){
            i = 0;
        }
        slideImg.src = images[i];
        i++;
        setTimeout('slider()',3000);
    }
  </script>
</body>
</html>