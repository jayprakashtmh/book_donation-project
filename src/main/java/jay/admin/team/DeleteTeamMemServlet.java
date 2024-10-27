package jay.admin.team;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/delteam")
public class DeleteTeamMemServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		} else {
			@SuppressWarnings("unchecked")
			ArrayList<TeamMem> tm = (ArrayList<TeamMem>) hs.getAttribute("team");
			int code = Integer.parseInt(req.getParameter("tid"));
			int k = 0;
			for (TeamMem t : tm) {
				if (t.getId() == code) {
					if (tm.remove(t)) {
						k = new DeleteTeamMemDAO().deleteTeamMem(code);
						break;
					}
				}
			}
			if (k > 0) {
				req.setAttribute("msg", "Team Member Deleted Successfully!!!!");
				req.getRequestDispatcher("AdminChoice.jsp").forward(req, res);
			}
		}

	}
}
