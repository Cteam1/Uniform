package servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Uniform;
import dao.UniformDAO;

public class UniformListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		//jspから受け取るデータの文字コードを指定
		request.setCharacterEncoding("UTF-8");

		String cmd = "";
		String error = "";

		try {

			//UniformDAOをオブジェクト化
			UniformDAO uniformDao = new UniformDAO();

			//DBからすべての商品情報を取得
			ArrayList<Uniform> uniformList = uniformDao.selectAll();

			//uniformListをリクエストスコープに設定
			request.setAttribute("uniform_list", uniformList);

		}
		catch (IllegalStateException e) {
			cmd = "guestMenu";
			error = "DBに接続できなかったため、ユニフォーム一覧は表示できませんでした。";
			return;
		}
		finally {
			if (cmd.equals("")) {
				//商品一覧に画面遷移
				request.getRequestDispatcher("/view/uniformList.jsp").forward(request, response);
			}
			else {
				//error ・cmdをリクエストスコープに設定
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);

				//エラー画面に遷移
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}
	}
}
