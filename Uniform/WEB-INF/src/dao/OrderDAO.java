package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Order;

public class OrderDAO {

	// データベース接続情報
	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/uniform_db";
	private static String USER = "root";
	private static String PASS = "root123";

	// DB接続用のメソッド
	private static Connection getConnection() {
		try {

			// ドライバ読み込み
			Class.forName(RDB_DRIVE);

			// データベースへの接続
			Connection con = DriverManager.getConnection(URL, USER, PASS);

			// connection型オブジェクトを戻す
			return con;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}// メソッド終了

	// DBに登録されているデータを全件取得するメソッド
	// 戻り値 ArrayList<Order> orderList
	public ArrayList<Order> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Order> orderList = new ArrayList<Order>();


		try {
			// DBと接続
			con = getConnection();
			// データ操作の準備
			smt = con.createStatement();
			// DB上のレコードを全件取得するSQL文
			String sql = "select order_info.order_id,order_info.name,price,quantity,order_info.order_date,order_info.payment,order_info.send,order_info.order_time from order_info "
					+ "inner join uniform_info on order_info.uniform_id=uniform_info.uniform_id order by order_date desc, order_time desc";

			// 取得したレコードをResultSetへ格納
			ResultSet rs = smt.executeQuery(sql);
			// 取得したレコードの各値をOrderオブジェクト
			// へセット
			while (rs.next()) {
				Order order = new Order();
				order.setOrderid(rs.getInt("order_id"));
				order.setName(rs.getString("name"));
				order.setQuantity(Integer.parseInt(rs.getString("quantity")));
				order.setPrice(Integer.parseInt(rs.getString("price")));
				order.setDate(rs.getString("order_date"));
				order.setPayment(rs.getString("payment"));
				order.setSend(rs.getString("send"));
				order.setOrderTime(rs.getString("order_time"));
				orderList.add(order);
			}
			// リソース解放
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return orderList;
	}// メソッド終了


	// DBに登録されているデータを全件取得するメソッド
	// 戻り値 ArrayList<Order> orderList
	public ArrayList<Order> selectAllGroup() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Order> orderList = new ArrayList<Order>();


		try {
			// DBと接続
			con = getConnection();
			// データ操作の準備
			smt = con.createStatement();
			// DB上のレコードを全件取得するSQL文
			String sql = "select * from order_info inner join uniform_info on uniform_info.uniform_id=order_info.uniform_id group by name,order_time order by order_date desc, order_time desc";

			// 取得したレコードをResultSetへ格納
			ResultSet rs = smt.executeQuery(sql);
			// 取得したレコードの各値をOrderオブジェクト
			// へセット
			while (rs.next()) {
				Order order = new Order();
				order.setOrderid(rs.getInt("order_id"));
				order.setName(rs.getString("name"));
				order.setQuantity(Integer.parseInt(rs.getString("quantity")));
				order.setPrice(Integer.parseInt(rs.getString("price")));
				order.setDate(rs.getString("order_date"));
				order.setPayment(rs.getString("payment"));
				order.setSend(rs.getString("send"));
				order.setOrderTime(rs.getString("order_time"));
				orderList.add(order);
			}
			// リソース解放
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return orderList;
	}// メソッド終了

	// 受注詳細を受け取るメソッド
	// 戻り値：ArrayList<Order> orderList 引数：String name String time
	public ArrayList<Order> orderDetail(String name, String orderTime) {

		Connection con = null;
		Statement smt = null;

		ArrayList<Order> orderList = new ArrayList<Order>();
		Order order = null;

		try {
			// DBと接続
			con = getConnection();
			// データ操作の準備
			smt = con.createStatement();
			// DB上のレコードを全件取得するSQL文
			String sql = "SELECT order_id,name,email,address,tel_number,uniform_info.uniform_id,uniform_info.type,quantity,uniform_info.price,order_date,order_time,payment,send,message FROM order_info "
					+ "INNER JOIN uniform_info ON order_info.uniform_id=uniform_info.uniform_id WHERE name='" + name
					+ "'&& order_time='" + orderTime + "'";

			// 取得したレコードをResultSetへ格納
			ResultSet rs = smt.executeQuery(sql);
			// 取得したレコードの各値をOrderオブジェクト
			// へセット
			while (rs.next()) {
				order = new Order();
				order.setOrderid(rs.getInt("order_id"));
				order.setName(rs.getString("name"));
				order.setEmail(rs.getString("email"));
				order.setAddress(rs.getString("address"));
				order.setTelNumber(rs.getString("tel_number"));
				order.setUniformType(rs.getString("type"));
				order.setQuantity(rs.getInt("quantity"));
				order.setPrice(rs.getInt("price"));
				order.setDate(rs.getString("order_date"));
				order.setOrderTime(rs.getString("order_time"));
				order.setPayment(rs.getString("payment"));
				order.setSend(rs.getString("send"));
				order.setMessage(rs.getString("message"));
				orderList.add(order);
			}
			// リソース解放
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return orderList;
	}// メソッド終了

	// 入金情報を更新するメソッド、発送準備中へ自動で変換
	// 引数：payment,orderId
	public void paymentUpdate(String payment, String name, String orderTime) {

		Connection con = null;
		Statement smt = null;
		String sql = null;

		// SQL
		if( payment.equals("入金済み")) {
			sql = "UPDATE order_info SET payment='" + payment + "',send='発送準備中' " + "WHERE name='" + name
				+ "' && order_time='" + orderTime + "'";
		}else {
			sql = "UPDATE order_info SET payment='" + payment
					+ "' send='未発送' WHERE name='" + name + "' && order_time='" + orderTime + "'";
		}

		try {

			con = getConnection();
			smt = con.createStatement();

			// SQL実行
			smt.executeUpdate(sql);

		} catch (Exception e) {
			// 例外をスロー
			throw new IllegalStateException(e);
		} finally {
			// リソース解放
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}

	}// メソッド終了

	// 発送状況を変更するメソッド
	// 引数：send,orderId
	public void sendUpdate(String send, String name, String orderTime) {

		Connection con = null;
		Statement smt = null;

		// SQL
		String sql = "UPDATE order_info SET send='" + send +
				"' WHERE name='" + name + "' && order_time='" + orderTime + "'";

		try {

			con = getConnection();
			smt = con.createStatement();

			// SQL実行
			smt.executeUpdate(sql);

		} catch (Exception e) {
			// 例外をスロー
			throw new IllegalStateException(e);
		} finally {
			// リソース解放
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}

	}// メソッド終了

	// 発送状況と入金情報を変更するメソッド
	// 引数 send(発送状況)、payment(入金情報)、name(名前)、orderTime(注文時刻)
	public void StatusReset(String send, String payment, String name, String orderTime) {

		Connection con = null;
		Statement smt = null;

		// SQL
		String sql = "UPDATE order_info SET send='" + send + "',payment='" + payment + "' WHERE name='" + name
				+ "' && order_time='" + orderTime + "'";

		try {

			con = getConnection();
			smt = con.createStatement();

			// SQL実行
			smt.executeUpdate(sql);

		} catch (Exception e) {
			// 例外をスロー
			throw new IllegalStateException(e);
		} finally {
			// リソース解放
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}

	}// メソッド終了



	// 購入情報をDBへ登録するメソッド
	// 引数 order
	public void insert(Order order) {

		Connection con = null;
		Statement smt = null;

		String sql = "INSERT INTO order_info VALUES(0,'" + order.getName() + "','" + order.getEmail() + "','"
				+ order.getAddress() + "','" + order.getTelNumber() + "','" + order.getUniformid() + "',"
				+ order.getQuantity() + ",'" + order.getMessage() + "','" + order.getPayment() + "','"
				+ order.getSend() + "',CURDATE(),CURTIME())";

		try {

			con = getConnection();
			smt = con.createStatement();

			smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}

	}// メソッド終了
}
