package servlet;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.Admin;
import bean.Order;
import dao.OrderDAO;

// 注文詳細機能に関する処理をおこなうサーブレットクラス

public class OrderDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {
			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");

			// セッション取得（使用しないが、不正ログインを防ぐため）
			HttpSession session = request.getSession();
			Admin admin = (Admin) session.getAttribute("admin");

			if (admin == null) { // セッション切れの場合
				error = "セッションが切れたため、注文詳細を確認することができませんでした。";
				cmd = "logout";
				return;
			}

			//データを取得
			String name = request.getParameter("name");
			String order_time  = request.getParameter("order_time");

			// OrderDAOをインスタンス化
			OrderDAO orderDao = new OrderDAO();

			// � 書籍情報を検索し、戻り値としてBookオブジェクトを取得する
			ArrayList<Order> order_list = null;
			order_list = orderDao.orderDetail(name,order_time);

			// 取得したorderリクエストスコープに格納する
			request.setAttribute("order_list", order_list);

		} catch (IllegalStateException e) {
			error = "DB接続エラーのため、注文詳細を確認することができませんでした。";
			cmd = "logout";
		} finally {
			// エラーの有無でフォワード先を呼び分ける
			if (cmd.equals("")) {
					request.getRequestDispatcher("/view/orderDetail.jsp").forward(request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);

			}
		}

	}
}
