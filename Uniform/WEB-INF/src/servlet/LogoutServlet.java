package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッション情報をクリアする
		HttpSession session = request.getSession();

		if (session != null) {
			session.invalidate();
		}

		//login.jspにフォワードする
		request.getRequestDispatcher("/view/menu.jsp").forward(request,response);
	}
}