package servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;

public class GuestMenuServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// セッションの作成
		HttpSession session = request.getSession();

		ArrayList<MultiBuy> multiBuys = (ArrayList<MultiBuy>) session.getAttribute("multiBuyList");

		if (multiBuys == null) {// セッションが切れの場合

			multiBuys = new ArrayList<MultiBuy>();

			session.setAttribute("multiBuyList", multiBuys);

		}

		// 購入者メニューへ遷移
		request.getRequestDispatcher("/view/guestMenu.jsp").forward(request, response);

	}

}
