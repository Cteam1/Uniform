package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.Order;
import dao.OrderDAO;
import util.SendMail;

public class PaymentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String error = "";
	String cmd = "";
	try {

		HttpSession session = request.getSession();

		Admin admin = (Admin) session.getAttribute("admin");

		if (admin == null) { // セッション切れの場合
			error = "セッションが切れたため、注文詳細を確認することができませんでした。";
			cmd = "logout";
			return;
		}

		//画面からの入力情報を受け取るためのエンコードを設定します。
		request.setCharacterEncoding("UTF-8");

		//入金ステータス
		String payment = request.getParameter("payment");

		//発送ステータス
		String send = request.getParameter("send");

		//引き数用変数name
		String name = request.getParameter("name");

		//引き数用変数ordertime
		String orderTime = request.getParameter("orderTime");

		String email = request.getParameter("email");



		//データベースを更新します。
		//ステータスが入金済み-未発送の時
		//メール発送あり
		OrderDAO orderDao = new OrderDAO();
		if(payment.equals("入金済み") && send.equals("未発送")){
			orderDao.paymentUpdate(payment, name, orderTime);

		//mail
			send = null;
			SendMail sendMail = new SendMail();
			sendMail.send(name, payment, send, email);

		//ステータスが入金済み-発送済の時
		//メール発送あり
		}else if(payment.equals("入金済み") && send.equals("発送済み")) {
			//orderDao.sendUpdate(send, name, orderTime);
			orderDao.StatusReset(send,payment, name, orderTime);

			//mail
			payment = null;
			SendMail sendMail = new SendMail();
			sendMail.send(name, payment, send, email);


		//未入金-未発送の状態に戻すとき
		}else if(payment.equals("入金済み") && send.equals("発送準備中")) {
			orderDao.StatusReset(send, payment, name, orderTime);
		}

	} catch (Exception e) {
		//★エラーをキャッチした場合、Error.jspへフォワード処理を行う
		error = "DB接続エラーの為、支払い状況、発送状況の変更は出来ませんでした。";
		cmd = "logout";
	} finally {
		if(error.equals("")){
			request.getRequestDispatcher("/orderList").forward(request, response);
		} else {
			request.setAttribute("cmd", cmd);
			request.setAttribute("error", error);
			request.getRequestDispatcher("/view/error.jsp").forward(request, response);
	}






}
	}
}
