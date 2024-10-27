package jay.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/updateuser")
public class UpdateUserProfileServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("index.jsp").forward(req, res);
		} else {
			User u = (User) hs.getAttribute("user");
			u.setFname(req.getParameter("fname"));
			u.setLname(req.getParameter("lname"));
			u.setPhno(Long.parseLong(req.getParameter("phno")));
			u.setEmail(req.getParameter("email"));
			u.setAddr(req.getParameter("addr"));
			
			int k = new UpdateUserProfileDAO().updateUser(u);
			if(k>0) {
				req.setAttribute("msg", "Updated!!");
				req.getRequestDispatcher("index.jsp").forward(req, res);
			}
		}
	}
}
