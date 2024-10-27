package jay.admin.product;

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
@WebServlet("/delprod")
public class DeleteProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		} else {

			@SuppressWarnings("unchecked")
			ArrayList<Product> alp = (ArrayList<Product>) hs.getAttribute("products");
			int id = Integer.parseInt(req.getParameter("pcode"));
			int k = 0;
			for (Product prod : alp) {
				if (prod.getId() == id) {
					if (alp.remove(prod)) {
						k = new DeleteProductDAO().deleteProd(id);
						break;
					}
				}
			}
			if (k > 0) {
				req.setAttribute("msg", "Product Deleted Successfully!!!!");
				req.getRequestDispatcher("AdminChoice.jsp").forward(req, res);
			}
		}
	}
}
