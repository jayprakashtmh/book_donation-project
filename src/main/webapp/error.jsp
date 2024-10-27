<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Error</title>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	background: #000;
	display: flex;
	align-items: center;
	justify-content: center;
	color: #aa9166;
}

.container {
	display: flex;
	height: 90vh;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	gap: 10px;
	overflow: hidden;
}

img {
	height: 100%;
	width: 100%;
}
</style>
</head>
<body>
	<div class="container">
		<a href="index.jsp"><img src="foun-img/good.png" alt=""></a>
		<h2>Click Me to go to Main Page</h2>
	</div>
</body>
</html>