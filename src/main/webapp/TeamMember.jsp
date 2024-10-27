<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*, jay.admin.team.TeamMem"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Team</title>
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
		<div class="box">
			<div class="container-box">
				<h1>Team Members</h1>

				<%
				@SuppressWarnings("unchecked")
				ArrayList<TeamMem> tm = (ArrayList<TeamMem>) session.getAttribute("team");
				Iterator<TeamMem> it = tm.iterator();
				while (it.hasNext()) {
					TeamMem t = it.next();
				%>
				<div class="box-img">
					<%
					String path = "img\\" + t.getPic();
					%>
					<div class="content-l">
						<p>
							<span>Name :</span>
							<%=t.getName()%></p>
						<p>
							<span>About :</span>
							<%=t.getAbout()%></p>
					</div>
					<div class="content-r">
						<img alt="Yaha Product Photo Hona Chahiye Tha!!!" src="<%=path%>">
					</div>
				</div>

				<div class="btn">

					<a href="editteam?tid=<%=t.getId()%>">Edit</a> <a
						href="delteam?tid=<%=t.getId()%>">Delete</a>
				</div>
				<%
				}
				%>
			</div>
		</div>
		<a href="AddTeamMember.jsp">Add Team Member</a>
	</section>
</body>
</html>