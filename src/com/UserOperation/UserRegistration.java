package com.UserOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.UserLogin.User;
import com.connecction.ConnectionInstnace;

public class UserRegistration {
	
	public static void userDetails() throws SQLException {
		PreparedStatement prepareStatement=null;
		Connection conn=null;
		try {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter the first name>>");
		String fname=scanner.next();
		System.out.println("Enter the last name>>");
		String lname=scanner.next();
		System.out.println("Enter the username>>");
		String username=scanner.next();
		System.out.println("Enter the password>>");
		String pass=scanner.next();
		System.out.println("Enter the city>>");
		String city=scanner.next();
		System.out.println("Enter the mail id>>");
		String mailID=scanner.next();
		System.out.println("Enter the  mobile number>>");
		String phone=scanner.next();
		
		
		
		conn=ConnectionInstnace.getConnection(); 
		String sql="insert into User (FirstName,LastName,UserName,Password,City,Email,Phone,Role)VALUES(?,?,?,?,?,?,?,?)"; 
	    prepareStatement=conn.prepareStatement(sql);
		prepareStatement.setString(1, fname);
		prepareStatement.setString(2, lname);
		prepareStatement.setString(3, username);
		prepareStatement.setString(4, pass);
		prepareStatement.setString(5, city);
		prepareStatement.setString(6, mailID);
		prepareStatement.setString(7, phone);
		prepareStatement.setString(8, "customer");
		
		int i = prepareStatement.executeUpdate();
        System.out.println("User inserted. Rows affected: " + i);
		} catch(SQLException e) {
	            e.printStackTrace();
		} finally {
			
			// Close the resources
	        prepareStatement.close();
	        conn.close();
		}
		}
        
		
	}


