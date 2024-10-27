package jay.user.content;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/mail")
public class MailServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Mail m = new Mail();
		m.setName(req.getParameter("name"));
		m.setNumber(Long.parseLong(req.getParameter("phno")));
		m.setMsg(req.getParameter("msg"));

		int k = new MailDAO().saveData(m);

		if (k > 0) {
			req.setAttribute("msg", "Message Send Successfully!!!");
			req.getRequestDispatcher("index.jsp").forward(req, res);
		}
	}
}
