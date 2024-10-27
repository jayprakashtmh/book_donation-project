package jay.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		User u = new UserLoginDAO().loginUser(req.getParameter("uname"), req.getParameter("pword"));
		try {
			u.getFname().length();
			HttpSession hs = req.getSession();
			hs.setAttribute("user", u);
			req.getRequestDispatcher("index.jsp").forward(req, res);
		} catch (Exception e) {
			req.setAttribute("msg", "Invalid Username or Passowrd!!");
			req.getRequestDispatcher("logerror.jsp").forward(req, res);
		}
	}
}
