package jay.user;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jay.common.Image;

@SuppressWarnings("serial")
@WebServlet("/userreg")
@MultipartConfig
public class UserRegistrationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		User u = new User();
		u.setUname(req.getParameter("uname"));
		u.setPword(req.getParameter("pword"));
		u.setFname(req.getParameter("fname"));
		u.setLname(req.getParameter("lname"));
		u.setPhno(Long.parseLong(req.getParameter("phno")));
		u.setEmail(req.getParameter("email"));
		u.setDob(Date.valueOf(req.getParameter("dob")));
		u.setPic_url(new Image().saveImage(req.getPart("pic")));
		u.setAddr(req.getParameter("addr"));
		int k = new UserRegistrationDAO().regUser(u);
		if (k > 0) {
			req.setAttribute("msg", "You have been Registered Successfully!!!");
			req.getRequestDispatcher("index.jsp").forward(req, res);
		}
	}
}
