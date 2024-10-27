package jay.user.product;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jay.common.Product;
import jay.user.OrderDetails;

@SuppressWarnings("serial")
@WebServlet("/qty")
public class PaymentBookServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("index.jsp").forward(req, res);
		} else {
			int pid = Integer.parseInt(req.getParameter("pid"));
			int uid = Integer.parseInt(req.getParameter("uid"));
			int qty = Integer.parseInt(req.getParameter("qty"));
			int k = 0;
			Product p = new Product();
			ArrayList<Product> prod = new ShowProductDAO().showProd();
			for (Product product : prod) {
				if (product.getId() == pid) {
					p = product;
					int qty2 = product.getQty();
					k = new DecreaseQtyPaymentBookDAO().setQty(pid, qty2 - qty);
				}
			}
			if (k > 0) {
				OrderDetails od = new OrderDetails();
				od.setName(p.getName());
				od.setQty(qty);
				od.setPrice(p.getPrice());
				od.setPic(p.getPic_url());
				od.setDate(Date.valueOf(LocalDate.now()));
				od.setuId(uid);

				int i = new CreateOrderDetailsDAO().createOrder(od);
				if (i > 0) {
					req.getRequestDispatcher("success.jsp").forward(req, res);
				}
			}
		}
	}
}
