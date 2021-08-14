package cn.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class  DBUtil {
	private static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static String DRV = "oracle.jdbc.driver.OracleDriver";
	private static String USER = "scott";
	private static String PWD = "tiger";
	private DBUtil() {
		
	}
	
	static {
		try {
			Class.forName(DRV);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(URL,USER, PWD);
		return conn;
	}
	
	public static void freeConnection(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
	
	public static void freeStatement(Statement pstm) throws SQLException {
		if (pstm != null) {
			pstm.close();
		}
	}
	
	public static void freeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}

}
