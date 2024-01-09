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

	public static Connection getInstance() throws Exception {
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
				throw new Exception("데이터베이스 연결 실패 !!");
			} catch (SQLException e) {
				throw new Exception("사용자 조회 오류 !!");
			}
		}
		return dbConn;
	}
	public static int statementUpdate(String sql) throws Exception {
		int resultValue = 0;
			try {
				if(st== null) {
					st = dbConn.createStatement();
				}
				resultValue = st.executeUpdate(sql);
				System.out.println("StatementExcuteUpdate...");
			} catch (SQLException e) {
				throw new Exception("수정 실패 !!");
			}
		return resultValue;
	}
	public static ResultSet statementQuery(String sql) throws Exception {
			try {
				if(st == null) {
				st = dbConn.createStatement();
				System.out.println("statementQuery...");
				}
				rs = st.executeQuery(sql);
			} catch (SQLException e) {
				throw new Exception("조회 실패 !!");
			}
		return rs;
	}
	public static void dbClose() throws Exception {
			try {
				if (rs!= null)rs.close();
				if (st!= null)st.close();
				if (dbConn!= null)dbConn.close();
			} catch (SQLException e) {
				throw new Exception("데이터베이스 종료 실패 !!");
			}finally {
				rs = null;
				st = null;
				dbConn = null;
			}
	}
	public static void dbReset() throws Exception {
		try {
			if (rs!= null)rs.close();
			if (st!= null)st.close();
		} catch (SQLException e) {
			throw new Exception("데이터베이스 초기화 실패 !!");
		}finally {
			rs = null;
			st = null;
		}
	}
}
