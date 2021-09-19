package com.sugang.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
	private DBConn() {}
	public static Connection dbConn = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	public static Connection getInstance() {
		if(dbConn == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				System.out.println("Enter DB Id >>");
				String user = new java.util.Scanner(System.in).nextLine();
				System.out.println("Enter db Password >>");
				String pw = new java.util.Scanner(System.in).nextLine();
				dbConn = DriverManager.getConnection(url, user, pw);
				System.out.println("DrivermanagerConnection...");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dbConn;
	}
	public static int statementUpdate(String sql) {
		int resultValue = 0;
			try {
				if(st== null) {
					st = dbConn.createStatement();
				}
				resultValue = st.executeUpdate(sql);
				System.out.println("StatementExcuteUpdate...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return resultValue;
	}
	public static ResultSet statementQuery(String sql) {
			try {
				if(st == null) {
				st = dbConn.createStatement();
				System.out.println("statementQuery...");
				}
				rs = st.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return rs;
	}
	public static void dbClose() {
			try {
				if (rs!= null)rs.close();
				if (st!= null)st.close();
				if (dbConn!= null)dbConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				rs = null;
				st = null;
				dbConn = null;
			}
	}
	public static void dbReset() {
		try {
			if (rs!= null)rs.close();
			if (st!= null)st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rs = null;
			st = null;
		}
	}
}
