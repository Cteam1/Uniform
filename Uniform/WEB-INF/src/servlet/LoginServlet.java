package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import dao.AdminDAO;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {

			//管理者情報DTOをオブジェクト化
			Admin admin  =new Admin();

			//セッション情報を取得
			HttpSession session = request.getSession();

			//リクエストスコープからユーザーidとpassの情報を取得
			String adminid = request.getParameter("admin");
			String pass = request.getParameter("pass");

			//管理者情報DAOをオブジェクト化
			AdminDAO  adminDao  = new AdminDAO();

			//メソッドを呼び出して管理者情報を取得し、データベースに該当する管理者があるか確認
			admin = adminDao.selectByUserid(adminid, pass);
			if(admin.getAdminid() != null || admin.getPassword() != null) {
				//該当する管理者がいた場合は、管理者情報をフォワード
				session.setAttribute("admin", admin);

			}else {
				error = "入力データが間違っています。";
				cmd = "login";
			}

		} catch (Exception e) {
			error = "DB接続エラーのため、ログインできません。";
			cmd = "menu";
		}finally {
			if (error.equals("")) {
				//エラーが発生しなかった際は受注一覧画面に遷移
				request.getRequestDispatcher("/view/adminMenu.jsp").forward(request, response);
			} else if (cmd.equals("menu")){ // DB接続エラー
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			} else { // ID,パスワード入力値エラー
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
