package com.calculator.build.JDBC;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JDBCTest {

	public static void main(String[] args) {
		System.out.println("Select an option from the following list:");
		System.out.println("1. Create a fee slip");
		System.out.println("2. Delete a fee slip");
		System.out.println("3. Update a fee slip");
		System.out.println("4. See fee slip of a particular student");
		System.out.println("5. See all fee slips from a month");
		System.out.println("6. See all fee slips generated today");
		System.out.println("7. See all fee slips");
		
		System.out.print("\n> ");
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		
		try {
			choice = scan.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("INVALID choice!");
			System.exit(-1);
		}
		
		if(choice < 1 || choice > 7) {
			System.out.println("INVALID choice!");
			System.exit(-1);
		}
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/feeslips", "root", "");
			int reg;
			String firstName;
			String lastName;
			String month;
			int rows;
			
			java.util.Date date;
			java.sql.Date sqlDate;
			
			Statement stmt = null;
			
			ResultSet rs = null;
			
			switch(choice) {
			case 1:
				System.out.print("Enter student registration: ");
				reg = scan.nextInt();
				scan.nextLine();
				System.out.print("Enter student first name: ");
				firstName = scan.nextLine();
				System.out.print("Enter student last name: ");
				lastName = scan.nextLine();
				System.out.print("Enter fee month: ");
				month = scan.nextLine();
				
				date = new java.util.Date();
	            sqlDate = new java.sql.Date(date.getTime());
	            
	            stmt = conn.createStatement();
	            rows = stmt.executeUpdate("INSERT INTO slips (id, firstName, lastName, month, currDate)"
	            		+ "VALUES ("+reg+",'"+firstName+"','"+lastName+"','"+month+"','"+sqlDate.toString()+"')");
	            
	            System.out.println(rows + " row(s) added successfully!");
	            break;
			case 2:
				System.out.print("Enter student registration: ");
				reg = scan.nextInt();
				scan.nextLine();
				
				stmt = conn.createStatement();
	            rows = stmt.executeUpdate("DELETE FROM slips WHERE id =" + reg);
	            
	            System.out.println(rows + " row(s) deleted successfully!");
	            break;
			case 3:
				System.out.print("Enter student registration: ");
				reg = scan.nextInt();
				scan.nextLine();
				System.out.print("Enter student first name: ");
				firstName = scan.nextLine();
				System.out.print("Enter student last name: ");
				lastName = scan.nextLine();
				System.out.print("Enter fee month: ");
				month = scan.nextLine();
	            
	            stmt = conn.createStatement();
	            rows = stmt.executeUpdate("UPDATE slips SET firstName='"+firstName+"', lastName='"+lastName+"', month='"+month+"'");
	            
	            System.out.println(rows + " row(s) added successfully!");
	            break;
			case 4:
				System.out.print("Enter student registration: ");
				reg = scan.nextInt();
				scan.nextLine();
				
				stmt = conn.createStatement();
	            rs = stmt.executeQuery("SELECT * from slips WHERE id = " + reg);
	            
	            while(rs.next()) {
	            	System.out.println("\nReg: " + rs.getInt("id"));
	            	System.out.println("Name: " + rs.getString("firstName") + " " + rs.getString("lastName"));
	            	System.out.println("Month: " + rs.getString("month"));
	            	System.out.println("Date: " + rs.getString("currDate"));
	            }
	            break;
			case 5:
				System.out.print("Enter fee month: ");
				month = scan.nextLine();
				scan.nextLine();
				
				stmt = conn.createStatement();
	            rs = stmt.executeQuery("SELECT * from slips WHERE month = '" + month + "'");
	            
	            while(rs.next()) {
	            	System.out.println("\nReg: " + rs.getInt("id"));
	            	System.out.println("Name: " + rs.getString("firstName") + " " + rs.getString("lastName"));
	            	System.out.println("Month: " + rs.getString("month"));
	            	System.out.println("Date: " + rs.getString("currDate"));
	            	System.out.println("-----------------------------------");
	            }
	            break;
			case 6:
				date = new java.util.Date();
	            sqlDate = new java.sql.Date(date.getTime());
	            
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery("SELECT * from slips WHERE currDate = '" + sqlDate.toString() + "'");
	            
	            while(rs.next()) {
	            	System.out.println("\nReg: " + rs.getInt("id"));
	            	System.out.println("Name: " + rs.getString("firstName") + " " + rs.getString("lastName"));
	            	System.out.println("Month: " + rs.getString("month"));
	            	System.out.println("Date: " + rs.getString("currDate"));
	            	System.out.println("-----------------------------------");
	            }
	            
	            break;
			case 7:
				stmt = conn.createStatement();
	            rs = stmt.executeQuery("SELECT * from slips");
	            
				while(rs.next()) {
	            	System.out.println("\nReg: " + rs.getInt("id"));
	            	System.out.println("Name: " + rs.getString("firstName") + " " + rs.getString("lastName"));
	            	System.out.println("Month: " + rs.getString("month"));
	            	System.out.println("Date: " + rs.getString("currDate"));
	            	System.out.println("-----------------------------------");
	            }
				break;
				
			}
			
			scan.close();
		
		}
		catch(SQLException e) {
			System.out.println("SQL Exception:");
			System.out.println(e);
		}
		catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		
	}

}
