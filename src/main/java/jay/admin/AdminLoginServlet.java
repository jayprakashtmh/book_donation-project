package jay.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/adminlog")
public class AdminLoginServlet extends HttpServlet {
	private AdminLoginDAO ald;

	@Override
	public void init() throws ServletException {
		ald = new AdminLoginDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = ald.login(req.getParameter("uname"), req.getParameter("pword"));

		if (name != null) {
			HttpSession hs = req.getSession(); 
			hs.setAttribute("name", name);
			req.getRequestDispatcher("AdminChoice.jsp").forward(req, res);
		} else {
			req.setAttribute("msg", "Login Process Denyed!!!");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
	}
}
