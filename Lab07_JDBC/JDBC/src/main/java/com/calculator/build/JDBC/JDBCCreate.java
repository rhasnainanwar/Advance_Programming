package com.calculator.build.JDBC;

import java.sql.*;

public class JDBCCreate {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/feeslips", "root", "");
			
			System.out.println("Connection Successful!");
			
			Statement stmt = conn.createStatement();
			
			int rows = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS slips"
					+ "(id INT UNSIGNED PRIMARY KEY,"
					+ "firstName VARCHAR(30) NOT NULL,"
					+ "lastName VARCHAR(30) NOT NULL,"
					+ "month VARCHAR(15) NOT NULL,"
					+ "currDate DATE NOT NULL)");
			
			System.out.println(rows + " rows affected!");
			
			stmt.close();
			conn.close();
		}
		catch(SQLException e) {
			System.out.println("SQL Exception:");
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
