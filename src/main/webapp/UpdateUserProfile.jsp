<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="jay.user.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Profile</title>
<link rel="stylesheet" href="fstyle.css">
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
			<li><a href="ourteam">About Us</a></li>
		</ul>

		<%
		User u = (User) session.getAttribute("user");
		String path = null;
		if (u == null) {
		%>
		<a href="login.html" class="h-btn">Login</a>
		<%
		} else {
		path = "img\\" + u.getPic_url();
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





	<form id="check" action="updateuser" method="post">

		<h2>
			<img src=<%=path%> alt="">
		</h2>

		<div class="row100">
			<div class="col">
				<div class="inputBox">
					<input type="text" name="fname" value=<%=u.getFname()%> required>
					<span class="text">First Name</span> <span class="line"></span>
				</div>
			</div>
			<div class="col">
				<div class="inputBox">
					<input type="text" name="lname" value=<%=u.getLname()%> required>
					<span class="text">Last Name</span> <span class="line"></span>
				</div>
			</div>
		</div>

		<div class="row100">
			<div class="col">
				<div class="inputBox">
					<input type="text" id="phno" name="phno" value=<%=u.getPhno()%>
						required> <span class="text">Phone</span> <span
						class="line"></span>
				</div>
			</div>
			<div class="col">
				<div class="inputBox">
					<input type="text" id="email" name="email" value=<%=u.getEmail()%>
						required> <span class="text">Email</span> <span
						class="line"></span>
				</div>
			</div>
		</div>

		<div class="row100">
			<div class="col">
				<div class="inputBox">
					<input type="text" name="addr" value="<%=u.getAddr()%>" required>
					<span class="text">Address</span> <span class="line"></span>
				</div>
			</div>
		</div>

		<div class="row100">
			<div class="col">
				<input type="submit" value="Update">
			</div>
		</div>



	</form>

	<script src="validate.js"></script>

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