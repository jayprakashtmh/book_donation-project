package jay.user.product;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jay.common.Product;

@SuppressWarnings("serial")
@WebServlet("/prod")
public class ShowProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Product> prod = new ShowProductDAO().showProd();
		req.setAttribute("prod", prod);
		req.getRequestDispatcher("prod.jsp").forward(req, resp);
	}
}
