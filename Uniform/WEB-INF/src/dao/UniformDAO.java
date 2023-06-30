package dao;

import java.sql.*;
import java.util.*;

import bean.Uniform;

public class UniformDAO {

	/**
	 * JDBCドライバ内部のDriverクラスパス
	 */
	private static final String RDB_DRIVE = "com.mysql.jdbc.Driver";
	/**
	 * 接続するMySQLデータベースパス
	 */
	private static final String URL = "jdbc:mysql://localhost/uniform_db";
	/**
	 * データベースのユーザー名
	 */
	private static final String USER = "root";
	/**
	 * データベースのパスワード
	 */
	private static final String PASSWD = "root123";

	/**
	 * フィールド変数の情報を基に、DB接続をおこなうメソッド
	 *
	 * @return データベース接続情報
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * DBの書籍情報を格納するuniform_infoテーブルから全書籍情報を取得するメソッド
	 *
	 * @return 全書籍情報のリスト
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public ArrayList<Uniform> selectAll() {

		ArrayList<Uniform> uni_list = new ArrayList<Uniform>();
		String sql = "SELECT * FROM uniform_info ORDER BY uniform_id";

		Connection con = null;
		Statement smt = null;
		try {
			con = UniformDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				Uniform uni = new Uniform();
				uni.setUniformid(rs.getString("uniform_id"));
				uni.setUniformType(rs.getString("type"));
				uni.setStock(rs.getInt("stock"));
				uni.setPrice(rs.getInt("price"));

				uni_list.add(uni);
			}

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
		return uni_list;

	}

	public static Uniform selectByUniformid(String uniform_id) {
		Connection con = null;
		Statement smt = null;

		Uniform uni = new Uniform();

		try {
			// ★引数の情報を利用し、検索用のSQL文を文字列として定義します
			String sql = "SELECT uniform_id,type,stock,price FROM uniform_info WHERE uniform_id = '" + uniform_id + "'";

			// BookDAOクラスに定義した、getConnection()メソッドを利用してConnectionオブジェクトを生成します
			con = getConnection();

			// ConnectionオブジェクトのcreateStatement（）メソッドを利用してStatementオブジェクトを生成します。
			smt = con.createStatement();

			// ★SQL文を発行し結果セットを取得します
			ResultSet rs = smt.executeQuery(sql);

			// 結果セットから書籍データを取り出し、Bookオブジェクトに格納します
			while (rs.next()) {
				uni.setUniformid(rs.getString("uniform_id"));
				uni.setUniformType(rs.getString("type"));
				uni.setStock(rs.getInt("stock"));
				uni.setPrice(rs.getInt("price"));
			}

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
		return uni;
	}

	// ユニフォームの座個数を変更するメソッド
	public void updateStock(String uniform_id, int stock) {

		Connection con = null;
		Statement smt = null;

		try {
			// ★引数の情報を利用し、検索用のSQL文を文字列として定義します
			String sql = "UPDATE uniform_info SET stock=" + stock + " WHERE uniform_id='" + uniform_id + "'";

			// BookDAOクラスに定義した、getConnection()メソッドを利用してConnectionオブジェクトを生成します
			con = getConnection();

			// ConnectionオブジェクトのcreateStatement（）メソッドを利用してStatementオブジェクトを生成します。
			smt = con.createStatement();

			// ★SQL文を実行
			smt.executeUpdate(sql);
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
	}
}
