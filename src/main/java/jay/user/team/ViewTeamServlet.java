package jay.user.team;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ourteam")
public class ViewTeamServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ArrayList<Team> team = new ViewTeamDAO().viewTeam();
		req.setAttribute("team", team);
		req.getRequestDispatcher("OurTeam.jsp").forward(req, res);
	}
}
