package jay.admin.content;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/homepage")
public class EditIndexDataServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		} else {	
			IndexData id = new ViewIndexDataDAO().showData();
			req.setAttribute("index", id);
			req.getRequestDispatcher("UpdateHomePage.jsp").forward(req, res);
		}
	}
}
