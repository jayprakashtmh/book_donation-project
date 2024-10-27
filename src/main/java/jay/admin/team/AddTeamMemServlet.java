package jay.admin.team;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jay.common.Image;

@SuppressWarnings("serial")
@WebServlet("/addteam")
@MultipartConfig
public class AddTeamMemServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		} else {
			TeamMem tm = new TeamMem();
			tm.setName(req.getParameter("name"));
			tm.setAbout(req.getParameter("about"));
			tm.setPic(new Image().saveImage(req.getPart("pic")));
			tm.setfLink(req.getParameter("flink"));
			tm.setxLink(req.getParameter("xlink"));
			tm.setiLink(req.getParameter("ilink"));

			int k = new AddTeamMemDAO().addTeam(tm);

			if (k > 0) {
				req.setAttribute("msg", "Team Member Added Successfully!!!!");
				req.getRequestDispatcher("AdminChoice.jsp").forward(req, res);
			}
		}
	}
}
