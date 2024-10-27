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


	<%
	Product p = (Product) request.getAttribute("product");
	String path = "img\\" + p.getPic_url();
	%>


	<section id="home">
		<div class="slider">
			<img src="foun-img/s1.jpg" id="slideImg">
		</div>

		<div class="content">

			<div class="top">
				<div class="details">
					<h4>Product Information</h4>
					<div class="tag">
						<p style="color: black;">Product Name :</p>
						<p><%=p.getName()%></p>
					</div>
					<div class="tag">
						<p style="color: black;">Product Price :</p>
						<p><%=p.getPrice()%></p>
					</div>
					<div class="tag">
						<p style="color: black;">Product Category :</p>
						<p><%=p.getCategory()%></p>
					</div>
					<div class="tag">
						<p style="color: black;">Product Qty :</p>
						<p><%=p.getQty()%></p>
					</div>
				</div>
				<div class="details">
					<h4>Product Pic</h4>
					<img src="<%=path%>" alt="">
				</div>
			</div>

			<form action="qty" id="form" method="post">
				<input type="hidden" name="pid" value="<%=p.getId()%>"> <input
					type="hidden" name="uid" value="<%=u.getId()%>"> <input
					type="number" id="qty" name="qty" min="1" max="<%=p.getQty()%>"
					placeholder="Enter Qty" onchange="calTotal()"> <input
					type="hidden" id="price" name="price" value="<%=p.getPrice()%>">
				<input type="text" id="ttlPrice" name="totalPrice" readonly>
			</form>
			<a href="checkout" onclick="submitData(); return false;">Pay</a>

		</div>
	</section>

	<script>
	
	function submitData(){
		 var qty = parseInt(document.getElementById("qty").value);
		 if(qty<=<%=p.getQty()%>){
				document.getElementById("form").submit();
				}
				else{
					alert("Please Check Quantity!!");
				}
	}
	
        function calTotal(){
            var qty = parseInt(document.getElementById("qty").value);
            var price =<%=p.getPrice()%>;
			if(qty<=<%=p.getQty()%>){
            var tP = qty*price;
            document.getElementById("ttlPrice").value=tP.toFixed(2);
			}
			else{
				alert("Please Check Quantity!!");
			}
        }

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