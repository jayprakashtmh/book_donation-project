package jay.admin.content;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jay.common.Image;

@WebServlet("/updatesponsor")
@SuppressWarnings("serial")
@MultipartConfig
public class UpdateSponsorContentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		} else {
			SponsorContent sc = new SponsorContent();
			sc.setText1(req.getParameter("text1"));
			sc.setText2(req.getParameter("text2"));
			sc.setText3(req.getParameter("text3"));
			sc.setPicUrl(new Image().saveImage(req.getPart("pic")));
			sc.setaText1(req.getParameter("atext1"));
			sc.setaText1Url(req.getParameter("atext1url"));
			sc.setaText2(req.getParameter("atext2"));
			sc.setaText2Url(req.getParameter("atext2url"));

			int k = new UpdateSponsorContentDAO().updateContent(sc);
			if (k > 0) {
				req.setAttribute("msg", "Sponsor Data Updated Successfully!!!!");
				req.getRequestDispatcher("AdminChoice.jsp").forward(req, res);
			}
		}
	}
}
