package jay.user.click;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jay.user.OrderDetails;
import jay.user.User;

@SuppressWarnings("serial")
@WebServlet("/vieword")
public class ViewOrderDetailsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("index.jsp").forward(req, res);
		} else {
			User u = (User) hs.getAttribute("user");
			ArrayList<OrderDetails> od = new VewOrderDetailsDAO().showOrderDetails(u.getId());
			req.setAttribute("order", od);
			req.getRequestDispatcher("UserOrder.jsp").forward(req, res);
		}
	}
}
