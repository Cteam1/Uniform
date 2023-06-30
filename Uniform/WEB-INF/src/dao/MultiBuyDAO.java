package dao;

import java.sql.*;
import java.util.*;

import bean.MultiBuy;

public class MultiBuyDAO {

	//DB情報
	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/uniform_db";
	private static String USER = "root";
	private static String PASSWD = "root123";

	private Connection getConnection() {

		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL,USER,PASSWD);
			return con;
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public ArrayList<MultiBuy> selectByOrderid(int orderid) {

		Connection con  = null;
		Statement smt = null;
		String sql = "SELECT * FROM multibuy_info WHERE order_id = '" + orderid  + "'";
		ArrayList<MultiBuy> multibuyList = new ArrayList<MultiBuy>();

		try {
			//DBのアクセス・操作の準備
			con = getConnection();
			smt = con.createStatement();

			//sql文を実行し、結果を取得
			ResultSet rs = smt.executeQuery(sql);

			//sql文から取得した結果を変数に格納
			String uniformid = rs.getString("uniform_id");
			int quantity = rs.getInt("quantity");

			//取得した結果の数だけ繰り返す
			while (rs.next()) {

				MultiBuy multibuy = new MultiBuy();

				//各パラメータをmultibuyに格納
				multibuy.setOrderid(orderid);
				multibuy.setUniformid(uniformid);
				multibuy.setQuantity(quantity);

				//multibuyListに格納
				multibuyList.add(multibuy);
			}

		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
		//リソース開放処理
		finally {
			if (smt != null) {
				try {
					smt.close();
				}
				catch (SQLException ignore) {

				}
			}
			if (con != null) {
				try {
					con.close();
				}
				catch(SQLException e) {

				}
			}
		}
		return multibuyList;
	}
}
