package excel02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DataUtil;

public class DBUtil {
	/*
	 * String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; String url =
	 * "jdbc:sqlserver://127.0.0.1;DatabaseName=javenforexcel";
	 */

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://127.0.0.1:3306/wxy";

	ResultSet res = null;

	private static String dbUrl = "jdbc:mysql://localhost:3306/meeting";
	private static String dbUserName = "root";
	private static String dbPassword = "1226";
	private static String jdbcName = "com.mysql.jdbc.Driver";

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName(jdbcName);
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			System.out.println(DataUtil.getData() + ":数据库连接成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("装载 JDBC/ODBC 驱动程序失败。");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("无法连接数据库");
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param con
	 * @throws Exception
	 */
	public static void closeCon(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
		System.out.println(DataUtil.getData() + ":数据库连接关闭");
	}

	// 查询
	public ResultSet Search(String sql, String str[]) {
		try {
			PreparedStatement pst = DBUtil.getCon().prepareStatement(sql);
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					pst.setString(i + 1, str[i]);
				}
			}
			res = pst.executeQuery();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	// 增删修改
	public int AddU(String sql, String str[]) {
		int a = 0;
		try {
			PreparedStatement pst = DBUtil.getCon().prepareStatement(sql);
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					pst.setString(i + 1, str[i]);
				}
			}
			a = pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	public static void main(String[] args) {
		DBUtil db = new DBUtil();
	}

}