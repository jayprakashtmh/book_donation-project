<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%
	String msg = (String) request.getAttribute("msg");
	%>
	<%@include file="login.html" %>
	
	<script type="text/javascript">
	alert("<%=msg%>");
	</script>
</body>
</html>