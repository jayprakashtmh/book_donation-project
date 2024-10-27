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
@WebServlet("/updateprod")
public class UpdateProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		} else {
			@SuppressWarnings("unchecked")
			ArrayList<Product> alp = (ArrayList<Product>) hs.getAttribute("products");
			int id = Integer.parseInt(req.getParameter("id"));
			int k = 0;
			for (Product prod : alp) {
				if (prod.getId() == id) {
					prod.setDescr(req.getParameter("descr"));
					prod.setPrice(Float.parseFloat(req.getParameter("price")));
					prod.setQty(Integer.parseInt(req.getParameter("qty")));
					k = new UpdateProductDAO().updateProd(prod);
					break;
				}
			}
			if (k > 0) {
				req.setAttribute("msg", "Product Updated Successfully!!!!");
				req.getRequestDispatcher("AdminChoice.jsp").forward(req, res);
			}
		}
	}
}
