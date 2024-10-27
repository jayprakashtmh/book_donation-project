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

@SuppressWarnings("serial")
@WebServlet("/updateindexpage")
@MultipartConfig
public class UpdateIndexDataServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		} else {
			IndexData id = new IndexData();
			id.setLogo(req.getParameter("logo"));
			id.sethText(req.getParameter("htext"));
			id.setDescr(req.getParameter("descr"));
			id.setfLink(req.getParameter("flink"));
			id.setxLink(req.getParameter("xlink"));
			id.setiLink(req.getParameter("ilink"));
			id.setPicUrl(new Image().saveImage(req.getPart("pic")));
			int k = new UpdateIndexDataDAO().updateIndexData(id);

			if (k > 0) {
				req.setAttribute("msg", "Index Data Updated Successfully!!!!");
				req.getRequestDispatcher("AdminChoice.jsp").forward(req, res);
			}
		}
	}
}
