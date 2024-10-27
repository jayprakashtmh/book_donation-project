package jay.user.content;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/fill")
public class FillFormServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		FillForm ff = new FillForm();
		ff.setName(req.getParameter("name"));
		ff.setProfession(req.getParameter("profession"));
		ff.setPhno(Long.parseLong(req.getParameter("phno")));
		ff.setEmail(req.getParameter("email"));
		ff.setState(req.getParameter("state"));
		ff.setCity(req.getParameter("city"));
		ff.setPin(Integer.parseInt(req.getParameter("pin")));
		ff.setAddr(req.getParameter("addr"));

		int k = new FillFormDAO().addData(ff);

		if (k > 0) {
			req.setAttribute("msg", "Message Send Successfully!!!");
		}else {
			req.setAttribute("msg", "Something Wrong, Please try Again!!!");
		}
		req.getRequestDispatcher("index.jsp").forward(req, res);

	}
}
