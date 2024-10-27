package jay.admin.product;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jay.common.Image;
import jay.common.Product;

@SuppressWarnings("serial")
@WebServlet("/addprod")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private AddProductDAO add;

	@Override
	public void init() throws ServletException {
		add = new AddProductDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		} else {
			Product p = new Product();
			p.setName(req.getParameter("name"));
			p.setDescr(req.getParameter("descr"));
			p.setCategory(req.getParameter("category"));
			p.setPrice(Float.parseFloat(req.getParameter("price")));
			p.setQty(Integer.parseInt(req.getParameter("qty")));
			p.setPic_url(new Image().saveImage(req.getPart("pic")));
			int k = add.addProduct(p);

			if (k > 0) {
				req.setAttribute("msg", "Product Added Successfully!!!!");
				req.getRequestDispatcher("AdminChoice.jsp").forward(req, res);
			}
		}

	}
}
