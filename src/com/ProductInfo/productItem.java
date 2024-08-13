package com.ProductInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.UserLogin.User;
import com.connecction.ConnectionInstnace;

public class productItem
 {

	public static void addProduct(User loginuser) throws SQLException {
		
		if (loginuser == null) {
            System.out.println("Please login first.");
            return;
        } else if(loginuser.getRole().equals("customer") || loginuser.getRole().equals("Guest")) {
        	
        	System.out.println("This operation can only be performed by an Admin.");

        	 return;
        }
		ArrayList<Product> productlist= new ArrayList<Product>();
		
		PreparedStatement prepareStatement=null;
		Connection conn=null;
		
		try {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Product Id>>");
		int pid=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Product Description>>");
		String description=scanner.nextLine();
		System.out.println();
		System.out.println("Product Name>>");
		String name=scanner.nextLine();
		System.out.println("Price>>");
		int price=scanner.nextInt();
		System.out.println("Quantity>>");
		int quantity=scanner.nextInt();
		
		
		conn=ConnectionInstnace.getConnection();
		String sql="insert into Products (Pid,Description,Name,Price,Quantity)VALUES(?,?,?,?,?)"; 
	    prepareStatement=conn.prepareStatement(sql);
		prepareStatement.setInt(1,pid);
		prepareStatement.setString(2, description);
		prepareStatement.setString(3, name);
		prepareStatement.setInt(4, price);
		prepareStatement.setInt(5, quantity);
		
		int i = prepareStatement.executeUpdate();
		System.out.println("Product added. Rows affected: " + i);
		} catch(SQLException e) {
	            e.printStackTrace();
		} finally {
			
			// Close the resources
	        prepareStatement.close();
	        conn.close();
		}
		
        
		
		
	}
 }



