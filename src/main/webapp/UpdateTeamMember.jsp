<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,jay.admin.team.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Team Details</title>
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
		<h2>Update Team Member</h2>
		<%
		@SuppressWarnings("unchecked")
		ArrayList<TeamMem> tm = (ArrayList<TeamMem>) session.getAttribute("team");
		int code = Integer.parseInt(request.getParameter("tid"));
		Iterator<TeamMem> it = tm.iterator();
		while (it.hasNext()) {
			TeamMem t = it.next();
			if (t.getId() == code) {
		%>
		<div>
			<form action="updateteam" method="post">
				<input type="hidden" name="id" value="<%=t.getId()%>">
				<label>Update Name</label>
				<input type="text" name="name" value="<%=t.getName()%>">
				<label>Update About Member</label>
				<input type="text" name="about" value="<%=t.getAbout()%>">
				<input type="submit" value="Update">
			</form>
		</div>
		<%
		break;
		}
		}
		%>
	</section>
</body>
</html>