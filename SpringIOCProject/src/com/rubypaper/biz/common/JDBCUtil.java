package com.rubypaper.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	public static Connection getConnection() {
		try {
			// 1. ����̹� ��ü�� �޸𸮿� �ε��Ѵ�.
			Class.forName("org.h2.Driver");

			// 2. Connection ��ü�� ȹ���Ѵ�.
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// SELECT ����� �ڿ� ����
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		// close ���� ResultSet -> Statement -> Connection
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}

		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}

		try {
			if (!conn.isClosed() && conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

	// Not SELECT ����� �ڿ� ����
	public static void close(PreparedStatement stmt, Connection conn) {
		// close ���� Statement -> Connection
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null;
		}

		try {
			if (!conn.isClosed() && conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

}
