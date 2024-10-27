package jay.user.product;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jay.common.Product;

@SuppressWarnings("serial")
@WebServlet("/pay")
public class PayForBookServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("index.jsp").forward(req, res);
		} else {
			int uid = Integer.parseInt(req.getParameter("uid"));
			int pid = Integer.parseInt(req.getParameter("pid"));
			ArrayList<Product> prod = new ShowProductDAO().showProd();
			Product product = new Product();
			for (Product p : prod) {
				if(pid==p.getId()) {
					product = p;
					break;
				}
			}
			req.setAttribute("uid", uid);
			req.setAttribute("product", product);
			req.getRequestDispatcher("pay.jsp").forward(req, res);
		}
	}
}
