package jay.admin.product;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jay.common.Product;

@SuppressWarnings("serial")
@WebServlet("/showprod")
public class ViewProductsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		} else {
			ArrayList<Product> alp = new ViewProductsDAO().showProducts();
			hs.setAttribute("products", alp);
			req.getRequestDispatcher("Product.jsp").forward(req, res);
		}
	}
}
